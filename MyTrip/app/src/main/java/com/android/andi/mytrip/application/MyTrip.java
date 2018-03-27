package com.android.andi.mytrip.application;

import android.app.Application;
import android.content.Context;

import com.android.andi.mytrip.utils.AppPreference;

/**
 * Created by Andi Xu on 3/27/18.
 */

public class MyTrip extends Application {

    private Context mContext;
    private AppPreference mPreference;

    @Override
    public void onCreate(){
        super.onCreate();
        mContext = this;
    }

    public Context getApplicationContext(){
        return mContext;
    }

    public AppPreference getPreference(){
        if(mPreference == null){
            mPreference = new AppPreference();
        }

        return mPreference;
    }


}
