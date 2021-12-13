Using Eureka and Rest Templates complete the following:

1. Book Look Up:

* A simple BookService that stores Books by ISBN and includes title, author, and genre
*A simple BookFormatService that stores Books by ISBN and includes all formats in which the Book is available (hardcover, paperback, electronic, and/or audio).

Both services should have standard GET and POST routes. The Book service should return a DTO with ISBN, title, author, genre, and a list of available formats. The formats must be retrieved from the BookFormatService.
