package com.fundoopay.fundoopay;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SplashScreenFragment extends Fragment {

    private static long SPLASH_TIME_OUT=5000;
    LocationInterface locationInterface;
    public SplashScreenFragment() {
    }

    public SplashScreenFragment(LocationInterface locationInterface) {
        this.locationInterface=locationInterface;
    }

    public static SplashScreenFragment newInstance(String param1, String param2) {
        SplashScreenFragment fragment = new SplashScreenFragment();
        Bundle args = new Bundle();
         fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_splash_screen,container,false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                locationInterface.returnFromSplashScren();
            }
        }, SPLASH_TIME_OUT);
        return view;
    }

}
