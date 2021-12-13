package com.ironhack.lab108;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("4.2545");
        System.out.println("=== method to return double rounded ===");
        System.out.println(transformDouble(bigDecimal));
        System.out.println("=== method to reverse BigDecimal ===");
        System.out.println(reverse(new BigDecimal("1.2345")));
        System.out.println(reverse(BigDecimal.valueOf(-45.67)));
        System.out.println("=== IntList Interface ===");
        IntArrayList list = new IntArrayList();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        System.out.println(list);
        IntVector listVector = new IntVector();
        for (int i = 1; i <= 20; i++) {
            listVector.add(i);
        }
        System.out.println(listVector);
        System.out.println("listVector position 13 is: " + listVector.get(13));
        listVector.add(21);
        System.out.println(listVector);
    }

    /**
     * Create a method that accepts a BigDecimal and returns a double of the BigDecimal number rounded to
     * the nearest hundredth. For example, 4.2545 should return 4.25
     */
    public static double transformDouble(BigDecimal bigDecimal) {
        BigDecimal aux = bigDecimal.setScale(2, RoundingMode.HALF_EVEN);
        return aux.doubleValue();
    }

    /**
     * create a method that accepts a BigDecimal, reverses the sign (if the parameter is positive, the result
     * should be negative and vice versa), rounds the number to the nearest tenth and returns the result.
     * For example, 1.2345 should return -1.2 and -45.67 should return 45.7
     */
    public static BigDecimal reverse(BigDecimal bigDecimal) {
        BigDecimal result;
        int sign = bigDecimal.signum();
        if ((sign == 1) || (sign == 0)){
            result = bigDecimal.abs();
        } else {
            result = bigDecimal.negate();
        }
        return  result.setScale(1, RoundingMode.HALF_EVEN);
    }
}
