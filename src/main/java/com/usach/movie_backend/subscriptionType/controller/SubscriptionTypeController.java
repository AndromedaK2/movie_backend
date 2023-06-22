package com.usach.movie_backend.subscriptionType.controller;

import com.usach.movie_backend.subscriptionType.domain.SubscriptionType;
import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.subscriptionType.service.SubscriptionTypeService;
import com.usach.movie_backend.subscriptionType.service.dto.SubscriptionTypeCreate;
import com.usach.movie_backend.subscriptionType.service.dto.SubscriptionTypeUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="subscription types", description = "Subscription Types Management API")
@RestController
@RequestMapping("/subscription-types")
public class SubscriptionTypeController {
    @Autowired
    private SubscriptionTypeService subscriptionTypeService;

    @Operation(
            summary = "Retrieve  Subscription Types",
            description = "Get Subscription Types",
            tags = { "subscription types", "get" })
    @GetMapping
    public ResponseEntity<List<SubscriptionType>>findAll(){
        List<SubscriptionType>subscriptionTypes= subscriptionTypeService.findAll();
        return new ResponseEntity<>(subscriptionTypes, HttpStatus.OK);

    }

    @Operation(
            summary = "Retrieve a Subscription Type by Id",
            description = "Get a Subscription Type object by specifying its id",
            tags = { "subscription types", "get" })
    @GetMapping("/{idSubscriptionType}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable("idSubscriptionType")Integer idSubscriptionType){
        return new ResponseEntity<>(subscriptionTypeService.findByIdSubscriptionType(idSubscriptionType),HttpStatus.OK);
    }

    @Operation(
            summary = "Retrieve a Subscription Type by name",
            description = "Get a Subscription Type object by specifying its name",
            tags = { "subscription types", "get" })
    @GetMapping("/subscriptionTypeName/{subscriptionTypeName}")
    public ResponseEntity<SubscriptionType> findByName(@PathVariable("subscriptionTypeName") SubscriptionTypes subscriptionTypeName){
        return new ResponseEntity<>(subscriptionTypeService.findBySubscriptionTypeName(subscriptionTypeName), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SubscriptionType> create(@RequestBody SubscriptionTypeCreate subscriptionTypeCreate){
        return new ResponseEntity<>(subscriptionTypeService.create(subscriptionTypeCreate),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<SubscriptionType> update(@RequestBody SubscriptionTypeUpdate subscriptionTypeUpdate){
        return new ResponseEntity<>(subscriptionTypeService.update(subscriptionTypeUpdate),HttpStatus.OK);
    }
}
