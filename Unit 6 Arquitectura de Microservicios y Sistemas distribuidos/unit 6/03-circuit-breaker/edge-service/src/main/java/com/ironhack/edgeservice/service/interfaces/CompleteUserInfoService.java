package com.ironhack.edgeservice.service.interfaces;

import com.ironhack.edgeservice.controller.dto.ResponseDTO;

import java.math.BigDecimal;

public interface CompleteUserInfoService {
    ResponseDTO getCompleteUserInfo(int id, BigDecimal salary, String department);
}
