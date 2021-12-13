package com.ironhack.assessment.challenge1;

/**
 * Requirements
 * The method balancer takes in an int array numList and an a int sum.
 * <p>
 * The method should validate if sum is equals to the sum of all array elements if is lower you should iterate
 * over the array, find the smallest element of the array and sum +1 on this position. This process should be made
 * until the sum of all elements of the array is equals or greater to sum.
 * <p>
 * Sample Input/Output:
 * input [4, 1, 3, 2, 5], 52
 * output [11, 11, 10, 10, 10]
 * <p>
 * input [4, 1, 3, 2, 5], 25
 * output [5, 5, 5, 5, 5]
 * <p>
 * input [4, 1, 3, 2, 5], 5
 * output [4, 1, 3, 2, 5]
 */
public class Solution {
    public static void main(String[] args) {
        int[] input0 = {4, 1, 3, 2, 5};
        int[] result = balancer(input0, 52);
        for (int element : result) {
            System.out.println(element);
        }
    }

    public static int[] balancer(int[] numList, int sum) {
        while (addArray(numList) < sum) {
            numList[findSmallest(numList)] += 1;
        }
        return numList;
    }

    public static int findSmallest(int[] numList) {
        int smallest = 0;
        for (int i = 0; i < numList.length; i++) {
            if (numList[i] < numList[smallest]) {
                smallest = i;
            }
        }
        return smallest;
    }

    public static int addArray(int[] numList) {
        int sumatory = 0;
        for (int elem : numList) {
            sumatory = sumatory + elem;
        }
        return sumatory;
    }
}
