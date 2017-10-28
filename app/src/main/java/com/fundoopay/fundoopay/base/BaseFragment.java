package com.fundoopay.fundoopay.base;

import android.app.Fragment;
import android.view.View;
public abstract class BaseFragment extends Fragment {
    public abstract void initView(View view);
    public abstract void clickListener();
}
