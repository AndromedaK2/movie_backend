package com.usach.movie_backend.users.service;

import com.usach.movie_backend.suscriptions.domain.Subscription;
import com.usach.movie_backend.users.domain.User;
import com.usach.movie_backend.users.service.dto.UserCreate;
import com.usach.movie_backend.users.service.dto.UserLogin;
import com.usach.movie_backend.users.service.dto.UserUpdate;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IUserService {
    User findByIdUser(Integer userId);
    User findByEmail(String email);
    Page<User> findAll(int page, int size);
    User update(UserUpdate userUpdate);
    int updateUserSubscription(String email, Subscription subscription);
    void deleteById(Integer idUser);
    void deleteByEmail(String email);
    User login(UserLogin userLogin);
    User register(UserCreate userCreate);

}
