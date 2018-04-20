package com.android.andi.mytrip.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.android.andi.mytrip.R;
import com.android.andi.mytrip.application.MyTrip;
import com.android.andi.mytrip.models.Business;
import com.android.andi.mytrip.server.ServerAPI;
import com.android.andi.mytrip.utils.GetImageByUrl;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class BusinessActivity extends AppCompatActivity implements OnMapReadyCallback{

    private MyTrip mMyTrip;

    private ImageView mImageView;

    private TextView business_name;

    private RatingBar business_rating;

    private TextView business_link_review;

    private TextView business_distance;

    private TextView business_tag;

    private TextView business_price;

    private RatingBar business_personal_rating;

    private TextView business_phone;

    private TextView business_address;

    private EditText business_personal_review;

    private Button btn_Submit;

    private Business mBusiness;


    private GoogleMap mMap;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_item);

        mMyTrip = (MyTrip) getApplicationContext();

        mImageView= findViewById(R.id.business_photo);
        business_name = findViewById(R.id.businessName);
        business_rating = findViewById(R.id.business_rating);
        business_link_review = findViewById(R.id.business_link_review);
        business_tag = findViewById(R.id.business_tag);
        business_price = findViewById(R.id.business_price);
        business_personal_rating = findViewById(R.id.business_personal_rating);
        business_phone = findViewById(R.id.business_phone);
        business_address = findViewById(R.id.business_address);
        btn_Submit = findViewById(R.id.btn_submit);



        Intent intent = getIntent();
        mBusiness = intent.getParcelableExtra("business");
        business_name.setText(mBusiness.getBusinessName());
        business_rating.setRating((float) mBusiness.getRating());
        business_tag.setText(mBusiness.getTag());
        business_price.setText(mBusiness.getPrice());
        business_phone.setText(mBusiness.getPhone());
        StringBuilder sb = new StringBuilder();
        for (String addr: mBusiness.getAddress()) {
            sb.append(addr);
            sb.append(" ");
        }
        business_address.setText(sb.toString());
        new GetImageByUrl().setImage(mImageView, mBusiness.getPhoto_url());

//        List<Fragment> lst = getFragmentManager().getFragments();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);

        business_link_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReviewListActivity.class);
                intent.putExtra("business1", mBusiness);
                startActivity(intent);
            }
        });

        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = business_personal_review.toString();
            }
        });

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            LatLng point = new LatLng(mBusiness.getLatitude(), mBusiness.getLongitude());
            googleMap.addMarker(new MarkerOptions().position(point)
                    .title("Marker"));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 15));
        }
    }


}
