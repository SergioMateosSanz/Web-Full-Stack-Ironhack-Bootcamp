package com.ironhack.maventest.assessment;

import java.util.Map;
import java.util.HashMap;

/*
Map Challenge
This challenge is designed to test your fundamental understanding of Maps.

Requirements
The incrementAtKey takes in a Map with String keys and Integer values and a String key.

The method should return the map with the Integer value associated with the key incremented by 1.

Sample Input/Output:
input {"a" : 1, "b": 2, "c": 3}, "a"
output{"a" : 2, "b": 2, "c": 3}

input {"a" : 1, "b": 2, "c": 3}, "b"
output{"a" : 1, "b": 3, "c": 3}
 */
public class Challenge1 {

    public static Map<String, Integer> incrementAtKey(Map<String, Integer> map, String key) {
        HashMap<String, Integer> hashMap = new HashMap<>(map);
        if (hashMap.get(key) == null) {
            return map;
        } else {
            hashMap.put(key, hashMap.get(key) + 1);
            return hashMap;
        }
    }
}
