package com.usach.movie_backend.directors.controller;

import com.usach.movie_backend.directors.domain.Director;
import com.usach.movie_backend.directors.service.DirectorService;
import com.usach.movie_backend.directors.service.dto.DirectorCreate;
import com.usach.movie_backend.directors.service.dto.DirectorUpdate;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name="directors", description = "Directors Management API")
@RestController
@RequestMapping("/directors")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<Director>> findAll() {
        List<Director> directors = directorService.findAll();
        return new ResponseEntity<>(directors, HttpStatus.OK);
    }

    @GetMapping("/{idDirector}")
    public ResponseEntity<Director> findById(@PathVariable("idDirector") Integer idDirector) {
        return directorService.findByDirector(idDirector).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<Director> findById(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return new ResponseEntity<>(directorService.findByFirstNameAndLastName(firstName,lastName),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Director> create(@RequestBody DirectorCreate directorCreate) {
        return new ResponseEntity<>(directorService.create(directorCreate), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Director> update(@RequestBody DirectorUpdate directorUpdate) {
        return new ResponseEntity<>(directorService.update(directorUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{idDirector}")
    public ResponseEntity delete(@PathVariable("idDirector") Integer idDirector){
        directorService.delete(idDirector);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}


