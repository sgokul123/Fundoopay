package com.fundoopay.fundoopay.home.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;
import com.fundoopay.fundoopay.custom.CustomTextViewFA;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VerifyFragment extends BaseFragment implements View.OnClickListener, TextWatcher {
    RelativeLayout relativeLayoutOtp, relativeLayoutVerify;
    @BindView(R.id.editTextOtp1)
    AppCompatEditText editTextOtp1;
    @BindView(R.id.editTextOtp2)
    AppCompatEditText editTextOtp2;
    @BindView(R.id.editTextOtp3)
    AppCompatEditText editTextOtp3;
    @BindView(R.id.editTextOtp4)
    AppCompatEditText editTextOtp4;
    @BindView(R.id.textViewVerify)
    CustomTextViewFA textViewVerify;
    @BindView(R.id.yourCircularProgressbar)
    CircularProgressBar yourCircularProgressbar;
    private long SPLASH_TIME_OUT = 1000;
    private ProgressBar mprogressBar;
    MainActivity mainActivity;
    private Unbinder binder;
    public VerifyFragment() {
    }
    public static VerifyFragment newInstance(MainActivity mainActivity) {
        VerifyFragment fragment = new VerifyFragment();
        fragment.mainActivity = mainActivity;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_verify, container, false);
        binder= ButterKnife.bind(this,view);
        initView(view);
        return view;
    }
    @Override
    public void initView(View view) {
        relativeLayoutOtp = view.findViewById(R.id.relativeOtp);
        relativeLayoutVerify = view.findViewById(R.id.relativeVerify);
        clickListener();
    }

    @Override
    public void clickListener() {
       textViewVerify.setOnClickListener(this);
        editTextOtp1.addTextChangedListener(this);
        editTextOtp2.addTextChangedListener(this);
        editTextOtp3.addTextChangedListener(this);
        editTextOtp4.addTextChangedListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textViewVerify:
                relativeLayoutOtp.setVisibility(View.GONE);
                relativeLayoutVerify.setVisibility(View.VISIBLE);
                int animationDuration = 2000; // 2500ms = 2,5s
                yourCircularProgressbar.setProgressWithAnimation(85, animationDuration);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainActivity.returnFromVerify();
                    }
                }, SPLASH_TIME_OUT);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if(editTextOtp1.hasFocus()&&!editTextOtp1.getText().toString().isEmpty()){
            editTextOtp2.requestFocus();
        }else
        if(editTextOtp2.hasFocus()&&!editTextOtp2.getText().toString().isEmpty()){
            editTextOtp3.requestFocus();
        }else
        if(editTextOtp3.hasFocus()&&!editTextOtp3.getText().toString().isEmpty()) {
            editTextOtp4.requestFocus();

        }else
        if(editTextOtp4.hasFocus()&&editTextOtp4.getText().toString().isEmpty()){
            editTextOtp3.requestFocus();
        }else
        if(editTextOtp3.hasFocus()&&editTextOtp3.getText().toString().isEmpty()){
            editTextOtp2.requestFocus();
        }else
        if(editTextOtp2.hasFocus()&&editTextOtp2.getText().toString().isEmpty()){
            editTextOtp1.requestFocus();
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {


    }
}
