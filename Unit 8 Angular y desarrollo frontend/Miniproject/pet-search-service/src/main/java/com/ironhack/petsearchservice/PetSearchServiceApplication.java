package com.ironhack.petsearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PetSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetSearchServiceApplication.class, args);
	}

}
