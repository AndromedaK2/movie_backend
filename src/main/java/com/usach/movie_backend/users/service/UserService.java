package com.usach.movie_backend.users.service;

import com.usach.movie_backend.configuration.exceptions.BusinessException;
import com.usach.movie_backend.suscriptions.domain.Subscription;
import com.usach.movie_backend.suscriptions.repository.ISubscriptionRepository;
import com.usach.movie_backend.users.domain.User;
import com.usach.movie_backend.users.repository.IUserRepository;
import com.usach.movie_backend.users.service.dto.UserCreate;
import com.usach.movie_backend.users.service.dto.UserLogin;
import com.usach.movie_backend.users.service.dto.UserUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService  implements  IUserService{

    @Autowired
    IUserRepository userRepository;

    @Autowired
    ISubscriptionRepository subscriptionRepository;

    @Autowired
    UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Transactional(readOnly = true)
    public User findByIdUser(Integer idUser){
        Optional<User> user = userRepository.findById(idUser);
        if(userRepository.findById(idUser).isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User with idUser: %d not found", idUser));
        }
        logger.info("user {0} was finding", user.get().getEmail());
        return user.get();
    }

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
       Optional<User> user = userRepository.findUserByEmail(email);
       if(user.isEmpty()){
           throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User with email: %s not found", email));
       }
       logger.info("user {0} was finding", user.get().getEmail());
       return user.get();
    }

    @Transactional(readOnly = true)
    public Page<User> findAll(int page, int size){
        Page<User> users = userRepository.findAll(PageRequest.of(page, size));
        logger.info("retrieve users");
        return users;
    }

    @Transactional(noRollbackFor = {BusinessException.class,ResponseStatusException.class})
    public User register(UserCreate userCreate){
        if(userRepository.findUserByEmail(userCreate.email()).isPresent()){
            logger.info("user {0} already exists",userCreate.email());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exist");
        }
        User user = userMapper.createUserMapping(userCreate);
        logger.info("register user");
        return userRepository.save(user);
    }

    @Transactional(noRollbackFor = {BusinessException.class,ResponseStatusException.class})
    public User update(UserUpdate userUpdate){
        Optional<User> user = userRepository.findUserByEmail(userUpdate.email());
        if(user.isEmpty()){
            logger.info("user {0} does not exist",userUpdate.email());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }

        user.get().setPassword(userUpdate.password());
        user.get().setEmail(userUpdate.email());
        user.get().setBirthday(userUpdate.birthday());
        user.get().setLastName(userUpdate.lastName());
        user.get().setFirstName(userUpdate.firstName());
        user.get().setWallet(userUpdate.wallet());

        return  userRepository.save(user.get());
    }

    @Transactional
    public int updateUserSubscription(String email, Subscription subscription){
        logger.info("update user subscription");
        return userRepository.updateUserSubscriptionId(email,subscription.getIdSubscription());
    }

    @Transactional
    public void deleteById(Integer idUser){
        logger.info("delete user {0}",idUser);
        userRepository.deleteById(idUser);
    }

    @Transactional
    public void deleteByEmail(String email){
        Optional<User> user = userRepository.findUserByEmail(email);
        if(user.isPresent()){
            logger.info("delete user {0}",email);
            userRepository.deleteById(user.get().getId());
        }
    }

    @Transactional
    public User login(UserLogin userLogin){
        Optional<User> user = userRepository.login(userLogin.email(), userLogin.password());
        if(user.isEmpty()){
            logger.info("user {0} does not exist",userLogin.email());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }
        if(user.get().getSubscription()!=null)
           expiredSubscription(user);
        logger.info("login user {0}",userLogin.email());
        return user.get();
    }

    private void expiredSubscription(Optional<User> user) {
        boolean subscriptionExpired = user.get().getSubscription().getExpirationDate().before(new Date());
        if (subscriptionExpired) {
            Subscription subscription = user.get().getSubscription();
            subscription.setActive(false);
            subscriptionRepository.save(subscription);
            user.get().setSubscription(subscription);
            logger.info("subscription set inactive");
        }
    }
}

