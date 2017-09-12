package com.fundoopay.fundoopay.bankdetail.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.bankdetail.model.BankModel;

import java.util.ArrayList;


public class BankAdapter  extends RecyclerView.Adapter<BankAdapter.ViewHolder>{
    Context mContext;
    ArrayList<BankModel> mBanks;
    public BankAdapter(Context context, ArrayList<BankModel> banks) {
        this.mContext=context;
        this.mBanks=banks;
    }

    @Override
    public BankAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_banks, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textViewBank.setText(mBanks.get(position).getmBankName());
    }

    @Override
    public int getItemCount() {
        return mBanks.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatTextView textViewBank;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewBank=itemView.findViewById(R.id.textViewBank);
            textViewBank.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
         switch (view.getId()){
             case R.id.textViewBank:
                 Toast.makeText(mContext, mBanks.get(getAdapterPosition())+"   Selected", Toast.LENGTH_SHORT).show();
                 break;
         }
        }
    }
}
