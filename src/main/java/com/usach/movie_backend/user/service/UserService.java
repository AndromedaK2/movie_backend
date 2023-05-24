package com.usach.movie_backend.user.service;

import com.usach.movie_backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String getUserById(String userId){
        if(userId.equals("1")){
            return  "Usuario 1";
        }else{
            return "Usuario x";
        }
    }

    public List<String> getAllUsers(){
        ArrayList<String> users = new ArrayList<>();
        for (int i = 0; i<10; i++){
            users.add("usuario "+i);
        }
        return users;
    }

    public String createUser(){
        return "Usuario Creado";
    }

    public String updateUser(){
        return "Usuario Creado";
    }

    public String deleteUser(){
        return "Usuario Creado";
    }
}

