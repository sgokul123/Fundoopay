package com.fundoopay.fundoopay.base;

import android.support.v4.app.Fragment;
import android.view.View;
public abstract class BaseFragment extends Fragment {
    public abstract void initView(View view);
    public abstract void clickListener();
}
