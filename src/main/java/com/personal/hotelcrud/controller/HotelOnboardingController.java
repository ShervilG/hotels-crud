package com.personal.hotelcrud.controller;

import com.personal.hotelcrud.dto.HotelDetailsResponse;
import com.personal.hotelcrud.dto.HotelOnboardRequest;
import com.personal.hotelcrud.entity.Hotel;
import com.personal.hotelcrud.service.HotelOnboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelOnboardingController {

  @Autowired
  private HotelOnboardService hotelOnboardService;

  @PostMapping("/add-hotel")
  public String onboardHotel(@RequestBody HotelOnboardRequest hotelOnboardRequest) throws Exception {
    try {
      hotelOnboardService.onboardHotel(hotelOnboardRequest);
      return "success !";
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @GetMapping("/find-all")
  public List<HotelDetailsResponse> findAllHotelsByCity(@RequestParam(value = "city", required = true) String city) throws Exception {
    try {
      return hotelOnboardService.findAllByCity(city);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }
}
