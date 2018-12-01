package com.ddlab.rnd.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducerBootApplication {

  public static void main(String[] args) {
	  SpringApplication.run(ProducerBootApplication.class, args);
  }
}
