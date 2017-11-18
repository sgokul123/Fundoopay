package com.fundoopay.fundoopay.home.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;
import com.fundoopay.fundoopay.custom.MultiSpinner;
import com.fundoopay.fundoopay.home.model.NearBySociety;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.content.ContentValues.TAG;

public class LocationFragment extends BaseFragment implements View.OnClickListener {
    private GoogleApiClient mClient;
    AppCompatImageView imageViewMap;
    MainActivity locationInterface;
    Place mPlace;
    int selectedItem;
    AppCompatEditText editTextLocateAddress;
    AppCompatTextView textViewLocateAddress;
    private StringBuilder stBuilder;
    AppCompatTextView textViewNext;

    static ArrayList<String> nearByLocation;
    static LocationFragment fragment;

    public LocationFragment() {
    }


    public static LocationFragment newInstance(MainActivity locationInterface) {
        if(fragment==null) {
            fragment = new LocationFragment();
        }
        fragment.locationInterface=locationInterface;
        return fragment;
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

        if(nearByLocation==null){
            nearByLocation=new ArrayList<>();
        }

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
                    getActivity().startActivityForResult(builder.build(getActivity()),locationInterface.PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.textViewNext:
                locationInterface.returnFromLocation(mPlace);
                break;
            default:
                break;
        }
    }

    public static void setLocation(Place place) {
        fragment.setLocationText(place);
   }

    private void setLocationText(Place place) {
        this.mPlace =place;
        textViewLocateAddress.setVisibility(View.GONE);
        editTextLocateAddress.setVisibility(View.VISIBLE);
        stBuilder = new StringBuilder();
        Log.i(TAG, "setLocation: "+mPlace.getId()+"local   "+mPlace.getLocale()+" phone   "+mPlace.getPhoneNumber()+" tyype  "+mPlace.getPlaceTypes());

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
    }



}
