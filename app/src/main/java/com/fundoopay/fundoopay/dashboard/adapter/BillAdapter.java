package com.fundoopay.fundoopay.dashboard.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.dashboard.view.FundooPayActivity;


public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder> {
    FundooPayActivity mFundooPayActivity;
    Context mContext;
    public BillAdapter(FundooPayActivity fundooPayActivity, Context context) {
        this.mContext=context;
        this.mFundooPayActivity=fundooPayActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_bills, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatImageView imageViewPush;
        CardView cardViewBill;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewPush = itemView.findViewById(R.id.imageViewPrint);
           // imageViewPush.setOnClickListener(this);
            cardViewBill=itemView.findViewById(R.id.cardViewBill);
            cardViewBill.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.cardViewBill:
                    mFundooPayActivity.getRecieptCall(getAdapterPosition());
                    break;
                default:

                    break;
            }
        }
    }
}
