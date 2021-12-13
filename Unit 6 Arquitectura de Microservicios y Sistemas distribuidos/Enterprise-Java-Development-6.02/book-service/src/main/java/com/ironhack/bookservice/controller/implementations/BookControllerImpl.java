package com.ironhack.bookservice.controller.implementations;

import com.ironhack.bookservice.controller.interfaces.BookController;
import com.ironhack.bookservice.controller.dto.BookDTO;
import com.ironhack.bookservice.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookControllerImpl implements BookController {

    @Autowired
    private BookService bookService;

    @Override
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO store(@RequestBody BookDTO bookDTO) {

        return bookService.store(bookDTO);
    }

    @Override
    @GetMapping("/books/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBook(@PathVariable(name = "isbn") String isbn) {

        return bookService.getBook(isbn);
    }
}
