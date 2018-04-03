package com.android.andi.mytrip.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

/**
 * Created by Andi Xu on 3/30/18.
 */

@Entity
public class Business {

    @PrimaryKey
    private long id;

    private String name;
    private String photoUrl;
    private String address;
    private String city;
    //display phone
    private String phone;
    private String tag;
    private double latitude;
    private double longitude;
    private int price;


    public Business(long id, String name, String photoUrl, String address, String city, String phone, String tag, double latitude, double longitude, int price) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.tag = tag;
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
