package com.fundoopay.fundoopay.home.view;

import com.google.android.gms.common.api.GoogleApiClient;

public interface MainActivityInteface {
       int PLACE_PICKER_REQUEST = 4;
    public void returnFromSplashScren();
    interface LocationInteface {
          void returnFromLocation();
          void muLocationClient(GoogleApiClient mClient);

    }

    interface MobileVerifyInteface {

          void returnFromMobileVerify();
    }

    interface OtpInterface {

          void returnFromOtp();
    }

    interface ServiceInteface {

          void returnFromService();
    }
    interface  VerifyInteface{
        void returnFromVerify();
    }
}
