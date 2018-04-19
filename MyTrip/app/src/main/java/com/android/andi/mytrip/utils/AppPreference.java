package com.android.andi.mytrip.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.andi.mytrip.models.Business;
import com.android.andi.mytrip.models.User;
import com.google.gson.Gson;

/**
 * Created by Andi Xu on 4/4/18.
 */

public class AppPreference {
    private final String PREF_APP_STATE = "appstate";
    private final String PREF_USER = "user";
    private final String PREF_BUSINESS = "business";

    //This function is used to clear all the preferences.
    public void clearAll(Context context) {
        SharedPreferences oSharedPreference = context.getSharedPreferences(context.getPackageName(), Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor oEditor = oSharedPreference.edit();
        oEditor.clear();
        oEditor.commit();
    }

    private void setPreference(Context context, String name, boolean value) {
        if (context == null)
            return;
        SharedPreferences oSharedPreference = context.getSharedPreferences(context.getPackageName(), Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor oEditor = oSharedPreference.edit();
        oEditor.putBoolean(name, value);
        oEditor.commit();
    }

    private boolean getPreference(Context context, String name, boolean defaultValue) {
        if (context == null)
            return defaultValue;
        SharedPreferences oSharedPreference = context.getSharedPreferences(context.getPackageName(), Context.MODE_MULTI_PROCESS);
        return oSharedPreference.getBoolean(name, defaultValue);
    }

    private void setPreference(Context context, String name, String value) {
        if (context == null)
            return;
        SharedPreferences oSharedPreference = context.getSharedPreferences(context.getPackageName(), Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor oEditor = oSharedPreference.edit();
        oEditor.putString(name, value);
        oEditor.commit();
    }

    private String getPreference(Context context, String name, String defaultValue) {
        if (context == null)
            return defaultValue;
        SharedPreferences oSharedPreference = context.getSharedPreferences(context.getPackageName(), Context.MODE_MULTI_PROCESS);
        return oSharedPreference.getString(name, defaultValue);
    }

    //Get and set the current user state.
    //Weather the user has logged in or not
    public void setAppState(Context context, boolean val) {
        if (context == null)
            return;
        setPreference(context, PREF_APP_STATE, val);
    }

    public boolean getAppState(Context context) {
        if (context == null)
            return false;
        return getPreference(context, PREF_APP_STATE, false);
    }

    public void storeUser(Context context, User user) {
        if (context == null)
            return;

        if (user != null){
            Gson gson = new Gson();
            String json = gson.toJson(user);
            setPreference(context, PREF_USER, json);
        } else {
            setPreference(context, PREF_USER, "");
        }


    }

    public User getUser(Context context) {
        User user = new User("username", "", "");

        if (context == null)
            return null;
        String json = getPreference(context, PREF_USER, "");
        if (!json.isEmpty()){
            Gson gson = new Gson();
            user = gson.fromJson(json, User.class);
        }

        return user;
    }

    public void storeBusiness(Context context, Business business) {
        if (context == null)
            return;

        if (business != null){
            Gson gson = new Gson();
            String json = gson.toJson(business);
            setPreference(context, PREF_BUSINESS, json);
        } else {
            setPreference(context, PREF_BUSINESS, "");
        }


    }

    public Business getBusiness(Context context) {
        Business business = new Business();

        if (context == null)
            return null;
        String json = getPreference(context, PREF_BUSINESS, "");
        if (!json.isEmpty()){
            Gson gson = new Gson();
            business = gson.fromJson(json, Business.class);
        }

        return business;
    }

}
