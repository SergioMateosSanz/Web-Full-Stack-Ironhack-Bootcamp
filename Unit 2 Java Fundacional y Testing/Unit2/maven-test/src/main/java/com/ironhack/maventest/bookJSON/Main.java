package com.ironhack.maventest.bookJSON;

import com.google.gson.Gson;

import java.util.ArrayList;

/* Create a Book class with title and pages properties
   Create an Author class with name, lastName and a Book list named publishedBooks
   Using the Gson library create an Author with at least 3 books and print it in standard output in JSON format.*/
public class Main {
    public static void main(String[] args) {

        Author author = new Author();
        System.out.println("Json representation of Object Author is ");
        System.out.println(new Gson().toJson(getObjectData(author)));
    }

    /**
     * Get the data to be inserted into the object
     **/
    public static Author getObjectData(Author author) {

        author.setName("J.R.R");
        author.setLastName("Tolkien");
        Book bookNumberOne = new Book("El señor de los Anillos: La comunidad del anillo", 550);
        Book bookNumerTwo = new Book("El señor de los Anillos: Las dos Torres", 667);
        Book bookNumberThree = new Book("El señor de los Anillos: El retorno del Rey", 681);
        ArrayList<Book> booksList = new ArrayList<>();
        booksList.add(bookNumberOne);
        booksList.add(bookNumerTwo);
        booksList.add(bookNumberThree);
        author.setPublishedBooks(booksList);

        return author;
    }
}
