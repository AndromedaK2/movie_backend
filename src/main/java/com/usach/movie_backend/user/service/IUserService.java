package com.usach.movie_backend.user.service;

import com.usach.movie_backend.user.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IUserService<T> {
    Optional<User> findByIdUser(Integer userId);
    Optional<User> findByEmail(String email);
    List<User> getAllUsers();
    User createUser(UserCreate userCreate);
    User updateUser(Integer idUser, UserUpdate userUpdate);
    String deleteById(Integer idUser);
}
