package com.android.andi.mytrip.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.andi.mytrip.R;
import com.android.andi.mytrip.application.MyTrip;
import com.android.andi.mytrip.models.User;
import com.android.andi.mytrip.server.ServerAPI;
import com.android.andi.mytrip.server.ServerResponseCallback;
import com.android.andi.mytrip.server.ServerResponseData;
import com.google.gson.Gson;

public class SignInActivity extends AppCompatActivity {


    private EditText mEmailView;
    private Button mSignInButton;
    private EditText mPasswordView;
    private MyTrip mMyTrip;
    private User mUser;
    private String password_server;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mEmailView = (EditText) findViewById(R.id.email);
        mMyTrip = (MyTrip) getApplicationContext();
        TextView myText = (TextView) findViewById(R.id.link_signup);
        myText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));

            }
        });
        mPasswordView = findViewById(R.id.password);
        mSignInButton = findViewById(R.id.btn_signin);
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSignIn();
            }
        });
    }

    private void attemptSignIn() {

        //reset errors
        mEmailView.setError(null);
        mPasswordView.setError(null);

        //store value for login attempt
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        //check for valid input
        if(TextUtils.isEmpty(email)){
            mEmailView.setError("This field is required");
            focusView = mEmailView;
            cancel = true;
        }else if(TextUtils.isEmpty(password)){
            mPasswordView.setError("This field is required");
            focusView = mPasswordView;
            cancel = true;
        }

        if(cancel){

            focusView.requestFocus();
            
        } else {

            ServerAPI.getUserByEmail(mMyTrip, email, new ServerResponseCallback() {
                @Override
                public void onResponse(ServerResponseData response) {

                    if(response.statusCode == ServerAPI.STATUS_OK){
                        mUser = new Gson().fromJson(response.responseData, User.class);

                        password_server = mUser.getPassword();
                        Log.e("response", mUser.getPassword());
                    }
                }
            });

            if(password.equals(password_server)){
                //save this user
                mMyTrip.getPreference().setAppState(SignInActivity.this,true);
                mMyTrip.getPreference().storeUser(mMyTrip, mUser);

                startActivity(new Intent(SignInActivity.this, MainActivity.class));
                finish();
            }else{
                //Toast.makeText(mApp, "Wrong Password", Toast.LENGTH_SHORT).show();
            }
        }

    }



}
