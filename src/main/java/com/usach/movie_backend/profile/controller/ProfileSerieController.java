package com.usach.movie_backend.profile.controller;

import com.usach.movie_backend.profile.domain.ProfileSerie;
import com.usach.movie_backend.profile.service.ProfileSerieService;
import com.usach.movie_backend.profile.service.dto.ViewLaterSerie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="profile series", description = "Profile series management API")
@RestController
@RequestMapping("/profile-series")
public class ProfileSerieController {

    @Autowired

    private ProfileSerieService profileSerieService;

    @Operation(
            summary = "Retrieve all profile series",
            description = "Get all profile series objects",
            tags = { "profile series", "get" })
    @GetMapping
    public ResponseEntity<List<ProfileSerie>> findAll() {
        List<ProfileSerie> profileSeries = profileSerieService.findAll();
        return new ResponseEntity<>(profileSeries, HttpStatus.OK);
    }

    @Operation(
            summary = "Mark viewLater a specific serie",
            description = "Create profile serie",
            tags = { "profile series", "post" })
    @PostMapping
    public ResponseEntity<ProfileSerie> markViewLater(@RequestBody ViewLaterSerie viewLaterSerie){
        return new ResponseEntity<>(profileSerieService.create(viewLaterSerie),HttpStatus.CREATED);
    }

    @Operation(
            summary = "DesMark viewLater a specific serie",
            description = "Delete profile series",
            tags = { "profile series", "delete" })
    @DeleteMapping
    public ResponseEntity desMarkViewLater(@RequestBody ViewLaterSerie  viewLaterMovie){
        profileSerieService.delete(viewLaterMovie);
        return ResponseEntity.noContent().build();
    }
}

