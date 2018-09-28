package com.microdrones.technical_test.mission;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mission {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("horizontalSpeed")
    @Expose
    private Double horizontalSpeed;
    @SerializedName("altitude")
    @Expose
    private Integer altitude;
    @SerializedName("points")
    @Expose
    private List<Point> points = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHorizontalSpeed() {
        return horizontalSpeed;
    }

    public void setHorizontalSpeed(Double horizontalSpeed) {
        this.horizontalSpeed = horizontalSpeed;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
