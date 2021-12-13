package com.ironhack.EnterpriseJavaDevelopment202.classes;

import java.util.ArrayList;

/*
Java has certain words that are considered “Java Keywords”. Keywords are reserved and cannot be used as variable names.
Employing TDD, create a method that takes in a String and returns true if the String contains any Java Keywords.
For example, break is a Java keyword. The String "Don't break my heart" should return true. The String "I love to
breakdance" should return false. You will need to use Google to find a list of all Java Keywords.
 */
public class Specification2 {

    public boolean validateJavaKeywords(String text) {
        ArrayList<String> javaKeywords = javaKeywords();
        String[] words = text.split(" ");
        for (String word : words) {
            if (javaKeywords.contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> javaKeywords() {
        ArrayList<String> javaKeywords = new ArrayList<>();
        javaKeywords.add("abstract");
        javaKeywords.add("assert");
        javaKeywords.add("boolean");
        javaKeywords.add("break");
        javaKeywords.add("byte");
        javaKeywords.add("case");
        javaKeywords.add("catch");
        javaKeywords.add("char");
        javaKeywords.add("class");
        javaKeywords.add("const");
        javaKeywords.add("continue");
        javaKeywords.add("default");
        javaKeywords.add("do");
        javaKeywords.add("double");
        javaKeywords.add("else");
        javaKeywords.add("enum");
        javaKeywords.add("extends");
        javaKeywords.add("final");
        javaKeywords.add("finally");
        javaKeywords.add("float");
        javaKeywords.add("for");
        javaKeywords.add("goto");
        javaKeywords.add("if");
        javaKeywords.add("implements");
        javaKeywords.add("import");
        javaKeywords.add("instanceof");
        javaKeywords.add("int");
        javaKeywords.add("interface");
        javaKeywords.add("long");
        javaKeywords.add("native");
        javaKeywords.add("new");
        javaKeywords.add("package");
        javaKeywords.add("private");
        javaKeywords.add("protected");
        javaKeywords.add("public");
        javaKeywords.add("return");
        javaKeywords.add("short");
        javaKeywords.add("static");
        javaKeywords.add("strictfp");
        javaKeywords.add("super");
        javaKeywords.add("switch");
        javaKeywords.add("synchronized");
        javaKeywords.add("this");
        javaKeywords.add("throw");
        javaKeywords.add("throws");
        javaKeywords.add("transient");
        javaKeywords.add("try");
        javaKeywords.add("void");
        javaKeywords.add("volatile");
        javaKeywords.add("while");
        return javaKeywords;
    }
}
