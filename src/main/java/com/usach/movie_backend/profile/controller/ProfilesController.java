package com.usach.movie_backend.profile.controller;

import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfilesController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<Profile>>findAll(){
        List<Profile>profiles = profileService.findAll();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
    @GetMapping("/{idProfile}")
    public ResponseEntity<Profile> findById(@PathVariable("idProfile")Integer idProfile){
        return profileService.findByProfile(idProfile).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Profile> create(@RequestBody Profile profile){
        return new ResponseEntity<>(profileService.create(profile),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Profile> update(@RequestBody Profile profile){
        return profileService.findByProfile(profile.getIdProfile())
                .map( u -> ResponseEntity.ok(profileService.update(profile)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idProfile}")
    public ResponseEntity<Object> delete(@PathVariable("idProfile") Integer id){
        return profileService.findByProfile(id)
                .map( u ->{
                    profileService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

}