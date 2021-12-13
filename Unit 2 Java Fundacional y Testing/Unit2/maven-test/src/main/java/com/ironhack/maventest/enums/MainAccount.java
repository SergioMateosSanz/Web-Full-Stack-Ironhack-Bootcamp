package com.ironhack.maventest.enums;

import java.math.BigDecimal;

public class MainAccount {
    public static void main(String[] args) {
        Account account = new Account("Pepito", "Calle principal 1", new BigDecimal(1467.55), Hold.NONE);

        System.out.println(account);
    }
}
