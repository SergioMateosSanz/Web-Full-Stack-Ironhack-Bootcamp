package com.ironhack.petadoptionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PetAdoptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetAdoptionServiceApplication.class, args);
	}

}
