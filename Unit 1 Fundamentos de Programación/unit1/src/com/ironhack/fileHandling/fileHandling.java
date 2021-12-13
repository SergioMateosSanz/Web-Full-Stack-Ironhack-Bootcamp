package com.ironhack.fileHandling;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/*
Create a program who reads the file called oscar_age_female.csv who have this columns Index, Year, Age, Name, Movie in
format csv read it print it in a new file called result.txt in the following format.
Name: name
Year: year
Age: age
Movie: movie
 */
public class fileHandling {
    public static void main(String[] args) {

        try {
            File myFile = new File("src/com/ironhack/fileHandling/oscar_age_female.csv");
            Scanner myReader = new Scanner(myFile);
            FileWriter writer = new FileWriter("src/com/ironhack/fileHandling/result.txt");
            String header = myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] fields = data.split(",");
                writer.write("Name: " + fields[3] + "\n");
                writer.write("Year: " + fields[1] + "\n");
                writer.write("Age: " + fields[2] + "\n");
                writer.write("Movie: " + fields[4] + "\n");
                writer.write("================== \n");
            }
            myReader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }


}
