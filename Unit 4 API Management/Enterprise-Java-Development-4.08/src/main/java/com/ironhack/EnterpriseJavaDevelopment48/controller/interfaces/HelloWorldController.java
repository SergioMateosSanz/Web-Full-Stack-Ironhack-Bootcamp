package com.ironhack.EnterpriseJavaDevelopment48.controller.interfaces;

import com.ironhack.EnterpriseJavaDevelopment48.controller.dto.JustNameDTO;
import com.ironhack.EnterpriseJavaDevelopment48.security.CustomUserDetails;

public interface HelloWorldController {

    String helloWorld();
    String greater(String name);
    String postGreater(JustNameDTO justNameDTO);
    String helloMe(CustomUserDetails userDetails);
}
