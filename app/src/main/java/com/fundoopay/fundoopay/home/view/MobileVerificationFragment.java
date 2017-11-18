package com.fundoopay.fundoopay.home.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;

import butterknife.ButterKnife;

import static android.support.v4.content.PermissionChecker.checkSelfPermission;

public class MobileVerificationFragment extends BaseFragment implements View.OnClickListener {
    Switch imageViewOnOffSms;
    Switch imageViewOnOffState;
    AppCompatTextView textViewNext;
    MainActivity mainActivity;
    private boolean isGrantedSMS;
    private boolean isGrantedPhone;

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
                if (imageViewOnOffSms.isChecked()) {
                    isGrantedSMS = isPermissionGrantedSMS();
                }

                break;
            case R.id.imageviewOnOffState:

                if (imageViewOnOffState.isChecked()) {
                    isGrantedPhone = isPermissionGrantedPhone();
                }

                break;
            case R.id.mobileVerifyeNext:
                if(isGrantedSMS &&imageViewOnOffSms.isChecked()||isGrantedPhone && imageViewOnOffState.isChecked())
                {
                    mainActivity.returnFromMobileVerify();
                }else{
                    Toast.makeText(mainActivity, "Check Permitions", Toast.LENGTH_SHORT).show();
                }
                  break;
            default:
                break;
        }
    }

    public boolean isPermissionGrantedSMS() {
        if (checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
            }
            return false;
        }
    }

    public boolean isPermissionGrantedPhone() {
        if (checkSelfPermission(getActivity(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE}, 2);
            }
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    isGrantedSMS = true;

                } else {

                    imageViewOnOffSms.setChecked(false);
                    isGrantedSMS = false;
                }
            }

            case 2: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    isGrantedPhone = true;

                } else {

                    imageViewOnOffState.setChecked(false);
                    isGrantedPhone = false;
                }
            }

        }
    }

}
