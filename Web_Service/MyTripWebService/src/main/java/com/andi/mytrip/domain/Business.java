package com.andi.mytrip.domain;

import org.springframework.data.annotation.Id;

public class Business {

    @Id
    private String businessId;

    private String businessName;
    private String city;
    private String address;
    private double latitude;
    private double longitude;
    private Tag tag;
    private int price;
    private String phone;

    public Business(){};

    public Business(String businessId, String businessName, String city, String address, double latitude, double longitude, Tag tag, int price, String phone) {
        this.businessId = businessId;
        this.businessName = businessName;
        this.city = city;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tag = tag;
        this.price = price;
        this.phone = phone;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
