package com.ironhack.EnterpriseJavaDevelopment36.repository;

import com.ironhack.EnterpriseJavaDevelopment36.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>  {
}
