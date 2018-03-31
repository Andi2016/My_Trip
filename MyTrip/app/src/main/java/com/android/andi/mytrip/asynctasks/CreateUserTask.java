package com.android.andi.mytrip.asynctasks;

import android.content.Context;
import android.os.AsyncTask;

import com.android.andi.mytrip.activities.MainActivity;
import com.android.andi.mytrip.application.MyTrip;
import com.android.andi.mytrip.models.User;
import com.android.andi.mytrip.server.ServerAPI;
import com.android.andi.mytrip.server.ServerResponseCallback;
import com.android.andi.mytrip.server.ServerResponseData;

import static com.android.andi.mytrip.activities.LaunchActivity.appDatabase;

/**
 * Created by Andi Xu on 3/30/18.
 */

public class CreateUserTask extends AsyncTask <String, Void, Void> {

    private static Context context;

    @Override
    protected void onPreExecute(){
        super.onPreExecute();

        //Set up precondition to execute this task
    }

    @Override
    protected Void doInBackground(String... params) {
        User user = new User(params[0], params[1], params[2]);
        appDatabase.myDao().insertUser(user);

//        ServerAPI.CreateUser(context, params[0], params[1], params[2], new ServerResponseCallback() {
//            @Override
//            public void onResponse(ServerResponseData response) {
//                if (response.statusCode == ServerAPI.STATUS_OK) {
//
//                }
//            }
//        });
        return null;
    }

    @Override
    protected void onPostExecute(Void avoid) {
        super.onPostExecute(avoid);
        this.cancel(false);
    }



}
