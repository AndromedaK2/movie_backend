package com.usach.movie_backend.chapters.controller;


import com.usach.movie_backend.chapters.domain.Chapter;
import com.usach.movie_backend.chapters.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @GetMapping
    public ResponseEntity<List<Chapter>> findAll(){
        List<Chapter>chapters = chapterService.findAll();
        return new ResponseEntity<>(chapters, HttpStatus.OK);
    }
    @GetMapping("/{idChapter}")
    public ResponseEntity<Chapter> findById(@PathVariable("idChapter")Integer idChapter){
        return chapterService.findByChapter(idChapter).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Chapter> create(@RequestBody Chapter chapter){
        return new ResponseEntity<>(chapterService.create(chapter),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Chapter> update(@RequestBody Chapter chapter){
        return chapterService.findByChapter(chapter.getIdChapter())
                .map( u -> ResponseEntity.ok(chapterService.update(chapter)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idChapter}")
    public ResponseEntity<Object> delete(@PathVariable("idChapter") Integer id){
        return chapterService.findByChapter(id)
                .map( u ->{
                    chapterService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
