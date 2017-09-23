package com.fundoopay.fundoopay.home.view;

import com.google.android.gms.common.api.GoogleApiClient;


interface LocationInterface {
     public static final int PLACE_PICKER_REQUEST = 4;
    public void returnFromSplashScren();
    public  void muLocationClient(GoogleApiClient mClient);
    public  void returnFromService();
}
