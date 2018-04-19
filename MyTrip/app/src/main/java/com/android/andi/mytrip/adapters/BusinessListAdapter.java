package com.android.andi.mytrip.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.andi.mytrip.R;
import com.android.andi.mytrip.application.MyTrip;
import com.android.andi.mytrip.models.Business;
import com.android.andi.mytrip.utils.GetImageByUrl;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andi Xu on 3/31/18.
 */

public class BusinessListAdapter extends RecyclerView.Adapter<BusinessListAdapter.ViewHolder>{

    private List<Business> mBusinesses;
    private Context mContext;
    private BusinessListAdapter.BusinessListAdapterListener mListener;
    private MyTrip mMyTrip;

    public BusinessListAdapter(Context context, BusinessListAdapter.BusinessListAdapterListener listener) {
        this.mBusinesses = new ArrayList<>();
        this.mListener = listener;
        mContext = context;
        mMyTrip = (MyTrip) mContext.getApplicationContext();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.business_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Business business = mBusinesses.get(position);
        String business_name = business.getBusinessName();
        StringBuilder sb = new StringBuilder();
        for (String str: business.getAddress()) {
            sb.append(str);
            sb.append(" ");
        }
        holder.infoView.setText(business_name + "\n" + sb.toString() + "\n" + business.getTag());
        new GetImageByUrl().setImage(holder.photoView, business.getPhoto_url());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnClick(position);
            }
        });

    }

    public void clearItems(){
        mBusinesses.clear();
    }

    public void addItems(ArrayList<Business> list) {
        mBusinesses.clear();
        mBusinesses.addAll(list);
    }

    @Override
    public int getItemCount() {
        return mBusinesses.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final ImageView photoView;
        public final TextView infoView;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            photoView = view.findViewById(R.id.business_photo);
            infoView = view.findViewById(R.id.business_info);
        }
    }

    public interface BusinessListAdapterListener {
        void OnClick(int position);
    }

}
