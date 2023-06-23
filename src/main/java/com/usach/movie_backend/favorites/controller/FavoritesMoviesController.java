package com.usach.movie_backend.favorites.controller;


import com.usach.movie_backend.favorites.domain.FavoritesMovies;
import com.usach.movie_backend.favorites.service.FavoritesMoviesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favoritesmovies")
public class FavoritesMoviesController {
    @Autowired
    private FavoritesMoviesService favoritesMoviesService;

    @GetMapping
    public ResponseEntity<List<FavoritesMovies>> findAll(){
        List<FavoritesMovies>favoritesMovies = favoritesMoviesService.findAll();
        return new ResponseEntity<>(favoritesMovies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FavoritesMovies> create(@RequestBody FavoritesMovies favoritesMovies){
        return new ResponseEntity<>(favoritesMoviesService.create(favoritesMovies),HttpStatus.CREATED);
    }

    @DeleteMapping("/{idFavoritesMovies}")
    public ResponseEntity<Object> delete(@PathVariable("idFavoritesMovies") Integer id){
        return favoritesMoviesService.findByFavoritesMovies(id)
                .map( u ->{
                    favoritesMoviesService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
