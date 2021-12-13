package com.Ironhack.Homework_DataLayer_DevsDragons.menu;

import com.Ironhack.Homework_DataLayer_DevsDragons.Main;
import com.Ironhack.Homework_DataLayer_DevsDragons.app.App;
import com.Ironhack.Homework_DataLayer_DevsDragons.app.DataEntry;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.User;
import com.Ironhack.Homework_DataLayer_DevsDragons.repository.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static com.Ironhack.Homework_DataLayer_DevsDragons.Main.print;

public class DirectorMenu {

    private static LeadRepository leadRepository;

    private static AccountRepository accountRepository;

    private static OpportunityRepository opportunityRepository;

    private static ContactRepository contactRepository;

    private static UserRepository userRepository;

    public DirectorMenu(LeadRepository leadRepository, AccountRepository accountRepository, OpportunityRepository opportunityRepository, ContactRepository contactRepository, UserRepository userRepository) {
        DirectorMenu.leadRepository = leadRepository;
        DirectorMenu.accountRepository = accountRepository;
        DirectorMenu.opportunityRepository = opportunityRepository;
        DirectorMenu.contactRepository = contactRepository;
        DirectorMenu.userRepository = userRepository;
    }

    private static App application;

    /**
     * Method to print help
     */
    public static void helpDirectorMenu() {
        print("------------------------        H E L P       ----------------------------------");
        print("'New Sales' to add a sale representative");
        print("'Show Sales' to view all sales representatives");
        print("'Consult Reporting' to view all existing reports");
    }

    public void menu(User user) {

        application = new App(leadRepository, accountRepository, opportunityRepository, contactRepository, userRepository);

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String action;
        boolean exit = false;
        do {
            print("");
            print("================================================================================");
            print("                              - Director's Menu -                               ");
            print("================================================================================");
            print("Enter a command or 'Exit' to exit (input help to show available commands):");
            try {
                action = bufferedReader.readLine().toUpperCase(Locale.ROOT);
                switch (action) {
                    case "EXIT":
                        exit = true;
                        break;
                    case "NEW SALES":
                        DataEntry dataEntry = new DataEntry();
                        application.newSales(dataEntry.entryName(scanner), dataEntry.entryPassword(scanner),new Date(), new Date(0L), user.getName(), user.getName());
                        System.out.println("New sales added");
                        break;
                    case "SHOW SALES":
                        if (application.showSales() == null) {
                            System.out.println("There are not Sales Representatives in application");
                        } else {
                            printHeaderShowSales();
                            for (int i = 0; i < application.showSales().size(); i++) {
                                System.out.println(application.showSales().get(i).getId() + "       " + application.showSales().get(i).getName());
                            }
                        }
                        break;
                    case "CONSULT REPORTING":
                        reportingExecution();
                        break;
                    case "HELP":
                        helpDirectorMenu();
                        break;
                    default:
                        System.out.println("Incorrect option");
                }

            } catch (Exception e) {
                System.out.println("Incorrect option. Please try again");
            }
        } while (!exit);
    }

    /**
     * Method to print help report options
     */
    public static void helpReportingMenu() {
        print("------------------------        H E L P       ----------------------------------");
        print("  By SalesRep:");
        print("   - Report Lead by SalesRep");
        print("   - Report Opportunity by SalesRep");
        print("   - Report CLOSED-WON by SalesRep");
        print("   - Report CLOSED-LOST by SalesRep");
        print("   - Report OPEN by SalesRep");
        print("  By Product:");
        print("   - Report Opportunity by Product");
        print("   - Report CLOSED-WON by Product");
        print("   - Report CLOSED-LOST by Product");
        print("   - Report OPEN by Product");
        print("  By Country:");
        print("   - Report Opportunity by Country");
        print("   - Report CLOSED-WON by Country");
        print("   - Report CLOSED-LOST by Country");
        print("   - Report OPEN by Country");
        print("  By City:");
        print("   - Report Opportunity by City");
        print("   - Report CLOSED-WON by City");
        print("   - Report CLOSED-LOST by City");
        print("   - Report OPEN by City");
        print("  By Industry:");
        print("   - Report Opportunity by Industry");
        print("   - Report CLOSED-WON by Industry");
        print("   - Report CLOSED-LOST by Industry");
        print("   - Report OPEN by Industry");
        print("  By EmployeeCount:");
        print("   - Mean EmployeeCount");
        print("   - Median EmployeeCount");
        print("   - Max EmployeeCount");
        print("   - Min EmployeeCount");
        print("  By Quantity:");
        print("   - Mean Quantity");
        print("   - Median Quantity");
        print("   - Max Quantity");
        print("   - Min Quantity");
        print("  By Opportunity:");
        print("   - Mean Opps per Account");
        print("   - Median Opps per Account");
        print("   - Max Opps per Account");
        print("   - Min Opps per Account");
    }

