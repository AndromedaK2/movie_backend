package com.usach.movie_backend.seasons.controller;

import com.usach.movie_backend.seasons.domain.Season;
import com.usach.movie_backend.seasons.service.SeasonCreate;
import com.usach.movie_backend.seasons.service.SeasonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seasons")
@Tag(name="seasons", description = "Seasons Management API")
public class SeasonController {
    @Autowired
    private SeasonService seasonService;
    @GetMapping
    public ResponseEntity<List<Season>> findAll(){
        List<Season>seasons = seasonService.findAll();
        return new ResponseEntity<>(seasons, HttpStatus.OK);
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Season>>findByTitle(@RequestParam(required = false,value = "title",defaultValue = "")String title){
        List<Season> seasons = seasonService.findAllByTitle(title);
        return new ResponseEntity<>(seasons,HttpStatus.OK);
    }

    @GetMapping("/{idSeason}")
    public ResponseEntity<Season> findById(@PathVariable("idSeason")Integer idSeason){
        return new ResponseEntity<>(seasonService.findBySeason(idSeason), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Season> create(@RequestBody SeasonCreate season){
        return new ResponseEntity<>(seasonService.create(season),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Season> update(@RequestBody Season season){
        return new ResponseEntity<>(seasonService.update(season),HttpStatus.OK);
    }

    @DeleteMapping("/{idSeason}")
    public ResponseEntity delete(@PathVariable("idSeason") Integer id){
         seasonService.delete(id);
         return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
