/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: TemperatureObserver.java
 * Description: The TemperatureObserver class receives the temperature information from the parsed JSON.
 */


package edu.bu.met.cs665.observers;

import edu.bu.met.cs665.DAOs.WeatherData;
import edu.bu.met.cs665.helpers.WeatherInfoConfig;

public class TemperatureObserver implements WeatherObserver{
    @Override
    public void update(WeatherData data, WeatherInfoConfig config) {
        /**
         * The update method for the observer pattern.
         *
         * @param data The parsed JSON data.
         * @param config The configured unit that the user chose for displaying temperature (celsius/fahrenheit)
         */
        System.out.println("Temperature: " + data.getCurrent().getTemperature() + " " + config.getTempUnit());
    }
}
