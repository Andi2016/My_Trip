package com.andi.mytrip.rest;

import com.andi.mytrip.domain.Review;
import com.andi.mytrip.domain.Trip;
import com.andi.mytrip.repository.ReviewRepository;
import com.andi.mytrip.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    private TripRepository tripRepository;
    private ReviewRepository reviewRepository;

    public TripController(TripRepository tripRepository, ReviewRepository reviewRepository){
        this.tripRepository = tripRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping
    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }

    @PostMapping
    public Trip addTrip(@RequestBody Trip trip){
        trip.setTripId(getLargestId());
        tripRepository.save(trip);
        return trip;
    }

    @GetMapping("/{tripId}")
    public Trip getTripByTripId(@PathVariable String tripId){
        return tripRepository.findByTripId(tripId);
    }

    @PutMapping("/{tripId}")
    public Trip updateTripByTripId(@RequestBody Trip trip, @PathVariable String tripId){
        Trip trip_origin = tripRepository.findByTripId(trip.getTripId());
        if(trip_origin != null){
            tripRepository.save(trip);
        }
        return trip;
    }

    @DeleteMapping("/{tripId}")
    public void deleteTripByTripId(@PathVariable String tripId){
        tripRepository.deleteByTripId(tripId);
    }

    @GetMapping("/{tripId}/review")
    public List<Review> getTripReviewByTripId(@PathVariable String tripId){
        return reviewRepository.findByTripId(tripId);
    }

    private String getLargestId(){
        List<Trip> list = tripRepository.findAll();
        list.sort(new Comparator<Trip>() {
            @Override
            public int compare(Trip o1, Trip o2) {
                return (int) (Integer.parseInt(o2.getTripId()) - Integer.parseInt(o1.getTripId()));
            }
        });
        return Integer.parseInt(list.get(0).getTripId())+1+"";
    }

}
