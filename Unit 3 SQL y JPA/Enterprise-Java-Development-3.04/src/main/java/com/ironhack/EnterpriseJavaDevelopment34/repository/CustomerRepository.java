package com.ironhack.EnterpriseJavaDevelopment34.repository;

import com.ironhack.EnterpriseJavaDevelopment34.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Short> {

    List<Customer> findByName(String name);
    List<Customer> findByStatus(String status);
}
