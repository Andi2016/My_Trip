package com.android.andi.mytrip.asynctasks;

import android.os.AsyncTask;

import com.android.andi.mytrip.activities.MainActivity;
import com.android.andi.mytrip.models.User;

/**
 * Created by Andi Xu on 3/30/18.
 */

public class CreateUserTask extends AsyncTask <String, Integer, String> {

    @Override
    protected void onPreExecute(){
        super.onPreExecute();

        //Set up precondition to execute this task
    }

    @Override
    protected String doInBackground(String... params) {
        User user = new User(0,params[0],params[1],params[2],params[3],params[4]);
        MainActivity.appDatabase.myDao().insertUser(user);
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        this.cancel(false);
    }


}
