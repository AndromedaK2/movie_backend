package com.usach.movie_backend.user.service;

import com.usach.movie_backend.configuration.exceptions.BusinessException;
import com.usach.movie_backend.suscription.domain.Subscription;
import com.usach.movie_backend.suscription.repository.ISubscriptionRepository;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.repository.IUserRepository;
import com.usach.movie_backend.user.service.dtos.UserCreate;
import com.usach.movie_backend.user.service.dtos.UserLogin;
import com.usach.movie_backend.user.service.dtos.UserUpdate;
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
            throw new BusinessException(HttpStatus.CONFLICT.toString(),HttpStatus.CONFLICT, String.format("User with idUser: %d not found", idUser));
        }
        logger.info("user {0} was finding", user.get().getEmail());
        return user.get();
    }

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
       Optional<User> user = userRepository.findByEmail(email);
       if(user.isEmpty()){
           throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User with email: %d not found", email));
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
        if(userRepository.findByEmail(userCreate.email()).isPresent()){
            logger.info("user {0} already exists",userCreate.email());
            throw new BusinessException(HttpStatus.CONFLICT.toString(),HttpStatus.CONFLICT, "User already exist");
        }
        User user = userMapper.createUserMapping(userCreate);
        logger.info("register user");
        return userRepository.save(user);
    }

    @Transactional(noRollbackFor = {BusinessException.class,ResponseStatusException.class})
    public Optional<User> update(UserUpdate userUpdate){
        if(userRepository.findByEmail(userUpdate.email()).isEmpty()){
            logger.info("user {0} does not exist",userUpdate.email());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }
        int updated = userRepository.updateUser(
               userUpdate.email(),
               userUpdate.password(),
               userUpdate.firstName(),
               userUpdate.lastName(),
               userUpdate.birthday(),
               userUpdate.wallet());
        if(updated!=1){
            logger.info("user {0} could not be updated",userUpdate.email());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User could not be updated");
        }
        logger.info("update user");
        return userRepository.findByEmail(userUpdate.email());
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
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            logger.info("delete user {0}",email);
            userRepository.deleteByEmail(email);
            logger.info("delete subscription");
            subscriptionRepository.deleteById(user.get().getSubscription().getIdSubscription());
        }
    }

    @Transactional
    public User login(UserLogin userLogin){
        Optional<User> user = userRepository.login(userLogin.email(), userLogin.password());
        if(user.isEmpty()){
            logger.info("user {0} does not exist",userLogin.email());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }
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

