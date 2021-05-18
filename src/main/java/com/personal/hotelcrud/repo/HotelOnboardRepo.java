package com.personal.hotelcrud.repo;

import com.personal.hotelcrud.entity.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HotelOnboardRepo extends MongoRepository<Hotel, Long> {

  Hotel findByNameAndCity(String name, String city);

  List<Hotel> findAllByCity(String city);
}
