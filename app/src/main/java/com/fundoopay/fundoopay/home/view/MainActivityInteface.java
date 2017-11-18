package com.fundoopay.fundoopay.home.view;

import com.fundoopay.fundoopay.home.model.NearBySociety;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;

import java.util.ArrayList;

public interface MainActivityInteface {
       int PLACE_PICKER_REQUEST = 4;
    public void returnFromSplashScren();

    void getReturnFromLocality();

    interface LocationInteface {
          void returnFromLocation(Place mPlace);
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
