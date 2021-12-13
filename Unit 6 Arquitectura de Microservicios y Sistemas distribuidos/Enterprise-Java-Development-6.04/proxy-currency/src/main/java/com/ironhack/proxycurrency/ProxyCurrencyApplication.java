package com.ironhack.proxycurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProxyCurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyCurrencyApplication.class, args);
	}

}
