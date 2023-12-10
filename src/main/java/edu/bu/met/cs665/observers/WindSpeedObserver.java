/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: WindSpeedObserver.java
 * Description: The WindSpeedObserver class receives the wind speed information from the parsed JSON.
 */

package edu.bu.met.cs665.observers;

import edu.bu.met.cs665.dataObj.WeatherData;
import edu.bu.met.cs665.helpers.WeatherInfoConfig;

public class WindSpeedObserver implements WeatherObserver{
    @Override
    public void update(WeatherData data, WeatherInfoConfig config) {
        /**
         * The update method for the observer pattern.
         *
         * @param data The parsed JSON data.
         * @param config The configured unit that the user chose for displaying wind speed (kmh/mph)
         */
        System.out.println("Wind Speed: " + data.getCurrent().getWindSpeed() + " " + config.getWindSpeedUnit());
    }
}
