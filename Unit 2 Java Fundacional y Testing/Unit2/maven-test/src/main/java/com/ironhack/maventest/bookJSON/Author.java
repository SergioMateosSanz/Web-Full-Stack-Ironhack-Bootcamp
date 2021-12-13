package com.ironhack.maventest.bookJSON;

import java.util.ArrayList;

public class Author {
    private String name;
    private String lastName;
    private ArrayList<Book> publishedBooks;

    public Author(String name, String lastName, ArrayList<Book> publishedBooks) {
        this.name = name;
        this.lastName = lastName;
        this.publishedBooks = publishedBooks;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(ArrayList<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", publishedBooks=" + publishedBooks +
                '}';
    }
}
