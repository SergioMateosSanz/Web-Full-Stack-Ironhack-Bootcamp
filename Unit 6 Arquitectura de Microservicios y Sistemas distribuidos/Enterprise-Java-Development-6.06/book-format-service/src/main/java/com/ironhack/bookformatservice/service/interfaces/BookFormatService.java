package com.ironhack.bookformatservice.service.interfaces;

import com.ironhack.bookformatservice.controller.dto.BookFormatDTO;
import com.ironhack.bookformatservice.controller.dto.FormatDTO;

public interface BookFormatService {

    FormatDTO store(BookFormatDTO bookFormatDTO);
    FormatDTO getAll(String isbn) throws InterruptedException;
}
