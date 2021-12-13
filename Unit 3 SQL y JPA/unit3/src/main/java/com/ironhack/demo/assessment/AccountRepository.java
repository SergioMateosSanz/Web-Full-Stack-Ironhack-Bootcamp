package com.ironhack.demo.assessment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Account class
There exists and Account class of the form below:

class Account{
  private String customerName;
  private double balance;
  private Integer id;
  private Branch branch;
  private String accountType

  //getters and setters omitted for brevity
}
Requirements
In the AccountRepository interface, add methods necessary to complete each of the following:

Find an Account by customer name
Find All Accounts with a balance less than a provided number

Requirements
In the AccountRepository interface, add methods necessary to complete each of the following:

Find an Account by customer names containing the provided String
Find an Account by customer names and account type
Find All Accounts with a balance greater than a provided number, order by customer name
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<List<Account>> findByCustomerName(String name);
    List<Account> findByBalanceLessThan(double balance);

    Optional<List<Account>> findByCustomerNameContaining(String customerName);

    Optional<List<Account>> findByCustomerNameAndAccountType(String customerName, String accountType);

    List<Account> findByBalanceGreaterThanOrderByCustomerName(Double balance);
}
