package com.usach.movie_backend.profiles.controller;


import com.usach.movie_backend.profiles.domain.ProfileChapter;
import com.usach.movie_backend.profiles.service.ProfileChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profilechapter")
public class ProfileChapterController {
    @Autowired

    private ProfileChapterService profileChapterService ;

    @GetMapping
    public ResponseEntity<List<ProfileChapter>> findAll(){
        List<ProfileChapter>profileChapters = profileChapterService.findAll();
        return new ResponseEntity<>(profileChapters, HttpStatus.OK);
    }
    @GetMapping("/{idProfileChapter}")
    public ResponseEntity<ProfileChapter> findById(@PathVariable("idProfileChapter")Integer idProfileChapter){
        return profileChapterService.findByProfileChapter(idProfileChapter).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<ProfileChapter> create(@RequestBody ProfileChapter profileChapter){
        return new ResponseEntity<>(profileChapterService.create(profileChapter),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProfileChapter> update(@RequestBody ProfileChapter profileChapter){
        return profileChapterService.findByProfileChapter(profileChapter.getIdProfileChapter())
                .map( u -> ResponseEntity.ok(profileChapterService.update(profileChapter)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idProfileChapter}")
    public ResponseEntity<Object> delete(@PathVariable("idProfileChapter") Integer idProfileChapter){
        return profileChapterService.findByProfileChapter(idProfileChapter)
                .map( u ->{
                    profileChapterService.delete(idProfileChapter);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

}
