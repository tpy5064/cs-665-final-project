/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: WeatherAPI.java
 * Description: This class takes a user formatted apiUrl, formatted using the UriBuilder class and queries
 * the data from the open-meteo weather API.
 */

package edu.bu.met.cs665.apis;

import com.fasterxml.jackson.databind.DeserializationFeature;
import edu.bu.met.cs665.subjects.WeatherSubject;
import edu.bu.met.cs665.callback.Task;
import edu.bu.met.cs665.DAOs.WeatherData;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class WeatherAPI extends Task {
    private WeatherSubject weatherSubject;

    public WeatherAPI(WeatherSubject w) {
        this.weatherSubject = w;
    }
    @Override
    public void fetch(String apiUrl) {
        /**
         * This method fetches from the open-meteo API with a formatted apiUrl.
         *
         * @param apiUrl The formatted API URI
         */
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet getRequest = new HttpGet(apiUrl);
            HttpEntity response = httpClient.execute(getRequest).getEntity();
            String json = EntityUtils.toString(response);

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            WeatherData data = mapper.readValue(json, WeatherData.class);
            weatherSubject.setData(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
