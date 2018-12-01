package com.ddlab.rnd.boot;

import org.springframework.cloud.openfeign.FeignClient;

import feign.Param;
import feign.RequestLine;

@FeignClient("name")
public interface GetInfo {
    
//    @RequestMapping(value="/location/{pincode}",produces = MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
    @RequestLine("GET /location/{pincode}")
    public String getName(@Param("pincode") String pincode);
}
