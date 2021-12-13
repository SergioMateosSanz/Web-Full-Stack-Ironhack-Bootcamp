package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.UserInfoClient;
import com.ironhack.edgeservice.controller.dto.RequestDTO;
import com.ironhack.edgeservice.controller.dto.ResponseDTO;
import com.ironhack.edgeservice.service.interfaces.CompleteUserInfoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CompleteUserInfoServiceImpl implements CompleteUserInfoService {

    @Autowired
    private UserInfoClient userInfoClient;

    private final Logger logger = LoggerFactory.getLogger(CompleteUserInfoServiceImpl.class);

    @CircuitBreaker(name = "getCompleteUserInfo", fallbackMethod = "getCompleteUserInfoFallback")
    public ResponseDTO getCompleteUserInfo(int id, BigDecimal salary, String department) {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setDepartment(department);
        requestDTO.setSalary(salary);
        ResponseDTO responseDTO = userInfoClient.addUserInfo(id, requestDTO);

        return responseDTO;
    }

    public ResponseDTO getCompleteUserInfoFallback(int id, BigDecimal salary, String department, Exception e) {
        // Show error message
        logger.error(e.getMessage());

        // Build dummy response
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setAge(99);
        responseDTO.setDepartment("Sales");
        responseDTO.setName("Pepe (cacheado)");
        responseDTO.setSalary(new BigDecimal("10000"));
        responseDTO.setId(0);
        return responseDTO;
    }
}
