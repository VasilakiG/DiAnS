package com.dians.backend.controller;

import com.dians.backend.model.Landmark;
import com.dians.backend.service.LandmarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Validated
@CrossOrigin(origins = "*")
public class LandmarkController {
    private final LandmarkService landmarkService;

    public LandmarkController(LandmarkService landmarkService) {
        this.landmarkService = landmarkService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Landmark>> getLandmarksPage(){
        return new ResponseEntity<>(landmarkService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Optional<Landmark>> getSingleLandmarkPage(@PathVariable Long id){
        return new ResponseEntity<>(landmarkService.findById(id), HttpStatus.OK);
    }
}
