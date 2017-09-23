package com.fundoopay.fundoopay.home.view;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.bankdetail.view.BankDetailActivity;
import com.fundoopay.fundoopay.base.BaseFragment;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class VerifyFragment extends BaseFragment implements View.OnClickListener {
    AppCompatTextView textViewVerify;
    RelativeLayout relativeLayoutOtp,relativeLayoutVerify;
    private long SPLASH_TIME_OUT=1000;
    private Typeface avnir;
    private ProgressBar mprogressBar;
    private CircularProgressBar circularProgressBar;

    public VerifyFragment() {
        // Required empty public constructor
    }
 public static VerifyFragment newInstance(String param1, String param2) {
        VerifyFragment fragment = new VerifyFragment();
        Bundle args = new Bundle();
       fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_verify, container, false);
        initView(view);
        clickListener();
        return view;
    }

    @Override
    public void initView(View view) {
        textViewVerify=view.findViewById(R.id.textViewVerify);
        relativeLayoutOtp=view.findViewById(R.id.relativeOtp);
        relativeLayoutVerify=view.findViewById(R.id.relativeVerify);
        avnir= Typeface.createFromAsset(getContext().getAssets(),"avnir.ttf");
         circularProgressBar = (CircularProgressBar)view.findViewById(R.id.yourCircularProgressbar);



    }

    @Override
    public void clickListener() {
        textViewVerify.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textViewVerify:
                relativeLayoutOtp.setVisibility(View.GONE);
                relativeLayoutVerify.setVisibility(View.VISIBLE);
                int animationDuration = 2000; // 2500ms = 2,5s
                circularProgressBar.setProgressWithAnimation(85,animationDuration);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(getActivity(), BankDetailActivity.class);
                        startActivity(intent);

                    }
                }, SPLASH_TIME_OUT);
                break;
        }
    }
}
