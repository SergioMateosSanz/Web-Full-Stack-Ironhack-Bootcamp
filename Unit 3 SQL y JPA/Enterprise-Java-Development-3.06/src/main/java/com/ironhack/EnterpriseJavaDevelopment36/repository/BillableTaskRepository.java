package com.ironhack.EnterpriseJavaDevelopment36.repository;

import com.ironhack.EnterpriseJavaDevelopment36.model.BillableTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillableTaskRepository extends JpaRepository<BillableTask, String> {
}
