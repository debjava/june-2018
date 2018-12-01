package com.ddlab.boot.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class ConsumerController {

  @GetMapping(path = "/item/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> getItemsById() throws RestClientException, IOException {
    String baseUrl = "http://localhost:8081/producer/home/item/11";
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = null;
    try {
      response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
    } catch (Exception ex) {
      System.out.println(ex);
    }
    System.out.println(response.getBody());
    return response;
  }

  private static HttpEntity<?> getHeaders() throws IOException {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
    return new HttpEntity<>(headers);
  }

  @Autowired private DiscoveryClient discoveryClient;

  @GetMapping(path = "/items/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> getNewItemsById() throws RestClientException, IOException {

    System.out.println("discoveryClient----------->" + discoveryClient);

    discoveryClient.getServices().forEach(System.out::println);

    List<ServiceInstance> instances = discoveryClient.getInstances("producer");
    System.out.println("instances----------->" + instances);
    ServiceInstance serviceInstance = instances.get(0);
    System.out.println("serviceInstance----------->" + serviceInstance);
    String baseUrl = serviceInstance.getUri().toString();
    System.out.println("baseUrl----------->" + baseUrl);
    baseUrl = baseUrl + "/producer/home/item/11";
    System.out.println("baseUrl----------->" + baseUrl);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = null;
    try {
      response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
    } catch (Exception ex) {
      System.out.println(ex);
    }
    System.out.println(response.getBody());

    return response;
  }
}
