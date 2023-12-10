/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: WeatherSubject.java
 * Description: The subject in the observer pattern. Responsible for managing all the observers and updating them.
 */


package edu.bu.met.cs665.subjects;

import edu.bu.met.cs665.dataObj.WeatherData;
import edu.bu.met.cs665.helpers.WeatherInfoConfig;
import edu.bu.met.cs665.observers.WeatherObserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject {
    private List<WeatherObserver> observers = new ArrayList<>();
    private WeatherData data;

    public void addObserver(WeatherObserver o) {
        observers.add(o);
    }

    public void updateObservers(WeatherInfoConfig config) {
        for(WeatherObserver o : observers) {
            o.update(data, config);
        }
    }

    public void setData(WeatherData data) {
        this.data = data;
    }
}
