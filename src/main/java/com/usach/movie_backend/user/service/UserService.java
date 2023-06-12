package com.usach.movie_backend.user.service;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.suscription.domain.Subscription;
import com.usach.movie_backend.suscription.repository.ISubscriptionRepository;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.repository.IUserRepository;
import com.usach.movie_backend.user.service.dtos.UserCreate;
import com.usach.movie_backend.user.service.dtos.UserLogin;
import com.usach.movie_backend.user.service.dtos.UserMapper;
import com.usach.movie_backend.user.service.dtos.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class UserService  implements  IUserService{

    @Autowired
    IUserRepository userRepository;

    @Autowired
    ISubscriptionRepository subscriptionRepository;

    @Autowired
    UserMapper userMapper;

    @Transactional(readOnly = true)
    public Optional<User> findByIdUser(Integer idUser){
        return Optional.ofNullable(userRepository.findById(idUser).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with idUser: %d not found", idUser))));
    }

    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
       Optional<User> user = userRepository.findByEmail(email);
       if(user.isEmpty()){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "User does not exist");
       }
       return user;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public User createUser(UserCreate userCreate){
        if(userRepository.findByEmail(userCreate.email()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exist");
        }
        User user = userMapper.createUserMapping(userCreate);
        return userRepository.save(user);
    }

    @Transactional
    public Optional<User> updateUser(UserUpdate userUpdate){
        if(userRepository.findByEmail(userUpdate.email()).isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");

       int updated = userRepository.updateUser(
               userUpdate.email(),
               userUpdate.password(),
               userUpdate.firstName(),
               userUpdate.lastName(),
               userUpdate.birthday(),
               userUpdate.wallet());
        if(updated!=1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User could not be updated");
        }
        return userRepository.findByEmail(userUpdate.email());

    }

    @Transactional
    public int updateUserSubscription(String email, Subscription subscription){
        return userRepository.updateUserSubscriptionId(email,subscription.getIdSubscription());
    }

    @Transactional
    public void deleteById(Integer idUser){
        userRepository.deleteById(idUser);
    }

    @Transactional
    public  void deleteByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            userRepository.deleteByEmail(email);
            subscriptionRepository.deleteById(user.get().getSubscription().getIdSubscription());
        }
    }

    @Transactional
    public User paySubscription(String email, Float money) {
        User user = this.findByEmail(email).get();
        Subscription subscription = user.getSubscription();
        SubscriptionType subscriptionType = subscription.getSubscriptionType();

        if(!subscription.isActive()){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    String.format("Subscription is still active. You must pay in %s", subscription.getExpirationDate()));
        }

        Float paid = subscriptionType.getPrice() - money;

        if(subscriptionType.getPrice()> paid ){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Money is not enough");
        }
        if(subscriptionType.getPrice() < paid ){
           user.setWallet(user.getWallet() + paid);
        }

        subscription.setActive(true);
        subscription.setPaymentDate(new Date());
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, 1);
        Date updatedDate = calendar.getTime();
        subscription.setExpirationDate(updatedDate);

        user.setSubscription(subscription);

        User userUpdated = userRepository.save(user);

        return userUpdated;

    }

    @Transactional
    public Optional<User> login(UserLogin userLogin){
        Optional<User> user = userRepository.login(userLogin.email(), userLogin.password());
        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }
        return user ;
    }


}

