package com.usach.movie_backend.user.service;

import com.usach.movie_backend.rol.service.IRolService;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Optional<User> user = userRepository.findById(idUser);
        return user;
    }


    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user;
    }

    public List<User> getAllUsers(){
         List<User> users = userRepository.findAll();
         return users;
    }

    public User createUser(UserCreate userCreate){
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
}

