package com.Ironhack.Homework_DataLayer_DevsDragons.repository;

import com.Ironhack.Homework_DataLayer_DevsDragons.model.person.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
