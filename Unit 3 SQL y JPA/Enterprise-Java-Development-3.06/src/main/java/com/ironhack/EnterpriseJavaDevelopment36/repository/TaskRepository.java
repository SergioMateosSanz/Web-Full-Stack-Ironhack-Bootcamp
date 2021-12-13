package com.ironhack.EnterpriseJavaDevelopment36.repository;

import com.ironhack.EnterpriseJavaDevelopment36.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
}
