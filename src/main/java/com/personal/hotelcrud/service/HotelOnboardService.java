package com.personal.hotelcrud.service;

import com.personal.hotelcrud.dto.HotelDetailsResponse;
import com.personal.hotelcrud.dto.HotelOnboardRequest;
import com.personal.hotelcrud.entity.Hotel;

import java.util.List;

public interface HotelOnboardService {

  void onboardHotel(HotelOnboardRequest hotelOnboardRequest) throws Exception;

  List<HotelDetailsResponse> findAllByCity(String city) throws Exception;
}
