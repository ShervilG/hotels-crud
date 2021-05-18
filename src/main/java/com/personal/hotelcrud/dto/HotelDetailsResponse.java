package com.personal.hotelcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class HotelDetailsResponse {

  private String name;

  private String data;

  private Double latitude;

  private Double longitude;

  private String city;

  private String state;

  private String country;
}
