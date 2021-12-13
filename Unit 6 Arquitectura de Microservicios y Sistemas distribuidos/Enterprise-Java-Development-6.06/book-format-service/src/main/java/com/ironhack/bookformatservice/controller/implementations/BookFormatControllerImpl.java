package com.ironhack.bookformatservice.controller.implementations;

import com.ironhack.bookformatservice.controller.dto.BookFormatDTO;
import com.ironhack.bookformatservice.controller.dto.FormatDTO;
import com.ironhack.bookformatservice.controller.interfaces.BookFormatController;
import com.ironhack.bookformatservice.service.interfaces.BookFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookFormatControllerImpl implements BookFormatController {

    @Autowired
    private BookFormatService bookFormatService;

    @Override
    @PostMapping("/book-format")
    @ResponseStatus(HttpStatus.CREATED)
    public FormatDTO store(@RequestBody BookFormatDTO bookFormatDTO) {

        return bookFormatService.store(bookFormatDTO);
    }

    @Override
    @GetMapping("/book-format/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public FormatDTO getAll(@PathVariable(name = "isbn") String isbn) throws InterruptedException {

        return bookFormatService.getAll(isbn);
    }
}
