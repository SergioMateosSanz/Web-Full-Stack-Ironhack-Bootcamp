package com.ironhack.EnterpriseJavaDevelopment48.service.impl.interfaces;

import com.ironhack.EnterpriseJavaDevelopment48.controller.dto.AuthorDTO;

public interface AuthorService {

    AuthorDTO store(AuthorDTO authorDTO);
    void delete(int id);
    void update(int id, AuthorDTO authorDTO);
}
