package com.usach.movie_backend.genders.controller;


import com.usach.movie_backend.genders.domain.Gender;
import com.usach.movie_backend.genders.service.GenderService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name="genders", description = "Genders management API")
@RestController
@RequestMapping("/genders")
public class GenderController {

    @Autowired
    private GenderService genderService;


    @GetMapping
    public ResponseEntity<List<Gender>> findAll(){
        List<Gender>profiles = genderService.findAll();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
    @GetMapping("/{idGender}")
    public ResponseEntity<Gender> findById(@PathVariable("idGender")Integer idGender){
        return genderService.findByGender(idGender).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Gender> findByName(@PathVariable("name")String name){
        return new ResponseEntity<>(genderService.findByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Gender> create(@RequestBody Gender gender){
        return new ResponseEntity<>(genderService.create(gender),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Gender> update(@RequestBody Gender gender){
        return genderService.findByGender(gender.getIdGender())
                .map( u -> ResponseEntity.ok(genderService.update(gender)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idGender}")
    public ResponseEntity<Object> delete(@PathVariable("idGender") Integer id){
        return genderService.findByGender(id)
                .map( u ->{
                    genderService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
