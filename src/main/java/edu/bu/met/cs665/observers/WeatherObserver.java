/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: WeatherObserver.java
 * Description: The abstract observer base class that future observers can implement.
 */


package edu.bu.met.cs665.observers;

import edu.bu.met.cs665.DAOs.WeatherData;
import edu.bu.met.cs665.helpers.WeatherInfoConfig;

public interface WeatherObserver {
    void update(WeatherData data, WeatherInfoConfig config);
}
