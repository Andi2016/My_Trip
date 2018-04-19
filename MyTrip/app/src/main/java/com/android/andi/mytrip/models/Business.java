package com.android.andi.mytrip.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andi Xu on 3/30/18.
 */


public class Business implements Parcelable {


    private String id;
    private String businessId;
    private String businessName;
    private String photo_url;
    private List<String> address;
    private String city;
    //display phone
    private String phone;
    private String tag;
    private double latitude;
    private double longitude;
    private String price;
    private List<Review> reviews;
    private double rating;

    public Business() {}

    public Business(String id, String businessId, String businessName, String photo_url, List<String> address, String city, String phone, String tag, double latitude, double longitude, String price, List<Review> reviews, double rating) {
        this.id = id;
        this.businessId = businessId;
        this.businessName = businessName;
        this.photo_url = photo_url;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.tag = tag;
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
        this.reviews = reviews;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.businessId);
        dest.writeString(this.businessName);
        dest.writeString(this.photo_url);
        dest.writeStringList(this.address);
        dest.writeString(this.city);
        dest.writeString(this.phone);
        dest.writeString(this.tag);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeString(this.price);
        dest.writeList(this.reviews);
        dest.writeDouble(this.rating);
    }

    protected Business(Parcel in) {
        this.id = in.readString();
        this.businessId = in.readString();
        this.businessName = in.readString();
        this.photo_url = in.readString();
        this.address = in.createStringArrayList();
        this.city = in.readString();
        this.phone = in.readString();
        this.tag = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.price = in.readString();
        this.reviews = new ArrayList<Review>();
        in.readList(this.reviews, Review.class.getClassLoader());
        this.rating = in.readDouble();
    }

    public static final Parcelable.Creator<Business> CREATOR = new Parcelable.Creator<Business>() {
        @Override
        public Business createFromParcel(Parcel source) {
            return new Business(source);
        }

        @Override
        public Business[] newArray(int size) {
            return new Business[size];
        }
    };
}
