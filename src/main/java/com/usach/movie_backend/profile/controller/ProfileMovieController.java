package com.usach.movie_backend.profile.controller;

import com.usach.movie_backend.profile.domain.ProfileMovie;

import com.usach.movie_backend.profile.service.ProfileMovieService;
import com.usach.movie_backend.profile.service.dtos.ViewLaterMovie;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="profiles movies", description = "profiles movies management API")
@RestController
@RequestMapping("/profile-movies")
public class ProfileMovieController {
    @Autowired

    private ProfileMovieService profileMovieService;

    @GetMapping
    public ResponseEntity<List<ProfileMovie>> findAll(){
        List<ProfileMovie>profileMovies = profileMovieService.findAll();
        return new ResponseEntity<>(profileMovies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfileMovie> markViewLater(@RequestBody ViewLaterMovie  viewLaterMovie){
        return new ResponseEntity<>(profileMovieService.create(viewLaterMovie),HttpStatus.CREATED);
    }

   // @DeleteMapping("/{idProfileMovie}")
//    public ResponseEntity<Object> desMarkViewLater(@PathVariable("idProfileMovie") Integer idProfileMovie){


  //  }
}
