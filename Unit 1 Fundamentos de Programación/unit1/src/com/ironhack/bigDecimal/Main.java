package com.ironhack.bigDecimal;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Using the BigDecimal documentation and create two big decimals. Perform add, subtract, divide, multiply,
 * and modulus operations between them and print the results after each operation.
 * As a challenge, determine how to perform the the following operation (2.3 * x + 1.5) / (x - 0.8).
 */
public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal(188.65);
        BigDecimal bigDecimal2 = new BigDecimal(33.33);

        System.out.println("=== BIG DECIMAL ADD ===");
        BigDecimal result = bigDecimal1.add(bigDecimal2, MathContext.DECIMAL32);
        System.out.println(result);
        System.out.println("=== BIG DECIMAL SUBTRACT ===");
        result = bigDecimal1.subtract(bigDecimal2, MathContext.DECIMAL32);
        System.out.println(result);
        System.out.println("=== BIG DECIMAL DIVIDE ===");
        result = bigDecimal1.divide(bigDecimal2, MathContext.DECIMAL32);
        System.out.println(result);
        System.out.println("=== BIG DECIMAL MULTIPLY ===");
        result = bigDecimal1.multiply(bigDecimal2,MathContext.DECIMAL32);
        System.out.println(result);
        System.out.println("=== BIG DECIMAL MODULUS ===");
        result = bigDecimal1.remainder(bigDecimal2, MathContext.DECIMAL32);
        System.out.println(result);
        System.out.println("=== BIG DECIMAL operation (2.3 * x + 1.5) / (x - 0.8) ===");
        BigDecimal resultOperation = bigDecimal1.multiply(BigDecimal.valueOf(2.3));
        resultOperation = resultOperation.add(BigDecimal.valueOf(1.5));
        BigDecimal secondPart = bigDecimal1.subtract(BigDecimal.valueOf(0.8), MathContext.DECIMAL32);
        resultOperation = resultOperation.divide(secondPart, MathContext.DECIMAL32);
        System.out.println(resultOperation);
    }
}
