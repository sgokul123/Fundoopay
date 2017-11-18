package com.fundoopay.fundoopay.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.fundoopay.fundoopay.constants.Constants;
import com.fundoopay.fundoopay.home.view.MainActivity;

import static android.content.Context.MODE_PRIVATE;


public class Utils {
    private final SharedPreferences pref;
    Context mContext;
    SharedPreferences.Editor mSharedPref_editor;

    public Utils(Context context) {
        this.mContext=context;
        pref = context.getSharedPreferences(Constants.SharedPref.SHAREDPREFERANCES_KEY, MODE_PRIVATE);

    }

    public  void saveCount(int count){
        mSharedPref_editor=pref.edit();
        mSharedPref_editor.putInt(Constants.SharedPref.INT_COUNT,count);
        mSharedPref_editor.commit();
    }

    public int getCount() {
        return pref.getInt(Constants.SharedPref.INT_COUNT,500);
    }
}
