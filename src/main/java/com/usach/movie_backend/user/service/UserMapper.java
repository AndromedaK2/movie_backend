package com.usach.movie_backend.user.service;


import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.dtos.UserCreate;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User createUserMapping(UserCreate userCreate){
        User user = new User();
        user.setBirthday(userCreate.birthday());
        user.setEmail(userCreate.email());
        user.setFirstName(userCreate.firstName());
        user.setLastName(userCreate.lastName());
        user.setPassword(userCreate.password());
        return user;
    }

}
