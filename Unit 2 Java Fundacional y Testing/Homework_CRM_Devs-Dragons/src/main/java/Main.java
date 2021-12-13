import app.App;
import app.DataEntry;
import exceptions.InvalidLeadException;
import opportunity.Opportunity;
import person.Lead;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        App application = new App();
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
                        System.out.println("Enter the command of the action you want to perform");
                        System.out.println("-- Write HELP to see a list of available commands");
                        String action = scanner.nextLine().toUpperCase(Locale.ROOT);
                        String userAction = action;
                        if (getIdOfAction(action) != -1) {
                            userAction = getAction(action);
                        }
                        switch (userAction) {
                            case "NEW LEAD":
                                DataEntry dataEntry = new DataEntry();
                                application.newLead(dataEntry.entryName(scanner), dataEntry.entryPhone(scanner),
                                        dataEntry.entryMail(scanner), dataEntry.entryCompany(scanner));
                                break;
                            case "SHOW LEADS":
                                if (showLeads(application) == null) {
                                    System.out.println("There are not Leads in application");
                                } else {
                                    printHeaderShowLeads();
                                    for (int i = 0; i < showLeads(application).size(); i++) {
                                        System.out.println(showLeads(application).get(i));
                                    }
                                }
                                break;
                            case "LOOKUP LEAD":
                                int id = getIdOfAction(action);
                                System.out.println(leadInfo(application.lookUpLead(id)));
                                break;

                            case "SHOW OPPORTUNITIES":
                                if (showOpportunities(application) == null) {
                                    System.out.println("There are not opportunities in application");
                                } else {
                                    printHeaderShowOpportunities();
                                    for (int i = 0; i < showOpportunities(application).size(); i++) {
                                        System.out.println(showOpportunities(application).get(i));
                                    }
                                }
                                break;
                            case "CONVERT":
                                id = getIdOfAction(action);
                                application.convert(application.lookUpLead(id), application, scanner);
                                break;
                            case "CLOSE-WON":
                                id = getIdOfAction(action);
                                application.closeWon(id);
                                break;
                            case "CLOSE-LOST":
                                id = getIdOfAction(action);
                                application.closeLost(id);
                                break;
                            case "HELP":
                                App.printHelp();
                                break;
                            default:
                                System.out.println("Incorrect option");
                        }
                        break;
                }
            } catch (InvalidLeadException e) {
                print(e.getMessage());
            } catch (Exception e) {
                System.out.println("Incorrect option. Please try again");
            }
        } while (option != 0);
    }

    /**
     * Method to show the menu
     */
    public static void menu() {

        print("=================================================");
        print("-  Welcome to IronHack CRM LBL Trucking Company -");
        print("=================================================");
        print("Select one option:");
        print("1: Enter a command");
        print("0: Exit");
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
     * Method to get Leads List
     *
     * @param application app.App
     * @return List<Lead>
     */
    public static List<Lead> showLeads(App application) {
        if (application.getLeads().isEmpty()) {
            return null;
        }
        return application.getLeads();
    }

    /**
     * Method to get Opportunities List
     *
     * @param application app.App
     * @return List<Opportunity>
     */
    public static List<Opportunity> showOpportunities(App application) {
        if (application.getOpportunities().isEmpty()) {
            return null;
        }
        return application.getOpportunities();
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
    public static String leadInfo(Lead lead) throws InvalidLeadException {
        if (lead == null) throw new InvalidLeadException("Lead not found");

        printHeaderLookUpLead();

        String id = String.format("%-10s", lead.getId());
        String name = String.format("%-30s", lead.getName());
        String phoneNumber = String.format("%-24s", lead.getPhoneNumber());
        String email = String.format("%-40s", lead.getEmail());
        String company = String.format("%-40s", lead.getCompanyName());
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
