package com.example.weatherapp.repositories;

import com.example.weatherapp.entities.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
  WeatherData findByCityOrLatitudeAndLongitude(String city, double latitude, double longitude);
}
