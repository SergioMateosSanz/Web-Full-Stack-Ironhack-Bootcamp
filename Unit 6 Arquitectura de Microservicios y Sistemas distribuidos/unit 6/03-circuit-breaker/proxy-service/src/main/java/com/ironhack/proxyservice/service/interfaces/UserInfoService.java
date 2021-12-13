package com.ironhack.proxyservice.service.interfaces;

import com.ironhack.proxyservice.controller.dto.RequestDTO;
import com.ironhack.proxyservice.controller.dto.ResponseDTO;

public interface UserInfoService {
    ResponseDTO addUserInfo(int id, RequestDTO requestDTO);
}

