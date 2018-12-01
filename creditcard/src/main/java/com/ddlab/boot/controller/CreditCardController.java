package com.ddlab.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class CreditCardController {

  @Value("${server.port}")
  String port;

  @GetMapping(path = "/name", produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> getDebitCardName() {
    return new ResponseEntity<String>("Standard Chatered Card service running in " + port, HttpStatus.OK);
  }
}
