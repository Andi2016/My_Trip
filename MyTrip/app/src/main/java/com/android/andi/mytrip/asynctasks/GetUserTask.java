//package com.android.andi.mytrip.asynctasks;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.android.andi.mytrip.models.User;
//import com.android.andi.mytrip.server.ServerAPI;
//import com.android.andi.mytrip.server.ServerResponseCallback;
//import com.android.andi.mytrip.server.ServerResponseData;
//
//import static com.android.andi.mytrip.activities.LaunchActivity.appDatabase;
//import static com.android.andi.mytrip.activities.MainActivity.error;
//
///**
// * Created by Andi Xu on 3/31/18.
// */
//
//public class GetUserTask extends AsyncTask<Void, Void, String> {
//    private static Context context;
//
//
//    @Override
//    protected void onPreExecute(){
//        super.onPreExecute();
//
//        //Set up precondition to execute this task
//    }
//
//    @Override
//    protected String doInBackground(Void... voids) {
//        User[] users = appDatabase.myDao().loadAllUsers();
//        return users[0].getEmail();
//    }
//
//    @Override
//    protected void onPostExecute(String result) {
//        super.onPostExecute(result);
//        error = result;
//    }
//
//}