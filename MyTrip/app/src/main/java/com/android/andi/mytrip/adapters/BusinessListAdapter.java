package com.android.andi.mytrip.adapters;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.andi.mytrip.Fragments.BusinessListFragment;
import com.android.andi.mytrip.R;
import com.android.andi.mytrip.models.Business;


import java.util.List;

/**
 * Created by Andi Xu on 3/31/18.
 */

public class BusinessListAdapter extends RecyclerView.Adapter<BusinessListAdapter.ViewHolder>{

    private final List<Business> mValues;
    private final BusinessListFragment.OnListFragmentInteractionListener mListener;

    public BusinessListAdapter(List<Business> mValues, BusinessListFragment.OnListFragmentInteractionListener listener) {
        this.mValues = mValues;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.business_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final ImageView photoView;
        public final TextView nameView;
        public final TextView tagView;
        public final TextView priceView;
        public final TextView distanceView;
        public final TextView phoneView;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            ImageView = view.findViewById(R.id.business_photo);
            nameView = view.findViewById(R.id.business_name);
            tagView = view.findViewById(R.id.business_price);
            priceView = view.findViewById(R.id.business_price);
            distanceView = view.findViewById(R.id.business_distance);
            phoneView = view.findViewById(R.id.business_phone);

        }
    }
}
