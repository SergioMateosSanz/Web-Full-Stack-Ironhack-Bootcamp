package com.ironhack.bookformatservice.model;

import com.ironhack.bookformatservice.classes.BookFormatPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class BookFormat {

    @EmbeddedId
    private BookFormatPK bookFormatPK;

    public BookFormat() {
    }

    public BookFormat(String isbn, short id) {
        super();
        bookFormatPK = new BookFormatPK(isbn, id);
    }

    public String getIsbn() {
        return bookFormatPK.getIsbn();
    }

    public void setIsbn(String isbn) {
        bookFormatPK.setIsbn(isbn);
    }

    public short getId() {
        return bookFormatPK.getId();
    }

    public void setId(short id) {
        bookFormatPK.setId(id);
    }
}
