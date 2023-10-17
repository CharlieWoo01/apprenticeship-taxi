package com.taxiservice.controllers;

import com.taxiservice.models.Rating;
import com.taxiservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping(value = "/rating", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        return ratingService.addDriverStarRating(rating);
    }

    @GetMapping(value = "/rating/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> getRatingsForDriver(@PathVariable Long driverId) {
        return ratingService.getRatingsForDriver(driverId);
    }
}
