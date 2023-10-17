package com.taxiservice.services.impl;

import com.taxiservice.models.Ratings;
import com.taxiservice.repository.RatingRepository;
import com.taxiservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public ResponseEntity<Ratings> addDriverStarRating(Ratings ratings) {
        ratingRepository.save(ratings);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratings);
    }

    @Override
    public ResponseEntity<Ratings> getRatingsForDriver(Long driverId) {
        Ratings rating = ratingRepository.findRatingsByDriver(driverId);

        if (rating == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(rating);
    }

}