package com.Ironhack.Homework_DataLayer_DevsDragons;

import com.Ironhack.Homework_DataLayer_DevsDragons.app.App;
import com.Ironhack.Homework_DataLayer_DevsDragons.app.DataEntry;
import com.Ironhack.Homework_DataLayer_DevsDragons.enums.UserType;
import com.Ironhack.Homework_DataLayer_DevsDragons.menu.DirectorMenu;
import com.Ironhack.Homework_DataLayer_DevsDragons.menu.SalesRepresentativeMenu;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.Opportunity;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.User;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.person.Lead;
import com.Ironhack.Homework_DataLayer_DevsDragons.repository.*;
import exceptions.InvalidLeadException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static App application;

    private static DirectorMenu directorMenu;

    private static SalesRepresentativeMenu salesRepresentativeMenu;

    private static UserRepository userRepository;

    public static void init(LeadRepository leadRepository, AccountRepository accountRepository, OpportunityRepository opportunityRepository, ContactRepository contactRepository, UserRepository userRepository) {
        application = new App(leadRepository, accountRepository, opportunityRepository, contactRepository, userRepository);
        directorMenu = new DirectorMenu(leadRepository, accountRepository, opportunityRepository, contactRepository, userRepository);
        salesRepresentativeMenu = new SalesRepresentativeMenu(leadRepository, accountRepository, opportunityRepository, contactRepository, userRepository);
    }


    /**
     * Method to show the menu
     */
    public static void menu() {

        print("=================================================");
        print("-  Welcome to IronHack CRM LBL Trucking Company -");
        print("=================================================");
        print("Select one option:");
        print("1: Login");
        print("0: Exit");
    }

    public static void login() {

        print("=================================================");
        print("-  For test use 'DirectorTest' and password '123456' ");
        print("-  or 'SalesTest' and password '123456' -            ");
        print("=================================================");
        print("Enter username or 'Exit' to cancel:");
    }

    public static void mainExecution() {

        application.UsertestCreation();
        Optional<User> optionalUser;

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int option = -1;
        do {
            menu();
            try {
                option = Integer.parseInt(bufferedReader.readLine());
                if (option < 0 || option > 1) throw new RuntimeException("Incorrect option. Please try again");

                switch (option) {
                    case 0:
                        System.out.println("Thanks and see you soon");
                        break;
                    case 1:
                        login();
                        String username = scanner.nextLine().toUpperCase(Locale.ROOT);
                        optionalUser = application.findUser(username);

                        if (!optionalUser.isPresent()) {
                            System.out.println("Invalid user");
                        } else {
                            User user = optionalUser.get();
                            System.out.println("Welcome " + user.getName() + ". Enter password (case sensitive)");
                            String password = scanner.nextLine();

                            if (!user.getPasswordAccess().equals(password)) {
                                System.out.println("Invalid password");
                            } else {
                                System.out.println(user.getUserType().toString());
                                if (user.getUserType().toString().equals("DIRECTOR")) {
                                    directorMenu.menu(user);
                                } else {
                                    salesRepresentativeMenu.menu(user);
                                }
                            }
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect option. Please try again");
            }
        } while (option != 0);
    }


    /**
     * imple method that writes to the standard output stream
     *
     * @param output String to print
     */
    public static void print(String output) {
        System.out.println(output);
    }

    /**
     * method to get the "id Lead/Opportunity" from input String in console
     *
     * @param string String string
     * @return int
     */
    public static int getIdOfAction(String string) {
        int id = -1;
        String[] action = string.split(" ");
        String lastString = action[action.length - 1];
        boolean number = true;
        char[] characters = lastString.toCharArray();
        for (char character : characters) {
            if (!Character.isDigit(character)) {
                number = false;
            }
        }
        if (number) {
            id = Integer.parseInt(action[action.length - 1]);
        }
        return id;
    }

    /**
     * method to separate the text of the expected action from input String in console if it has an "Id"
     *
     * @param string String string
     * @return string userAction
     */
    public static String getAction(String string) {

        String userAction = "";
        String[] stringArray = string.split(" ");
        String[] action = new String[stringArray.length - 1];

        System.arraycopy(stringArray, 0, action, 0, action.length);

        for (String s : action) {
            userAction = userAction + s + " ";
        }
        return userAction.trim();
    }

    /**
     * Method to print a specific Lead's details
     * Similar to toString() but with more information
     *
     * @param lead
     * @return String Lead's information
     */
    public static String leadInfo(Optional<Lead> lead) throws InvalidLeadException {
        if (lead.isEmpty()) throw new InvalidLeadException("Lead not found");

        printHeaderLookUpLead();

        String id = String.format("%-10s", lead.get().getId());
        String name = String.format("%-30s", lead.get().getName());
        String phoneNumber = String.format("%-24s", lead.get().getPhoneNumber());
        String email = String.format("%-40s", lead.get().getEmail());
        String company = String.format("%-40s", lead.get().getCompanyName());
        return (id + name + phoneNumber + email + company).trim();

    }

    /**
     * Method to print header when show a List of Leads
     */

    public static void printHeaderShowLeads() {

        String id = String.format("%-10s", "ID");
        String name = String.format("%-40s", "NAME");
        System.out.println(id + name);
    }

    /**
     * Method to print header when show a List of Opportunities
     */
    public static void printHeaderShowOpportunities() {

        String idTitle = String.format("%-10s", "ID");
        String productTitle = String.format("%-15s", "PRODUCT");
        String quantityTitle = String.format("%-10s", "QUANTITY");
        String nameTitle = String.format("%-30s", "NAME");
        String phoneTitle = String.format("%-24s", "PHONE");
        String emailTitle = String.format("%-40s", "EMAIL");
        String companyTitle = String.format("%-40s", "COMPANY");
        String statusTitle = String.format("%-40s", "STATUS");
        System.out.println((idTitle + productTitle +
                quantityTitle + nameTitle + phoneTitle + emailTitle +
                companyTitle + statusTitle).trim());
    }

    /**
     * Method to print header when show a Lead
     */
    public static void printHeaderLookUpLead() {

        String idTitle = String.format("%-10s", "ID");
        String nameTitle = String.format("%-30s", "NAME");
        String phoneTitle = String.format("%-24s", "PHONE");
        String emailTitle = String.format("%-40s", "EMAIL");
        String companyTitle = String.format("%-40s", "COMPANY");
        System.out.println((idTitle + nameTitle + phoneTitle + emailTitle + companyTitle).trim());
    }
}
