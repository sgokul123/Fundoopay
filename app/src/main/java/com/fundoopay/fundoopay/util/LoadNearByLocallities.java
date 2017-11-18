package com.fundoopay.fundoopay.util;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.fundoopay.fundoopay.home.model.NearBySociety;
import com.fundoopay.fundoopay.home.view.LocalityFragment;
import com.fundoopay.fundoopay.location.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class LoadNearByLocallities extends AsyncTask<ArrayList<String>, String, ArrayList<NearBySociety>> {
    LocalityFragment localityFragment;
    private String TAG="LoadNearByLocallities";
    private ArrayList<String> strLocality;
    private ArrayList<NearBySociety> nearBylocality;
    private Utils utils;
    int cnt=0;

    public LoadNearByLocallities(LocalityFragment localityFragment, Context context) {
        this.localityFragment=localityFragment;
        strLocality=new ArrayList<>();
        nearBylocality=new ArrayList<>();
        utils=new Utils(context);
    }

    @Override
    protected void onPostExecute(ArrayList<NearBySociety> s) {
        super.onPostExecute(s);
        localityFragment.setNearByLocation(s);
    }

    @Override
    protected ArrayList<NearBySociety> doInBackground(ArrayList<String>... arrayLists) {
        ArrayList<String> params=arrayLists[0];
        utils.saveCount(1);
        cnt=params.size();
        for (String str : params) {
            getCAllToLocallities(str);
        }
        return nearBylocality;
    }

    private void getCAllToLocallities(final String url) {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("fgdf", "onResponse: "+response);
                        int count=utils.getCount();
                        utils.saveCount(count+1);
                        Log.i(TAG, "onResponse: "+url.toString());
                        try {
                            JSONArray jarray = (JSONArray) response.get("results");
                            Log.i("sfd", "onResponse: "+jarray.length());
                            for (int i=0;i<jarray.length();i++) {
                                JSONObject jsonObject= (JSONObject) jarray.get(i);
                                JSONObject gbject= (JSONObject) jsonObject.get("geometry");
                                JSONObject lbject= (JSONObject) gbject.get("location");
                                NearBySociety society=new NearBySociety();
                                society.setLat((Double) lbject.get("lat"));
                                society.setLng((Double) lbject.get("lng"));
                                society.setName((String) jsonObject.get("name"));
                                society.setId((String) jsonObject.get("id"));
                                if (!strLocality.contains(society.getName())) {
                                    strLocality.add(society.getName());
                                    nearBylocality.add(society);
                                    Log.i("responce", "onResponse: " );
                                }
                                Log.i("", "onResponse: "+jarray);
                            }
                            if(count==cnt){
                                LocalityFragment.setNearByLocalyties(nearBylocality);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("fgfd", "onErrorResponse: ");
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
