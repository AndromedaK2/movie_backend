package com.usach.movie_backend.favorites.controller;

import com.usach.movie_backend.favorites.domain.FavoritesSerie;
import com.usach.movie_backend.favorites.service.FavoritesSeriesService;
import com.usach.movie_backend.favorites.service.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favorite-series")
@Tag(name="favorite series", description = "Favorite Series Management API")
public class FavoritesSeriesController {

    @Autowired
    private FavoritesSeriesService favoritesSeriesService;

    @Operation(
            summary = "Retrieve all favorite series",
            description = "Get all favorite series",
            tags = { "favorite series", "get" })
    @GetMapping
    public ResponseEntity<List<FavoritesSerie>> findAll(){
        List<FavoritesSerie>favoritesSeries = favoritesSeriesService.findAll();
        return new ResponseEntity<>(favoritesSeries, HttpStatus.OK);
    }
    @Operation(
            summary = "Retrieve favorite series",
            description = "Get  favorite series",
            tags = { "favorite series", "get" })
    @PostMapping("/get-list")
    public ResponseEntity<FavoriteSeries> findFavoriteSeries(@RequestBody FavoriteSerieGet favoriteSerieGet){
        return new ResponseEntity<>(favoritesSeriesService.findFavoriteSerie(favoriteSerieGet), HttpStatus.OK);
    }
    @Operation(
            summary = "Add serie to my favorite list",
            description = "Add a favorite serie",
            tags = { "favorite serie", "post" })
    @PostMapping
    public ResponseEntity<FavoritesSerie> create(@RequestBody FavoriteSerieCreate favoriteSerieCreate){
        return new ResponseEntity<>(favoritesSeriesService.create(favoriteSerieCreate),HttpStatus.CREATED);
    }

    @Operation(
            summary = "Delete serie to my favorite list",
            description = "Delete a favorite serie",
            tags = { "favorite series", "post" })
    @DeleteMapping
    public ResponseEntity delete(@RequestBody FavoriteSerieDelete favoriteSerieDelete){
        favoritesSeriesService.delete(favoriteSerieDelete);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
