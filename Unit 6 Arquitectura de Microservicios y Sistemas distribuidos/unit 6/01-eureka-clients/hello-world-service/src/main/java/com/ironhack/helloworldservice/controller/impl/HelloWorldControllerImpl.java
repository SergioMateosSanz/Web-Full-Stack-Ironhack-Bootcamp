package com.ironhack.helloworldservice.controller.impl;


import com.ironhack.helloworldservice.client.WorldServiceClient;
import com.ironhack.helloworldservice.controller.interfaces.HelloWorldController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldControllerImpl implements HelloWorldController {

    @Autowired
    private WorldServiceClient worldServiceClient;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    private final Logger logger = LoggerFactory.getLogger(HelloWorldControllerImpl.class);

    @GetMapping("/hello-world")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        logger.info("INIT helloWorld method");
//        RestTemplate restTemplate = new RestTemplate();
//        String worldServiceBaseUrl = discoveryClient.getInstances("world-service").get(0).getUri().toString(); // http://localhost:8081
//        logger.info("world-service URL: " + worldServiceBaseUrl);
//
//        String url = worldServiceBaseUrl + "/world";
//        String result = restTemplate.getForObject(url, String.class);
        String result = worldServiceClient.world(55);
        return "Hello " + result;
    }

//    @GetMapping("/blah")
//    public String blabla() {
//        return "Bla bla bla";
//    }
}
