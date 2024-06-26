package com.usach.movie_backend.users.service.dto;

import java.util.Date;

public record UserUpdate(String firstName,
                         String lastName,
                         String email,
                         Date birthday,
                         String password,
                         Float wallet){
}
