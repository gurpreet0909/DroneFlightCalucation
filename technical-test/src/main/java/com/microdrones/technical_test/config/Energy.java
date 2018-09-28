package com.microdrones.technical_test.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Energy {

    @SerializedName("numberOfBatteries")
    @Expose
    private Integer numberOfBatteries;
    @SerializedName("capacity")
    @Expose
    private Integer capacity;

    public Integer getNumberOfBatteries() {
        return numberOfBatteries;
    }

    public void setNumberOfBatteries(Integer numberOfBatteries) {
        this.numberOfBatteries = numberOfBatteries;
    }

    public Integer getCapacity() {
        return capacity*numberOfBatteries;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}