package com.fundoopay.fundoopay.view;

import android.support.v4.app.Fragment;
import android.view.View;

abstract class BaseFragment extends Fragment {
    public abstract void initView(View view);
    public abstract void clickListener();
}
