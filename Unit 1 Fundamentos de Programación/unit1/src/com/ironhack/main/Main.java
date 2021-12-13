package com.ironhack.main;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!!");
        System.out.println("=== STRING METHODS ====");
        System.out.println(productFormatter(" prod uct Name ", "20210610"));
        System.out.println("=== LOOPS FIRST ====");
        int[] elements = {5, 4, 3, 2, 1};
        multiplied(elements);
        for (int element : elements) {
            System.out.println(element);
        }
        System.out.println("=== LOOPS SECOND ===");
        int[] elementsInvert = new int[elements.length];
        invert(elements, elementsInvert);
        for (int elementInvert : elementsInvert) {
            System.out.println(elementInvert);
        }
    }

    /*
       Create a method named productFormatter that receives a String name productName and a String date as parameters.
       This method should return the productName trimmed, change spaces by _ and append the date at the end of the string.
       The result must be given in uppercase.
     */
    public static String productFormatter(String productName, String date) {
        return productName.trim().replaceAll(" ", "_").concat("_" + date).toUpperCase();
    }

    /*
   Create a method iterate over an Array of integer and update each position of this array by multiplying that
   value by the value of the next position. The last position must be multiplied by the first position of the array
    */
    public static void multiplied(int[] elements) {
        int i = 0;
        int j = elements[0];
        while (i < elements.length) {
            if (i == (elements.length - 1)) {
                elements[i] = elements[i] * j;
            } else {
                elements[i] = elements[i] * elements[i + 1];
            }
            i++;
        }
    }

    /*
    Create a method to invert an array
    */
    public static void invert(int[] elements, int[] result) {
        int i = elements.length;
        while (i > 0) {
            result[i - 1] = elements[elements.length - i];
            i--;
        }
    }
}
