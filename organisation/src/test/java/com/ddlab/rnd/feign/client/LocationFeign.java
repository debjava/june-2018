package com.ddlab.rnd.feign.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.ddlab.boot.entity.Location;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@FeignClient(name = "location") // It can be any name of your choice
public interface LocationFeign {
  @RequestLine("GET /location/{pincode}")
  String getLocation(@Param("pincode") String pincode);

  @RequestLine("POST /create/location")
  @Headers("Content-Type: application/json")
  String createLocation(Location location);

  @RequestLine("PUT /update/location")
  @Headers("Content-Type: application/json")
  Location updateLocation(Location location);

  @RequestLine("DELETE /delete/location")
  @Headers("Content-Type: application/json")
  String deleteLocation(Location location);
}
