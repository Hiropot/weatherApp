package com.example.weatherapp.configurations;

import com.example.weatherapp.APIs.WeatherApi;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfig {

  @Bean
  public HttpClient httpClient() {
    return HttpClients.createDefault();
  }

  @Bean
  public WeatherApi weatherApi(HttpClient httpClient, @Value("${API_KEY}") String apiKey) {
    return new WeatherApi(httpClient, apiKey);
  }
}