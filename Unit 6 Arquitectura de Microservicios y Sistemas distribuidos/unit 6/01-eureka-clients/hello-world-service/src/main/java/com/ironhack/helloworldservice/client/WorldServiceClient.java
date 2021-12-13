package com.ironhack.helloworldservice.client;

import com.ironhack.helloworldservice.configuration.LoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@LoadBalancerClient(name = "world-service", configuration = LoadBalancerConfiguration.class)
@FeignClient("world-service")
public interface WorldServiceClient {
    @GetMapping("/world/{id}")
    String world(@PathVariable int id);
}
