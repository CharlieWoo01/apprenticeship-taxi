package com.taxiservice.controllers;

import com.taxiservice.models.Ratings;
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
import java.util.List;

@RestController
@RequestMapping("/api")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping(value = "/rating", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ratings> addRating(@RequestBody Ratings ratings) {
        return ratingService.addDriverStarRating(ratings);
    }

    @GetMapping(value = "/rating/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ratings> getRatingsForDriver(@PathVariable Long driverId) {
        return ratingService.getRatingsForDriver(driverId);
    }
}
