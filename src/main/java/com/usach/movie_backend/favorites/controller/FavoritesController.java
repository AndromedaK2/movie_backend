package com.usach.movie_backend.favorites.controller;


import com.usach.movie_backend.favorites.domain.Favorites;
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
    public ResponseEntity<List<Favorites>> findAll(){
        List<Favorites>favorites = favoritesService.findAll();
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }
    @GetMapping("/{idFavorites}")
    public ResponseEntity<Favorites> findById(@PathVariable("idFavorites")Integer idFavorites){
        return favoritesService.findByFavorites(idFavorites).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Favorites> create(@RequestBody Favorites favorites){
        return new ResponseEntity<>(favoritesService.create(favorites),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Favorites> update(@RequestBody Favorites favorites){
        return favoritesService.findByFavorites(favorites.getIdFavorite())
                .map( u -> ResponseEntity.ok(favoritesService.update(favorites)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idFavorites}")
    public ResponseEntity<Object> delete(@PathVariable("idFavorites") Integer id){
        return favoritesService.findByFavorites(id)
                .map( u ->{
                    favoritesService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
