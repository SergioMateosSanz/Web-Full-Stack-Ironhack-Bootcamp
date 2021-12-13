package booksExample;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;
import javax.validation.Valid;


@RestController
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

// create your route here
@PostMapping("/books")
@ResponseStatus(HttpStatus.CREATED)
public Book store(@RequestBody @Valid Book book) {
return bookRepository.save(book);
}
}