package com.android.andi.mytrip.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.andi.mytrip.R;
import com.android.andi.mytrip.application.MyTrip;

public class LaunchActivity extends AppCompatActivity {

    private MyTrip mApp;
    private boolean userState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        mApp = (MyTrip) getApplicationContext();
        userState = mApp.getPreference().getAppState(LaunchActivity.this);

        if(userState){
            startActivity(new Intent(LaunchActivity.this, SignUpActivity.class));
            finish();
        }else{
            startActivity(new Intent(LaunchActivity.this, SignInActivity.class));
            finish();
        }
    }

}
