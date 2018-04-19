package com.android.andi.mytrip.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.andi.mytrip.R;
import com.android.andi.mytrip.activities.BusinessActivity;
import com.android.andi.mytrip.adapters.BusinessListAdapter;
import com.android.andi.mytrip.models.Business;
import com.android.andi.mytrip.server.ServerAPI;
import com.android.andi.mytrip.server.ServerResponseCallback;
import com.android.andi.mytrip.server.ServerResponseData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class BusinessListFragment extends Fragment implements BusinessListAdapter.BusinessListAdapterListener{


    private BusinessListAdapter mAdapter;
    private RecyclerView mRecyclerView;

    private EditText mEditText;

    private ArrayList<Business> list = new ArrayList<>();

    private String city;

    private Button mButton;




    public static BusinessListFragment newInstance() {
        BusinessListFragment fragment = new BusinessListFragment();
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
        View view =  inflater.inflate(R.layout.fragment_business_list, container, false);
        mRecyclerView = view.findViewById(R.id.business_list_recycle);
        mEditText = view.findViewById(R.id.city);
        city = mEditText.getText().toString();
        mButton = view.findViewById(R.id.change_city_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                List<Fragment> lst = getFragmentManager().getFragments();
//                Fragment currentFragment = getFragmentManager().getFragments().get(0);
//                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                fragmentTransaction.detach(currentFragment);
//                fragmentTransaction.attach(currentFragment);
//                fragmentTransaction.commit();
                city = mEditText.getText().toString();
//                setupView();
                fetchBusinesses();
            }
        });



        setupView();
        fetchBusinesses();

        return view;

    }


    private void setupView() {
        mAdapter = new BusinessListAdapter(getActivity(), BusinessListFragment.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


    private void fetchBusinesses() {
        Log.d("ddd", city);
        ServerAPI.getBusinessesByCity(getActivity(), city, new ServerResponseCallback() {
            @Override
            public void onResponse(ServerResponseData responseData) {
                list.clear();
                if (responseData.statusCode == ServerAPI.STATUS_OK) {
                    try {
                        JSONArray jsonArray = new JSONArray(responseData.responseData);
                        if (jsonArray.length() == 0) {
                            mAdapter.clearItems();
                            mAdapter.notifyDataSetChanged();
                        }

                        for (int i = 0; i < jsonArray.length(); i += 1) {
                            Business business = new Gson().fromJson(jsonArray.get(i).toString(), Business.class);
                            list.add(business);
                        }

                        mAdapter.addItems(list);
                        mAdapter.notifyDataSetChanged();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void OnClick(int position) {
        Intent intent = new Intent(getActivity(), BusinessActivity.class);
        Business business = list.get(position);
        intent.putExtra("business", business);
        startActivity(intent);
    }


}
