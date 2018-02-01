
package com.pushkarnayouth.mytraindemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrainCancelled {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("trains")
    @Expose
    private List<Train> trains = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

}
