package com.taxiservice.repository;

import com.taxiservice.models.Rating;

public interface RatingRepository {
    void save(Rating rating);
    Rating findRatingsByDriver(Long driverId);
}
