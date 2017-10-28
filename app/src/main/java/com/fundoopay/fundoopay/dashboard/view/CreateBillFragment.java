package com.fundoopay.fundoopay.dashboard.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;
import com.fundoopay.fundoopay.constants.Constants;
import com.fundoopay.fundoopay.custom.CustomTextViewFA;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class CreateBillFragment extends BaseFragment {
    Context mContext;
    @BindView(R.id.imageviewBack)
    AppCompatImageView imageviewBack;
    @BindView(R.id.textViewSeting)
    CustomTextViewFA textViewSeting;
    FundooPayActivity mFundooPayActivity;
    Unbinder unbinder;
    @BindView(R.id.imageViewCamera)
    AppCompatImageView imageViewCamera;
    @BindView(R.id.buttonCreateBill)
    AppCompatButton buttonCreateBill;
    public CreateBillFragment() {
    }


    public static CreateBillFragment newInstance(FundooPayActivity fundooPayActivity) {
        CreateBillFragment fragment = new CreateBillFragment();
        fragment. mFundooPayActivity = fundooPayActivity;

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_bill, container, false);

        initView(view);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this, view);
        textViewSeting.setText("Create Bill");
        clickListener();
    }

    @Override
    public void clickListener() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.imageviewBack, R.id.imageViewCamera, R.id.buttonCreateBill})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageviewBack:
                if (getFragmentManager().getBackStackEntryCount() <= 1) {
                    mFundooPayActivity.getBackFloting();
                }
                getFragmentManager().popBackStack();
                break;
            case R.id.imageViewCamera:
                dispatchTakePictureIntent();
                break;
            case R.id.buttonCreateBill:

                break;
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            getActivity().startActivityForResult(takePictureIntent, Constants.REQUEST_IMAGE_CAPTURE);
    }

    public static void setImageBitmap(Bitmap imageBitmap) {
        CreateBillFragment ada=new CreateBillFragment();
        ada.imageViewCamera.setMaxWidth(200);
        ada.imageViewCamera.setMaxHeight(300);
        ada.imageViewCamera.setImageBitmap(imageBitmap);
    }
}