    /**
     * New Queries Execution
     */
    public static void reportingExecution() {
        print("=================================================");
        print("-               Reporting Menu                  -");
        print("-    Count, Mean, Median, MAX and MIN queries   -");
        print("=================================================");

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String userAction;

        boolean exit = false;
        do {
            print("");
            print("-               Reporting Menu                                          -");
            print("-------------------------------------------------------------------------");
            print("Enter a command or 'Exit' to exit (input help to show available commands):");

            userAction = scanner.nextLine().toUpperCase(Locale.ROOT);

            try {
                switch (userAction) {
                    case "REPORT LEAD BY SALESREP":
                        App.reportLeadBySalesRep();
                        break;
                    case "REPORT OPPORTUNITY BY SALESREP":
                        App.reportOpportunityBySalesRep();
                        break;
                    case "REPORT CLOSED-WON BY SALESREP":
                        App.reportClosedWonBySalesRep();
                        break;
                    case "REPORT CLOSED-LOST BY SALESREP":
                        App.reportCloseLostBySalesRep();
                        break;
                    case "REPORT OPEN BY SALESREP":
                        App.reportOpenBySalesRep();
                        break;
                    case "REPORT OPPORTUNITY BY PRODUCT":
                        App.reportOpportunityByProduct();
                        break;
                    case "REPORT CLOSED-WON BY PRODUCT":
                        App.reportClosedWonByProduct();
                        break;
                    case "REPORT CLOSED-LOST BY PRODUCT":
                        App.reportCloseLostByProduct();
                        break;
                    case "REPORT OPEN BY PRODUCT":
                        App.reportOpenByProduct();
                        break;
                    case "REPORT OPPORTUNITY BY COUNTRY":
                        App.reportOpportunityByCountry();
                        break;
                    case "REPORT CLOSED-WON BY COUNTRY":
                        App.reportClosedWonByCountry();
                        break;
                    case "REPORT CLOSED-LOST BY COUNTRY":
                        App.reportCloseLostByCountry();
                        break;
                    case "REPORT OPEN BY COUNTRY":
                        App.reportOpenByCountry();
                        break;
                    case "REPORT OPPORTUNITY BY CITY":
                        App.reportOpportunityByCity();
                        break;
                    case "REPORT CLOSED-WON BY CITY":
                        App.reportClosedWonByCity();
                        break;
                    case "REPORT CLOSED-LOST BY CITY":
                        App.reportCloseLostByCity();
                        break;
                    case "REPORT OPEN BY CITY":
                        App.reportOpenByCity();
                        break;
                    case "REPORT OPPORTUNITY BY INDUSTRY":
                        App.reportOpportunityIndustry();
                        break;
                    case "REPORT CLOSED-WON BY INDUSTRY":
                        App.reportClosedWonByIndustry();
                        break;
                    case "REPORT CLOSED-LOST BY INDUSTRY":
                        App.reportCloseLostByIndustry();
                        break;
                    case "REPORT OPEN BY INDUSTRY":
                        App.reportOpenByIndustry();
                        break;
                    case "MEAN EMPLOYEECOUNT":
                        App.meanEmployeeCount();
                        break;
                    case "MEDIAN EMPLOYEECOUNT":
                        App.medianEmployeeCount();
                        break;
                    case "MAX EMPLOYEECOUNT":
                        App.maxEmployeeCount();
                        break;
                    case "MIN EMPLOYEECOUNT":
                        App.minEmployeeCount();
                        break;
                    case "MEAN QUANTITY":
                        App.meanQuantity();
                        break;
                    case "MEDIAN QUANTITY":
                        App.medianQuantity();
                        break;
                    case "MAX QUANTITY":
                        App.maxQuantity();
                        break;
                    case "MIN QUANTITY":
                        App.minQuantity();
                        break;
                    case "MEAN OPPS PER ACCOUNT":
                        App.meanOpps();
                        break;
                    case "MEDIAN OPPS PER ACCOUNT":
                        App.medianOpps();
                        break;
                    case "MAX OPPS PER ACCOUNT":
                        App.maxOpps();
                        break;
                    case "MIN OPPS PER ACCOUNT":
                        App.minOpps();
                        break;
                    //Exist
                    case "HELP":
                        helpReportingMenu();
                        break;
                    case "EXIT":
                        exit = true;
                        break;
                    default:
                        throw new RuntimeException("Incorrect option. Please try again");
                }
            } catch (Exception e) {
                System.out.println("Incorrect option. Please try again");
            }
        } while (!exit);
    }

    /**
     * Go back to mainExecution
     */
    private static void reportingExecutionExit() {
        Main.mainExecution();
    }

    public static void printHeaderShowSales() {

        String id = String.format("%-10s", "ID");
        String name = String.format("%-40s", "NAME");
        System.out.println(id + name);
    }

}
