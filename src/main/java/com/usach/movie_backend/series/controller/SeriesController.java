package com.usach.movie_backend.series.controller;

import com.usach.movie_backend.series.domain.Serie;
import com.usach.movie_backend.series.service.SerieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="series", description = "Series Management API")
@RestController
@RequestMapping("/series")
public class SeriesController {
    @Autowired
    private SerieService serieService;


    @Operation(
            summary = "Retrieve all Series",
            description = "Get all Series objects",
            tags = { "series", "get" })
    @GetMapping
    public ResponseEntity<List<Serie>> findAll(){
        List<Serie>series = serieService.findAll();
        return new ResponseEntity<>(series, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Serie",
            description = "Get serie by name",
            tags = { "series", "get" })
    @GetMapping("/{name}")
    public ResponseEntity<Serie> findByName(@PathVariable("name")String name){
        return new ResponseEntity<>(serieService.findByName(name),HttpStatus.OK);
    }

    @Operation(
            summary = "Create Serie",
            description = "Create serie",
            tags = { "series", "post" })
    @PostMapping
    public ResponseEntity<Serie> create(@RequestBody Serie series){
        return new ResponseEntity<>(serieService.create(series),HttpStatus.CREATED);
    }

    //@PutMapping
    //public ResponseEntity<Serie> update(@RequestBody Serie series){
    //    return serieService.findBySerie(series.getIdSerie())
      //          .map( u -> ResponseEntity.ok(serieService.update(series)))
      //          .orElseGet(()-> ResponseEntity.notFound().build());
    //}
   // @DeleteMapping("/{idSerie}")
    //public ResponseEntity<Object> delete(@PathVariable("idSerie") Integer id){
     //   return serieService.findBySerie(id)
       //         .map( u ->{
         //           serieService.delete(id);
           //         return ResponseEntity.ok().build();
             //   })
               // .orElseGet(()-> ResponseEntity.notFound().build());
    //}
}
