
package com.pushkarnayouth.mytraindemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("runs")
    @Expose
    private String runs;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

}
