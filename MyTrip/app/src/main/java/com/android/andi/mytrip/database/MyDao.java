package com.android.andi.mytrip.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.android.andi.mytrip.models.User;

/**
 * Created by Andi Xu on 3/30/18.
 */

@Dao
public interface MyDao {

    /**
     * Operations with "User Table"
     * @param users
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(User... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(User user);

    @Query("SELECT * FROM user")
    public User[] loadAllUsers();

    @Delete
    public void deleteUsers(User... users);

    @Delete
    public void deleteUser(User user);


}