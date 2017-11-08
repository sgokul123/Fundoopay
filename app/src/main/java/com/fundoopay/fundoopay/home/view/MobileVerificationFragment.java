package com.fundoopay.fundoopay.home.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;

import butterknife.ButterKnife;

public class MobileVerificationFragment extends BaseFragment implements View.OnClickListener {
    Switch imageViewOnOffSms;
    Switch imageViewOnOffState;
    AppCompatTextView textViewNext;
    MainActivity mainActivity;
    public MobileVerificationFragment() {
    }

    public static MobileVerificationFragment newInstance(MainActivity mainActivity) {
        MobileVerificationFragment fragment = new MobileVerificationFragment();
        fragment.mainActivity=mainActivity;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_mobile_verification, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        clickListener();
        return view;
    }

    @Override
    public void initView(View view) {
       imageViewOnOffSms=view.findViewById(R.id.imageviewOnOffSms);
        imageViewOnOffState =view.findViewById(R.id.imageviewOnOffState);
        textViewNext=view.findViewById(R.id.mobileVerifyeNext);


    }

    @Override
    public void clickListener() {
        imageViewOnOffSms.setOnClickListener(this);
        imageViewOnOffState.setOnClickListener(this);
        textViewNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageviewOnOffSms:

                break;
            case R.id.imageviewOnOffState:

                break;
            case R.id.mobileVerifyeNext:
                mainActivity.returnFromMobileVerify();
                  break;
            default:
                break;
        }
    }
}
