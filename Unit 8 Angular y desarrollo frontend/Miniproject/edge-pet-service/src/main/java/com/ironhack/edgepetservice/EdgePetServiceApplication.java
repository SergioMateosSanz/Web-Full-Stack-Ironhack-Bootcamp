package com.ironhack.edgepetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EdgePetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgePetServiceApplication.class, args);
	}

}
