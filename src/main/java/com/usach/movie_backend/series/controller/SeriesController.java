package com.usach.movie_backend.series.controller;

import com.usach.movie_backend.series.domain.Serie;
import com.usach.movie_backend.series.service.SerieService;
import com.usach.movie_backend.series.service.dto.SerieCreate;
import com.usach.movie_backend.series.service.dto.SerieUpdate;
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
    public ResponseEntity<Serie> create(@RequestBody SerieCreate serieCreate){
        return new ResponseEntity<>(serieService.create(serieCreate),HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update Serie",
            description = "Update serie",
            tags = { "series", "put" })
    @PutMapping
    public ResponseEntity<Serie> update(@RequestBody SerieUpdate serieUpdate){
        return new ResponseEntity<>(serieService.update(serieUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{idSerie}")
    public ResponseEntity delete(@PathVariable("idSerie") Integer id){
        serieService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
