package com.personal.hotelcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "hotels")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

  @Id
  private String id;

  private String name;

  private String data;

  private Double latitude;

  private Double longitude;

  private String city;

  private String state;

  private String country;
}
