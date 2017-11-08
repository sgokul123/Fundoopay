package com.fundoopay.fundoopay.home.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.bankdetail.view.BankDetailActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityInteface, MainActivityInteface.VerifyInteface, MainActivityInteface.MobileVerifyInteface, MainActivityInteface.OtpInterface, MainActivityInteface.ServiceInteface, MainActivityInteface.LocationInteface, GoogleApiClient.OnConnectionFailedListener {
    LocationFragment locationFragment;
    private GoogleApiClient mClient;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // SplashScreenFragment splashScreenFragment=new SplashScreenFragment(this);
        getFragmentManager().beginTransaction().replace(R.id.framlayoutMain, SplashScreenFragment.newInstance(this)).addToBackStack(null).commit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mClient != null) {
            mClient.connect();
        }
    }

    @Override
    protected void onStop() {
        if (mClient != null) {
            mClient.disconnect();
        }
        super.onStop();
    }


    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() <= 1) {
            super.onBackPressed();
            finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                LocationFragment.setLocation(place);
            }
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i(TAG, "onConnectionFailed: Connection Failuar");
    }

    @Override
    public void returnFromLocation() {

        Intent intent = new Intent(this, BankDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void muLocationClient(GoogleApiClient mClient) {
        this.mClient = mClient;
    }

    @Override
    public void returnFromSplashScren() {
        getFragmentManager().popBackStack();
        //ServiceFragment serviceFragment=new ServiceFragment(this);
        //getFragmentManager().beginTransaction().replace(R.id.framlayoutMain,MobileVerificationFragment.newInstance()).addToBackStack(null).commit();

        getFragmentManager().beginTransaction().replace(R.id.framlayoutMain, ServiceFragment.newInstance(this)).addToBackStack(null).commit();

    }

    @Override
    public void returnFromService() {
        getFragmentManager().beginTransaction().replace(R.id.framlayoutMain, MobileVerificationFragment.newInstance(this)).addToBackStack(null).commit();

    }

    @Override
    public void returnFromMobileVerify() {
        OtpSendFragment otpSendFragment = new OtpSendFragment();
        getFragmentManager().beginTransaction().replace(R.id.framlayoutMain, OtpSendFragment.newInstance(this)).addToBackStack(null).commit();

    }

    @Override
    public void returnFromOtp() {
        VerifyFragment verifyFragment = new VerifyFragment();
        getFragmentManager().beginTransaction().replace(R.id.framlayoutMain, VerifyFragment.newInstance(this)).addToBackStack(null).commit();

    }

    @Override
    public void returnFromVerify() {
        getFragmentManager().beginTransaction().replace(R.id.framlayoutMain, LocationFragment.newInstance(this)).addToBackStack(null).commit();

    }
}
