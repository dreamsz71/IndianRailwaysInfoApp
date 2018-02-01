
package com.pushkarnayouth.mytraindemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Train {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("days")
    @Expose
    private List<Day> days = null;
    @SerializedName("classes")
    @Expose
    private List<Class> classes = null;

    @SerializedName("actdep")
    @Expose
    private String actdep;
    @SerializedName("scharr")
    @Expose
    private String scharr;
    @SerializedName("delayarr")
    @Expose
    private String delayarr;
    @SerializedName("actarr")
    @Expose
    private String actarr;
    @SerializedName("delaydep")
    @Expose
    private String delaydep;
    @SerializedName("schdep")
    @Expose
    private String schdep;


    @SerializedName("dest")
    @Expose
    private Dest dest;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("source")
    @Expose
    private Source source;


    @SerializedName("dest_arrival_time")
    @Expose
    private String destArrivalTime;
    @SerializedName("from_station")
    @Expose
    private FromStation fromStation;
    @SerializedName("travel_time")
    @Expose
    private String travelTime;
    @SerializedName("src_departure_time")
    @Expose
    private String srcDepartureTime;
    @SerializedName("to_station")
    @Expose
    private ToStation toStation;

    @SerializedName("time_diff")
    @Expose
    private String timeDiff;
    @SerializedName("rescheduled_time")
    @Expose
    private String rescheduledTime;
    @SerializedName("rescheduled_date")
    @Expose
    private String rescheduledDate;


    public String getRescheduledDate() {
        return rescheduledDate;
    }

    public void setRescheduledDate(String rescheduledDate) {
        this.rescheduledDate = rescheduledDate;
    }

    public String getTimeDiff() {
        return timeDiff;
    }

    public void setTimeDiff(String timeDiff) {
        this.timeDiff = timeDiff;
    }

    public String getRescheduledTime() {
        return rescheduledTime;
    }

    public void setRescheduledTime(String rescheduledTime) {
        this.rescheduledTime = rescheduledTime;
    }


    public String getSrcDepartureTime() {
        return srcDepartureTime;
    }

    public void setSrcDepartureTime(String srcDepartureTime) {
        this.srcDepartureTime = srcDepartureTime;
    }

    public ToStation getToStation() {
        return toStation;
    }

    public void setToStation(ToStation toStation) {
        this.toStation = toStation;
    }


    public String getDestArrivalTime() {
        return destArrivalTime;
    }

    public void setDestArrivalTime(String destArrivalTime) {
        this.destArrivalTime = destArrivalTime;
    }

    public FromStation getFromStation() {
        return fromStation;
    }

    public void setFromStation(FromStation fromStation) {
        this.fromStation = fromStation;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }


    public String getActdep() {
        return actdep;
    }

    public void setActdep(String actdep) {
        this.actdep = actdep;
    }

    public String getScharr() {
        return scharr;
    }

    public void setScharr(String scharr) {
        this.scharr = scharr;
    }


    public String getDelayarr() {
        return delayarr;
    }

    public void setDelayarr(String delayarr) {
        this.delayarr = delayarr;
    }

    public String getActarr() {
        return actarr;
    }

    public void setActarr(String actarr) {
        this.actarr = actarr;
    }

    public String getDelaydep() {
        return delaydep;
    }

    public void setDelaydep(String delaydep) {
        this.delaydep = delaydep;
    }

    public String getSchdep() {
        return schdep;
    }

    public void setSchdep(String schdep) {
        this.schdep = schdep;
    }


    public Dest getDest() {
        return dest;
    }

    public void setDest(Dest dest) {
        this.dest = dest;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }


}
