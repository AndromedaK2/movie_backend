package com.usach.movie_backend.profile.controller;

import com.usach.movie_backend.profile.domain.ProfileChapter;
import com.usach.movie_backend.profile.domain.ProfileMovie;

import com.usach.movie_backend.profile.service.ProfileMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profilemovie")
public class ProfileMovieController {
    @Autowired

    private ProfileMovieService profileMovieService;

    @GetMapping
    public ResponseEntity<List<ProfileMovie>> findAll(){
        List<ProfileMovie>profileMovies = profileMovieService.findAll();
        return new ResponseEntity<>(profileMovies, HttpStatus.OK);
    }
    @GetMapping("/{idProfileMovie}")
    public ResponseEntity<ProfileMovie> findById(@PathVariable("idProfileMovie")Integer idProfileMovie){
        return profileMovieService.findByProfileMovie(idProfileMovie).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<ProfileMovie> create(@RequestBody ProfileMovie profileMovie){
        return new ResponseEntity<>(profileMovieService.create(profileMovie),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProfileMovie> update(@RequestBody ProfileMovie profileMovie ){
        return profileMovieService.findByProfileMovie(profileMovie.getIdProfileMovie())
                .map( u -> ResponseEntity.ok(profileMovieService.update(profileMovie)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idProfileMovie}")
    public ResponseEntity<Object> delete(@PathVariable("idProfileMovie") Integer idProfileMovie){
        return profileMovieService.findByProfileMovie(idProfileMovie)
                .map( u ->{
                    profileMovieService.delete(idProfileMovie);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
