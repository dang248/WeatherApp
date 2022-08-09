package com.example.weatherapp.data.model;

public class Wind {

    private Float speed;

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                '}';
    }
}
