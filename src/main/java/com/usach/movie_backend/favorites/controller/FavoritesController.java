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
    @GetMapping("/{idFavorites}")
    public ResponseEntity<Favorite> findById(@PathVariable("idFavorites")Integer idFavorites){
        return favoritesService.findByFavorites(idFavorites).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Favorite> create(@RequestBody Favorite favorites){
        return new ResponseEntity<>(favoritesService.create(favorites),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Favorite> update(@RequestBody Favorite favorites){
        return favoritesService.findByFavorites(favorites.getIdFavorite())
                .map( u -> ResponseEntity.ok(favoritesService.update(favorites)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<Object> delete(@PathVariable("name") String name,
                                         @PathVariable("username") String username,
                                         @PathVariable("userEmail") String userEmail){
        favoritesService.deleteByName(name,username,userEmail);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
