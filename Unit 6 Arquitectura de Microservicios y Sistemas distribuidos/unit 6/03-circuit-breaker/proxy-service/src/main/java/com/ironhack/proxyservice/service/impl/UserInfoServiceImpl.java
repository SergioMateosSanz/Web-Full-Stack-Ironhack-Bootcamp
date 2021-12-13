package com.ironhack.proxyservice.service.impl;

import com.ironhack.proxyservice.controller.dto.RequestDTO;
import com.ironhack.proxyservice.controller.dto.ResponseDTO;
import com.ironhack.proxyservice.model.UserInfo;
import com.ironhack.proxyservice.repository.UserInfoRepository;
import com.ironhack.proxyservice.service.interfaces.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;


    public ResponseDTO addUserInfo(int id, RequestDTO requestDTO) {
        UserInfo userInfo = userInfoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found :C"));

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setAge(userInfo.getAge());
        responseDTO.setName(userInfo.getName());
        responseDTO.setDepartment(requestDTO.getDepartment());
        responseDTO.setSalary(requestDTO.getSalary());
        responseDTO.setId(id);

        return responseDTO;
    }
}
