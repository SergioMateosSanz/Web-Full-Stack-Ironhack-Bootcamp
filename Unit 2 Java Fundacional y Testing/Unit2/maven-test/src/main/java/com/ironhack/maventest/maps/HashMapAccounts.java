package com.ironhack.maventest.maps;

import com.ironhack.maventest.enums.Account;
import com.ironhack.maventest.enums.Hold;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class HashMapAccounts {
    public static void main(String[] args) {

        Map<Long, Account> hashmapsAccounts = new HashMap<>();
        hashmapsAccounts.put(12345678L, new Account("Pepe", "calle arriba",
                new BigDecimal("123.78"), Hold.NONE));
        hashmapsAccounts.put(87654321L, new Account("María", "calle arriba",
                new BigDecimal("1423.78"), Hold.FRAUD));
        hashmapsAccounts.put(2345678L, new Account("Gustavo", "calle arriba",
                new BigDecimal("123.78"), Hold.NONE));

        hashmapsAccounts.forEach((K, V) -> System.out.println("Dni: " + K + " name: " + V.getName()));
    }
}
