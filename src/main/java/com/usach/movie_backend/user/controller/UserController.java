package com.usach.movie_backend.user.controller;

import com.usach.movie_backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> getUserById(@PathVariable("id") String userId){
        String user = userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<String>> getAllUsers(){
        List<String> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser (@RequestBody String user) {
        return new ResponseEntity<>("Usuario Creado",HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") String userId ,@RequestBody String user){
        return new ResponseEntity<>("Usuario Actualizado",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String userId){
        return new ResponseEntity<>("Usuario Eliminado",HttpStatus.OK);
    }
}
