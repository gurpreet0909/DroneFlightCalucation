
package com.microdrones.technical_test.drone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentLoadInFlight {

    @SerializedName("ascension")
    @Expose
    private Double ascension;
    @SerializedName("descent")
    @Expose
    private Double descent;
    @SerializedName("translation")
    @Expose
    private Double translation;

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

    public Double getTranslation() {
        return translation;
    }

    public void setTranslation(Double translation) {
        this.translation = translation;
    }

}