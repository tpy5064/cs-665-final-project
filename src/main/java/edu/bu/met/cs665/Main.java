/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: Main.java
 * Description: The main class where the program is run on a loop to continuously query for weather data.
 */

package edu.bu.met.cs665;


import edu.bu.met.cs665.apis.GeocoderAPI;
import edu.bu.met.cs665.apis.WeatherAPI;
import edu.bu.met.cs665.callback.Task;
import edu.bu.met.cs665.DAOs.LocationData;
import edu.bu.met.cs665.helpers.Timer;
import edu.bu.met.cs665.helpers.WeatherInfoConfig;
import edu.bu.met.cs665.observers.HumidityObserver;
import edu.bu.met.cs665.observers.PrecipitationObserver;
import edu.bu.met.cs665.observers.TemperatureObserver;
import edu.bu.met.cs665.observers.WindSpeedObserver;
import edu.bu.met.cs665.subjects.WeatherSubject;
import edu.bu.met.cs665.template.UriBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    WeatherSubject weatherSubject = new WeatherSubject();
    weatherSubject.addObserver(new TemperatureObserver());
    weatherSubject.addObserver(new HumidityObserver());
    weatherSubject.addObserver(new PrecipitationObserver());
    weatherSubject.addObserver(new WindSpeedObserver());



    while(true) {
      WeatherInfoConfig config = new WeatherInfoConfig();
      UriBuilder uriBuilder = new UriBuilder();
      GeocoderAPI geocoderService = new GeocoderAPI();
      Task apiService = new WeatherAPI(weatherSubject); //Target weather subject is contained within the api service

      System.out.println("Please enter a location to find its weather info:");
      String location = scanner.nextLine();
      LocationData locData = geocoderService.fetch(location); //User geocoder API to fetch location
      //Set config to use the location's latitude and longitude
      config.setLat(locData.getLat());
      config.setLon(locData.getLon());

      //Configure temperature unit
      while(true) {
        System.out.println("Please enter desired temperature units (celsius/fahrenheit): ");
        String tempUnit = scanner.nextLine();
        if (!tempUnit.equals("celsius") && !tempUnit.equals("fahrenheit")) {
          System.out.println("Unit not legal, please enter again!");
          continue;
        }
        config.setTempUnit(tempUnit);
        break;
      }

      //Configure wind speed unit
      while(true) {
        System.out.println("Please enter desired wind speed units (kmh/mph): ");
        String windSpeedUnit = scanner.nextLine();
        if (!windSpeedUnit.equals("kmh") && !windSpeedUnit.equals("mph")) {
          System.out.println("Unit not legal, please enter again!");
          continue;
        }
        config.setWindSpeedUnit(windSpeedUnit);
        break;
      }

      //Configure precipitation unit
      while(true) {
        System.out.println("Please enter desired precipitation units (mm/inch): ");
        String precipUnit = scanner.nextLine();
        if(!precipUnit.equals("mm") && !precipUnit.equals("inch")) {
          System.out.println("Unit not legal, please enter again!");
          continue;
        }
        config.setPrecipUnit(precipUnit);
        break;
      }

      //Build the URI
      String configuredUri = uriBuilder.buildUri(config);

      //Display date and user's chose location
      LocalDateTime date = LocalDateTime.now();
      DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
      System.out.println("Weather in " + location +  " as of " + date.format(format) + " is:\n");

      //Time response
      Timer.start();
      //Get weather info, once complete, callback to update all observers.
      apiService.fetchWithCallback(configuredUri, () -> weatherSubject.updateObservers(config));
      Timer.stop();

      //Get response time
      System.out.println("Response time: " + Timer.getTime() + "ms\n");


    }
  }

}
