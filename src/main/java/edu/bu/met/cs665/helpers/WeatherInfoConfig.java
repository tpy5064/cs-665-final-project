/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: WeatherInfoConfig.java
 * Description: A helper class that contains all user input to prevent long method arguments to UriBuilder.
 */


package edu.bu.met.cs665.helpers;

public class WeatherInfoConfig {

    private String lat;
    private String lon;
    private String tempUnit;
    private String windSpeedUnit;
    private String precipUnit;

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setTempUnit(String tempUnit) {
        this.tempUnit = tempUnit;
    }

    public void setWindSpeedUnit(String windSpeedUnit) {
        this.windSpeedUnit = windSpeedUnit;
    }

    public void setPrecipUnit(String precipUnit) {
        this.precipUnit = precipUnit;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getTempUnit() {
        return tempUnit;
    }

    public String getWindSpeedUnit() {
        return windSpeedUnit;
    }

    public String getPrecipUnit() {
        return precipUnit;
    }


}
