package com.android.andi.mytrip.models;

import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andi Xu on 3/30/18.
 */

public class Trip {

    private String trip_id;
    private String trip_name;
    private String username;
    private List<Review> reviews = new ArrayList<>();
    private String description;

    public Trip() {}

    public Trip(String trip_id, String trip_name, String username, List<Review> reviews, String description) {
        this.trip_id = trip_id;
        this.trip_name = trip_name;
        this.username = username;
        this.reviews = reviews;
        this.description = description;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getTrip_name() {
        return trip_name;
    }

    public void setTrip_name(String trip_name) {
        this.trip_name = trip_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
