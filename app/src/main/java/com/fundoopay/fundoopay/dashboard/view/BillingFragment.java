package com.fundoopay.fundoopay.dashboard.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;
import com.fundoopay.fundoopay.dashboard.adapter.BillReceiptAdapter;

public class BillingFragment extends BaseFragment {

    RecyclerView recyclerViewBilling;

    public BillingFragment() {
        // Required empty public constructor
    }
    public static BillingFragment newInstance(String param1, String param2) {
        BillingFragment fragment = new BillingFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_billing, container, false);
        initView(view);
        return  view;
    }

    @Override
    public void initView(View view) {
        recyclerViewBilling=view.findViewById(R.id.recyclerViewBilling);
        BillReceiptAdapter receiptAdapter=new BillReceiptAdapter(getActivity());
        recyclerViewBilling.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerViewBilling.setAdapter(receiptAdapter);
    }

    @Override
    public void clickListener() {

    }
}
