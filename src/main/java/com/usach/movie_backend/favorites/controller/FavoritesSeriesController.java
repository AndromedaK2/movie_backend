package com.usach.movie_backend.favorites.controller;


import com.usach.movie_backend.favorites.domain.FavoritesSeries;
import com.usach.movie_backend.favorites.service.FavoritesSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favoritesseries")
public class FavoritesSeriesController {
    @Autowired
    private FavoritesSeriesService favoritesSeriesService;

    @GetMapping
    public ResponseEntity<List<FavoritesSeries>> findAll(){
        List<FavoritesSeries>favoritesSeries = favoritesSeriesService.findAll();
        return new ResponseEntity<>(favoritesSeries, HttpStatus.OK);
    }
    @GetMapping("/{idFavoritesSeries}")
    public ResponseEntity<FavoritesSeries> findById(@PathVariable("idFavoritesSeries")Integer idFavoritesSeries){
        return favoritesSeriesService.findByFavoritesSeries(idFavoritesSeries).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<FavoritesSeries> create(@RequestBody FavoritesSeries favoritesSeries){
        return new ResponseEntity<>(favoritesSeriesService.create(favoritesSeries),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<FavoritesSeries> update(@RequestBody FavoritesSeries favoritesSeries){
        return favoritesSeriesService.findByFavoritesSeries(favoritesSeries.getIdFavoriteSerie())
                .map( u -> ResponseEntity.ok(favoritesSeriesService.update(favoritesSeries)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idFavoritesSeries}")
    public ResponseEntity<Object> delete(@PathVariable("idFavoritesSeries") Integer id){
        return favoritesSeriesService.findByFavoritesSeries(id)
                .map( u ->{
                    favoritesSeriesService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
