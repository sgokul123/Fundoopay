package com.fundoopay.fundoopay.bankdetail.view;

import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.addaccount.AddAccountFragment;
import com.fundoopay.fundoopay.bankdetail.adapter.BankAdapter;
import com.fundoopay.fundoopay.bankdetail.model.BankModel;
import com.fundoopay.fundoopay.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BankDetailActivity extends BaseActivity {
    BankAdapter bankAdapter;
    RecyclerView recyclerView;
    ArrayList<BankModel> mBanks;
    @BindView(R.id.imageviewBackFirst)
    AppCompatImageView imageviewBackFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_detail);
        ButterKnife.bind(this);
        initView();
        setClickListener();
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recylerViewBanks);
        mBanks = new ArrayList<>();
        mBanks.add(new BankModel("Bank of Baroda."));
        mBanks.add(new BankModel("Allahabad Bank"));
        mBanks.add(new BankModel("State Bank of Saurashtra"));
        mBanks.add(new BankModel("Central Bank of India"));
        mBanks.add(new BankModel("State Bank of Patiala"));
        mBanks.add(new BankModel("Andhra Bank"));
        mBanks.add(new BankModel("Canara Bank"));
        mBanks.add(new BankModel("State Bank of Hyderabad"));
        bankAdapter = new BankAdapter(this, this, mBanks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(bankAdapter);
    }

    @Override
    public void setClickListener() {

    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() <1) {
            finish();
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    public void getCallBack() {
       // AddAccountFragment addAccountFragment = new AddAccountFragment(this);
        getFragmentManager().beginTransaction().replace(R.id.framlayoutBank, AddAccountFragment.newInstance(this)).addToBackStack(null).commit();
    }

    @OnClick(R.id.imageviewBackFirst)
    public void onViewClicked() {
        finish();
    }
}
