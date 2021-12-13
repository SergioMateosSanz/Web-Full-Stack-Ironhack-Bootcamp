package com.ironhack.proxyservice.controller.impl;

import com.ironhack.proxyservice.controller.dto.RequestDTO;
import com.ironhack.proxyservice.controller.dto.ResponseDTO;
import com.ironhack.proxyservice.controller.interfaces.UserInfoController;
import com.ironhack.proxyservice.service.interfaces.UserInfoService;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserInfoControllerImpl implements UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    private final Logger logger = LoggerFactory.getLogger(UserInfoControllerImpl.class);

    @PostMapping("/user-info/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDTO addUserInfo(@PathVariable int id, @RequestBody RequestDTO requestDTO) throws InterruptedException {
        logger.info("INIT addUserInfo");

        logger.debug("UserInfo id = " + id);

        Thread.sleep(3000);

        return userInfoService.addUserInfo(id, requestDTO);
    }
}
