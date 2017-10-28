package com.fundoopay.fundoopay.dashboard.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;
import com.fundoopay.fundoopay.custom.CustomTextViewFA;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SettingFragment extends BaseFragment {

    @BindView(R.id.textViewSeting)
    CustomTextViewFA textViewSeting;
    @BindView(R.id.imageviewBack)
    AppCompatImageView imageviewBack;
    Unbinder unbinder1;
    private Unbinder unbinder;
    FundooPayActivity fundooPayActivity;
    public SettingFragment() {
        // Required empty public constructor
    }

    public static SettingFragment newInstance(FundooPayActivity mContext) {
        SettingFragment fragment = new SettingFragment();
        fragment.fundooPayActivity=mContext;

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        initView(view);
        unbinder1 = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        textViewSeting.setText("Settings");
    }

    @Override
    public void clickListener() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.imageviewBack)
    public void onViewClicked() {
        if (getFragmentManager().getBackStackEntryCount()<=1){
            fundooPayActivity.getBackFloting();
        }
        getFragmentManager().popBackStack();
    }
}
