package com.ironhack.githubactionsdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    @GetMapping("/helloworld")
    @ResponseStatus(HttpStatus.OK)
    public String helloworld() {
        return "Hello World";
    }

    @GetMapping("/hellodavid")
    @ResponseStatus(HttpStatus.OK)
    public String hellodavid() {
        return "David is the best";
    }
}
