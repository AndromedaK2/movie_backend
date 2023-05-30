package com.usach.movie_backend.subscriptionType.controller;


import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.service.SubscriptionTypeService;
import com.usach.movie_backend.suscription.domain.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptiontype")
public class SubscriptionTypeController {
    @Autowired
    private SubscriptionTypeService subscriptionTypeService;

    @GetMapping
    public ResponseEntity<List<SubscriptionType>>findAll(){
        List<SubscriptionType>subscriptionTypes= subscriptionTypeService.findAll();
        return new ResponseEntity<>(subscriptionTypes, HttpStatus.OK);

    }
    @GetMapping("/{idSubscriptionType}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable("idSubscriptionType")Integer idSubscriptionType){
        return subscriptionTypeService.findBySubscriptionType(idSubscriptionType).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<SubscriptionType> create(@RequestBody SubscriptionType subscriptionType){
        return new ResponseEntity<>(subscriptionTypeService.create(subscriptionType),HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<SubscriptionType> update(@RequestBody SubscriptionType subscriptionType){
        return subscriptionTypeService.findBySubscriptionType(subscriptionType.getIdSubscriptionType())
                .map( u -> ResponseEntity.ok(subscriptionTypeService.update(subscriptionType)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idSubscriptionType}")
    public ResponseEntity<Object> delete(@PathVariable("idSubscriptionType") Integer id){
        return subscriptionTypeService.findBySubscriptionType(id)
                .map( u ->{
                    subscriptionTypeService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
