package com.android.andi.mytrip.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Andi Xu on 3/30/18.
 */


//Room uses the class name as the default database table name
@Entity(indices = {@Index(value = {"username"}, unique = true)})
public class User {

    @NonNull
    @PrimaryKey
    private String username;

    //Add @ColumnInfo annotation to a field to set a different column name in the database

    private String email;
    private String password;

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(long userId) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
