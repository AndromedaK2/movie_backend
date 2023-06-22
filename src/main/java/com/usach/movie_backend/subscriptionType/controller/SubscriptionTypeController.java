package com.usach.movie_backend.subscriptionType.controller;


import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.subscriptionType.service.SubscriptionTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="subscription type", description = "Subscription Type Management API")
@RestController
@RequestMapping("/subscriptiontypes")
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
        return subscriptionTypeService.findByIdSubscriptionType(idSubscriptionType).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/subscriptionTypeName/{subscriptionTypeName}")
    public ResponseEntity<Optional<SubscriptionType>> findByName(@PathVariable("subscriptionTypeName") SubscriptionTypes subscriptionTypeName){
        return new ResponseEntity<>(subscriptionTypeService.findBySubscriptionTypeName(subscriptionTypeName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubscriptionType> create(@RequestBody SubscriptionType subscriptionType){
        return new ResponseEntity<>(subscriptionTypeService.create(subscriptionType),HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<SubscriptionType> update(@RequestBody SubscriptionType subscriptionType){
        return subscriptionTypeService.findByIdSubscriptionType(subscriptionType.getIdSubscriptionType())
                .map( u -> ResponseEntity.ok(subscriptionTypeService.update(subscriptionType)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
