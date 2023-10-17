package com.taxiservice.repository.memory;

import com.taxiservice.models.Driver;
import com.taxiservice.models.Rating;
import com.taxiservice.repository.RatingRepository;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RatingRepositoryMock implements RatingRepository {
    private final Map<Long, Rating> ratingsMap = new HashMap<>();

    private Long nextId = 100L;

    @Override
    public Rating findRatingsByDriver(Long driverId) {
        return ratingsMap.get(driverId);
    }

    @Override
    public void save(Rating rating) {
        Driver driver = rating.getDriver();
        Long driverId = driver.getId();

        if (rating.getId() == null) {
            rating.setId(nextId);
            nextId++;
        }

        // Check if the driver's ratings already exist
        if (ratingsMap.containsKey(driver)) {
            ratingsMap.get(driver).getRatings().addAll(rating.getRatings());
        } else {
            ratingsMap.put(driverId, rating);
        }
    }
}
