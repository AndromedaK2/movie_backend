package com.usach.movie_backend.comments.controller;


import com.usach.movie_backend.comments.domain.CommentsProfilesSeries;
import com.usach.movie_backend.comments.service.CommentsProfilesSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commentsprofilesseries")
public class CommentsProfilesSeriesController {
    @Autowired
    private CommentsProfilesSeriesService profilesSeriesService;
    @GetMapping
    public ResponseEntity<List<CommentsProfilesSeries>> findAll(){
        List<CommentsProfilesSeries>commentsProfilesSeries = profilesSeriesService.findAll();
        return new ResponseEntity<>(commentsProfilesSeries, HttpStatus.OK);
    }
    @GetMapping("/{idCommentsProfilesSeries}")
    public ResponseEntity<CommentsProfilesSeries> findById(@PathVariable("idCommentsProfilesSeries")Integer idCommentsProfilesSeries){
        return profilesSeriesService.findByCommentsProfilesSeries(idCommentsProfilesSeries).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<CommentsProfilesSeries> create(@RequestBody CommentsProfilesSeries commentsProfilesSeries){
        return new ResponseEntity<>(profilesSeriesService.create(commentsProfilesSeries),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CommentsProfilesSeries> update(@RequestBody CommentsProfilesSeries commentsProfilesSeries){
        return profilesSeriesService.findByCommentsProfilesSeries(commentsProfilesSeries.getIdCommentSerie())
                .map( u -> ResponseEntity.ok(profilesSeriesService.update(commentsProfilesSeries)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idCommentsProfilesSeries}")
    public ResponseEntity<Object> delete(@PathVariable("idCommentsProfilesSeries") Integer id){
        return profilesSeriesService.findByCommentsProfilesSeries(id)
                .map( u ->{
                    profilesSeriesService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
