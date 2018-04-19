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
import com.android.andi.mytrip.models.Review;
import com.android.andi.mytrip.utils.GetImageByUrl;

import java.util.ArrayList;
import java.util.List;

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ViewHolder> {

    private List<Review> mReviews;
    private Context mContext;
    private ReviewListAdapter.ReviewListAdapterListener mListener;
    private MyTrip mMyTrip;
    private final String url = "https://i.pinimg.com/originals/53/54/f7/5354f750a2816333f42efbeeacb4e244.jpg";

    public ReviewListAdapter(Context context, ReviewListAdapter.ReviewListAdapterListener listener) {
        this.mReviews = new ArrayList<>();
        this.mListener = listener;
        mContext = context;
        mMyTrip = (MyTrip) mContext.getApplicationContext();
    }




    @Override
    public ReviewListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewListAdapter.ViewHolder holder, final int position) {
        Review review = mReviews.get(position);
        holder.name.setText(review.getUsername());
        holder.time.setText(review.getDate());
        holder.review_content.setText(review.getContent());
        new GetImageByUrl().setImage(holder.profile_image, url);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mListener.OnClick(position);
            }
        });
    }



    @Override
    public int getItemCount() {
        return mReviews.size();
    }


    public void clearItems(){
        mReviews.clear();
    }

    public void addItems(ArrayList<Review> list) {
        mReviews.clear();
        mReviews.addAll(list);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView profile_image;
        public final TextView name;
        public final TextView time;
        public final TextView review_content;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            profile_image = view.findViewById(R.id.profile_image);
            name = view.findViewById(R.id.name);
            time = view.findViewById(R.id.time);
            review_content = view.findViewById(R.id.review_content);
        }

    }

    public interface ReviewListAdapterListener {
        void OnClick(int position);
    }


}
