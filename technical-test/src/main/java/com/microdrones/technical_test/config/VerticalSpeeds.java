package com.microdrones.technical_test.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerticalSpeeds {

    @SerializedName("ascension")
    @Expose
    private Double ascension;
    @SerializedName("descent")
    @Expose
    private Double descent;

    public Double getAscension() {
        return ascension;
    }

    public void setAscension(Double ascension) {
        this.ascension = ascension;
    }

    public Double getDescent() {
        return descent;
    }

    public void setDescent(Double descent) {
        this.descent = descent;
    }

}