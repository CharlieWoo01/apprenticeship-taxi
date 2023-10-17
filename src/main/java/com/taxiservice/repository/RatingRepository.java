package com.taxiservice.repository;

import com.taxiservice.models.Ratings;

public interface RatingRepository {
    void save(Ratings rating);
    Ratings findRatingsByDriver(Long driverId);
}
