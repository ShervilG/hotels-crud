package com.personal.hotelcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelOnboardRequest {

  private String name;

  private String data;

  private Double latitude;

  private Double longitude;

  private String city;

  private String state;

  private String country;
}
