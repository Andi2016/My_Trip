package com.andi.mytrip.domain;

import org.springframework.data.annotation.Id;

public class Trip {
    @Id
    private String tripId;

    private String tripName;
    private String username;
    private String description;
    private String startTime;
    private String endTime;

    public Trip(){}

    public Trip(String tripId, String tripName, String username) {
        this.tripId = tripId;
        this.tripName = tripName;
        this.username = username;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
