package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.dto.ResponseDTO;
import com.ironhack.edgeservice.controller.interfaces.CompleteUserInfoController;
import com.ironhack.edgeservice.service.interfaces.CompleteUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CompleteUserInfoControllerImpl implements CompleteUserInfoController {

    @Autowired
    private CompleteUserInfoService completeUserInfoService;

    @GetMapping("/complete-user-info")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getCompleteUserInfo(@RequestParam int id, @RequestParam BigDecimal salary, @RequestParam String department) {
        return completeUserInfoService.getCompleteUserInfo(id, salary, department);
    }
}