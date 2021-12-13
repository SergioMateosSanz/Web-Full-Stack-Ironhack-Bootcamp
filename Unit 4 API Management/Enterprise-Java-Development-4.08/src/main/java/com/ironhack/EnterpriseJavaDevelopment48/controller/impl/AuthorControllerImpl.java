package com.ironhack.EnterpriseJavaDevelopment48.controller.impl;

import com.ironhack.EnterpriseJavaDevelopment48.controller.dto.AuthorDTO;
import com.ironhack.EnterpriseJavaDevelopment48.controller.interfaces.AuthorController;
import com.ironhack.EnterpriseJavaDevelopment48.service.impl.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthorControllerImpl implements AuthorController {

    @Autowired
    AuthorService authorService;

    @Override
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO store(@RequestBody @Valid AuthorDTO authorDTO) {

        return authorService.store(authorDTO);
    }

    @Override
    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") int id) {

        authorService.delete(id);
    }

    @Override
    @PutMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable(name = "id") int id, @RequestBody @Valid AuthorDTO authorDTO) {

        authorService.update(id, authorDTO);
    }
}
