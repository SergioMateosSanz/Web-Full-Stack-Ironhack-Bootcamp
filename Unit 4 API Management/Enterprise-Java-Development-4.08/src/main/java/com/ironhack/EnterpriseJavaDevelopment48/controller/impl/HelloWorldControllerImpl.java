package com.ironhack.EnterpriseJavaDevelopment48.controller.impl;

import com.ironhack.EnterpriseJavaDevelopment48.controller.dto.JustNameDTO;
import com.ironhack.EnterpriseJavaDevelopment48.controller.interfaces.HelloWorldController;
import com.ironhack.EnterpriseJavaDevelopment48.security.CustomUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldControllerImpl implements HelloWorldController {

    @GetMapping("/hello-world")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/hello/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String greater(@PathVariable(name = "name") String name) {
        return "Hello " + name;
    }

    @PostMapping("/hello-post")
    @ResponseStatus(HttpStatus.OK)
    public String postGreater(@RequestBody JustNameDTO justNameDTO) {
        return "Hello " + justNameDTO.getName();
    }

    @GetMapping("/hello-me")
    public String helloMe(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return "Welcome, " + userDetails.getUsername();
    }


}
