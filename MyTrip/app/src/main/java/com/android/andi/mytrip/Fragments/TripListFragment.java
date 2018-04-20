package com.android.andi.mytrip.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.andi.mytrip.R;
import com.android.andi.mytrip.activities.MainActivity;
import com.android.andi.mytrip.adapters.TripListAdapter;
import com.android.andi.mytrip.models.Trip;
import com.android.andi.mytrip.server.ServerAPI;
import com.android.andi.mytrip.server.ServerResponseCallback;
import com.android.andi.mytrip.server.ServerResponseData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class TripListFragment extends Fragment implements TripListAdapter.TripListAdapterListener{

    //UI references
    private EditText mLocationView;
    private Button mButtonView;
    private RecyclerView mRecyclerView;

    private TripListAdapter mAdapter;
    private ArrayList<Trip> list = new ArrayList<>();

    public static TripListFragment newInstance() {
        TripListFragment fragment = new TripListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trip_list, container, false);
        mLocationView = view.findViewById(R.id.city_tripList);
        mButtonView = view.findViewById(R.id.button_tripList);
        setupView();
        mButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchTrips();
            }
        });
        return view;
    }

    /**
     * This function sets up list view
     */
    private void setupView(){
        mAdapter = new TripListAdapter(getActivity(), TripListFragment.this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * This function fetch all trips by location
     */
    private int mTripCount = 0;
    private void fetchTrips(){
        mTripCount = 0;
        String location = mLocationView.getText().toString();

        ServerAPI.getTripsByLocations(getActivity(), location, new ServerResponseCallback() {
            @Override
            public void onResponse(ServerResponseData response) {
                if(response.statusCode == ServerAPI.STATUS_OK){
                    list.clear();
                    try{
                        JSONArray jsonArray = new JSONArray(response.responseData);
                        mTripCount = jsonArray.length();
                        if(mTripCount == 0){
                            mAdapter.clearItems();
                            mAdapter.notifyDataSetChanged();
                        }

                        for(int i = 0; i < jsonArray.length(); i++){
                            Trip trip = new Gson().fromJson(jsonArray.get(i).toString(), Trip.class);
                            list.add(trip);
                            mTripCount--;
                        }


                        if(mTripCount == 0){
                            mAdapter.addItems(list);
                            mAdapter.notifyDataSetChanged();
                        }
                    }catch (JSONException e){
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    @Override
    public void OnClick(int position) {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}
