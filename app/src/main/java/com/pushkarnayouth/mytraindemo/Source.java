
package com.pushkarnayouth.mytraindemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("lat")
    @Expose
    private Double lat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

}
