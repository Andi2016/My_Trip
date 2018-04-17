package com.andi.mytrip.repository;

import com.andi.mytrip.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    Review findByReviewId(String reviewId);
    List<Review> findByTripId(String tripId);
    List<Review> findByUsername(String username);
    List<Review> findByBusinessId(String businessId);
    void deleteByReviewId(String reviewId);
}
