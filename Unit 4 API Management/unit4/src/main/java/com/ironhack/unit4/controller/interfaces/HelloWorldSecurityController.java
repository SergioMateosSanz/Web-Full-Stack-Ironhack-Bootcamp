package com.ironhack.unit4.controller.interfaces;

import com.ironhack.unit4.controller.dto.JustNameDTO;
import com.ironhack.unit4.security.CustomerUserDetails;

import java.util.Optional;

public interface HelloWorldSecurityController {

    String helloWorldSecurity();

    String greater(String name);

    String postGreater(JustNameDTO justNameDTO);

    String helloMe(CustomerUserDetails customerUserDetails);
}
