package com.microdrones.technical_test.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {

    @SerializedName("additionalLoadCoefficient")
    @Expose
    private Double additionalLoadCoefficient;

    public Double getAdditionalLoadCoefficient() {
        return additionalLoadCoefficient;
    }

    public void setAdditionalLoadCoefficient(Double additionalLoadCoefficient) {
        this.additionalLoadCoefficient = additionalLoadCoefficient;
    }

}