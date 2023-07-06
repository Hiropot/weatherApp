package com.example.weatherapp.services;

import com.example.weatherapp.APIs.WeatherApi;
import com.example.weatherapp.entities.WeatherData;
import com.example.weatherapp.DTOs.WeatherApiResponseDTO;
import com.example.weatherapp.entities.mapper.WeatherDataMapper;
import com.example.weatherapp.repositories.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

  private final WeatherDataRepository weatherDataRepository;
  private final WeatherApi weatherApi;

  @Autowired
  public WeatherService(WeatherDataRepository weatherDataRepository, WeatherApi weatherApi) {
    this.weatherDataRepository = weatherDataRepository;
    this.weatherApi = weatherApi;
  }

  public WeatherData getWeatherByCity(String cityName) throws Exception {
    WeatherApiResponseDTO apiResponse = weatherApi.getWeatherByCity(cityName);
    WeatherData weatherData = WeatherDataMapper.mapFromApiResponse(cityName, apiResponse);
    return weatherDataRepository.save(weatherData);
  }

  public WeatherData getWeatherByCoordinates(double latitude, double longitude) throws Exception {
    WeatherApiResponseDTO apiResponse = weatherApi.getWeatherByCoordinates(latitude, longitude);
    WeatherData weatherData = WeatherDataMapper.mapFromApiResponse(apiResponse.getName(), apiResponse);
    return weatherDataRepository.save(weatherData);
  }
}