package com.fundoopay.fundoopay.addaccount;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AddAccountFragment extends BaseFragment {
    @BindView(R.id.imageviewBack)
    AppCompatImageView imageviewBack;
    private Context mContext;
    @BindView(R.id.imageViewLogo)
    AppCompatImageView imageViewLogo;
    @BindView(R.id.textViewCardNumber)
    AppCompatTextView textViewCardNumber;
    @BindView(R.id.textViewAccountType)
    AppCompatTextView textViewAccountType;
    @BindView(R.id.textViewIFSC)
    AppCompatTextView textViewIFSC;
    @BindView(R.id.editTextPin1)
    AppCompatEditText editTextPin1;
    @BindView(R.id.edittextPin2)
    AppCompatEditText edittextPin2;
    @BindView(R.id.edittextPin3)
    AppCompatEditText edittextPin3;
    @BindView(R.id.edittextPin4)
    AppCompatEditText edittextPin4;
    @BindView(R.id.buttonAddPin)
    AppCompatButton buttonAddPin;
    @BindView(R.id.buttonResetPin)
    AppCompatButton buttonResetPin;
    @BindView(R.id.textviewSubmit)
    AppCompatTextView textviewSubmit;
    private Unbinder unbinder;

    public AddAccountFragment() {
        // Required empty public constructor
    }

    public AddAccountFragment(Context context) {
        this.mContext = context;
    }


    public static AddAccountFragment newInstance(String param1, String param2) {
        AddAccountFragment fragment = new AddAccountFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_account, container, false);
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
//55a39cadd433454abe6f47262dc8da30  -api key
    @OnClick({R.id.buttonAddPin, R.id.buttonResetPin, R.id.textviewSubmit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonAddPin:
                SetUPIFragment upiFragment = new SetUPIFragment(mContext);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framlayoutBank, upiFragment).addToBackStack(null).commit();
                break;
            case R.id.buttonResetPin:

                break;
            case R.id.textviewSubmit:

                break;
        }
    }

    @OnClick(R.id.imageviewBack)
    public void onViewClicked() {
        getActivity().getSupportFragmentManager().popBackStackImmediate();
    }
}
