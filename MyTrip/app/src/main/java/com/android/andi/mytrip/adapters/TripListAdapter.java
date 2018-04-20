package com.android.andi.mytrip.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.andi.mytrip.R;
import com.android.andi.mytrip.models.Trip;
import com.android.andi.mytrip.utils.GetImageByUrl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andi Xu on 4/19/18.
 */

public class TripListAdapter extends RecyclerView.Adapter<TripListAdapter.ViewHolder>{

    private List<Trip> mTripList;
    private Context mContext;
    private TripListAdapter.TripListAdapterListener mListener;

    public TripListAdapter(Context context, TripListAdapter.TripListAdapterListener listener){
        mContext = context;
        mTripList = new ArrayList<>();
        mListener = listener;
    }

    public void addItems(ArrayList<Trip> list){
        mTripList.clear();
        mTripList.addAll(list);
    }

    public ArrayList<Trip> getItems(){
        return (ArrayList<Trip>) mTripList;
    }

    public void clearItems(){
        mTripList.clear();
    }

    @Override
    public TripListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //inflate the custom layout
        View tripView = inflater.inflate(R.layout.trip_list_item, parent, false);

        //return a new holder instance
        return new TripListAdapter.ViewHolder(tripView);
    }

    @Override
    public void onBindViewHolder(TripListAdapter.ViewHolder holder, final int position) {
       Trip trip = mTripList.get(position);
       new GetImageByUrl().setImage(holder.mAuthorImage, trip.getPhoto_url());
       holder.mTripName.setText(trip.getTrip_name());
       holder.mTripDescription.setText(trip.getDescription());

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mListener.OnClick(position);
           }
       });
    }

    @Override
    public int getItemCount() {
        return mTripList.size();
    }

    //View holder class
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mAuthorImage;
        private TextView mTripName;
        private TextView mTripDescription;

        public ViewHolder(View view){
            super(view);
            mAuthorImage = view.findViewById(R.id.head_author);
            mTripName = view.findViewById(R.id.tripName);
            mTripDescription = view.findViewById(R.id.tripDescription);
        }
    }

    public interface TripListAdapterListener {
        void OnClick(int position);
    }
}
