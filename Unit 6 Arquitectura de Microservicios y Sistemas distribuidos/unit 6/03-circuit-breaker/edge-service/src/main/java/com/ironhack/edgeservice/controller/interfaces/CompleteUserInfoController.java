package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.controller.dto.ResponseDTO;

import java.math.BigDecimal;

public interface CompleteUserInfoController {
    ResponseDTO getCompleteUserInfo(int id, BigDecimal salary, String department);
}
