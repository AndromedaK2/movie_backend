package com.usach.movie_backend.directors.controller;

import com.usach.movie_backend.directors.domain.Director;
import com.usach.movie_backend.directors.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<Director>>findAll(){
        List<Director>directors = directorService.findAll();
        return  new ResponseEntity<>(directors, HttpStatus.OK);
    }
}
