package booksExample;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;


@RestController
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

// create your route here
@GetMapping("/books/{isbn}")
@ResponseStatus(HttpStatus.OK)
public Book getBook(@PathVariable(name = "isbn") Integer bookIsbn) {
return bookRepository.findByIsbn(bookIsbn);
}

}