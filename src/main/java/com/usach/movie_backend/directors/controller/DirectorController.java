package com.usach.movie_backend.directors.controller;

import com.usach.movie_backend.directors.domain.Director;
import com.usach.movie_backend.directors.service.DirectorService;
import com.usach.movie_backend.profile.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
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
    public ResponseEntity<Director> create(@RequestBody Director director) {
        return new ResponseEntity<>(directorService.create(director), HttpStatus.CREATED);
    }

}


