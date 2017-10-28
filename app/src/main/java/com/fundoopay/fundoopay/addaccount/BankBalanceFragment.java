package com.fundoopay.fundoopay.addaccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;
import com.fundoopay.fundoopay.dashboard.view.FundooPayActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class BankBalanceFragment extends BaseFragment {


    @BindView(R.id.buttonBankBalance)
    AppCompatButton buttonBankBalance;
    @BindView(R.id.imageviewBack)
    AppCompatImageView imageviewBack;
    private Unbinder unbinder;

    public BankBalanceFragment() {
        // Required empty public constructor
    }
/*
    public BankBalanceFragment(SetUPIFragment setUPIFragment) {
    }*/

    public static BankBalanceFragment newInstance(SetUPIFragment setUPIFragment) {
        BankBalanceFragment fragment = new BankBalanceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bank_balance, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void clickListener() {

    }

    @OnClick({R.id.imageviewBack, R.id.buttonBankBalance})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageviewBack:
                getActivity().getFragmentManager().popBackStack();
                break;
            case R.id.buttonBankBalance:
                Intent intent = new Intent(getActivity(), FundooPayActivity.class);
                getActivity().startActivity(intent);
                break;
        }
    }
}
