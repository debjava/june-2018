package com.ddlab.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddlab.boot.entity.Location;
import com.ddlab.boot.service.OrgService;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class OrgController {

  @Autowired private OrgService orgService;

  // http://localhost:8081/org/home/location/12345
  @GetMapping(path = "/location/{pincode}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Location> getLocationByPincode(@PathVariable("pincode") String pincode) {
    System.out.println("Org Service :::" + orgService);
    return new ResponseEntity<Location>(orgService.getLocationByPincode(pincode), HttpStatus.OK);
  }

  @PostMapping(
      path = "/create/location",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> createOrgSpace(@RequestBody Location location) {
    System.out.println("Created location : " + location);
    return new ResponseEntity<String>("Resource created successfully.", HttpStatus.CREATED);
  }

  @PutMapping(
      path = "/update/location",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Location> updateOrgSpace(@RequestBody Location location) {
    System.out.println("Updated location : " + location);
    return new ResponseEntity<Location>(location, HttpStatus.OK);
  }

  @DeleteMapping(
      path = "/delete/location",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> deleteOrgSpace(@RequestBody Location location) {
    System.out.println("Deleted location : " + location);
    return new ResponseEntity<String>("Resource deleted successfully.", HttpStatus.OK);
  }
}
