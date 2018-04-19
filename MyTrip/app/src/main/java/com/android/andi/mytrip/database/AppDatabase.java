package com.android.andi.mytrip.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.android.andi.mytrip.models.User;

/**
 * Created by Andi Xu on 3/30/18.
 */

//create an instance of the database using Singleton
@Database(entities = {User.class}, version =1)
public abstract class AppDatabase extends RoomDatabase{
    private static AppDatabase INSTANCE;

    public abstract MyDao myDao();

    public static AppDatabase getAppDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "mydb").build();
        }
        return INSTANCE;
    }

    public void destroyInstance(){
        INSTANCE = null;
    }
}