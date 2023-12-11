/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: WeatherData.java
 * Description: The Data-Access-Object for the WeatherAPI to parse the incoming JSON object.
 */

package edu.bu.met.cs665.DAOs;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {
    private Current current;
    public static class Current {

        @JsonProperty("temperature_2m")
        private double temperature;
        @JsonProperty("relative_humidity_2m")
        private double humidity;
        @JsonProperty("precipitation")
        private double precipitation;
        @JsonProperty("wind_speed_10m")
        private double windSpeed;

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public double getPrecipitation() {
            return precipitation;
        }

        public void setPrecipitation(double precipitation) {
            this.precipitation = precipitation;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }
    }
    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}
