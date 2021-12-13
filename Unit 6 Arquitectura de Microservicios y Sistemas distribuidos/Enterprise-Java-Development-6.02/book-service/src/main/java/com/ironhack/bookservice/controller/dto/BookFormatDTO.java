package com.ironhack.bookservice.controller.dto;

import java.util.List;

public class BookFormatDTO {

    private String isbn;
    private List<String> formatList;

    public BookFormatDTO() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getFormatList() {
        return formatList;
    }

    public void setFormatList(List<String> formatList) {
        this.formatList = formatList;
    }
}
