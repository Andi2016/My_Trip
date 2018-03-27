package com.android.andi.mytrip.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Andi Xu on 3/27/18.
 */

public class AppPreference {
    private final String USER_STATE = "user_state";

    private void setPreference(Context context, String name, boolean value){
        if(context == null)
            return;

        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(name, value);
        editor.commit();
    }

    private boolean getPrefernece(Context context, String name, boolean defaultValue){
        if(context == null)
            return defaultValue;

        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_MULTI_PROCESS);
        return sharedPreferences.getBoolean(name, defaultValue);
    }

    public void setUSER_STATE(Context context, boolean value){
        if(context == null)
            return;

        setPreference(context, USER_STATE, value);
    }

    public boolean getAppState(Context context){
        if(context == null)
            return false;
        return getPrefernece(context, USER_STATE, false);
    }
}
