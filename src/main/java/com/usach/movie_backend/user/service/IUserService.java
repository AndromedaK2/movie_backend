package com.usach.movie_backend.user.service;

import com.usach.movie_backend.suscription.domain.Subscription;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.dtos.UserCreate;
import com.usach.movie_backend.user.service.dtos.UserLogin;
import com.usach.movie_backend.user.service.dtos.UserUpdate;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User findByIdUser(Integer userId);
    User findByEmail(String email);
    List<User> getAllUsers();
    User createUser(UserCreate userCreate);
    Optional<User> updateUser( UserUpdate userUpdate);
    int updateUserSubscription(String email, Subscription subscription);
    void deleteById(Integer idUser);
    User login(UserLogin userLogin);
    void deleteByEmail(String email);

}
