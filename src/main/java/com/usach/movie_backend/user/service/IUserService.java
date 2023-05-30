package com.usach.movie_backend.user.service;

import java.util.ArrayList;
import java.util.List;

public interface IUserService {
    String getUserById(String userId);
    String getUserByUserName(String userId);
    List<String> getAllUsers();
    String createUser();
    String updateUser();
    String deleteUser();
}
