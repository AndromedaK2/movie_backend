package com.usach.movie_backend.actor.controller;

import com.usach.movie_backend.actor.domain.ActorSerie;
import com.usach.movie_backend.actor.service.ActorSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actorserie")
public class ActorSerieController {
    @Autowired
    private ActorSerieService actorSerieService;


    @GetMapping
    public ResponseEntity<List<ActorSerie>> findAll(){
        List<ActorSerie>actorSeries = actorSerieService.findAll();
        return new ResponseEntity<>(actorSeries, HttpStatus.OK);
    }
    @GetMapping("/{idActorSerie}")
    public ResponseEntity<ActorSerie> findById(@PathVariable("idActorSerie")Integer idActorSerie){
        return actorSerieService.findByActorSerie(idActorSerie).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<ActorSerie> create(@RequestBody ActorSerie actorSerie){
        return new ResponseEntity<>(actorSerieService.create(actorSerie),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ActorSerie> update(@RequestBody ActorSerie actorSerie){
        return actorSerieService.findByActorSerie(actorSerie.getIdActorSerie())
                .map( u -> ResponseEntity.ok(actorSerieService.update(actorSerie)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idActorSerie}")
    public ResponseEntity<Object> delete(@PathVariable("idActorSerie") Integer id){
        return actorSerieService.findByActorSerie(id)
                .map( u ->{
                    actorSerieService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
