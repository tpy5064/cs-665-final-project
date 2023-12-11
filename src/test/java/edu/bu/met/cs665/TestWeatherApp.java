package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import edu.bu.met.cs665.apis.GeocoderAPI;
import edu.bu.met.cs665.DAOs.LocationData;
import edu.bu.met.cs665.DAOs.WeatherData;
import edu.bu.met.cs665.helpers.WeatherInfoConfig;
import edu.bu.met.cs665.template.UriBuilder;
import org.junit.Test;

/**
 * Write some Unit tests for your program like the examples below.
 */

public class TestWeatherApp {


    @Test
    public void testConfigFieldsInstantiatedAsExpected() {
        WeatherInfoConfig config = new WeatherInfoConfig();
        config.setLat("12");
        config.setLon("12.1");
        config.setTempUnit("fahrenheit");
        config.setPrecipUnit("inch");
        config.setWindSpeedUnit("mph");

        assertEquals(config.getLat(), "12");
        assertEquals(config.getLon(), "12.1");
        assertEquals(config.getTempUnit(), "fahrenheit");
        assertEquals(config.getPrecipUnit(), "inch");
        assertEquals(config.getWindSpeedUnit(), "mph");
    }

    @Test
    public void testConfiguredApiUrlAsExpected() {
        WeatherInfoConfig config = new WeatherInfoConfig();
        config.setLat("12");
        config.setLon("12.1");
        config.setTempUnit("fahrenheit");
        config.setPrecipUnit("inch");
        config.setWindSpeedUnit("mph");

        UriBuilder builder = new UriBuilder();

        String expected = "https://api.open-meteo.com/v1/forecast?latitude=12&longitude=12.1" +
                "&current=temperature_2m,relative_humidity_2m,precipitation,wind_speed_10m&" +
                "temperature_unit=fahrenheit&wind_speed_unit=mph" +
                "&precipitation_unit=inch&timezone=America%2FNew_York";
        assertEquals(expected, builder.buildUri(config));
    }

    @Test
    public void testGeocoderApiFunctional() {
        GeocoderAPI api = new GeocoderAPI();
        LocationData loc = api.fetch("Boston");
        assertNotNull(loc.getLat());
        assertNotNull(loc.getLon());
    }

    @Test
    public void weatherDataFunctionality() {
        WeatherData data = new WeatherData();
        data.setCurrent(new WeatherData.Current());
        data.getCurrent().setTemperature(35);
        data.getCurrent().setHumidity(50);
        data.getCurrent().setWindSpeed(1);
        data.getCurrent().setPrecipitation(10);

        assertEquals(data.getCurrent().getTemperature(), 35, 0);
        assertEquals(data.getCurrent().getHumidity(), 50, 0);
        assertEquals(data.getCurrent().getWindSpeed(), 1, 0);
        assertEquals(data.getCurrent().getPrecipitation(), 10, 0);
    }


}
