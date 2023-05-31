package com.usach.movie_backend.user.service;

import com.usach.movie_backend.rol.service.IRolService;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.repository.IUserRepository;
import com.usach.movie_backend.user.service.dtos.UserCreate;
import com.usach.movie_backend.user.service.dtos.UserLogin;
import com.usach.movie_backend.user.service.dtos.UserMapper;
import com.usach.movie_backend.user.service.dtos.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  implements  IUserService<User>{

    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    IRolService rolService;

    public Optional<User> findByIdUser(Integer idUser){
        return Optional.ofNullable(userRepository.findById(idUser).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with idUser: %d not found", idUser))));
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with email: %d not found", email))));
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

    public User updateUser(Integer idUser , UserUpdate userUpdate){
        User user = userMapper.updateUserMapping( idUser ,userUpdate);
        return userRepository.save(user);
    }

    public String deleteById(Integer idUser){
        userRepository.deleteById(idUser);
        return "user deleted";
    }

    public Optional<User> login(UserLogin userLogin){
        return userRepository.login(userLogin.email(), userLogin.password());
    }
}

