package com.ironhack.bookservice.client;

import com.ironhack.bookservice.controller.dto.BookFormatDTO;
import com.ironhack.bookservice.controller.dto.FormatDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("book-format-service")
public interface BookFormatClient {

    @PostMapping("/book-format")
    FormatDTO store(@RequestBody BookFormatDTO bookFormatDTO);

    @GetMapping("/book-format/{isbn}")
    FormatDTO getAll(@PathVariable(name = "isbn") String isbn);
}
