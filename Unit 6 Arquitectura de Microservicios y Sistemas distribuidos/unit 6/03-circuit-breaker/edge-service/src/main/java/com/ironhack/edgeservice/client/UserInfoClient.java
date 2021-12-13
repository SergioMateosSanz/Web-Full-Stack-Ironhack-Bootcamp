package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.RequestDTO;
import com.ironhack.edgeservice.controller.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("proxy-service")
public interface UserInfoClient {

    @PostMapping("/user-info/{id}")
    ResponseDTO addUserInfo(@PathVariable int id, @RequestBody RequestDTO requestDTO);
}
