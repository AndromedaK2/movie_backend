package com.usach.movie_backend.profile.controller;

import com.usach.movie_backend.profile.domain.ProfileMovie;
import com.usach.movie_backend.profile.domain.ProfileSerie;
import com.usach.movie_backend.profile.service.ProfileMovieService;
import com.usach.movie_backend.profile.service.ProfileSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profileserie")
public class ProfileSerieController {

    @Autowired

    private ProfileSerieService profileSerieService;

    @GetMapping
    public ResponseEntity<List<ProfileSerie>> findAll(){
        List<ProfileSerie>profileSeries = profileSerieService.findAll();
        return new ResponseEntity<>(profileSeries, HttpStatus.OK);
    }
    @GetMapping("/{idProfileSerie}")
    public ResponseEntity<ProfileSerie> findById(@PathVariable("idProfileSerie")Integer idProfileMovie){
        return profileSerieService.findByProfileSerie(idProfileMovie).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<ProfileSerie> create(@RequestBody ProfileSerie profileSerie){
        return new ResponseEntity<>(profileSerieService.create(profileSerie),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProfileSerie> update(@RequestBody ProfileSerie profileSerie ){
        return profileSerieService.findByProfileSerie(profileSerie.getIdProfileSerie())
                .map( u -> ResponseEntity.ok(profileSerieService.update(profileSerie)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{idProfileSerie}")
    public ResponseEntity<Object> delete(@PathVariable("idProfileSerie") Integer idProfileSerie){
        return profileSerieService.findByProfileSerie(idProfileSerie)
                .map( u ->{
                    profileSerieService.delete(idProfileSerie);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
