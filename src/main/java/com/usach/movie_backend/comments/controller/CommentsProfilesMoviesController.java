package com.usach.movie_backend.comments.controller;


import com.usach.movie_backend.comments.domain.CommentsProfilesMovies;
import com.usach.movie_backend.comments.service.CommentsProfilesMoviesService;
import com.usach.movie_backend.comments.service.dto.CommentProfileMovieCreate;
import com.usach.movie_backend.comments.service.dto.CommentProfileMovieUpdate;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("comments-profiles-movies")
@Tag(name="comments profiles movies", description = "Comments profiles movies Management API")
public class CommentsProfilesMoviesController {
    @Autowired
    private CommentsProfilesMoviesService commentsProfilesMoviesService;
    @GetMapping
    public ResponseEntity<List<CommentsProfilesMovies>> findAll(){
        List<CommentsProfilesMovies>commentsProfilesMovies = commentsProfilesMoviesService.findAll();
        return new ResponseEntity<>(commentsProfilesMovies, HttpStatus.OK);
    }

    @GetMapping("/sum/{idMovie}")
    public Double sumCommentsMovie(@PathVariable("idMovie")Integer idMovie){

        Double prom = commentsProfilesMoviesService.sumCommentsMovie(idMovie)/2;
    return prom;}
    @GetMapping("/number/{idMovie}")
    public Double numCommentsMovie(@PathVariable("idMovie")Integer idMovie){

       return commentsProfilesMoviesService.numberComments(idMovie);}


    @GetMapping("/{idCommentsProfilesMovies}")
    public ResponseEntity<CommentsProfilesMovies> findById(@PathVariable("idCommentsProfilesMovies")Integer idCommentsProfilesMovies){
        return new ResponseEntity<>(commentsProfilesMoviesService.findByCommentsProfilesMovies(idCommentsProfilesMovies), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CommentsProfilesMovies> create(@RequestBody CommentProfileMovieCreate commentProfileMovieCreate){
        return new ResponseEntity<>(commentsProfilesMoviesService.create(commentProfileMovieCreate),HttpStatus.CREATED);
    }



    @PutMapping
    public ResponseEntity<CommentsProfilesMovies> update(@RequestBody CommentProfileMovieUpdate commentProfileMovieUpdate){
        return  new ResponseEntity<>(commentsProfilesMoviesService.update(commentProfileMovieUpdate),HttpStatus.OK);
    }
    @DeleteMapping("/{idCommentsProfilesMovies}")
    public ResponseEntity delete(@PathVariable("idCommentsProfilesMovies") Integer id){
        commentsProfilesMoviesService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
