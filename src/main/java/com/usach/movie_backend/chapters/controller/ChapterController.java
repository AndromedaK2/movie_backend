package com.usach.movie_backend.chapters.controller;


import com.usach.movie_backend.chapters.domain.Chapter;
import com.usach.movie_backend.chapters.service.ChapterService;
import com.usach.movie_backend.chapters.service.dto.ChapterCreate;
import com.usach.movie_backend.chapters.service.dto.ChapterDelete;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chapters")
@Tag(name="chapters", description = "Chapters Management API")
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
    public ResponseEntity<Chapter> create(@RequestBody ChapterCreate chapter){
        return new ResponseEntity<>(chapterService.create(chapter),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Chapter> update(@RequestBody Chapter chapter){
        return chapterService.findByChapter(chapter.getIdChapter())
                .map( u -> ResponseEntity.ok(chapterService.update(chapter)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody ChapterDelete chapterDelete){
        chapterService.delete(chapterDelete);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
