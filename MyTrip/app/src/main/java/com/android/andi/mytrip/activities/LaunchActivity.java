package com.android.andi.mytrip.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.andi.mytrip.R;
import com.android.andi.mytrip.application.MyTrip;
import com.android.andi.mytrip.database.AppDatabase;

public class LaunchActivity extends AppCompatActivity {

    private MyTrip myTrip;
    private boolean userState;
    public static AppDatabase appDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        myTrip = (MyTrip) getApplicationContext();
        userState = myTrip.getPreference().getAppState(LaunchActivity.this);
        appDatabase = Room.databaseBuilder(myTrip, AppDatabase.class, "My-db").build();

        if(userState){
            startActivity(new Intent(LaunchActivity.this, MainActivity.class));
            finish();
        }else{
            startActivity(new Intent(LaunchActivity.this, SignUpActivity.class));
            //finish();
        }
    }

}
