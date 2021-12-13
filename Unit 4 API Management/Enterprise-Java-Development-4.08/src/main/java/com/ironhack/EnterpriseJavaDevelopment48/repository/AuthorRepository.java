package com.ironhack.EnterpriseJavaDevelopment48.repository;

import com.ironhack.EnterpriseJavaDevelopment48.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByName(String name);
}
