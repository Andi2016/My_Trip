package com.andi.mytrip.rest;

import com.andi.mytrip.domain.Review;
import com.andi.mytrip.domain.Trip;
import com.andi.mytrip.repository.ReviewRepository;
import com.andi.mytrip.repository.TripRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PostMapping
    public Review addReview(@RequestBody Review review){
        review.setReviewId(getLargestId());
        return reviewRepository.save(review);
    }

    @GetMapping("/{reviewId}")
    public Review getReviewByReviewId(@PathVariable String reviewId){
        return reviewRepository.findByReviewId(reviewId);
    }

    @PutMapping("/{reviewId}")
    public Review updateReviewByReviewId(@RequestBody Review review, @PathVariable String reviewId){
        Review review_origin = reviewRepository.findByReviewId(review.getReviewId());
        if(review_origin != null){
            reviewRepository.save(review);
        }
        return review;
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReviewByReviewId(@PathVariable String reviewId){
        reviewRepository.deleteByReviewId(reviewId);
    }

    private String getLargestId(){
        List<Review> list = reviewRepository.findAll();
        list.sort(new Comparator<Review>() {
            @Override
            public int compare(Review o1, Review o2) {
                return (int) (Integer.parseInt(o2.getReviewId()) - Integer.parseInt(o1.getReviewId()));
            }
        });
        return Integer.parseInt(list.get(0).getReviewId())+1+"";
    }
}
