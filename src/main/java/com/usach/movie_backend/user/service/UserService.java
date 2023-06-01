package com.usach.movie_backend.user.service;

import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.repository.IUserRepository;
import com.usach.movie_backend.user.service.dtos.UserCreate;
import com.usach.movie_backend.user.service.dtos.UserLogin;
import com.usach.movie_backend.user.service.dtos.UserMapper;
import com.usach.movie_backend.user.service.dtos.UserUpdate;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService  implements  IUserService{

    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserMapper userMapper;



    public Optional<User> findByIdUser(Integer idUser){
        return Optional.ofNullable(userRepository.findById(idUser).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with idUser: %d not found", idUser))));
    }

    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User does not exist"));
        }
        return user;
    }

    public List<User> getAllUsers(){
         List<User> users = userRepository.findAll();
         return users;
    }

    public User createUser(UserCreate userCreate){
        if(userRepository.findByEmail(userCreate.email()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User already exist"));
        }
        User user = userMapper.createUserMapping(userCreate);
        return userRepository.save(user);
    }

    public Optional<User> updateUser(UserUpdate userUpdate){
        if(userRepository.findByEmail(userUpdate.email()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User does not exist"));
        }

       Integer updated = userRepository.updateUser(
               userUpdate.email(),
               userUpdate.password(),
               userUpdate.firstName(),
               userUpdate.lastName(),
               userUpdate.birthday(),
               userUpdate.wallet());
        if(updated!=1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("User could not be updated"));
        }
        return userRepository.findByEmail(userUpdate.email());

    }

    public void deleteById(Integer idUser){
        userRepository.deleteById(idUser);
    }

    public  void deleteByEmail(String email){
        userRepository.deleteByEmail(email);
    }

    public Optional<User> login(UserLogin userLogin){
        Optional<User> user = userRepository.login(userLogin.email(), userLogin.password());
        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User does not exist"));
        }
        return user ;
    }


}

