package com.usach.movie_backend.favorites.controller;

import com.usach.movie_backend.favorites.domain.FavoritesMovie;
import com.usach.movie_backend.favorites.service.FavoritesMoviesService;

import com.usach.movie_backend.favorites.service.dto.FavoriteMovieCreate;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieDelete;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favorite-movies")
@Tag(name="favorite movies", description = "Favorite Movies Management API")
public class FavoritesMoviesController {
    @Autowired
    private FavoritesMoviesService favoritesMoviesService;

    @Operation(
            summary = "Retrieve all favorite movies",
            description = "Get all favorite movies",
            tags = { "favorite movies", "get" })
    @GetMapping
    public ResponseEntity<List<FavoritesMovie>> findAll(){
        List<FavoritesMovie>favoritesMovies = favoritesMoviesService.findAll();
        return new ResponseEntity<>(favoritesMovies, HttpStatus.OK);
    }

    @Operation(
            summary = "Add movie to my favorite list",
            description = "Add a favorite movie",
            tags = { "favorite movies", "post" })
    @PostMapping
    public ResponseEntity<FavoritesMovie> addFavoriteMovie(@RequestBody FavoriteMovieCreate favoritesMovieCreate){
        return new ResponseEntity<>(favoritesMoviesService.create(favoritesMovieCreate),HttpStatus.CREATED);
    }

    @Operation(
            summary = "Delete movie to my favorite list",
            description = "Delete a favorite movie",
            tags = { "favorite movies", "post" })
    @DeleteMapping
    public ResponseEntity<Object> deleteFavoriteMovie(@RequestBody FavoriteMovieDelete favoriteMovieDelete){
        favoritesMoviesService.delete(favoriteMovieDelete);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
