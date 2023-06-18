package com.usach.movie_backend.comments.controller;


import com.usach.movie_backend.comments.domain.CommentsProfilesMovies;
import com.usach.movie_backend.comments.service.CommentsProfilesMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commentsprofilesmovies")
public class CommentsProfilesMoviesController {
    @Autowired
    private CommentsProfilesMoviesService commentsProfilesMoviesService;
    @GetMapping
    public ResponseEntity<List<CommentsProfilesMovies>> findAll(){
        List<CommentsProfilesMovies>commentsProfilesMovies = commentsProfilesMoviesService.findAll();
        return new ResponseEntity<>(commentsProfilesMovies, HttpStatus.OK);
    }
    @GetMapping("/{idCommentsProfilesMovies}")
    public ResponseEntity<CommentsProfilesMovies> findById(@PathVariable("idCommentsProfilesMovies")Integer idCommentsProfilesMovies){
        return commentsProfilesMoviesService.findByCommentsProfilesMovies(idCommentsProfilesMovies).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<CommentsProfilesMovies> create(@RequestBody CommentsProfilesMovies commentsProfilesMovies){
        return new ResponseEntity<>(commentsProfilesMoviesService.create(commentsProfilesMovies),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CommentsProfilesMovies> update(@RequestBody CommentsProfilesMovies commentsProfilesMovies){
        return commentsProfilesMoviesService.findByCommentsProfilesMovies(commentsProfilesMovies.getIdCommentMovie())
                .map( u -> ResponseEntity.ok(commentsProfilesMoviesService.update(commentsProfilesMovies)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idCommentsProfilesMovies}")
    public ResponseEntity<Object> delete(@PathVariable("idCommentsProfilesMovies") Integer id){
        return commentsProfilesMoviesService.findByCommentsProfilesMovies(id)
                .map( u ->{
                    commentsProfilesMoviesService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
