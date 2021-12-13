package com.ironhack.proxyservice.controller.interfaces;

import com.ironhack.proxyservice.controller.dto.RequestDTO;
import com.ironhack.proxyservice.controller.dto.ResponseDTO;

public interface UserInfoController {
    // POST
    // Id por parámetro
    // RequestDTO
    // ResponseDTO
    ResponseDTO addUserInfo(int id, RequestDTO requestDTO) throws InterruptedException;
}
