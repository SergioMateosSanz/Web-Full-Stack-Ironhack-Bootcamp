package com.ironhack.bookformatservice.controller.interfaces;

import com.ironhack.bookformatservice.controller.dto.BookFormatDTO;
import com.ironhack.bookformatservice.controller.dto.FormatDTO;

public interface BookFormatController {

    FormatDTO store(BookFormatDTO bookFormatDTO);
    FormatDTO getAll(String isbn) throws InterruptedException;
}
