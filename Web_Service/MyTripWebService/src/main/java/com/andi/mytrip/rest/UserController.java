package com.andi.mytrip.rest;

import com.andi.mytrip.domain.Review;
import com.andi.mytrip.domain.Trip;
import com.andi.mytrip.domain.User;
import com.andi.mytrip.repository.ReviewRepository;
import com.andi.mytrip.repository.TripRepository;
import com.andi.mytrip.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;
    private TripRepository tripRepository;
    private ReviewRepository reviewRepository;

    public UserController(UserRepository userRepository, TripRepository tripRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.tripRepository = tripRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        if(!userRepository.findAll().contains(user)){
            userRepository.save(user);
            return user;
        }else{
            return null;
        }
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userRepository.findByUsername(username);
    }

    @PutMapping("/{username}")
    public User updateUserByUsername(@RequestBody User user, @PathVariable String username){
        User user_origin = userRepository.findByUsername(user.getUsername());
        if(user_origin != null){
            userRepository.save(user);
        }
        return user;
    }

    @DeleteMapping("/{username}")
    public void deleteUserByUsername(@PathVariable String username){
        userRepository.deleteByUsername(username);
    }

    @GetMapping("/{username}/trip")
    public List<Trip> getTripsByUsername(@PathVariable String username){
        return tripRepository.findByUsername(username);
    }

    @GetMapping("/{username}/review")
    public List<Review> getReviewsByUsername(@PathVariable String username){
        return reviewRepository.findByUsername(username);
    }
}
