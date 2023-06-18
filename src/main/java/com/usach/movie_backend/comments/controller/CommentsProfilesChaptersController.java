package com.usach.movie_backend.comments.controller;


import com.usach.movie_backend.comments.domain.CommentsProfilesChapters;
import com.usach.movie_backend.comments.service.CommentsProfilesChaptersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commentsprofileschapters")
public class CommentsProfilesChaptersController {
    @Autowired
    private CommentsProfilesChaptersService commentsProfilesChaptersService;
    @GetMapping
    public ResponseEntity<List<CommentsProfilesChapters>> findAll(){
        List<CommentsProfilesChapters>commentsProfilesChapters = commentsProfilesChaptersService.findAll();
        return new ResponseEntity<>(commentsProfilesChapters, HttpStatus.OK);
    }
    @GetMapping("/{idCommentsProfilesChapters}")
    public ResponseEntity<CommentsProfilesChapters> findById(@PathVariable("idCommentsProfilesChapters")Integer idCommentsProfilesChapters){
        return commentsProfilesChaptersService.findByCommentsCommentsProfilesChapters(idCommentsProfilesChapters).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<CommentsProfilesChapters> create(@RequestBody CommentsProfilesChapters commentsProfilesChapters){
        return new ResponseEntity<>(commentsProfilesChaptersService.create(commentsProfilesChapters),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CommentsProfilesChapters> update(@RequestBody CommentsProfilesChapters commentsProfilesChapters){
        return commentsProfilesChaptersService.findByCommentsCommentsProfilesChapters(commentsProfilesChapters.getIdCommentChapter())
                .map( u -> ResponseEntity.ok(commentsProfilesChaptersService.update(commentsProfilesChapters)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idCommentsProfilesChapters}")
    public ResponseEntity<Object> delete(@PathVariable("idCommentsProfilesChapters") Integer id){
        return commentsProfilesChaptersService.findByCommentsCommentsProfilesChapters(id)
                .map( u ->{
                    commentsProfilesChaptersService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
