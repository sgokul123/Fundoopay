package com.fundoopay.fundoopay.home.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;

import java.util.List;


public class OtpSendFragment extends BaseFragment implements View.OnClickListener {
    AppCompatButton simCardFirst, simCardSecound;
    AppCompatTextView verifyMobileNext;
    private Typeface avnir;

    public OtpSendFragment() {
    }


    // TODO: Rename and change types and number of parameters
    public static OtpSendFragment newInstance(String param1, String param2) {
        OtpSendFragment fragment = new OtpSendFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_otp_send, container, false);
        initView(view);
        clickListener();
        return view;
    }

    @Override
    public void initView(View view) {
        simCardFirst = view.findViewById(R.id.simCardFirst);
        simCardSecound = view.findViewById(R.id.simCardSecound);
        verifyMobileNext=view.findViewById(R.id.verifyMobileNext);
        avnir= Typeface.createFromAsset(getContext().getAssets(),"avnir.ttf");

    }

    @Override
    public void clickListener() {
        simCardSecound.setOnClickListener(this);
        simCardFirst.setOnClickListener(this);
        verifyMobileNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simCardFirst:
                /*simCardFirst.setBackgroundColor(getResources().getColor(R.color.holo_blue_dark));
                simCardSecound.setBackgroundColor(getResources().getColor(R.color.holo_white_dark));*/
                simCardFirst.setBackgroundColor(Color.TRANSPARENT);
                simCardFirst.setTextColor(getResources().getColor(R.color.holo_blue_dark));
                simCardSecound.setTextColor(getResources().getColor(R.color.holo_white_dark));
                simCardSecound.setBackgroundDrawable(getContext().getDrawable(R.drawable.left_diagonal_square));
                getsimDetails();
                break;
            case R.id.simCardSecound:
              /*  simCardFirst.setBackgroundColor(getResources().getColor(R.color.holo_white_dark));
                simCardSecound.setBackgroundColor(getResources().getColor(R.color.holo_blue_dark));*/
                simCardSecound.setBackgroundColor(Color.TRANSPARENT);
                simCardSecound.setTextColor(getResources().getColor(R.color.holo_blue_dark));
                simCardFirst.setTextColor(getResources().getColor(R.color.holo_white_dark));
                simCardFirst.setBackgroundDrawable(getContext().getDrawable(R.drawable.square_diagonal));
                getsimDetails();
                break;
            case  R.id.verifyMobileNext:
                VerifyFragment verifyFragment=new VerifyFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framlayoutMain,verifyFragment).addToBackStack(null).commit();
                break;
        }
    }
    public void getsimDetails(){
        try {
            String simTwoNumber = null, simOneNumber = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                SubscriptionManager subManager = (SubscriptionManager) getActivity().getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
                List<SubscriptionInfo> subInfoList = null;
                subInfoList = subManager.getActiveSubscriptionInfoList();
                if (subInfoList != null && subInfoList.size() > 0) {
                    switch (subInfoList.size()) {
                        case 2:
                            simTwoNumber = subInfoList.get(1).getNumber();
                        case 1:
                            simOneNumber = subInfoList.get(0).getNumber();
                            break;
                        default:
                            break;
                    }
                }
                Toast.makeText(getContext(), "Sim  Number  :"+simTwoNumber+"   SirealNumber : "+simOneNumber, Toast.LENGTH_SHORT).show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }   }
}
