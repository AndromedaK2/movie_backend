package com.usach.movie_backend.genders.controller;

import com.usach.movie_backend.genders.domain.GenderMovie;
import com.usach.movie_backend.genders.service.GenderMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gendermovie")
public class GenderMovieController {

    @Autowired
    private GenderMovieService genderMovieService;
    @GetMapping
    public ResponseEntity<List<GenderMovie>> findAll(){
        List<GenderMovie>genderMovies = genderMovieService.findAll();
        return new ResponseEntity<>(genderMovies, HttpStatus.OK);
    }
    @GetMapping("/{idGenderMovie}")
    public ResponseEntity<GenderMovie> findById(@PathVariable("idGenderMovie")Integer idGenderMovie){
        return genderMovieService.findByGenderMovie(idGenderMovie).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<GenderMovie> create(@RequestBody GenderMovie genderMovie){
        return new ResponseEntity<>(genderMovieService.create(genderMovie),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<GenderMovie> update(@RequestBody GenderMovie genderMovie){
        return genderMovieService.findByGenderMovie(genderMovie.getIdGenderMovie())
                .map( u -> ResponseEntity.ok(genderMovieService.update(genderMovie)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idGenderMovie}")
    public ResponseEntity<Object> delete(@PathVariable("idGenderMovie") Integer id){
        return genderMovieService.findByGenderMovie(id)
                .map( u ->{
                    genderMovieService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
