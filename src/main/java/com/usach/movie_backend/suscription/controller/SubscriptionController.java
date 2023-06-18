package com.usach.movie_backend.suscription.controller;



import com.usach.movie_backend.subscriptionType.domain.SubscriptionTypes;
import com.usach.movie_backend.suscription.domain.Subscription;
import com.usach.movie_backend.suscription.service.SubscriptionService;
import com.usach.movie_backend.user.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@Tag(name="subscriptions", description = "Subscriptions Management API")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping
    public ResponseEntity<List<Subscription>> findAll(){
        List<Subscription>subscriptions = subscriptionService.findAll();
        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
    }
    @GetMapping("/{idSubscription}")
    public ResponseEntity<Subscription> findById(@PathVariable("idSubscription")Integer idSubscription){
        return subscriptionService.findBySubscription(idSubscription).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @Transactional
    @PostMapping("/{userEmail}/{subscriptionType}")
    public ResponseEntity<Subscription> create(@PathVariable("userEmail") String userEmail , @PathVariable("subscriptionType")SubscriptionTypes subscriptionTypes){
        return new ResponseEntity<>(subscriptionService.create(userEmail,subscriptionTypes),HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Subscription> update(@RequestBody Subscription subscription){
        return subscriptionService.findBySubscription(subscription.getIdSubscription())
                .map( u -> ResponseEntity.ok(subscriptionService.update(subscription)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{idSubscription}")
    public ResponseEntity<Object> delete(@PathVariable("idSubscription") Integer id){
        return subscriptionService.findBySubscription(id)
                .map( u ->{
                    subscriptionService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Pay subscription",
            description = "Pay subscription by using email and money",
            tags = { "subscriptions", "put" })
    @PutMapping("/pay/{email}/{money}")
    public ResponseEntity<User> paySubscription(@PathVariable("email") String email, @PathVariable("money") @Positive(message = "value must be positive") @Min(value = 0,
            message = "Invalid amount of money:  Less than zero") Float money){
        return new ResponseEntity<>(subscriptionService.paySubscription(email,money),HttpStatus.OK);
    }

}
