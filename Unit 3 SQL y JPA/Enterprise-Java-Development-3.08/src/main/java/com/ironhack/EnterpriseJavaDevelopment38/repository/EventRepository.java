package com.ironhack.EnterpriseJavaDevelopment38.repository;

import com.ironhack.EnterpriseJavaDevelopment38.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
}
