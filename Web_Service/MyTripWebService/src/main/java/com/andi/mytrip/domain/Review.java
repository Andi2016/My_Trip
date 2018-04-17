package com.andi.mytrip.domain;

public class Review {

    private String reviewId;
    private String username;
    private String businessId;
    private String tripId;
    private String content;
    private String date;

    public Review(String reviewId, String username, String businessId, String tripId, String content, String date) {
        this.reviewId = reviewId;
        this.username = username;
        this.businessId = businessId;
        this.tripId = tripId;
        this.content = content;
        this.date = date;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
