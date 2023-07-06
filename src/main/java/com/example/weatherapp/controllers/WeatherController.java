package com.example.weatherapp.controllers;

import com.example.weatherapp.entities.WeatherData;
import com.example.weatherapp.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

  private final WeatherService weatherService;

  @Autowired
  public WeatherController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @GetMapping("/city/{cityName}")
  public WeatherData getWeatherByCity(@PathVariable String cityName) throws Exception {
    return weatherService.getWeatherByCity(cityName);
  }

  @GetMapping("/coordinates")
  public WeatherData getWeatherByCoordinates(@RequestParam double latitude, @RequestParam double longitude) throws Exception {
    return weatherService.getWeatherByCoordinates(latitude, longitude);
  }
}