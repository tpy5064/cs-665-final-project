/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: GeocoderAPI.java
 * Description: This class takes a user input physical address and converts it to a LocationData object
 * containing the longitude and latitude of that address using a geocoder API.
 */


package edu.bu.met.cs665.apis;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bu.met.cs665.dataObj.LocationData;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GeocoderAPI {

    public LocationData fetch(String location) {
        /**
         * This method fetches from the geocoder API with a formatted apiUrl.
         *
         * @param apiUrl The user-input location, used to format the API URI within this method
         */
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String encodedLoc = URLEncoder.encode(location, StandardCharsets.UTF_8.toString());
            //Formatted URI
            String apiUrl = "https://geocode.maps.co/search?q=" + encodedLoc;
            HttpGet getRequest = new HttpGet(apiUrl); //GET request
            HttpEntity response = httpClient.execute(getRequest).getEntity();
            String json = EntityUtils.toString(response);

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //API returns a list of most relevant locations, map to the WeatherData DAO (Data-Access-Object)
            List<LocationData> locations = mapper.readValue(json, new TypeReference<List<LocationData>>() {});


            if(locations.size() > 0) {
                LocationData result = locations.get(0); //Get most relevant location
                System.out.println("Latitude: " + result.getLat());
                System.out.println("Longitude: " + result.getLon());
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
