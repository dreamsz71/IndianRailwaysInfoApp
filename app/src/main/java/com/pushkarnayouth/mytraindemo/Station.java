
package com.pushkarnayouth.mytraindemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("lng")
    @Expose
    private Object lng;
    @SerializedName("lat")
    @Expose
    private Object lat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getLng() {
        return lng;
    }

    public void setLng(Object lng) {
        this.lng = lng;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

}
