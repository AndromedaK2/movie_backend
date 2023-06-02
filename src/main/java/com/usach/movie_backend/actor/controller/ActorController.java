package com.usach.movie_backend.actor.controller;

import com.usach.movie_backend.actor.domain.Actor;
import com.usach.movie_backend.actor.domain.ActorChapter;
import com.usach.movie_backend.actor.service.ActorChapterService;
import com.usach.movie_backend.actor.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;


    @GetMapping
    public ResponseEntity<List<Actor>> findAll(){
        List<Actor>actors = actorService.findAll();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }
    @GetMapping("/{idActor}")
    public ResponseEntity<Actor> findById(@PathVariable("idActor")Integer idActor){
        return actorService.findByActor(idActor).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Actor> create(@RequestBody Actor actor){
        return new ResponseEntity<>(actorService.create(actor),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Actor> update(@RequestBody Actor actor){
        return actorService.findByActor(actor.getIdActor())
                .map( u -> ResponseEntity.ok(actorService.update(actor)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idActor}")
    public ResponseEntity<Object> delete(@PathVariable("idActor") Integer id){
        return actorService.findByActor(id)
                .map( u ->{
                    actorService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
