package com.usach.movie_backend.movies.controller;

import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.service.MoviesService;
import com.usach.movie_backend.movies.service.dto.MovieUpdate;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name="movies", description = "Movies Management API")
@RestController
@RequestMapping("/movies")
public class MoviesController {
@Autowired
    private MoviesService movieService;

    @GetMapping
    public ResponseEntity<Page<Movie>> findAll(@RequestParam(required = false,value = "page", defaultValue = "0")  Integer page,
                                               @RequestParam(required = false, value = "size", defaultValue = "20")  Integer size,
                                               @RequestParam(required = false,value = "genderName", defaultValue = "") String genderName,
                                               @RequestParam(required = false,value = "producerName",defaultValue = "") String producerName,
                                               @RequestParam(required = false,value = "directorFirstName",defaultValue = "") String directorFirstName,
                                               @RequestParam(required = false,value = "directorLastName",defaultValue = "") String directorLastName){
        Page<Movie> movies = movieService.findAll(page,size,genderName,producerName,directorFirstName,directorLastName);
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
    public ResponseEntity<Movie> update(@RequestBody MovieUpdate movieUpdate){
        return new ResponseEntity<>( movieService.update(movieUpdate),HttpStatus.OK);
    }
    @DeleteMapping("/{title}")
    public ResponseEntity<Object> delete(@PathVariable("title")String title){
      movieService.delete(title);
      return ResponseEntity.noContent().build();
    }

}
