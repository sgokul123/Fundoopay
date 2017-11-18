package com.fundoopay.fundoopay.home.model;


public class NearBySociety {

    private String name;
    private String id;

    private double lat;
    private double lng;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
