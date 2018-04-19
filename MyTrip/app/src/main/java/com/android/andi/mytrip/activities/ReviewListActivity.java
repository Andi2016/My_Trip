package com.android.andi.mytrip.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.andi.mytrip.R;
import com.android.andi.mytrip.adapters.ReviewListAdapter;
import com.android.andi.mytrip.application.MyTrip;
import com.android.andi.mytrip.models.Business;
import com.android.andi.mytrip.models.Review;
import com.android.andi.mytrip.server.ServerAPI;
import com.android.andi.mytrip.server.ServerResponseCallback;
import com.android.andi.mytrip.server.ServerResponseData;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;

public class ReviewListActivity extends AppCompatActivity implements ReviewListAdapter.ReviewListAdapterListener{

    private Business mBusiness;

    private TextView business_name;

    private MyTrip mMyTrip;

    private ReviewListAdapter mAdapter;
    private RecyclerView mRecyclerView;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_review_list);

        mMyTrip = (MyTrip) getApplicationContext();

        mRecyclerView = findViewById(R.id.review_list);
        business_name = findViewById(R.id.businessName);

        Intent intent = getIntent();

        mBusiness = intent.getParcelableExtra("business1");

        business_name.setText(mBusiness.getBusinessName());

        setupView();
        fetchReviews();

    }

    public void setupView() {
        mAdapter = new ReviewListAdapter(mMyTrip, ReviewListActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mMyTrip);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


    public void fetchReviews() {
        ServerAPI.getReviewsByBusinessId(mMyTrip, mBusiness.getBusinessId(), new ServerResponseCallback() {
            @Override
            public void onResponse(ServerResponseData responseData) {
                if (responseData.statusCode == ServerAPI.STATUS_OK) {
                    try {
                        final ArrayList<Review> list = new ArrayList<>();
                        JSONArray jsonArray = new JSONArray(responseData.responseData);
                        if (jsonArray.length() == 0) {
                            mAdapter.clearItems();
                            mAdapter.notifyDataSetChanged();
                        }
                        for (int i = 0; i < jsonArray.length(); i += 1) {
                            Review review = new Gson().fromJson(jsonArray.get(i).toString(), Review.class);
                            list.add(review);
                        }

                        mAdapter.addItems(list);
                        mAdapter.notifyDataSetChanged();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    @Override
    public void OnClick(int position) {

    }
}
