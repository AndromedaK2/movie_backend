package com.usach.movie_backend.user.service;

import com.usach.movie_backend.suscription.domain.Subscription;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.dtos.UserCreate;
import com.usach.movie_backend.user.service.dtos.UserLogin;
import com.usach.movie_backend.user.service.dtos.UserUpdate;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IUserService {
    User findByIdUser(Integer userId);
    User findByEmail(String email);
    Page<User> findAll(int page, int size);
    Optional<User> update(UserUpdate userUpdate);
    int updateUserSubscription(String email, Subscription subscription);
    void deleteById(Integer idUser);
    void deleteByEmail(String email);
    User login(UserLogin userLogin);
    User register(UserCreate userCreate);

}
