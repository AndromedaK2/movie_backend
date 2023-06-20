package com.usach.movie_backend.profile.controller;

import com.usach.movie_backend.profile.domain.ProfileMovie;

import com.usach.movie_backend.profile.service.ProfileMovieService;
import com.usach.movie_backend.profile.service.dtos.ViewLaterMovie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="profile-movies", description = "Profile movies management API")
@RestController
@RequestMapping("/profile-movies")
public class ProfileMovieController {
    @Autowired

    private ProfileMovieService profileMovieService;

    @Operation(
            summary = "Retrieve all profile movies",
            description = "Get all profile movies objects",
            tags = { "profile-movies", "get" })
    @GetMapping
    public ResponseEntity<List<ProfileMovie>> findAll(){
        List<ProfileMovie>profileMovies = profileMovieService.findAll();
        return new ResponseEntity<>(profileMovies, HttpStatus.OK);
    }

    @Operation(
            summary = "Mark viewLater a specific movie",
            description = "Create profile movie",
            tags = { "profile-movies", "post" })
    @PostMapping
    public ResponseEntity<ProfileMovie> markViewLater(@RequestBody ViewLaterMovie  viewLaterMovie){
        return new ResponseEntity<>(profileMovieService.create(viewLaterMovie),HttpStatus.CREATED);
    }

    @Operation(
            summary = "DesMark viewLater a specific movie",
            description = "Delete profile movie",
            tags = { "profile-movies", "delete" })
   @DeleteMapping
   public ResponseEntity desMarkViewLater(@RequestBody ViewLaterMovie  viewLaterMovie){
        profileMovieService.delete(viewLaterMovie);
        return ResponseEntity.noContent().build();
   }
}
