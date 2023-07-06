package com.example.weatherapp.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDTO {

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


  @Data
  public static class Coord {

    private double lon;
    private double lat;
  }

  @Data
  public static class Weather {

    private int id;
    private String main;
    private String description;
    private String icon;
  }

  @Data
  public static class Main {

    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
    private double sea_level;
    private int grnd_level;
  }

  @Data
  public static class Wind {

    private double speed;
    private double gust;
    private int deg;
  }

  @Data
  public static class Clouds {

    private int all;
  }

  @Data
  public static class Sys {

    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;
  }
}