package com.fundoopay.fundoopay.home.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.constants.Constants;
import com.fundoopay.fundoopay.dashboard.view.FundooPayActivity;
import com.fundoopay.fundoopay.home.model.NearBySociety;
import com.fundoopay.fundoopay.location.app.AppController;
import com.fundoopay.fundoopay.util.Utils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener, MainActivityInteface, MainActivityInteface.VerifyInteface, MainActivityInteface.MobileVerifyInteface, MainActivityInteface.OtpInterface, MainActivityInteface.ServiceInteface, MainActivityInteface.LocationInteface, GoogleApiClient.OnConnectionFailedListener {
    LocationFragment locationFragment;
    private GoogleApiClient mClient;
    private String TAG = "MainActivity";
    ArrayList<String> strHousingSocieties;
    Utils utils;
     ArrayList<NearBySociety> nearBylocality;
     ArrayList<NearBySociety> nearBySocieties;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        utils=new Utils(this);
        strHousingSocieties=new ArrayList<>();
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
                utils.saveCount(Constants.SharedPref.COUNT);
                LocationFragment.setLocation(place);
           }
        }
    }



    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i(TAG, "onConnectionFailed: Connection Failuar");
    }

    @Override
    public void returnFromLocation(Place mPlace) {
        getFragmentManager().beginTransaction().replace(R.id.framlayoutMain,LocalityFragment.newInstance()).addToBackStack(null).commit();
        LocalityFragment.currentPlace=mPlace;
        LocalityFragment.mainActivity=this;
        /*  Log.i(TAG, "returnFromLocation: "+ nearBySocieties.get(selectedItem).getName());
        Intent intent = new Intent(this, BankDetailActivity.class);
        startActivity(intent);*/
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
    public void getReturnFromLocality() {
        Intent intent = new Intent(this, FundooPayActivity.class);
        startActivity(intent);
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

    @Override
    public void onResponse(Object response) {
        Log.i(TAG, "onResponse: " + response.toString());
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.i(TAG, "onErrorResponse: " + error.getMessage());
    }
}
