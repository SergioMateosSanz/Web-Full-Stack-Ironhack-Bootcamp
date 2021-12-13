package com.ironhack.EnterpriseJavaDevelopment36.repository;

import com.ironhack.EnterpriseJavaDevelopment36.model.InternalTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalTaskRepository extends JpaRepository<InternalTask, String> {
}
