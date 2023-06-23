package com.usach.movie_backend.favorites.controller;

import com.usach.movie_backend.favorites.domain.FavoritesMovie;
import com.usach.movie_backend.favorites.service.FavoritesMoviesService;

import com.usach.movie_backend.favorites.service.dto.FavoriteMovieCreate;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favorite-movies")
public class FavoritesMoviesController {
    @Autowired
    private FavoritesMoviesService favoritesMoviesService;

    @GetMapping
    public ResponseEntity<List<FavoritesMovie>> findAll(){
        List<FavoritesMovie>favoritesMovies = favoritesMoviesService.findAll();
        return new ResponseEntity<>(favoritesMovies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FavoritesMovie> addFavoriteMovie(@RequestBody FavoriteMovieCreate favoritesMovieCreate){
        return new ResponseEntity<>(favoritesMoviesService.create(favoritesMovieCreate),HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteFavoriteMovie(@RequestBody FavoriteMovieDelete favoriteMovieDelete){
        favoritesMoviesService.delete(favoriteMovieDelete);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
