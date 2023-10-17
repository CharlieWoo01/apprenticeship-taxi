package com.taxiservice.services;

import com.taxiservice.models.Driver;
import com.taxiservice.models.Ratings;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface RatingService {
    ResponseEntity<Ratings> addDriverStarRating(Ratings ratings);

    ResponseEntity<Ratings> getRatingsForDriver(Long driverId);
}
