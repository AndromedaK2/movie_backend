package com.usach.movie_backend.actor.controller;


import com.usach.movie_backend.actor.domain.ActorMovie;
import com.usach.movie_backend.actor.service.ActorChapterService;
import com.usach.movie_backend.actor.service.ActorMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actormovie")
public class ActorMovieController {
    @Autowired
    private ActorMovieService actorMovieService;


    @GetMapping
    public ResponseEntity<List<ActorMovie>> findAll(){
        List<ActorMovie>actorMovies = actorMovieService.findAll();
        return new ResponseEntity<>(actorMovies, HttpStatus.OK);
    }
    @GetMapping("/{idActorMovie}")
    public ResponseEntity<ActorMovie> findById(@PathVariable("idActorMovie")Integer idActorMovie){
        return actorMovieService.findByActorMovie(idActorMovie).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<ActorMovie> create(@RequestBody ActorMovie actorMovie){
        return new ResponseEntity<>(actorMovieService.create(actorMovie),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ActorMovie> update(@RequestBody ActorMovie actorMovie){
        return actorMovieService.findByActorMovie(actorMovie.getIdActorMovie())
                .map( u -> ResponseEntity.ok(actorMovieService.update(actorMovie)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idActorMovie}")
    public ResponseEntity<Object> delete(@PathVariable("idActorMovie") Integer id){
        return actorMovieService.findByActorMovie(id)
                .map( u ->{
                    actorMovieService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
