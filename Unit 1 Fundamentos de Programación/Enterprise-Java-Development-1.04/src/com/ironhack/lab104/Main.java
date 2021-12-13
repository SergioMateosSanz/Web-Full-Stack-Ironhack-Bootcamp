package com.ironhack.lab104;

public class Main {
    public static void main(String[] args) {
        System.out.println("===METHOD 1===");
        //int[] integerArray = {};
        //int[] integerArray = {33};
        int[] integerArray = {-33, -2, -3, -4, -5, -6};
        System.out.println("The difference is: " + differenceBetweenOppositesNumbers(integerArray));

        System.out.println("===METHOD 2===");
        //double[] doubleArray = {};
        //double[] doubleArray = {1.33};
        //double[] doubleArray = {1.33, -4.56};
        double[] doubleArray = {-23.67, 12.00, 25.99, 0.55, -99.99};
        findSmallestAndSecondSmallest(doubleArray);

        System.out.println("===METHOD 3===");
        //System.out.println("Solution is: " + mathematicalExpression(0.00,0.00));
        System.out.println("Solution is: " + mathematicalExpression(2.44,5.11));
    }

    /**
     * Get the difference between the largest and smallest values
     * @author: Sergio Mateos Sanz
     * @param elements Array of integers
     * @return difference
     */
    public static int differenceBetweenOppositesNumbers(int[] elements) {
        if (elements.length == 0) {
            return 0;
        } else {
            int smallest = elements[0];
            int biggest = elements[0];
            for (int element : elements) {
                if (element > biggest) {
                    biggest = element;
                }
                if (element < smallest) {
                    smallest = element;
                }
            }
            return biggest - smallest;
        }
    }

    /**
     * Find and print in the console the smallest and second smallest elements
     * @author: Sergio Mateos Sanz
     * @param elements array of doubles
     */
    public static void findSmallestAndSecondSmallest(double[] elements) {
        if (elements.length == 0) {
            System.out.println("Smallest and second smallest are 0.00");
        } else {
            double smallest = elements[0];
            double secondSmallest = elements[0];
            for (int i = 1; i < elements.length; i++) {
                if (elements[i] < smallest) {
                    secondSmallest = smallest;
                    smallest = elements[i];
                }
                if (((smallest == secondSmallest) && (elements[i] > smallest)) ||
                        ((elements[i] < secondSmallest) && (elements[i] > smallest))) {
                    secondSmallest = elements[i];
                }
            }
            System.out.println("Smallest is :" + smallest);
            System.out.println("Second smallest is :" + secondSmallest);
        }
    }

    /**
     * Resolves mathematical expression sqrt(x) + sqrt(((4*y)/5)-x)
     * @author: Sergio Mateos Sanz
     * @param x double
     * @param y double
     * @return solution of mathematical expression
     */
    public static double mathematicalExpression(double x, double y) {
        return Math.sqrt((Math.sqrt(x)) + Math.sqrt(((4*y)/5) - x));
    }

}
