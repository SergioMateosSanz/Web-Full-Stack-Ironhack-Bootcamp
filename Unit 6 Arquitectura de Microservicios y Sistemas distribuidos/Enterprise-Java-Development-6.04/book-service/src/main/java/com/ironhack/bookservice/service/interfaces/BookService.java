package com.ironhack.bookservice.service.interfaces;

import com.ironhack.bookservice.controller.dto.BookDTO;

public interface BookService {

    BookDTO store(BookDTO bookDTO);
    BookDTO getBook(String isbn);
}
