package com.fundoopay.fundoopay.dashboard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.fundoopay.fundoopay.R;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    public NotificationAdapter(Context context) {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_notify, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        RadioButton radioButton;
        LinearLayout linearViewNotify;
        public ViewHolder(View itemView) {
            super(itemView);
            radioButton=itemView.findViewById(R.id.radioChake);
            linearViewNotify=itemView.findViewById(R.id.linearViewNotify);
            linearViewNotify.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View view) {
            radioButton.setVisibility(View.VISIBLE);
            radioButton.setChecked(true);
            return false;
        }
    }
}
