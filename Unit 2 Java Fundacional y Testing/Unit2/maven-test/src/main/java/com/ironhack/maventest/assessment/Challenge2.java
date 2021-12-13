package com.ironhack.maventest.assessment;

import java.util.List;
import java.util.ArrayList;

/*
List Challenge
This challenge tests your basic understanding of Lists.

Requirements
The method incrementAtIndex takes in a List of Integers numList and an integer index.

The method should return the List of Integers with the element at index index incremented by 1.

Sample Input/Output:
input [4, 5, 6], 1
output [4, 6, 6]

input [1, 1, 1, 1], 0
output [2, 1, 1, 1]

input [1, 1, 1, 1], 3
output [1, 1, 1, 2]
 */
public class Challenge2 {

    public static List<Integer> incrementAtIndex(List<Integer> numList, int index) {
        ArrayList<Integer> arrayList = new ArrayList<>(numList);
        try {
            arrayList.set(index, arrayList.get(index) + 1);
            return arrayList;
        } catch (IndexOutOfBoundsException e) {
            return numList;
        }
    }
}
