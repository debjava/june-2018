package com.ddlab.rnd.boot;

import org.springframework.cloud.openfeign.FeignClient;

import com.ddlab.boot.entity.Location;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

//@FeignClient("location",url = "http://localhost:9001")
@FeignClient(name="someName")
public interface GetLocation {
    
    @RequestLine("GET /location/{pincode}")
    String getLocation(@Param("pincode") String pincode);
    
    @RequestLine("POST /create/location")
    @Headers("Content-Type: application/json")
    String createLocation(Location location);
}
