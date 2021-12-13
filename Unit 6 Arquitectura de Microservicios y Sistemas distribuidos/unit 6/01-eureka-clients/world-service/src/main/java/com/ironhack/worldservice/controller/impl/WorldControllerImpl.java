package com.ironhack.worldservice.controller.impl;

import com.ironhack.worldservice.controller.interfaces.WorldController;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WorldControllerImpl implements WorldController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    private final Logger logger = LoggerFactory.getLogger(WorldControllerImpl.class);

    @GetMapping("/world/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String world(@PathVariable int id) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String helloWorldServiceBaseUrl = discoveryClient.getInstances("hello-world-service").get(0).getUri().toString();
//        // http://localhost:8080
//        logger.info("hello world service base url = " + helloWorldServiceBaseUrl);
//
//        String url = helloWorldServiceBaseUrl + "/blah";
//        String result = restTemplate.getForObject(url, String.class);
//        return "Resultado: " + result;
        logger.info("Running in port - " + port);
        return "World " + id;

    }
}
