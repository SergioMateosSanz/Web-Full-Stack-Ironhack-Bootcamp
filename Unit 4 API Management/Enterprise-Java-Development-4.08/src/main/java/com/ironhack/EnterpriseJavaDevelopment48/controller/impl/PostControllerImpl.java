package com.ironhack.EnterpriseJavaDevelopment48.controller.impl;

import com.ironhack.EnterpriseJavaDevelopment48.controller.dto.PostDTO;
import com.ironhack.EnterpriseJavaDevelopment48.controller.interfaces.PostController;
import com.ironhack.EnterpriseJavaDevelopment48.service.impl.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PostControllerImpl implements PostController {

    @Autowired
    PostService postService;

    @Override
    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO getPostAndAuthor(@PathVariable(name = "id") int id) {

        return postService.getById(id);
    }

    @Override
    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public PostDTO store(@RequestBody @Valid PostDTO postDTO) {

        return postService.store(postDTO);
    }

    @Override
    @DeleteMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") int id) {

        postService.delete(id);
    }

    @Override
    @PatchMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable(name = "id") int id, @RequestBody PostDTO postDTO) {

        postService.update(id, postDTO);
    }
}
