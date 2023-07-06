package com.example.weatherapp.APIs;

import com.example.weatherapp.DTOs.WeatherApiResponseDTO;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherApi {
  private final HttpClient httpClient;
  private final String apiKey;
  private final ObjectMapper objectMapper;

  public WeatherApi(HttpClient httpClient, String apiKey) {
    this.httpClient = httpClient;
    this.apiKey = apiKey;
    this.objectMapper = new ObjectMapper();
  }

  public WeatherApiResponseDTO getWeatherByCity(String city) throws Exception {
    String url = buildWeatherApiUrlByCity(city);
    String responseBody = executeHttpRequest(url);
    return parseJsonResponse(responseBody);
  }

  public WeatherApiResponseDTO getWeatherByCoordinates(double latitude, double longitude) throws Exception {
    String url = buildWeatherApiUrlByCoordinates(latitude, longitude);
    String responseBody = executeHttpRequest(url);
    return parseJsonResponse(responseBody);
  }

  private String buildWeatherApiUrlByCity(String city) {
    return "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=" + "metric" + "&appid=" + apiKey;
  }

  private String buildWeatherApiUrlByCoordinates(double latitude, double longitude) {
    return "http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&units=" + "metric" + "&appid=" + apiKey;
  }

  private String executeHttpRequest(String url) throws Exception {
    HttpGet request = new HttpGet(url);
    HttpResponse response = httpClient.execute(request);
    HttpEntity entity = response.getEntity();
    return EntityUtils.toString(entity);
  }

  private WeatherApiResponseDTO parseJsonResponse(String responseBody) throws Exception {
    return objectMapper.readValue(responseBody, WeatherApiResponseDTO.class);
  }
}