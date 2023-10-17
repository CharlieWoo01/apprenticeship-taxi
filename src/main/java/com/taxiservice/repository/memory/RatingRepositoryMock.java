package com.taxiservice.repository.memory;

import com.taxiservice.models.Driver;
import com.taxiservice.models.Ratings;
import com.taxiservice.repository.RatingRepository;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RatingRepositoryMock implements RatingRepository {
    private final Map<Long, Ratings> ratingsMap = new HashMap<>();

    private Long nextId = 100L;

    @Override
    public Ratings findRatingsByDriver(Long driverId) {
        return ratingsMap.get(driverId);
    }

    @Override
    public void save(Ratings ratings) {
        Driver driver = ratings.getDriver();
        Long driverId = driver.getId();

        if (ratings.getId() == null) {
            ratings.setId(nextId);
            nextId++;
        }

        // Check if the driver's ratings already exist
        if (ratingsMap.containsKey(driver)) {
            ratingsMap.get(driver).getRatings().addAll(ratings.getRatings());
        } else {
            ratingsMap.put(driverId, ratings);
        }
    }
}
