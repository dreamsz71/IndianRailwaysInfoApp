package com.pushkarnayouth.mytraindemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareEstimation {

    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("debit")
    @Expose
    private Integer debit;
    @SerializedName("from_station")
    @Expose
    private FromStation fromStation;
    @SerializedName("to_station")
    @Expose
    private ToStation toStation;
    @SerializedName("train")
    @Expose
    private Train train;
    @SerializedName("quota")
    @Expose
    private Quota quota;
    @SerializedName("journey_class")
    @Expose
    private JourneyClass journeyClass;
    @SerializedName("fare")
    @Expose
    private Double fare;

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

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Quota getQuota() {
        return quota;
    }

    public void setQuota(Quota quota) {
        this.quota = quota;
    }

    public JourneyClass getJourneyClass() {
        return journeyClass;
    }

    public void setJourneyClass(JourneyClass journeyClass) {
        this.journeyClass = journeyClass;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

}
