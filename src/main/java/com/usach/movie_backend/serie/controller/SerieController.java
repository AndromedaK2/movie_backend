package com.usach.movie_backend.serie.controller;


import com.usach.movie_backend.serie.domain.Series;
import com.usach.movie_backend.serie.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serie")
public class SerieController {
    @Autowired
    private SerieService serieService;


    @GetMapping
    public ResponseEntity<List<Series>> findAll(){
        List<Series>series = serieService.findAll();
        return new ResponseEntity<>(series, HttpStatus.OK);
    }
    @GetMapping("/{idSerie}")
    public ResponseEntity<Series> findById(@PathVariable("idSerie")Integer idSerie){
        return serieService.findBySerie(idSerie).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Series> create(@RequestBody Series series){
        return new ResponseEntity<>(serieService.create(series),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Series> update(@RequestBody Series series){
        return serieService.findBySerie(series.getIdSerie())
                .map( u -> ResponseEntity.ok(serieService.update(series)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idSerie}")
    public ResponseEntity<Object> delete(@PathVariable("idSerie") Integer id){
        return serieService.findBySerie(id)
                .map( u ->{
                    serieService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
