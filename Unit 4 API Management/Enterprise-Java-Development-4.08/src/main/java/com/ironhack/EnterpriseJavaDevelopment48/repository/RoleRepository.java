package com.ironhack.EnterpriseJavaDevelopment48.repository;

import com.ironhack.EnterpriseJavaDevelopment48.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
