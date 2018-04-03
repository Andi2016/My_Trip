package com.android.andi.mytrip.activities;


import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.andi.mytrip.Fragments.BusinessListFragment;
import com.android.andi.mytrip.Fragments.TripListFragment;
import com.android.andi.mytrip.R;
import com.android.andi.mytrip.application.MyTrip;
import com.android.andi.mytrip.asynctasks.GetUserTask;
import com.android.andi.mytrip.database.AppDatabase;
import com.android.andi.mytrip.models.User;

import static com.android.andi.mytrip.activities.LaunchActivity.appDatabase;

public class MainActivity extends AppCompatActivity {
    private MyTrip myTrip;
    public static String error="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTrip = (MyTrip) getApplicationContext();


        GetUserTask getUserTask = new GetUserTask();
        getUserTask.execute();

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = BusinessListFragment.newInstance();;
                                break;
                            case R.id.action_item2:
                                selectedFragment = BusinessListFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, TripListFragment.newInstance());
        transaction.commit();


    }


}
