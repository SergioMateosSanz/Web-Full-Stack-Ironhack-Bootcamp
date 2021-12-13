package com.ironhack.EnterpriseJavaDevelopment34.repository;

import com.ironhack.EnterpriseJavaDevelopment34.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    Customer customerOne;
    Customer customerTwo;
    Customer customerThree;
    Customer customerFour;
    Customer customerFive;

    @BeforeEach
    void setUp() {
        customerOne = new Customer("Customer One", "Gold", 12345);
        customerTwo = new Customer("Customer Two", "Gold", 467);
        customerThree = new Customer("Customer Three", "Silver", 8796);
        customerFour = new Customer("Pepe", "Silver", 7657567);
        customerFive = new Customer("Pepe", "", 98);
        customerRepository.save(customerOne);
        customerRepository.save(customerTwo);
        customerRepository.save(customerThree);
        customerRepository.save(customerFour);
        customerRepository.save(customerFive);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void findByName_returnCustomerList_UniqueCustomerFound() {
        List<Customer> customerList = customerRepository.findByName("Customer One");
        assertEquals(1, customerList.size());
        assertEquals(customerList.get(0), customerOne);
    }

    @Test
    void findByName_returnCustomerList_MoreThanOneCustomerFound() {
        List<Customer> customerList = customerRepository.findByName("Pepe");
        assertEquals(2, customerList.size());
        assertEquals(customerList.get(0), customerFour);
        assertEquals(customerList.get(1), customerFive);
    }

    @Test
    void findByName_returnEmptyCustomerList_CustomerNotFound() {
        List<Customer> customerList = customerRepository.findByName("Juanito");
        assertEquals(0, customerList.size());
    }

    @Test
    void findByStatus_returnCustomerList_UniqueCustomerFound() {
        List<Customer> customerList = customerRepository.findByStatus("");
        assertEquals(1, customerList.size());
        assertEquals(customerList.get(0), customerFive);
    }

    @Test
    void findByStatus_returnCustomerList_MoreThanOneCustomerFound() {
        List<Customer> customerList = customerRepository.findByStatus("Gold");
        assertEquals(2, customerList.size());
        assertEquals(customerList.get(0), customerOne);
        assertEquals(customerList.get(1), customerTwo);
    }

    @Test
    void findByStatus_returnEmptyCustomerList_CustomerNotFound() {
        List<Customer> customerList = customerRepository.findByStatus("LOLO");
        assertEquals(0, customerList.size());
    }
}