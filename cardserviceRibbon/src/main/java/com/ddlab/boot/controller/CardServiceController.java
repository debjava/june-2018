package com.ddlab.boot.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cards")
@CrossOrigin
public class CardServiceController {

  @LoadBalanced
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Autowired RestTemplate restTemplate;

  @GetMapping(path = "/dcard/name", produces = MediaType.TEXT_PLAIN_VALUE)
  public String getDebitCardName() {
    return this.restTemplate.getForObject("http://debitcard/dc/home/name", String.class);
  }

  @GetMapping(path = "/ccard/name", produces = MediaType.TEXT_PLAIN_VALUE)
  public String getCreditCardName() {
    return this.restTemplate.getForObject("http://creditcard/cc/home/name", String.class);
  }

  @Autowired private LoadBalancerClient loadBalancer;

  @GetMapping(path = "/info", produces = MediaType.TEXT_PLAIN_VALUE)
  public String doStuff() {
    ServiceInstance instance = loadBalancer.choose("creditcard");
    URI storesUri =
        URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
    return storesUri.toString();
  }
}
