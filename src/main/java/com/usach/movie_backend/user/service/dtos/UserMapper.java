package com.usach.movie_backend.user.service.dtos;

import com.usach.movie_backend.suscription.domain.Subscription;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.dtos.UserCreate;
import com.usach.movie_backend.user.service.dtos.UserUpdate;
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

    public User updateUserMapping(Integer idUser, UserUpdate userUpdate){
        User user = new User();
        user.setBirthday(userUpdate.birthday());
        user.setEmail(userUpdate.email());
        user.setFirstName(userUpdate.firstName());
        user.setLastName(userUpdate.lastName());
        user.setPassword(userUpdate.password());
        user.setId(idUser);
        return user;
    }
}
