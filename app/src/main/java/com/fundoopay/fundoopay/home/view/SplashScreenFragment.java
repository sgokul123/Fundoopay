package com.fundoopay.fundoopay.home.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;


public class SplashScreenFragment extends BaseFragment {
    AppCompatTextView textViewFundoo,textViewPay,textViewSDisc;
    private static long SPLASH_TIME_OUT=5000;
    LocationInterface locationInterface;
    public SplashScreenFragment() {

    }


    public static SplashScreenFragment newInstance(LocationInterface locationInterface) {
        SplashScreenFragment fragment = new SplashScreenFragment();
        fragment.locationInterface=locationInterface;

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_splash_screen,container,false);
        initView(view);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                locationInterface.returnFromSplashScren();
            }
        }, SPLASH_TIME_OUT);
        return view;
    }

    @Override
    public void initView(View view) {
        textViewFundoo=view.findViewById(R.id.textViewFundoo);
        textViewPay=view.findViewById(R.id.textViewPay);
        textViewSDisc=view.findViewById(R.id.textViewSplash);

    }

    @Override
    public void clickListener() {

    }
}
