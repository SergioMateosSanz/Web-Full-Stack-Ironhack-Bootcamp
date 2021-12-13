package booksExample;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

// create your route here
@GetMapping("/books")
@ResponseStatus(HttpStatus.OK)
public List<Book> getAllBooks() {
return bookRepository.findAll();
}

}

