package com.ironhack.bookformatservice.repository;

import com.ironhack.bookformatservice.classes.BookFormatPK;
import com.ironhack.bookformatservice.model.BookFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookFormatRepository extends JpaRepository<BookFormat, BookFormatPK> {

    @Query("SELECT b FROM BookFormat AS b WHERE isbn = :isbn")
    List<BookFormat> findByIsbn(@Param("isbn") String isbn);
}
