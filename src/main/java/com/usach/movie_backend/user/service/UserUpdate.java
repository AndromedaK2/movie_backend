package com.usach.movie_backend.user.service;

import java.util.Date;

public record UserUpdate(String firstName,
                         String lastName,
                         String email,
                         Date birthday,
                         String password){
}
