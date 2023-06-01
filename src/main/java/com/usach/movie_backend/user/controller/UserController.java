package com.usach.movie_backend.user.controller;

import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.IUserService;
import com.usach.movie_backend.user.service.dtos.UserCreate;
import com.usach.movie_backend.user.service.dtos.UserLogin;
import com.usach.movie_backend.user.service.dtos.UserUpdate;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="users", description = "Users Management API")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable("id") Integer idUser){
        Optional<User> user = userService.findByIdUser(idUser);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<Optional<User>> findUserByEmail(@PathVariable("email") String email){
        Optional<User> user = userService.findByEmail(email);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody UserCreate userCreate) {
        User userCreated = userService.createUser(userCreate);
        return new ResponseEntity<>(userCreated,HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Optional<User>> login(@RequestBody UserLogin userLogin){
        Optional<User> user =  userService.login(userLogin);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Optional<User>> updateUser(@RequestBody UserUpdate userUpdate){
        Optional<User> user = userService.updateUser(userUpdate);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Integer idUser){
        userService.deleteById(idUser);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<String> deleteByEmail(@PathVariable("email") String email){
        userService.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }

}
