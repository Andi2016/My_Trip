package com.android.andi.mytrip.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Andi Xu on 3/30/18.
 */

public class Review implements Parcelable {
    private String reviewId;
    private String username;
    private double rating;
    private String date;
    private String content;
    private String photo_url;
    private String businessId;

    public Review() {}

    public Review(String reviewId, String username, double rating, String date, String content, String photo_url) {
        this.reviewId = reviewId;
        this.username = username;
        this.rating = rating;
        this.date = date;
        this.content = content;
        this.photo_url = photo_url;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.reviewId);
        dest.writeString(this.username);
        dest.writeDouble(this.rating);
        dest.writeString(this.date);
        dest.writeString(this.content);
        dest.writeString(this.photo_url);
        dest.writeString(this.businessId);
    }

    protected Review(Parcel in) {
        this.reviewId = in.readString();
        this.username = in.readString();
        this.rating = in.readDouble();
        this.date = in.readString();
        this.content = in.readString();
        this.photo_url = in.readString();
        this.businessId = in.readString();
    }

    public static final Creator<Review> CREATOR = new Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel source) {
            return new Review(source);
        }

        @Override
        public Review[] newArray(int size) {
            return new Review[size];
        }
    };
}


