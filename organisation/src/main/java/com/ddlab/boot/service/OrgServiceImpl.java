package com.ddlab.boot.service;

import org.springframework.stereotype.Service;

import com.ddlab.boot.entity.Location;

@Service
public class OrgServiceImpl implements OrgService {

  @Override
  public Location getLocationByPincode(String pincode) {
    Location location = new Location();
    location.setOfficeName("DDLAB INC");
    location.setCity("Bangalore, Karnataka");
    location.setPincode(pincode);
    location.setStreetName("13th main road, 5th block");
    return location;
  }
}
