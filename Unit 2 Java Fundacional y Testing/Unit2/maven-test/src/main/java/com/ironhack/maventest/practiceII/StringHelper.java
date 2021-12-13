package com.ironhack.maventest.practiceII;

public class StringHelper {

    public String reverse(String input) {
        if (input.isEmpty()) return null;
        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public String encoder(String input) {
        if (input.isEmpty()) return null;
        char[] result = input.toCharArray();
        int j = 1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                result[i] = (char)(j+'0');
                j++;
            }
            if (input.charAt(i) == 'e') {
                result[i] = (char)(j+'0');
                j++;
            }
            if (input.charAt(i) == 'i') {
                result[i] = (char)(j+'0');
                j++;
            }
            if (input.charAt(i) == 'o') {
                result[i] = (char)(j+'0');
                j++;
            }
            if (input.charAt(i) == 'u') {
                result[i] = (char)(j+'0');
                j++;
            }
        }
        String solution = new String(result);
        return solution;
    }
}
