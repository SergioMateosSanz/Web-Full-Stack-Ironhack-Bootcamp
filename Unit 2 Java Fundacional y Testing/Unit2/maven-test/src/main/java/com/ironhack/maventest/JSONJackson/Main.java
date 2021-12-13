package com.ironhack.maventest.JSONJackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Invoice invoice = objectMapper.readValue(new File("src/main/resources/jsonFile.json"),
                    Invoice.class);
            System.out.println("=== INVOICE OBJECT ===");
            System.out.println(invoice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }

    }

}
