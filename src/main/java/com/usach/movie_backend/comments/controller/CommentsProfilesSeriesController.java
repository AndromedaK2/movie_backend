package com.usach.movie_backend.comments.controller;


import com.usach.movie_backend.comments.domain.CommentsProfilesSeries;
import com.usach.movie_backend.comments.service.CommentsProfilesSeriesService;
import com.usach.movie_backend.comments.service.dto.CommentProfileSerieCreate;
import com.usach.movie_backend.comments.service.dto.CommentProfileSerieUpdate;
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
        return new ResponseEntity<>(profilesSeriesService.findByCommentsProfilesSeries(idCommentsProfilesSeries),HttpStatus.OK);
    }
    @GetMapping("/note/{idCommentsProfilesSeries}")
    public double commentsSerieAVG(@PathVariable("idCommentsProfilesSeries")Integer idCommentsProfilesSeries){
        return profilesSeriesService.commentsSerieAVG(idCommentsProfilesSeries);
    }
    @PostMapping
    public ResponseEntity<CommentsProfilesSeries> create(@RequestBody CommentProfileSerieCreate commentProfileSerieCreate){
        return new ResponseEntity<>(profilesSeriesService.create(commentProfileSerieCreate),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CommentsProfilesSeries> update(@RequestBody CommentProfileSerieUpdate commentProfileSerieUpdate){
        return new ResponseEntity<>(profilesSeriesService.update(commentProfileSerieUpdate),HttpStatus.OK);
    }
    @DeleteMapping("/{idCommentsProfilesSeries}")
    public ResponseEntity<Object> delete(@PathVariable("idCommentsProfilesSeries") Integer id){
       profilesSeriesService.delete(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
