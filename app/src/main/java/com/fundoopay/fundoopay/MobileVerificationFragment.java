package com.fundoopay.fundoopay;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MobileVerificationFragment extends BaseFragment {

    public MobileVerificationFragment() {
    }

    public MobileVerificationFragment(LocationFragment locationFragment) {

    }

    public static MobileVerificationFragment newInstance(String param1, String param2) {
        MobileVerificationFragment fragment = new MobileVerificationFragment();
        Bundle args = new Bundle();
       fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_mobile_verification, container, false);

        return view;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void clickListener() {

    }
}
