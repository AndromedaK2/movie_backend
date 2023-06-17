package com.usach.movie_backend.producers.controller;


import com.usach.movie_backend.producers.domain.Producer;
import com.usach.movie_backend.producers.service.ProducerService;
import com.usach.movie_backend.profile.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/producer")
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
        return producerService.findByProducer(idProducer).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Producer> create(@RequestBody Producer producer){
        return new ResponseEntity<>(producerService.create(producer),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Producer> update(@RequestBody Producer producer){
        return producerService.findByProducer(producer.getIdProducer())
                .map( u -> ResponseEntity.ok(producerService.update(producer)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idProducer}")
    public ResponseEntity<Object> delete(@PathVariable("idProducer") Integer id){
        return producerService.findByProducer(id)
                .map( u ->{
                    producerService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
