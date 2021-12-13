package com.ironhack.unit4.controller.implementations;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HelloWorldControllerImpl implements com.ironhack.unit4.controller.interfaces.HelloWorldController {

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    //public String helloWorld(@RequestParam(defaultValue = "user") Optional<String> name) {
    public String helloWorld(@RequestParam Optional<String> name) {
        //return name.isPresent() ? "Hello " + name.get() : "Hello World";
        return name.map(s -> "Hello " + s).orElse("Hello World");
    }
}
