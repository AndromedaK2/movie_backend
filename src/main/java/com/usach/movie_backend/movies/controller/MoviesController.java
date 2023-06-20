package com.usach.movie_backend.movies.controller;

import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.service.MoviesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name="movies", description = "Movies Management API")
@RestController
@RequestMapping("/movie")
public class MoviesController {
@Autowired
    private MoviesService movieService;

    @GetMapping
    public ResponseEntity<Page<Movie>> findAll(@RequestParam(required = false,value = "page", defaultValue = "0")  Integer page,
                                               @RequestParam( required = false, value = "size", defaultValue = "20")  Integer size ){
        Page<Movie> movies = movieService.findAll(page,size);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Movie> findByTitle(@PathVariable("title")String title){
        Movie movie = movieService.findByTitle(title);
        return new ResponseEntity<>( movie,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movies){
        return new ResponseEntity<>(movieService.create(movies),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Movie> update(@RequestBody Movie movies){
        return movieService.findByMovieId(movies.getIdMovie())
                .map( u -> ResponseEntity.ok(movieService.update(movies)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idMovie}")
    public ResponseEntity<Object> delete(@PathVariable("idMovie") Integer id){
        return movieService.findByMovieId(id)
                .map( u ->{
                    movieService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

}
