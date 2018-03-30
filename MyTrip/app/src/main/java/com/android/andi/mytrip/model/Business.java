package com.android.andi.mytrip.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

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
    //display phone
    private String phone;
    private String tag;

}
