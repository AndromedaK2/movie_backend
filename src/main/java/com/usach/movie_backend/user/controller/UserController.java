package com.usach.movie_backend.user.controller;

import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.IUserService;
import com.usach.movie_backend.user.service.dtos.UserCreate;
import com.usach.movie_backend.user.service.dtos.UserLogin;
import com.usach.movie_backend.user.service.dtos.UserUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="users", description = "Users Management API")
@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private IUserService userService;

    @Operation(
            summary = "Retrieve a User by Id",
            description = "Get a User object by specifying its id",
            tags = { "users", "get" })
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Integer idUser){
        User user = userService.findByIdUser(idUser);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @Operation(
            summary = "Retrieve a User by Email",
            description = "Get a User object by specifying its email",
            tags = { "users", "get" })
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable("email") String email){
        User user = userService.findByEmail(email);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @Operation(
            summary = "Retrieve all Users",
            description = "Get all User objects",
            tags = { "users", "get" })
    @GetMapping
    public ResponseEntity<Page<User>> findAllUsers(@RequestParam(required = false,value = "page", defaultValue = "0")  Integer page,
                                                   @RequestParam( required = false, value = "size", defaultValue = "20")  Integer size  ){
        Page<User> users = userService.findAll(page,size);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @Operation(
            summary = "Create a user",
            description = "Create user object",
            tags = { "users", "post" })
    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody UserCreate userCreate) {
        User userCreated = userService.register(userCreate);
        return new ResponseEntity<>(userCreated,HttpStatus.CREATED);
    }


    @Operation(
            summary = "Login a user",
            description = "Login the application",
            tags = { "users", "post" })
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserLogin userLogin){
        User user =  userService.login(userLogin);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @Operation(
            summary = "Update a user",
            description = "Update fields of a user",
            tags = { "users", "put" })
    @PutMapping
    public ResponseEntity<Optional<User>> updateUser(@RequestBody UserUpdate userUpdate){
        Optional<User> user = userService.update(userUpdate);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @Operation(
            summary = "Delete user by id",
            description = "Delete all related with the user by id",
            tags = { "users", "delete" })
    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Integer idUser){
        userService.deleteById(idUser);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Delete user by email",
            description = "Delete all related with the user by email",
            tags = { "users", "delete" })
    @DeleteMapping("/email/{email}")
    public ResponseEntity deleteByEmail(@PathVariable("email") String email){
        userService.deleteByEmail(email);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
