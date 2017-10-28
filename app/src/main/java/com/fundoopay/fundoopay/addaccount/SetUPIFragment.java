package com.fundoopay.fundoopay.addaccount;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SetUPIFragment extends BaseFragment {

    @BindView(R.id.editTextDCardNumber1)
    AppCompatEditText editTextDCardNumber1;
    @BindView(R.id.editTextDCardNumber2)
    AppCompatEditText editTextDCardNumber2;
    @BindView(R.id.editTextDCardNumber3)
    AppCompatEditText editTextDCardNumber3;
    @BindView(R.id.editTextDCardNumber4)
    AppCompatEditText editTextDCardNumber4;
    @BindView(R.id.editTextDCardNumber5)
    AppCompatEditText editTextDCardNumber5;
    @BindView(R.id.editTextDCardNumber6)
    AppCompatEditText editTextDCardNumber6;
    @BindView(R.id.editTextValidity1)
    AppCompatEditText editTextValidity1;
    @BindView(R.id.editTextValidity2)
    AppCompatEditText editTextValidity2;
    @BindView(R.id.editTextValidity3)
    AppCompatEditText editTextValidity3;
    @BindView(R.id.editTextValidity4)
    AppCompatEditText editTextValidity4;
    @BindView(R.id.textViewUpiPinNext)
    AppCompatTextView textViewUpiPinNext;
    Unbinder unbinder;
    @BindView(R.id.layoutFundooPay)
    LinearLayout layoutFundooPay;
    @BindView(R.id.toolbar_update)
    Toolbar toolbarUpdate;
    @BindView(R.id.linearLayoutUpiPin1)
    LinearLayout linearLayoutUpiPin1;
    @BindView(R.id.editTextUpiPin1)
    AppCompatEditText editTextUpiPin1;
    @BindView(R.id.editTextUpiPin2)
    AppCompatEditText editTextUpiPin2;
    @BindView(R.id.editTextUpiPin3)
    AppCompatEditText editTextUpiPin3;
    @BindView(R.id.editTextUpiPin4)
    AppCompatEditText editTextUpiPin4;
    @BindView(R.id.linearLayoutUpiPin2)
    LinearLayout linearLayoutUpiPin2;
    @BindView(R.id.imageViewUpiNext)
    AppCompatImageView imageViewUpiNext;
    @BindView(R.id.relativeUpiPin)
    RelativeLayout relativeUpiPin;
    @BindView(R.id.imageviewBack)
    AppCompatImageView imageviewBack;



    public SetUPIFragment() {
        super();
    }


    public static SetUPIFragment newInstance(Context mContext) {
        SetUPIFragment fragment = new SetUPIFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_upi, container, false);
        initView(view);
        clickListener();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void clickListener() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.imageviewBack, R.id.textViewUpiPinNext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageviewBack:
                getActivity().getFragmentManager().popBackStackImmediate();
                break;
            case R.id.textViewUpiPinNext:
                if(textViewUpiPinNext.getText().toString().equals("SET")){
                    //BankBalanceFragment balanceFragment=new BankBalanceFragment(this);
                    textViewUpiPinNext.setText("Next");
                    linearLayoutUpiPin2.setVisibility(View.GONE);
                    linearLayoutUpiPin1.setVisibility(View.VISIBLE);
                    relativeUpiPin.setBackgroundColor(getResources().getColor(R.color.holo_white));
                    textViewUpiPinNext.setTextColor(getResources().getColor(R.color.holo_blue_dark));
                    getActivity().getFragmentManager().beginTransaction().replace(R.id.framlayoutBank,BankBalanceFragment.newInstance(this)).addToBackStack(null).commit();
                }else {
                    textViewUpiPinNext.setText("SET");
                    linearLayoutUpiPin2.setVisibility(View.VISIBLE);
                    linearLayoutUpiPin1.setVisibility(View.GONE);
                    relativeUpiPin.setBackgroundColor(getResources().getColor(R.color.holo_blue_dark));
                    textViewUpiPinNext.setTextColor(getResources().getColor(R.color.holo_white_dark));
                }
                break;
        }
    }
}
