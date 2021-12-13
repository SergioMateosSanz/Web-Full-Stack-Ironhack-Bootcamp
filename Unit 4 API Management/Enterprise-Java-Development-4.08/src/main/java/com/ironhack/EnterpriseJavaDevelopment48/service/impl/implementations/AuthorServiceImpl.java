package com.ironhack.EnterpriseJavaDevelopment48.service.impl.implementations;

import com.ironhack.EnterpriseJavaDevelopment48.controller.dto.AuthorDTO;
import com.ironhack.EnterpriseJavaDevelopment48.model.Author;
import com.ironhack.EnterpriseJavaDevelopment48.model.Post;
import com.ironhack.EnterpriseJavaDevelopment48.repository.AuthorRepository;
import com.ironhack.EnterpriseJavaDevelopment48.service.impl.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public AuthorDTO store(AuthorDTO authorDTO) {

        if ((!authorRepository.findByName(authorDTO.getName()).isEmpty()) || (authorDTO.getName() == null)) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Resource exists");
        }

        Author authorDatabase = new Author();
        authorDatabase.setName(authorDTO.getName());
        authorRepository.save(authorDatabase);
        authorDTO.setId(authorDatabase.getId());
        return authorDTO;
    }

    @Override
    public void delete(int id) {

        Author databaseAuthor = authorRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Resource with Id " + id + " not found"));
        if (databaseAuthor.getPostList().isEmpty()) {
            authorRepository.delete(databaseAuthor);
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Resource with Id " + id + " can not delete");
        }
    }

    @Override
    public void update(int id, AuthorDTO authorDTO) {

        Author databaseAuthor = authorRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Resource with Id " + id + " not found"));
        databaseAuthor.setName(authorDTO.getName());
        authorRepository.save(databaseAuthor);
    }
}
