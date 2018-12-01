package com.ddlab.rnd.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.ddlab.rnd.config.Configuration;

@SpringBootApplication
@RibbonClient(name = "justANameToIgnore", configuration = Configuration.class)
public class CardServiceBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(CardServiceBootApplication.class, args);
  }
}
