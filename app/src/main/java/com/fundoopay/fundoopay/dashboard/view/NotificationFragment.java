package com.fundoopay.fundoopay.dashboard.view;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;
import com.fundoopay.fundoopay.custom.CustomTextViewFA;
import com.fundoopay.fundoopay.dashboard.adapter.NotificationAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class NotificationFragment extends BaseFragment {
    private static Context mContext;
    @BindView(R.id.recyclerViewNotification)
    RecyclerView recyclerViewNotification;
    NotificationAdapter notificationAdapter;
    @BindView(R.id.textViewSeting)
    CustomTextViewFA textViewSeting;
    @BindView(R.id.imageviewBack)
    AppCompatImageView imageviewBack;
    @BindView(R.id.floatingButtonDelete)
    FloatingActionButton floatingButtonDelete;
    private Unbinder unbinder;
    private  String TAG="NotificationFragment";
    FundooPayActivity fundooPayActivity;
    public NotificationFragment() {

    }

    public static NotificationFragment newInstance(FundooPayActivity fundooPayActivity) {
        NotificationFragment fragment = new NotificationFragment();
        fragment.fundooPayActivity=fundooPayActivity;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        initView(view);
        return view;
    }

    @Override
    public void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        recyclerViewNotification.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        notificationAdapter = new NotificationAdapter(getActivity());
        recyclerViewNotification.setAdapter(notificationAdapter);
        textViewSeting.setText("Notifications");
    }

    @Override
    public void clickListener() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.imageviewBack, R.id.floatingButtonDelete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageviewBack:
                if (getFragmentManager().getBackStackEntryCount()<=1){
                    fundooPayActivity.getBackFloting();
                }
                getFragmentManager().popBackStack();
                break;
            case R.id.floatingButtonDelete:
                Log.i(TAG, "onViewClicked: "+ "delete");
                break;
        }
    }
}
