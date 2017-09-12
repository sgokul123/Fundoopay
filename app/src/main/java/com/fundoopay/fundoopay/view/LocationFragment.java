package com.fundoopay.fundoopay.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fundoopay.fundoopay.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;

public class LocationFragment extends BaseFragment implements View.OnClickListener {
    private GoogleApiClient mClient;
    AppCompatImageView imageViewMap;
    LocationInterface locationInterface;
    Place mPlace;
    AppCompatEditText editTextLocateAddress;
    AppCompatTextView textViewLocateAddress;
    private StringBuilder stBuilder;
    AppCompatTextView textViewNext;

    public LocationFragment(LocationInterface locationInterface) {
        this.locationInterface=locationInterface;
     }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_location,container,false);
        initView(view);
        clickListener();
        mClient = new GoogleApiClient
                .Builder(getActivity())
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .build();
        locationInterface.muLocationClient(mClient);
        return view;
    }

    @Override
    public void initView(View view) {
        imageViewMap=view.findViewById(R.id.imageViewLacation);
        editTextLocateAddress=view.findViewById(R.id.editTextLocateMe);
        textViewLocateAddress=view.findViewById(R.id.textViweLocateMe);
        textViewNext=view.findViewById(R.id.textViewNext);
    }

    @Override
    public void clickListener() {
        textViewNext.setOnClickListener(this);
        imageViewMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageViewLacation:
                 PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    String transitionName =getActivity().getString(R.string.transition_title_image);
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) getActivity(), imageViewMap,transitionName);
                    ActivityCompat.startActivity((Activity)getActivity(), builder.build(getActivity()), options.toBundle());

                    //getActivity().startActivityForResult(builder.build(getActivity()),locationInterface.PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.textViewNext:
                MobileVerificationFragment verificationFragment=new MobileVerificationFragment(this);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framlayoutMain,verificationFragment).addToBackStack(null).commit();

                break;
            default:
                break;
        }
    }

    public void setLocation(Place place) {
     this.mPlace =place;
        textViewLocateAddress.setVisibility(View.GONE);
        editTextLocateAddress.setVisibility(View.VISIBLE);
        stBuilder = new StringBuilder();
        String placename = String.format("%s", mPlace.getName());
        String latitude = String.valueOf(mPlace.getLatLng().latitude);
        String longitude = String.valueOf(mPlace.getLatLng().longitude);
        String address = String.format("%s", mPlace.getAddress());
        stBuilder.append("Name: ");
        stBuilder.append(placename);
        stBuilder.append("\n");
        stBuilder.append("Latitude: ");
        stBuilder.append(latitude);
        stBuilder.append("\n");
        stBuilder.append("Logitude: ");
        stBuilder.append(longitude);
        stBuilder.append("\n");
        stBuilder.append("Address: ");
        stBuilder.append(address);
        editTextLocateAddress.setText(stBuilder.toString());
      //  Toast.makeText(getContext(), "Address  :"+stBuilder.toString(), Toast.LENGTH_SHORT).show();
    }
}
