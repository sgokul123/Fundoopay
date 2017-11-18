package com.fundoopay.fundoopay.home.view;

import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseFragment;
import com.fundoopay.fundoopay.custom.MultiSpinner;
import com.fundoopay.fundoopay.home.model.NearBySociety;
import com.fundoopay.fundoopay.util.LoadNearByLocallities;
import com.fundoopay.fundoopay.util.LoadNearestHousingSocieties;
import com.google.android.gms.location.places.Place;

import java.util.ArrayList;

public class LocalityFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "LocalityFragment";
    private static LocalityFragment fragment=null;
    MultiSpinner localitySpinner,housingSocieties;
    public  static Place currentPlace=null;
    ArrayList<NearBySociety> mNearByLocalities;
    ArrayList<NearBySociety> mNearBySocieties;
    public  static MainActivityInteface mainActivity;
   private ArrayList<String> strNearByLocality;
    private ArrayList<String> strNearBySocieties;
     AppCompatTextView textViewNext;
    private ArrayList<NearBySociety> nearBySocieties;

    public LocalityFragment() {
        // Required empty public constructor
    }

    public static LocalityFragment newInstance() {
        if (fragment == null) {
            fragment = new LocalityFragment();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_locality, container, false);
        initView(view);
        clickListener();
        return view;
    }

    @Override
    public void initView(View view) {
        localitySpinner = view. findViewById(R.id.spinnerNearBy);
        housingSocieties=view.findViewById(R.id.housingSocieties);
        textViewNext=view.findViewById(R.id.textViewNext);
        strNearByLocality =new ArrayList<>();
        strNearBySocieties=new ArrayList<>();
        mNearBySocieties=new ArrayList<>();
        mNearByLocalities=new ArrayList<>();
        if(currentPlace!=null)
        {
            getNearByLocalities(currentPlace);
        }
    }

    private void getNearByLocalities(Place currentPlace) {
        ArrayList<String> url=new ArrayList<>();
        LoadNearByLocallities lacalities=new LoadNearByLocallities(this,getActivity());
        String type = "sublocality_level_1";
        for(int j=500;j<4000;j+=500) {
            final StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
            googlePlacesUrl.append("location=").append(19.0626741).append(",").append(72.93550499999999);
            googlePlacesUrl.append("&radius=").append(j);
            googlePlacesUrl.append("&types=").append(type);
            googlePlacesUrl.append("&sensor=true");
            googlePlacesUrl.append("&key=" + "AIzaSyABpsXU1PTjgxdWsboX8JzRwX-3sKPRRbY");
            url.add(googlePlacesUrl.toString());
        }
        lacalities.execute(url);
        }

    @Override
    public void clickListener() {
        Log.i(TAG, "clickListener: ");
        textViewNext.setOnClickListener(this);
    }

    public static void setHousingSocieties(ArrayList<NearBySociety> nearBySocieties) {
           fragment.setSocieties(nearBySocieties);
    }

    public void setSocieties(ArrayList<NearBySociety> nearBySocieties) {
        mNearBySocieties=nearBySocieties;
        for (NearBySociety society:nearBySocieties) {
            strNearBySocieties.add(society.getName());
        }
        housingSocieties.setItems(strNearBySocieties, getString(R.string.for_all), new MultiSpinner.MultiSpinnerListener() {
            @Override
            public void onItemsSelected(boolean[] selected) {
                Log.i(TAG, "onItemsSelected: "+selected.length);
                ArrayList<NearBySociety> tempsocieties = new ArrayList<>();
                for (int j=0;j<selected.length;j++) {
                    if(selected[j]){
                        tempsocieties.add(mNearBySocieties.get(j));
                    }
                    Log.i(TAG, "onItemsSelected: "+selected[j]);
                }

            }
        });
    }

    private void getHousingSocieties(ArrayList<NearBySociety> tempsocieties) {
        ArrayList<String> url=new ArrayList<>();

        nearBySocieties=new ArrayList<>();
        strNearBySocieties.clear();
        nearBySocieties.clear();
        LoadNearestHousingSocieties callnew= new LoadNearestHousingSocieties(this,getActivity());

        int i=1;
        for (NearBySociety nearBySociety:tempsocieties) {
            String type = "Society";
            final StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
            googlePlacesUrl.append("location=").append(nearBySociety.getLat()).append(",").append(nearBySociety.getLng());
            googlePlacesUrl.append("&radius=").append(2000);
            googlePlacesUrl.append("&keyword=").append(type);
            googlePlacesUrl.append("&sensor=true");
            googlePlacesUrl.append("&key=" + "AIzaSyABpsXU1PTjgxdWsboX8JzRwX-3sKPRRbY");
            url.add(googlePlacesUrl.toString());
        }
         callnew.execute(url);
    }

    @Override
    public void onClick(View view) {
        mainActivity.getReturnFromLocality();

    }
    public static void setNearByLocalyties(ArrayList<NearBySociety> nearBySocieties) {
        fragment.setNearByLocation(nearBySocieties);
    }
    public void setNearByLocation(ArrayList<NearBySociety> nearBylocality) {
        mNearByLocalities=nearBylocality;
        for (NearBySociety nearBySociety:nearBylocality) {
            strNearByLocality.add(nearBySociety.getName());
        }

        localitySpinner.setItems(strNearByLocality, getString(R.string.for_all), new MultiSpinner.MultiSpinnerListener() {
            @Override
            public void onItemsSelected(boolean[] selected) {
                Log.i(TAG, "onItemsSelected: "+selected);
                ArrayList<NearBySociety> tempLocalities = new ArrayList<>();
                for (int i=0;i<selected.length;i++) {
                    if(selected[i]){
                        tempLocalities.add(mNearByLocalities.get(i));
                    }

                    Log.i(TAG, "onItemsSelected: "+selected[i]);
                }
                getHousingSocieties(tempLocalities);
                //  mainActivity. getHousingSocieties(tempLocalities);
            }
        });
    }
}
