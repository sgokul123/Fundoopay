package com.fundoopay.fundoopay.dashboard.view;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseActivity;
import com.fundoopay.fundoopay.dashboard.adapter.BillAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FundooPayActivity extends BaseActivity {

    @BindView(R.id.appCompatButton1)
    AppCompatButton appCompatButton1;
    @BindView(R.id.appCompatButton2)
    AppCompatButton appCompatButton2;
    @BindView(R.id.recyclerViewDashBoard)
    RecyclerView recyclerViewDashBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundoo_pay);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        BillAdapter billAdapter=new BillAdapter(this);
        recyclerViewDashBoard.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerViewDashBoard.setAdapter(billAdapter);
    }


    @Override
    public void setClickListener() {

    }

    @OnClick({R.id.appCompatButton1, R.id.appCompatButton2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.appCompatButton1:
                Toast.makeText(this, "Tab First", Toast.LENGTH_SHORT).show();
                break;
            case R.id.appCompatButton2:
                Toast.makeText(this, "Tab Secound", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
