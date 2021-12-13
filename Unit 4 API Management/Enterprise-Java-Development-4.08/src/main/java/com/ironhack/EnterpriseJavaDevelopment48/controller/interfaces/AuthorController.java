package com.ironhack.EnterpriseJavaDevelopment48.controller.interfaces;

import com.ironhack.EnterpriseJavaDevelopment48.controller.dto.AuthorDTO;

public interface AuthorController {

    AuthorDTO store(AuthorDTO authorDTO);
    void delete(int id);
    void update(int id, AuthorDTO authorDTO);
}
