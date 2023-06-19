package com.usach.movie_backend.profile.controller;

import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.profile.service.ProfileService;
import com.usach.movie_backend.profile.service.dtos.ProfileCreate;
import com.usach.movie_backend.profile.service.dtos.ProfileUpdate;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="profiles", description = "Profiles management API")
@RestController
@RequestMapping("/profiles")
public class ProfilesController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<Profile>>findAll(){
        List<Profile>profiles = profileService.findAll();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
    @GetMapping("/{username}/{userEmail}")
    public ResponseEntity<Profile> find(@PathVariable("username")String username, @PathVariable("userEmail") String userEmail){
        return new ResponseEntity<>(profileService.find(username,userEmail),HttpStatus.OK);
    }
    @PostMapping("/userEmail/{userEmail}")
    public ResponseEntity<Profile> create(@PathVariable("userEmail") String userEmail ,  @RequestBody ProfileCreate profileCreate){
        return new ResponseEntity<>(profileService.create(profileCreate,userEmail),HttpStatus.CREATED);
    }

    @PutMapping("/{userEmail}")
    public ResponseEntity<Profile> update(@RequestBody ProfileUpdate profileUpdate, @PathVariable("userEmail") String userEmail){
        return new ResponseEntity<>(profileService.update(profileUpdate,userEmail),HttpStatus.OK);
    }
    @DeleteMapping("/{username}/{userEmail}")
    public ResponseEntity delete(@PathVariable("username") String username, @PathVariable("userEmail") String userEmail){
        profileService.delete(username,userEmail);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}