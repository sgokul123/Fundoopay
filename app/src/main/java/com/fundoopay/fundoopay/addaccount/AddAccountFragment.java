package com.fundoopay.fundoopay.addaccount;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fundoopay.fundoopay.R;

public class AddAccountFragment extends Fragment {

    public AddAccountFragment() {
        // Required empty public constructor
    }


    public static AddAccountFragment newInstance(String param1, String param2) {
        AddAccountFragment fragment = new AddAccountFragment();
        Bundle args = new Bundle();
       fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_account, container, false);
    }

}
