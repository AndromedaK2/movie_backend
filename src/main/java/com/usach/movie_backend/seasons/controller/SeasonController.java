package com.usach.movie_backend.seasons.controller;



import com.usach.movie_backend.seasons.domain.Season;
import com.usach.movie_backend.seasons.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/season")
public class SeasonController {
    @Autowired
    private SeasonService seasonService;
    @GetMapping
    public ResponseEntity<List<Season>> findAll(){
        List<Season>seasons = seasonService.findAll();
        return new ResponseEntity<>(seasons, HttpStatus.OK);
    }
    @GetMapping("/{idSeason}")
    public ResponseEntity<Season> findById(@PathVariable("idSeason")Integer idSeason){
        return seasonService.findBySeason(idSeason).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Season> create(@RequestBody Season season){
        return new ResponseEntity<>(seasonService.create(season),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Season> update(@RequestBody Season season){
        return seasonService.findBySeason(season.getIdSeason())
                .map( u -> ResponseEntity.ok(seasonService.update(season)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idSeason}")
    public ResponseEntity<Object> delete(@PathVariable("idSeason") Integer id){
        return seasonService.findBySeason(id)
                .map( u ->{
                    seasonService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
