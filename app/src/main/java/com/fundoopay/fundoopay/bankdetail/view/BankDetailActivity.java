package com.fundoopay.fundoopay.bankdetail.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.bankdetail.adapter.BankAdapter;
import com.fundoopay.fundoopay.bankdetail.model.BankModel;
import com.fundoopay.fundoopay.base.BaseActivity;

import java.util.ArrayList;

public class BankDetailActivity extends BaseActivity {
    BankAdapter bankAdapter;
    RecyclerView recyclerView;
   ArrayList<BankModel> mBanks ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_detail);
        initView();
        setClickListener();
    }

    @Override
    public void initView() {
        recyclerView= (RecyclerView) findViewById(R.id.recylerViewBanks);
        mBanks=new ArrayList<>();
        mBanks.add(new BankModel("India"));
        mBanks.add(new BankModel("USA"));
        mBanks.add(new BankModel("China"));
        mBanks.add(new BankModel("Japan"));
        mBanks.add(new BankModel("Other"));
        bankAdapter=new BankAdapter(this,mBanks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(bankAdapter);
    }

    @Override
    public void setClickListener() {

    }
}
