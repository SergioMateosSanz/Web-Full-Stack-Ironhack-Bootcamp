package com.ironhack.EnterpriseJavaDevelopment48.controller.interfaces;

import com.ironhack.EnterpriseJavaDevelopment48.controller.dto.PostDTO;

public interface PostController {

    PostDTO getPostAndAuthor(int id);
    PostDTO store(PostDTO postDTO);
    void delete(int id);
    void update(int id, PostDTO postDTO);
}
