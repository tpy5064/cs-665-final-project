/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: UriBuilder.java
 * Description: The template method to build the API URI without cluttering Main.java or WeatherAPI.java
 */


package edu.bu.met.cs665.template;

import edu.bu.met.cs665.helpers.WeatherInfoConfig;

public class UriBuilder {
    private String templateUri = "https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}" +
            "&current=temperature_2m,relative_humidity_2m,precipitation,wind_speed_10m&" +
            "temperature_unit={temp_unit}&wind_speed_unit={wind_speed_unit}" +
            "&precipitation_unit={precipitation_unit}&timezone=America%2FNew_York";

    public final String buildUri(WeatherInfoConfig config) {
        /**
         * The template method to build the URI
         * @param config The user configured options for units and location.
         */
        return templateUri.replace("{lat}", config.getLat())
                .replace("{lon}", config.getLon())
                .replace("{temp_unit}", config.getTempUnit())
                .replace("{wind_speed_unit}", config.getWindSpeedUnit())
                .replace("{precipitation_unit}", config.getPrecipUnit());
    }
}