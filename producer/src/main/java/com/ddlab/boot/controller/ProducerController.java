package com.ddlab.boot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class ProducerController {

  @GetMapping(path = "/item/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> getItemsById(@PathVariable("id") String id) {
    List<String> soapList = Arrays.asList("Lux soap", "Rexona Soap", "Patanjali Soap");
    return new ResponseEntity<String>(soapList.toString(), HttpStatus.OK);
  }
}
