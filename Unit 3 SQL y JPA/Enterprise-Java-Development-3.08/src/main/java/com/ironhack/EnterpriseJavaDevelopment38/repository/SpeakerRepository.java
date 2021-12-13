package com.ironhack.EnterpriseJavaDevelopment38.repository;

import com.ironhack.EnterpriseJavaDevelopment38.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Integer> {
}
