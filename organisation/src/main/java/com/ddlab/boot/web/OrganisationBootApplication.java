package com.ddlab.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrganisationBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrganisationBootApplication.class, args);
  }
}
