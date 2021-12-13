package com.ironhack.Jenkins.demo.controller.implementations;

import com.ironhack.Jenkins.demo.controller.interfaces.helloWorldController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldControllerImpl implements helloWorldController {

    @Override
    @GetMapping("/helloworld")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {

        return "hello people";
    }
}
