package com.ddlab.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/eurocards")
@CrossOrigin
public class EurekaRibbonCardController {

  @Autowired private LoadBalancerClient loadBalancer;

  private String getDCLoadBalancerURL() {
    ServiceInstance dcInstance = loadBalancer.choose("DC");
    String dcURL = dcInstance.getUri().toString();
    System.out.println("Base URL : " + dcURL);
    dcURL = dcURL + "/dc/home/name";
    return dcURL;
  }

  private String getCCLoadBalancerURL() {
    ServiceInstance ccInstance = loadBalancer.choose("CC");
    String ccURL = ccInstance.getUri().toString();
    System.out.println("Base URL : " + ccURL);
    ccURL = ccURL + "/cc/home/name";
    return ccURL;
  }

  @GetMapping(path = "/eureka/ribbon/names", produces = MediaType.TEXT_PLAIN_VALUE)
  public String doStuff() {
    RestTemplate restTemplate = new RestTemplate();
    String response = null;
    StringBuilder allResponse = new StringBuilder();
    try {
      String dcURL = getDCLoadBalancerURL();
      response = restTemplate.getForObject(dcURL, String.class);
      allResponse.append("Debit Card Details \n").append(response).append("\n\n");

      String ccURL = getCCLoadBalancerURL();
      response = restTemplate.getForObject(ccURL, String.class);
      allResponse.append("Credit Card Details \n").append(response).append("\n\n");

    } catch (Exception ex) {
      System.out.println(ex);
    }
    System.out.println("Finally response ::: " + response);
    return allResponse.toString();
  }
}
