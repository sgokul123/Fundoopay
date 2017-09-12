package com.fundoopay.fundoopay.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fundoopay.fundoopay.R;


public class SplashScreenFragment extends BaseFragment {
    AppCompatTextView textViewFundoo,textViewPay,textViewSDisc;
    Typeface aargh,avnir,bauhaus;

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
        avnir=Typeface.createFromAsset(getContext().getAssets(),"Avenir-Medium.ttf");
        bauhaus=Typeface.createFromAsset(getContext().getAssets(),"Bauhaus-93.ttf");


        textViewPay.setTypeface(bauhaus);
        textViewFundoo.setTypeface(bauhaus);
        textViewSDisc.setTypeface(avnir);
    }

    @Override
    public void clickListener() {

    }
}
