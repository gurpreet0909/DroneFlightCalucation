package com.microdrones.technical_test.drone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Drone {

    @SerializedName("currentLoadInFlight")
    @Expose
    private CurrentLoadInFlight currentLoadInFlight;
    @SerializedName("forcedLandingCharge")
    @Expose
    private Integer forcedLandingCharge;

    public CurrentLoadInFlight getCurrentLoadInFlight() {
        return currentLoadInFlight;
    }

    public void setCurrentLoadInFlight(CurrentLoadInFlight currentLoadInFlight) {
        this.currentLoadInFlight = currentLoadInFlight;
    }

    public Integer getForcedLandingCharge() {
        return forcedLandingCharge;
    }

    public void setForcedLandingCharge(Integer forcedLandingCharge) {
        this.forcedLandingCharge = forcedLandingCharge;
    }

}