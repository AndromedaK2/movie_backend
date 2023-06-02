package com.usach.movie_backend.actor.controller;

import com.usach.movie_backend.actor.domain.ActorChapter;
import com.usach.movie_backend.actor.service.ActorChapterService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actorchapter")
public class ActorChapterController {

    @Autowired
    private ActorChapterService actorChapterService;


    @GetMapping
    public ResponseEntity<List<ActorChapter>> findAll(){
        List<ActorChapter>actorChapters = actorChapterService.findAll();
        return new ResponseEntity<>(actorChapters, HttpStatus.OK);
    }
    @GetMapping("/{idActorChapter}")
    public ResponseEntity<ActorChapter> findById(@PathVariable("idActorChapter")Integer idActorChapter){
        return actorChapterService.findByActorChapter(idActorChapter).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<ActorChapter> create(@RequestBody ActorChapter actorChapter){
        return new ResponseEntity<>(actorChapterService.create(actorChapter),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ActorChapter> update(@RequestBody ActorChapter actorChapter){
        return actorChapterService.findByActorChapter(actorChapter.getIdActorChapter())
                .map( u -> ResponseEntity.ok(actorChapterService.update(actorChapter)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idActorChapter}")
    public ResponseEntity<Object> delete(@PathVariable("idActorChapter") Integer id){
        return actorChapterService.findByActorChapter(id)
                .map( u ->{
                    actorChapterService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
