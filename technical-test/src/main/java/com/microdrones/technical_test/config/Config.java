package com.microdrones.technical_test.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Config {

    @SerializedName("verticalSpeeds")
    @Expose
    private VerticalSpeeds verticalSpeeds;
    @SerializedName("energy")
    @Expose
    private Energy energy;
    @SerializedName("payload")
    @Expose
    private Payload payload;

    public VerticalSpeeds getVerticalSpeeds() {
        return verticalSpeeds;
    }

    public void setVerticalSpeeds(VerticalSpeeds verticalSpeeds) {
        this.verticalSpeeds = verticalSpeeds;
    }

    public Energy getEnergy() {
        return energy;
    }

    public void setEnergy(Energy energy) {
        this.energy = energy;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

}