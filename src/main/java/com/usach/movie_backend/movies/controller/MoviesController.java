package com.usach.movie_backend.movies.controller;

import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.service.MoviesService;
import com.usach.movie_backend.movies.service.dto.MovieCreate;
import com.usach.movie_backend.movies.service.dto.MovieUpdate;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name="movies", description = "Movies Management API")
@RestController
@RequestMapping("/movies")
public class MoviesController {
@Autowired
    private MoviesService movieService;

    @GetMapping
    public ResponseEntity<Page<Movie>> findAllByFilters(@RequestParam(required = false,value = "page", defaultValue = "0")  Integer page,
                                               @RequestParam(required = false, value = "size", defaultValue = "20")  Integer size,
                                               @RequestParam(required = false,value = "genderName", defaultValue = "") String genderName,
                                               @RequestParam(required = false,value = "producerName",defaultValue = "") String producerName,
                                               @RequestParam(required = false,value = "directorFirstName",defaultValue = "") String directorFirstName,
                                               @RequestParam(required = false,value = "directorLastName",defaultValue = "") String directorLastName,
                                               @RequestParam(required = false,value = "title",defaultValue = "") String title){
        Page<Movie> movies = movieService.findAllByFilters(page,size,genderName,producerName,directorFirstName,directorLastName,title);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @GetMapping("/views")
    public ResponseEntity<List<Movie>> findAllViews(){
        List<Movie>movies= movieService.findAllViews();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @GetMapping("/note")
    public ResponseEntity<List<Movie>> findAllNote(){
        List<Movie>movies= movieService.findAllNote();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Movie> findByTitle(@PathVariable("title")String title){
        Movie movie = movieService.findByTitle(title);
        return new ResponseEntity<>( movie,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody MovieCreate movieCreate){
        return new ResponseEntity<>(movieService.create(movieCreate),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Movie> update(@RequestBody MovieUpdate movieUpdate){
        return new ResponseEntity<>( movieService.update(movieUpdate),HttpStatus.OK);
    }
    @DeleteMapping("/{title}")
    public ResponseEntity<Object> delete(@PathVariable("title")String title){
      movieService.delete(title);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
