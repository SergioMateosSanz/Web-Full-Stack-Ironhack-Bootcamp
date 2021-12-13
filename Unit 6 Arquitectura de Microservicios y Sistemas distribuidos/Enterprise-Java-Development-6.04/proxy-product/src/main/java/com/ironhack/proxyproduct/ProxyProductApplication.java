package com.ironhack.proxyproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProxyProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyProductApplication.class, args);
	}

}
