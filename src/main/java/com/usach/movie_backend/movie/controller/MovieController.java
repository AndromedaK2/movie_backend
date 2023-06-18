package com.usach.movie_backend.movie.controller;

import com.usach.movie_backend.actor.domain.ActorChapter;
import com.usach.movie_backend.movie.domain.Movies;
import com.usach.movie_backend.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
@Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movies>> findAll(){
        List<Movies>movies = movieService.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{idMovie}")
    public ResponseEntity<Movies> findById(@PathVariable("idMovie")Integer idMovie){
        return movieService.findByMovie(idMovie).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Movies> create(@RequestBody Movies movies){
        return new ResponseEntity<>(movieService.create(movies),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Movies> update(@RequestBody Movies movies){
        return movieService.findByMovie(movies.getIdMovie())
                .map( u -> ResponseEntity.ok(movieService.update(movies)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idMovie}")
    public ResponseEntity<Object> delete(@PathVariable("idMovie") Integer id){
        return movieService.findByMovie(id)
                .map( u ->{
                    movieService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

}
