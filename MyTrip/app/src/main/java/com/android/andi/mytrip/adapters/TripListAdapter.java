package com.android.andi.mytrip.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.android.andi.mytrip.application.MyTrip;
import com.android.andi.mytrip.models.Review;
import com.android.andi.mytrip.models.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ViewHolder> {

    private List<Trip> mTrips;
    private Context mContext;
    private ReviewListAdapter.ReviewListAdapterListener mListener;
    private MyTrip mMyTrip;
    private final String[] urls =
            {
                    "https://handluggageonly.co.uk/wp-content/uploads/2015/12/Plan-Your-Italy-Road-Trip_-3.jpg",
                    "https://cache-graphicslib.viator.com/graphicslib/mm/94/cinque-terre-hiking-day-trip-from-florence-italy-421394-raw.jpg",
                    "http://s3.india.com/travel/wp-content/uploads/2015/08/Goa1.jpg",
                    "http://files.salsacdn.com/article/12603_Positano/imagemain/dreamstimemedium-48457638-XL_d_0_0_912.20170804191336.jpg",
                    "https://d5qsyj6vaeh11.cloudfront.net/images/whats%20available/touring/article%20images/great-coastal-drives/great-coastal-drives-trip-explorer-mobile.jpg"
            };


    public TripListAdapter(Context context, ReviewListAdapter.ReviewListAdapterListener listener) {
        this.mTrips = new ArrayList<>();
        this.mListener = listener;
        mContext = context;
        mMyTrip = (MyTrip) mContext.getApplicationContext();
    }

    @Override
    public ReviewListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ReviewListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
