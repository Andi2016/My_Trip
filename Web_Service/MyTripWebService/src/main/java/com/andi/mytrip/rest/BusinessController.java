package com.andi.mytrip.rest;

import com.andi.mytrip.domain.Business;
import com.andi.mytrip.domain.Photo;
import com.andi.mytrip.domain.Review;
import com.andi.mytrip.domain.Trip;
import com.andi.mytrip.repository.BusinessRepository;
import com.andi.mytrip.repository.PhotoRepository;
import com.andi.mytrip.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessController {

    private BusinessRepository businessRepository;
    private ReviewRepository reviewRepository;
    private PhotoRepository photoRepository;

    public BusinessController(BusinessRepository businessRepository, ReviewRepository reviewRepository, PhotoRepository photoRepository) {
        this.businessRepository = businessRepository;
        this.reviewRepository = reviewRepository;
        this.photoRepository = photoRepository;
    }

    @GetMapping
    public List<Business> getAllBusinesses(){
        return businessRepository.findAll();
    }

    @PostMapping
    public Business addBusiness(@RequestBody Business business){
        business.setBusinessId(getLargestId());
        businessRepository.save(business);
        return business;
    }

    @GetMapping("/{businessId}")
    public Business getBusinessByBusinessId(@PathVariable String businessId){
        return businessRepository.findByBusinessId(businessId);
    }

    @PutMapping("/{businessId}")
    public Business updateBusinessByBusinessId(@RequestBody Business business, @PathVariable String businessId){
        Business business_origin = businessRepository.findByBusinessId(business.getBusinessId());
        if(business_origin != null){
            businessRepository.save(business);
        }
        return business;
    }

    @DeleteMapping("/{businessId}")
    public void deleteBusinessByBusinessId(@PathVariable String businessId){
        businessRepository.deleteByBusinessId(businessId);
    }

    @GetMapping("/{businessId}/review")
    public List<Review> getReviewsByBusinessId(@PathVariable String businessId){
        return reviewRepository.findByBusinessId(businessId);
    }

    @GetMapping("/{businessId}/photo")
    public List<Photo> getPhotosByBusinessId(@PathVariable String businessId){
        return photoRepository.findByBusinessId(businessId);
    }


    private String getLargestId(){
        List<Business> list = businessRepository.findAll();
        list.sort(new Comparator<Business>() {
            @Override
            public int compare(Business o1, Business o2) {
                return (int) (Integer.parseInt(o2.getBusinessId()) - Integer.parseInt(o1.getBusinessId()));
            }
        });
        return Integer.parseInt(list.get(0).getBusinessId())+1+"";
    }
}
