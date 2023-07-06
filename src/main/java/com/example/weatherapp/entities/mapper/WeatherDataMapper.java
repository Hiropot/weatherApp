package com.example.weatherapp.entities.mapper;

import com.example.weatherapp.entities.WeatherData;
import com.example.weatherapp.DTOs.WeatherApiResponseDTO;
import java.time.LocalDateTime;

public class WeatherDataMapper {

  public static WeatherData mapFromApiResponse(String city, WeatherApiResponseDTO response) {
    WeatherData weatherData = new WeatherData();
    weatherData.setCity(city);
    weatherData.setLatitude(response.getCoord().getLat());
    weatherData.setLongitude(response.getCoord().getLon());
    weatherData.setTimeStamp(LocalDateTime.now());
    weatherData.setTemperature(response.getMain().getTemp());
    weatherData.setWeatherDescription(response.getWeather().get(0).getDescription());
    weatherData.setWeatherIcon(response.getWeather().get(0).getIcon());
    weatherData.setFeelsLike(response.getMain().getFeels_like());
    weatherData.setTempMin(response.getMain().getTemp_min());
    weatherData.setTempMax(response.getMain().getTemp_max());
    weatherData.setPressure(response.getMain().getPressure());
    weatherData.setHumidity(response.getMain().getHumidity());
    weatherData.setVisibility(response.getVisibility());
    weatherData.setWindSpeed(response.getWind().getSpeed());
    weatherData.setWindDeg(response.getWind().getDeg());
    weatherData.setCloudsAll(response.getClouds().getAll());
    weatherData.setSunrise(response.getSys().getSunrise());
    weatherData.setSunset(response.getSys().getSunset());

    return weatherData;
  }
}