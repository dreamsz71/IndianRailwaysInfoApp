package com.pushkarnayouth.mytraindemo;

/**
 * Created by Deepak on 12/19/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrainRouteResponse {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("available")
    @Expose
    private String available;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

}
