
package com.pushkarnayouth.mytraindemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Route {

    @SerializedName("no")
    @Expose
    private Integer no;
    @SerializedName("scharr")
    @Expose
    private String scharr;
    @SerializedName("schdep")
    @Expose
    private String schdep;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("halt")
    @Expose
    private Integer halt;
    @SerializedName("day")
    @Expose
    private Integer day;
    @SerializedName("station")
    @Expose
    private Station station;



    @SerializedName("has_arrived")
    @Expose
    private Boolean hasArrived;
    @SerializedName("has_departed")
    @Expose
    private Boolean hasDeparted;
    @Expose
    private String actarr;
    @SerializedName("actdep")
    @Expose
    private String actdep;
    @SerializedName("scharr_date")
    @Expose
    private String scharrDate;
    @SerializedName("actarr_date")
    @Expose
    private String actarrDate;
    @SerializedName("latemin")
    @Expose
    private Integer latemin;



    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getScharr() {
        return scharr;
    }

    public void setScharr(String scharr) {
        this.scharr = scharr;
    }

    public String getSchdep() {
        return schdep;
    }

    public void setSchdep(String schdep) {
        this.schdep = schdep;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getHalt() {
        return halt;
    }

    public void setHalt(Integer halt) {
        this.halt = halt;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Boolean getHasArrived() {
        return hasArrived;
    }

    public void setHasArrived(Boolean hasArrived) {
        this.hasArrived = hasArrived;
    }

    public Boolean getHasDeparted() {
        return hasDeparted;
    }

    public void setHasDeparted(Boolean hasDeparted) {
        this.hasDeparted = hasDeparted;
    }

    public String getActdep() {
        return actdep;
    }

    public void setActdep(String actdep) {
        this.actdep = actdep;
    }

    public String getScharrDate() {
        return scharrDate;
    }

    public void setScharrDate(String scharrDate) {
        this.scharrDate = scharrDate;
    }

    public String getActarrDate() {
        return actarrDate;
    }

    public void setActarrDate(String actarrDate) {
        this.actarrDate = actarrDate;
    }

    public Integer getLatemin() {
        return latemin;
    }

    public void setLatemin(Integer latemin) {
        this.latemin = latemin;
    }

}
