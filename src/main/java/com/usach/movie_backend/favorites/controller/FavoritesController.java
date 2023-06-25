package com.usach.movie_backend.favorites.controller;

import com.usach.movie_backend.favorites.domain.Favorite;
import com.usach.movie_backend.favorites.service.FavoritesService;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieAndSeriesList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favorites")
@Tag(name="favorites", description = "Favorites Management API")
public class FavoritesController {
    @Autowired
    private FavoritesService favoritesService;

    @Operation(
            summary = "Retrieve all favorite lists",
            description = "Get all favorite lists",
            tags = { "favorites", "get" })
    @GetMapping
    public ResponseEntity<List<Favorite>> findAll(){
        List<Favorite>favorites = favoritesService.findAll();
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @Operation(
            summary = "Retrieve all favorite movies and series",
            description = "Get all favorite movies and series",
            tags = { "favorites", "get" })
    @GetMapping("/{name}/{username}/{userEmail}")
    public ResponseEntity<FavoriteMovieAndSeriesList> findFavoriteMoviesAndSeries(@PathVariable("name") String name,
                                                                                     @PathVariable("username") String username,
                                                                                     @PathVariable("userEmail") String userEmail){
        return new ResponseEntity<>(favoritesService.findFavoriteMoviesAndSeries(name,username,userEmail), HttpStatus.OK);
    }

    @Operation(
            summary = "Create a favorite list for a profile",
            description = "Create a favorite list for a profile by name, username and userEmail",
            tags = { "favorites", "post" })
    @PostMapping("/{name}/{username}/{userEmail}")
    public ResponseEntity<Favorite> create(@PathVariable("name") String name,
                                           @PathVariable("username") String username,
                                           @PathVariable("userEmail") String userEmail){
        return new ResponseEntity<>(favoritesService.create(name,username,userEmail),HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update a favorite list for a profile",
            description = "Update a favorite list for a profile by name, username and userEmail",
            tags = { "favorites", "put" })
    @PutMapping("/{name}/{username}/{userEmail}")
    public ResponseEntity<Favorite> update(@PathVariable("name") String name,
                                           @PathVariable("username") String username,
                                           @PathVariable("userEmail") String userEmail,
                                           @PathVariable("newName") String newName){
        return new ResponseEntity<>(favoritesService.update(name,username,userEmail,newName),HttpStatus.OK);
    }
    @Operation(
            summary = "Delete a favorite list for a profile",
            description = "Delete a favorite list for a profile by name, username and userEmail",
            tags = { "favorites", "delete" })
    @DeleteMapping("/{name}/{username}/{userEmail}")
    public ResponseEntity delete(@PathVariable("name") String name,
                                         @PathVariable("username") String username,
                                         @PathVariable("userEmail") String userEmail){
        favoritesService.deleteByName(name,username,userEmail);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
