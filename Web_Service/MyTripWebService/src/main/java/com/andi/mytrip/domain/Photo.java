package com.andi.mytrip.domain;

import org.springframework.data.annotation.Id;

public class Photo {

    @Id
    private String businessId;
    private String photo_url;
    private String username;

    public Photo(String businessId, String photo_url, String username) {
        this.businessId = businessId;
        this.photo_url = photo_url;
        this.username = username;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
