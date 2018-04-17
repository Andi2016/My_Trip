package com.andi.mytrip.repository;

import com.andi.mytrip.domain.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TripRepository extends MongoRepository<Trip, String>{
    Trip findByTripId(String tripId);
    List<Trip> findByUsername(String username);
    void deleteByTripId(String tripId);
}
