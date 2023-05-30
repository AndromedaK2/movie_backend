package com.usach.movie_backend.user.controller;

import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.IUserService;
import com.usach.movie_backend.user.service.UserCreate;
import com.usach.movie_backend.user.service.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable("id") Integer idUser){
        Optional<User> user = userService.findByIdUser(idUser);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<String>> findAllUsers(){
        List<String> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser (@RequestBody UserCreate userCreate) {
        User userCreated = userService.createUser(userCreate);
        return new ResponseEntity<>(userCreated,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer idUser ,@RequestBody UserUpdate userUpdate){
        User user = userService.updateUser(idUser ,userUpdate);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer idUser){
        userService.deleteById(idUser);
        return new ResponseEntity<>("Usuario Eliminado",HttpStatus.OK);
    }
}
