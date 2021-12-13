package com.ironhack.EnterpriseJavaDevelopment38.repository;

import com.ironhack.EnterpriseJavaDevelopment38.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
}
