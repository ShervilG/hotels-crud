package com.personal.hotelcrud.service.impl;

import com.personal.hotelcrud.dto.HotelDetailsResponse;
import com.personal.hotelcrud.dto.HotelOnboardRequest;
import com.personal.hotelcrud.entity.Hotel;
import com.personal.hotelcrud.repo.HotelOnboardRepo;
import com.personal.hotelcrud.service.HotelOnboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelOnboardServiceImpl implements HotelOnboardService {

  @Autowired
  HotelOnboardRepo hotelOnboardRepo;

  @Override
  public void onboardHotel(HotelOnboardRequest hotelOnboardRequest) throws Exception {
    if(hotelOnboardRequest.getName() == null || hotelOnboardRequest.getCity() == null) {
      throw new Exception("Error in hotel name !");
    }
    Hotel existingHotel = hotelOnboardRepo.findByNameAndCity(hotelOnboardRequest.getName(), hotelOnboardRequest.getCity());
    if(existingHotel != null) {
      throw new Exception("Hotel already exists !");
    }
    Hotel hotel = new Hotel().toBuilder()
      .city(hotelOnboardRequest.getCity())
      .country((hotelOnboardRequest.getCountry() != null) ? hotelOnboardRequest.getCountry() : "")
      .latitude((hotelOnboardRequest.getLatitude() != null) ? hotelOnboardRequest.getLatitude() : null)
      .state((hotelOnboardRequest.getState() != null) ? hotelOnboardRequest.getState() : "")
      .name(hotelOnboardRequest.getName())
      .build();
    hotelOnboardRepo.save(hotel);
  }

  @Override
  public List<HotelDetailsResponse> findAllByCity(String city) throws Exception {
    if(city.length() == 0) {
      throw new Exception("City cant be empty !");
    }
    List<Hotel> hotelList = hotelOnboardRepo.findAllByCity(city);
    List<HotelDetailsResponse> responseList = new ArrayList<>();
    hotelList.forEach(hotel ->
      responseList.add(new HotelDetailsResponse().toBuilder()
        .city(hotel.getCity())
        .name(hotel.getName())
        .state(hotel.getState())
        .country(hotel.getCountry())
        .latitude(hotel.getLatitude())
        .longitude(hotel.getLongitude()).build())
    );
    return responseList;
  }
}
