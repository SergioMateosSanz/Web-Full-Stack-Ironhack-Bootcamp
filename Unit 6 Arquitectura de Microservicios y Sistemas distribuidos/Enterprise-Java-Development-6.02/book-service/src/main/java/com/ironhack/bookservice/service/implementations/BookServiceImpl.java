package com.ironhack.bookservice.service.implementations;

import com.ironhack.bookservice.controller.dto.BookDTO;
import com.ironhack.bookservice.controller.dto.BookFormatDTO;
import com.ironhack.bookservice.model.Book;
import com.ironhack.bookservice.repository.BookRepository;
import com.ironhack.bookservice.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final byte ISBN_MAX_SIZE = 13;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public BookDTO store(BookDTO bookDTO) {

        if (validInputBookDTO(bookDTO)) {
            Optional<Book> optionalBook = bookRepository.findById(bookDTO.getIsbn());
            if (optionalBook.isPresent()) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Resource exists");
            }
            Book book = new Book();
            book.setIsbn(bookDTO.getIsbn());
            book.setTitle(bookDTO.getTitle());
            book.setAuthor(bookDTO.getAuthor());
            book.setGenre(bookDTO.getGenre());
            bookRepository.save(book);

            BookFormatDTO bookFormatDTO = new BookFormatDTO();
            bookFormatDTO.setIsbn(bookDTO.getIsbn());
            bookFormatDTO.setFormatList(bookDTO.getFormatList());

            RestTemplate restTemplate = new RestTemplate();
            String urlBase = discoveryClient.getInstances("book-format-service").get(0).getUri().toString();
            String url = urlBase + "/book-format";

            restTemplate.postForEntity(url, bookFormatDTO, BookFormatDTO.class);
        }
        return bookDTO;
    }

    @Override
    public BookDTO getBook(String isbn) {

        Optional<Book> optionalBook = bookRepository.findById(isbn);

        if (!optionalBook.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not exits");
        }

        BookDTO bookDTO = new BookDTO();
        bookDTO.setIsbn(optionalBook.get().getIsbn());
        bookDTO.setTitle(optionalBook.get().getTitle());
        bookDTO.setAuthor(optionalBook.get().getAuthor());
        bookDTO.setGenre(optionalBook.get().getGenre());

        RestTemplate restTemplate = new RestTemplate();
        String urlBase = discoveryClient.getInstances("book-format-service").get(0).getUri().toString();
        String url = urlBase + "/book-format/" + isbn;

        BookFormatDTO result = restTemplate.getForObject(url, BookFormatDTO.class);

        bookDTO.setFormatList(result.getFormatList());

        return bookDTO;
    }

    private boolean validInputBookDTO(BookDTO bookDTO) {

        if ((bookDTO.getIsbn() == null) || (bookDTO.getTitle() == null ) || (bookDTO.getAuthor() == null) ||
                (bookDTO.getGenre() == null) ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Unprocessed entity");
        }

        if ((bookDTO.getIsbn().equals("")) || (bookDTO.getTitle().equals("")) || (bookDTO.getAuthor().equals("")) ||
                (bookDTO.getGenre().equals("")) ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Unprocessed entity");
        }

        if (bookDTO.getIsbn().length() > ISBN_MAX_SIZE) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Unprocessed entity");
        }

        return true;
    }
}
