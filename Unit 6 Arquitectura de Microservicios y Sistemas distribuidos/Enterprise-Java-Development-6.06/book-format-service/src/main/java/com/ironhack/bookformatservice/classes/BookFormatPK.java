package com.ironhack.bookformatservice.classes;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BookFormatPK implements Serializable {

    private String isbn;
    private short id;

    public BookFormatPK() {
    }

    public BookFormatPK(String isbn, short id) {
        this.isbn = isbn;
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }
}
