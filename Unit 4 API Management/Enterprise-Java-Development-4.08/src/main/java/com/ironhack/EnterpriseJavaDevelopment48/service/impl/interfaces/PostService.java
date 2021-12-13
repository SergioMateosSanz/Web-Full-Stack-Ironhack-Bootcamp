package com.ironhack.EnterpriseJavaDevelopment48.service.impl.interfaces;

import com.ironhack.EnterpriseJavaDevelopment48.controller.dto.PostDTO;

public interface PostService {

    PostDTO getById(int id);
    PostDTO store(PostDTO postDTO);
    void delete(int id);
    void update(int id, PostDTO postDTO);
}
