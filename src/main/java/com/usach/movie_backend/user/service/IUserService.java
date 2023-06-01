package com.usach.movie_backend.user.service;

import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.dtos.UserCreate;
import com.usach.movie_backend.user.service.dtos.UserLogin;
import com.usach.movie_backend.user.service.dtos.UserUpdate;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<User> findByIdUser(Integer userId);
    Optional<User> findByEmail(String email);
    List<User> getAllUsers();
    User createUser(UserCreate userCreate);
    Optional<User> updateUser(Integer idUser, UserUpdate userUpdate);
    void deleteById(Integer idUser);
    Optional<User> login(UserLogin userLogin);
    void deleteByEmail(String email);
}
