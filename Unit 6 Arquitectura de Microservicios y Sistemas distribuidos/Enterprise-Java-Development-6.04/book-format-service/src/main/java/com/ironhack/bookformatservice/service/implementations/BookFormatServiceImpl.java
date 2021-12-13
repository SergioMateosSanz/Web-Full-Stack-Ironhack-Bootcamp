package com.ironhack.bookformatservice.service.implementations;


import com.ironhack.bookformatservice.controller.dto.BookFormatDTO;
import com.ironhack.bookformatservice.controller.dto.FormatDTO;
import com.ironhack.bookformatservice.model.Book;
import com.ironhack.bookformatservice.model.BookFormat;
import com.ironhack.bookformatservice.model.Format;
import com.ironhack.bookformatservice.repository.BookFormatRepository;
import com.ironhack.bookformatservice.repository.BookRepository;
import com.ironhack.bookformatservice.repository.FormatRepository;
import com.ironhack.bookformatservice.service.interfaces.BookFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookFormatServiceImpl implements BookFormatService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private FormatRepository formatRepository;

    @Autowired
    private BookFormatRepository bookFormatRepository;

    @Override
    public FormatDTO store(BookFormatDTO bookFormatDTO) {

        Optional<Book> optionalBook = bookRepository.findById(bookFormatDTO.getIsbn());

        if (!optionalBook.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Book does not exits");
        }

        List<Short> idFormatList = new ArrayList<>();
        for (String format :bookFormatDTO.getFormatList()) {
            List<Format> formatList = formatRepository.findByName(format);
            if (formatList.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Format does not exits");
            }
            idFormatList.add(formatList.get(0).getId());
        }

        for (Short id : idFormatList) {
            BookFormat bookFormat = new BookFormat(bookFormatDTO.getIsbn(), id);
            bookFormatRepository.save(bookFormat);
        }

        FormatDTO formatDTO = new FormatDTO();
        formatDTO.setFormatList(bookFormatDTO.getFormatList());
        return formatDTO;
    }

    @Override
    public FormatDTO getAll(String isbn) {

        List<BookFormat> bookFormatList = bookFormatRepository.findByIsbn(isbn);

        if (bookFormatList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not exits");
        }

        List<Short> idFormatList = new ArrayList<>();
        for (BookFormat element : bookFormatList) {
            idFormatList.add(element.getId());
        }
        List<String> nameFormatList = new ArrayList<>();
        for (Short element : idFormatList) {
            nameFormatList.add(formatRepository.findById(element).get().getName());
        }

        FormatDTO formatDTO = new FormatDTO();
        formatDTO.setFormatList(nameFormatList);

        return formatDTO;
    }
}
