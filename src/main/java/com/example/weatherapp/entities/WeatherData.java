package com.example.weatherapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class WeatherData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String city;
  private double latitude;
  private double longitude;
  private LocalDateTime timeStamp;
  private double temperature;
  private String weatherDescription;
  private String weatherIcon;
  private double feelsLike;
  private double tempMin;
  private double tempMax;
  private int pressure;
  private int humidity;
  private int visibility;
  private double windSpeed;
  private int windDeg;
  private int cloudsAll;
  private long sunrise;
  private long sunset;

}