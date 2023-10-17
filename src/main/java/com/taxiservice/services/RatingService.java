package com.taxiservice.services;

import com.taxiservice.models.Rating;
import org.springframework.http.ResponseEntity;

public interface RatingService {
    ResponseEntity<Rating> addDriverStarRating(Rating rating);

    ResponseEntity<Rating> getRatingsForDriver(Long driverId);
}
