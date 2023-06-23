package com.usach.movie_backend.producers.controller;

import com.usach.movie_backend.producers.domain.Producer;
import com.usach.movie_backend.producers.service.ProducerService;
import com.usach.movie_backend.producers.service.dto.ProducerCreate;
import com.usach.movie_backend.producers.service.dto.ProducerUpdate;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="producers", description = "Producers Management API")
@RequestMapping("/producers")
@RestController
public class ProducerController {

@Autowired
    private ProducerService producerService;

    @GetMapping
    public ResponseEntity<List<Producer>> findAll(){
        List<Producer>producers = producerService.findAll();
        return new ResponseEntity<>(producers, HttpStatus.OK);
    }
    @GetMapping("/{idProducer}")
    public ResponseEntity<Producer> findById(@PathVariable("idProducer")Integer idProducer){
       return new ResponseEntity<>(producerService.findByIdProducer(idProducer),HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Producer> findByName(@PathVariable("name")String name) {
        return new ResponseEntity<>(producerService.findByName(name), HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<Producer> create(@RequestBody ProducerCreate producerCreate){
        return new ResponseEntity<>(producerService.create(producerCreate),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Producer> update(@RequestBody ProducerUpdate producerUpdate){
        return new ResponseEntity<>(producerService.update(producerUpdate),HttpStatus.OK);
    }
    @DeleteMapping("/{idProducer}")
    public ResponseEntity delete(@PathVariable("idProducer") Integer id){
        producerService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
