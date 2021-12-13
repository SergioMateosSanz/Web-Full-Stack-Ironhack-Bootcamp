package booksExample;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;


@RestController
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

// create your route here
@GetMapping("/books")
@ResponseStatus(HttpStatus.OK)
public List<Book> getBooksByTitleOrAuthor(@RequestParam(name ="title") Optional<String> optionalTitle, @RequestParam(name = "author") Optional<String> optionalAuthor) {
if ((optionalTitle.isPresent()) && (optionalAuthor.isPresent())) {
return List.of(bookRepository.findByTitleAndAuthor(optionalTitle.get(), optionalAuthor.get()));
} else {
if (optionalTitle.isPresent()) {
return bookRepository.findByTitle(optionalTitle.get());
} else {
if (optionalAuthor.isPresent()) {
return bookRepository.findByAuthor(optionalAuthor.get());
} else {
return bookRepository.findAll();
}
}
}
}

}