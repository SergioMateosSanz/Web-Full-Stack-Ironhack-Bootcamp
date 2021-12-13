package com.ironhack.maventest.JSONExample;

import com.google.gson.Gson;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
            File myFile = new File("src/main/resources/jsonFile.json");
            Scanner myReader = new Scanner(myFile);
            String text = "";
            while (myReader.hasNextLine()) {
                text = text.concat(myReader.nextLine());
            }
            myReader.close();
            System.out.println("=== FILE READING ===");
            System.out.println(text);
            Invoice myInvoice = gson.fromJson(text, Invoice.class);
            System.out.println("=== INVOICE OBJECT ===");
            System.out.println(myInvoice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }

    }

}
