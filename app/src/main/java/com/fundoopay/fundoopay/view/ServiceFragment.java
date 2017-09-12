package com.fundoopay.fundoopay.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.fundoopay.fundoopay.R;

public class ServiceFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    AppCompatTextView textViewNext,textViewFundoo,textViewPay;
    Spinner spin;
    LocationInterface locationInterface;
    AppCompatEditText editTextUName,editTextShopName;

    String[] country = { "India", "USA", "China", "Japan", "Other", };
    private Typeface aargh;
    private Typeface avnir;
    private Typeface bauhaus;

    public ServiceFragment(LocationInterface locationInterface) {
        this.locationInterface=locationInterface;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_, container, false);
        initView(view);
        clickListener();
        return view;
    }

    @Override
    public void initView(View view) {
        textViewNext=view.findViewById(R.id.serviceNext);
        spin = (Spinner)view. findViewById(R.id.spinner1);
        textViewFundoo=view.findViewById(R.id.textFundoo);
        textViewPay=view.findViewById(R.id.textPay);

        editTextUName=view .findViewById(R.id.editTextUName);
        editTextShopName=view.findViewById(R.id.editTextShopName);
        avnir=Typeface.createFromAsset(getContext().getAssets(),"Avenir-Medium.ttf");
        bauhaus=Typeface.createFromAsset(getContext().getAssets(),"Bauhaus-93.ttf");

        textViewFundoo.setTypeface(bauhaus);
        textViewPay.setTypeface(bauhaus);
        textViewNext.setTypeface(avnir);
        editTextUName.setTypeface(avnir);
        editTextShopName.setTypeface(avnir);
        ArrayAdapter aa = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    @Override
    public void clickListener() {
        textViewNext.setOnClickListener(this);
        spin.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.serviceNext:
                locationInterface.returnFromService();
                 break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
