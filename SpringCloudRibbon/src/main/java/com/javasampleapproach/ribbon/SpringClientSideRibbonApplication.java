package com.javasampleapproach.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.javasampleapproach.ribbon.config.Configuration;

@SpringBootApplication
//@RibbonClient(name = "helloworld1", configuration = Configuration.class)

@RibbonClient(name = "justANameToIgnore", configuration = Configuration.class)
public class SpringClientSideRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringClientSideRibbonApplication.class, args);
	}
}