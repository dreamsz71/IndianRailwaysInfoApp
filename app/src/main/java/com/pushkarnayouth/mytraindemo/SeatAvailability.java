package com.pushkarnayouth.mytraindemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeatAvailability {

    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("debit")
    @Expose
    private Integer debit;
    @SerializedName("train")
    @Expose
    private Train train;
    @SerializedName("from_station")
    @Expose
    private FromStation fromStation;
    @SerializedName("to_station")
    @Expose
    private ToStation toStation;
    @SerializedName("journey_class")
    @Expose
    private JourneyClass journeyClass;
    @SerializedName("quota")
    @Expose
    private Quota quota;
    @SerializedName("availability")
    @Expose
    private List<Availability> availability = null;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public FromStation getFromStation() {
        return fromStation;
    }

    public void setFromStation(FromStation fromStation) {
        this.fromStation = fromStation;
    }

    public ToStation getToStation() {
        return toStation;
    }

    public void setToStation(ToStation toStation) {
        this.toStation = toStation;
    }

    public JourneyClass getJourneyClass() {
        return journeyClass;
    }

    public void setJourneyClass(JourneyClass journeyClass) {
        this.journeyClass = journeyClass;
    }

    public Quota getQuota() {
        return quota;
    }

    public void setQuota(Quota quota) {
        this.quota = quota;
    }

    public List<Availability> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }

}
