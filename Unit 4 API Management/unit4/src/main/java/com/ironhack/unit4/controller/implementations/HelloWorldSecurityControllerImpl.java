package com.ironhack.unit4.controller.implementations;

import com.ironhack.unit4.controller.dto.JustNameDTO;
import com.ironhack.unit4.controller.interfaces.HelloWorldSecurityController;
import com.ironhack.unit4.security.CustomerUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldSecurityControllerImpl implements HelloWorldSecurityController {

    @Override
    @GetMapping("/hello-world")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorldSecurity() {
        return "hello world";
    }

    @Override
    @GetMapping("/hello-world/{name}")
    public String greater(@PathVariable(name = "name") String name) {
        return "hello " + name;
    }

    @Override
    @PostMapping("hello-world")
    @ResponseStatus(HttpStatus.CREATED)
    public String postGreater(@RequestBody JustNameDTO justNameDTO) {
        return "hello " + justNameDTO.getName();
    }

    @Override
    @GetMapping("/hello-me")
    @ResponseStatus(HttpStatus.OK)
    public String helloMe(@AuthenticationPrincipal CustomerUserDetails customerUserDetails) {
        return "Welcome " + customerUserDetails.getUsername();
    }
}
