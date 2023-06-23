package com.usach.movie_backend.favorites.controller;


import com.usach.movie_backend.favorites.domain.Favorite;
import com.usach.movie_backend.favorites.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favorites")
public class FavoritesController {
    @Autowired
    private FavoritesService favoritesService;

    @GetMapping
    public ResponseEntity<List<Favorite>> findAll(){
        List<Favorite>favorites = favoritesService.findAll();
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Favorite> create(@PathVariable("name") String name,
                                           @PathVariable("username") String username,
                                           @PathVariable("userEmail") String userEmail){
        return new ResponseEntity<>(favoritesService.create(name,username,userEmail),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Favorite> update(@PathVariable("name") String name,
                                           @PathVariable("username") String username,
                                           @PathVariable("userEmail") String userEmail){
        return new ResponseEntity<>(favoritesService.update(name,username,userEmail),HttpStatus.OK);
    }
    @DeleteMapping("/{name}/{username}/{userEmail}")
    public ResponseEntity delete(@PathVariable("name") String name,
                                         @PathVariable("username") String username,
                                         @PathVariable("userEmail") String userEmail){
        favoritesService.deleteByName(name,username,userEmail);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
