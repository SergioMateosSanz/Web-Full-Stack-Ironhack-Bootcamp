package com.ironhack.bookservice.controller.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BookDTO {

    @NotNull(message = "isbn must be informed")
    private String isbn;
    @NotNull(message = "title must be informed")
    private String title;
    @NotNull(message = "title must be informed")
    private String author;
    @NotNull(message = "genre must be informed")
    private String genre;
    private List<String> formatList;

    public BookDTO() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getFormatList() {
        return formatList;
    }

    public void setFormatList(List<String> formatList) {
        this.formatList = formatList;
    }
}
