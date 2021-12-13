package com.ironhack.bookservice.controller.interfaces;

import com.ironhack.bookservice.controller.dto.BookDTO;

public interface BookController {

    BookDTO store(BookDTO bookDTO);
    BookDTO getBook(String isbn);
}
