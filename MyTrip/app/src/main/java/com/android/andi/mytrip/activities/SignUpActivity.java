package com.android.andi.mytrip.activities;

import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.andi.mytrip.R;
import com.android.andi.mytrip.application.MyTrip;
import com.android.andi.mytrip.asynctasks.CreateUserTask;

public class SignUpActivity extends AppCompatActivity {
    private MyTrip myTrip;

    //UI references
    private EditText mFirstNameView;
    private EditText mLastNameView;
    private EditText mEmailView;
    private EditText mPasswordView;
    private Button mSignUpButton;

    @Override
    public void onBackPressed(){
        finish();
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        myTrip = (MyTrip) getApplicationContext();
        setUpActionBar();
        mFirstNameView = findViewById(R.id.first_name);
        mLastNameView = findViewById(R.id.last_name);
        mEmailView = findViewById(R.id.email);
        mPasswordView = findViewById(R.id.password);
        mSignUpButton = findViewById(R.id.btn_signup);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSignUp();
            }
        });
    }

    /**
     * This function sets up the actionbar for the screen
     */
    private void setUpActionBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Sign Up");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));

        }
    }

    private void attemptSignUp(){
        mFirstNameView.setError(null);
        mLastNameView.setError(null);
        mEmailView.setError(null);
        mPasswordView.setError(null);

        //Stores values at the time of the login attempt
        String firstName = mFirstNameView.getText().toString();
        String lastName = mLastNameView.getText().toString();
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if(TextUtils.isEmpty(firstName)){
            mFirstNameView.setError("This field is required");
            focusView = mFirstNameView;
            cancel = true;
        } else if(TextUtils.isEmpty(lastName)){
            mFirstNameView.setError("This field is required");
            focusView = mLastNameView;
            cancel = true;
        } else if(TextUtils.isEmpty(email)){
            mFirstNameView.setError("This field is required");
            focusView = mEmailView;
            cancel = true;
        } else if(!isEmailValid(email)){
            mEmailView.setError("This email address is invalid");
            focusView = mEmailView;
            cancel = true;
        } else if(TextUtils.isEmpty(password)){
            mEmailView.setError("This field is required");
            focusView = mPasswordView;
            cancel = true;
        } else if (!isPasswordValid(password)){
            mPasswordView.setError("Password should at least has 8 characters");
            focusView = mPasswordView;
            cancel = true;
        }

        if(cancel){
            focusView.requestFocus();
        }else {
            CreateUserTask createUserTask = new CreateUserTask();
            createUserTask.execute(firstName, lastName, email, password);
        }


    }


    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPasswordValid(String password){
        return password.length()>=8;
    }
}
