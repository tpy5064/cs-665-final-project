/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: HumidityObserver.java
 * Description: The HumidityObserver class receives the humidity information from the parsed JSON.
 */


package edu.bu.met.cs665.observers;

import edu.bu.met.cs665.dataObj.WeatherData;
import edu.bu.met.cs665.helpers.WeatherInfoConfig;

public class HumidityObserver implements WeatherObserver{
    @Override
    public void update(WeatherData data, WeatherInfoConfig config) {
        /**
         * The update method for the observer pattern.
         *
         * @param data The parsed JSON data.
         * @param config The config that the user chose, unused in this case.
         */
        System.out.println("Humidity: " + data.getCurrent().getHumidity() + "%");
    }
}
