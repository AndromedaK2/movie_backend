package com.usach.movie_backend.genders.controller;

import com.usach.movie_backend.genders.domain.GenderMovie;
import com.usach.movie_backend.genders.domain.GenderSerie;
import com.usach.movie_backend.genders.service.GenderMovieService;
import com.usach.movie_backend.genders.service.GenderSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genderserie")
public class GenderSerieController {

    @Autowired
    private GenderSerieService genderSerieService;
    @GetMapping
    public ResponseEntity<List<GenderSerie>> findAll(){
        List<GenderSerie>genderSeries = genderSerieService.findAll();
        return new ResponseEntity<>(genderSeries, HttpStatus.OK);
    }
    @GetMapping("/{idGenderSerie}")
    public ResponseEntity<GenderSerie> findById(@PathVariable("idGenderSerie")Integer idGenderSerie){
        return genderSerieService.findByGenderSerie(idGenderSerie).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<GenderSerie> create(@RequestBody GenderSerie genderSerie){
        return new ResponseEntity<>(genderSerieService.create(genderSerie),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<GenderSerie> update(@RequestBody GenderSerie genderSerie){
        return genderSerieService.findByGenderSerie(genderSerie.getIdGenderSerie())
                .map( u -> ResponseEntity.ok(genderSerieService.update(genderSerie)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idGenderSerie}")
    public ResponseEntity<Object> delete(@PathVariable("idGenderSerie") Integer id){
        return genderSerieService.findByGenderSerie(id)
                .map( u ->{
                    genderSerieService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
