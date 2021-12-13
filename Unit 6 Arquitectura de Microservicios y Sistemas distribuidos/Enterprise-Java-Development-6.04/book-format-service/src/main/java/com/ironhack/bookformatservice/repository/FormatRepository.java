package com.ironhack.bookformatservice.repository;

import com.ironhack.bookformatservice.model.Format;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormatRepository extends JpaRepository<Format, Short> {

    List<Format> findByName(String name);
}
