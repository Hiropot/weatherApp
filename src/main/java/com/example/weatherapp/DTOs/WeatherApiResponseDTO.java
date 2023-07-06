package com.example.weatherapp.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherApiResponseDTO {

  private Coord coord;
  private List<Weather> weather;
  private Main main;
  private int visibility;
  private Wind wind;
  private Clouds clouds;
  private Sys sys;
  private long dt;
  private long timezone;
  private long id;
  private String name;
  private int cod;

  // Constructors, getters, and setters
  @Data
  public static class Coord {

    private double lon;
    private double lat;

    // Constructors, getters, and setters
  }

  @Data
  public static class Weather {

    private int id;
    private String main;
    private String description;
    private String icon;

    // Constructors, getters, and setters
  }

  @Data
  public static class Main {

    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;

    @JsonProperty("temp")
    private void setTempCelsius(double temp) {
      this.temp = temp;
    }

    @JsonProperty("feels_like")
    private void setFeelsLikeCelsius(double feels_like) {
      this.feels_like = feels_like;
    }

    @JsonProperty("temp_min")
    private void setTempMinCelsius(double temp_min) {
      this.temp_min = temp_min;
    }

    @JsonProperty("temp_max")
    private void setTempMaxCelsius(double temp_max) {
      this.temp_max = temp_max;
    }

    // Constructors, getters, and setters
  }

  @Data
  public static class Wind {

    private double speed;
    private double gust;
    private int deg;

    // Constructors, getters, and setters
  }

  @Data
  public static class Clouds {

    private int all;

    // Constructors, getters, and setters
  }

  @Data
  public static class Sys {

    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;

    // Constructors, getters, and setters
  }
}