package com.fundoopay.fundoopay.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.fundoopay.fundoopay.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements LocationInterface, GoogleApiClient.OnConnectionFailedListener {
    private GoogleApiClient mClient;
    private String TAG="MainActivity";
    LocationFragment locationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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
        ServiceFragment serviceFragment=new ServiceFragment(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.framlayoutMain,serviceFragment).addToBackStack(null).commit();
    }

    @Override
    public void muLocationClient(GoogleApiClient mClasssssient) {
        this.mClient=mClasssssient;
    }

    @Override
    public void returnFromService() {
        locationFragment=new LocationFragment(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.framlayoutMain,locationFragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() <=1) {
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
