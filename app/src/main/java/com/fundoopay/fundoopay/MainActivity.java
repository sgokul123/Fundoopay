package com.fundoopay.fundoopay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class MainActivity extends AppCompatActivity  implements LocationInterface, GoogleApiClient.OnConnectionFailedListener {
    LocationFragment locationFragment;
    private GoogleApiClient mClient;
    private String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationFragment=new LocationFragment(this);
        SplashScreenFragment splashScreenFragment=new SplashScreenFragment(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.framlayoutMain,splashScreenFragment).addToBackStack(null).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
       if(mClient!=null){
           mClient.connect();
       }
    }

    @Override
    protected void onStop() {
        if(mClient!=null){
            mClient.disconnect();
        }
        super.onStop();
    }

    @Override
    public void returnFromSplashScren() {
        getSupportFragmentManager().popBackStack();
        getSupportFragmentManager().beginTransaction().replace(R.id.framlayoutMain,locationFragment).addToBackStack(null).commit();
    }

    @Override
    public void muLocationClient(GoogleApiClient mClasssssient) {
        this.mClient=mClient;
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() >0) {
            finish();
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_PICKER_REQUEST) {
            if(resultCode==RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                locationFragment.setLocation(place);
            }
        }
    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i(TAG, "onConnectionFailed: Connection Failuar");
    }
}
