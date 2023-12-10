/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: LocationData.java
 * Description: The Data-Access-Object for the GeocoderAPI to parse the incoming JSON object.
 */

package edu.bu.met.cs665.dataObj;

public class LocationData {
    private String lat;
    private String lon;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
