package com.Ironhack.Homework_DataLayer_DevsDragons.menu;

import com.Ironhack.Homework_DataLayer_DevsDragons.Main;
import com.Ironhack.Homework_DataLayer_DevsDragons.app.App;
import com.Ironhack.Homework_DataLayer_DevsDragons.app.DataEntry;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.Opportunity;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.User;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.person.Lead;
import com.Ironhack.Homework_DataLayer_DevsDragons.repository.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static com.Ironhack.Homework_DataLayer_DevsDragons.Main.print;

public class SalesRepresentativeMenu {

    private static LeadRepository leadRepository;

    private static AccountRepository accountRepository;

    private static OpportunityRepository opportunityRepository;

    private static ContactRepository contactRepository;

    private static UserRepository userRepository;

    public SalesRepresentativeMenu(LeadRepository leadRepository, AccountRepository accountRepository, OpportunityRepository opportunityRepository, ContactRepository contactRepository, UserRepository userRepository) {
        SalesRepresentativeMenu.leadRepository = leadRepository;
        SalesRepresentativeMenu.accountRepository = accountRepository;
        SalesRepresentativeMenu.opportunityRepository = opportunityRepository;
        SalesRepresentativeMenu.contactRepository = contactRepository;
        SalesRepresentativeMenu.userRepository = userRepository;
    }

    private static App application;

    /**
     * Method to print help
     */
    public static void helpSalesMenu() {
        print("------------------------        H E L P       ----------------------------------");
        print("'New Lead' (case insensitive) to add leads");
        print("'Show Leads' (case insensitive) to view all leads");
        print("'Lookup Lead id' (case insensitive) to view individual lead's details where id is the actual id");
        print("'Show Opportunities' (case insensitive) to view all opportunities");
        print("'convert id' (case insensitive) to convert a lead to an Opportunity where id is the actual id");
        print("'close-lost id' (case insensitive) to close Opportunity status where id is the actual id");
        print("'close-won id' (case insensitive) to close Opportunity status where id is the actual id");
    }

    public void menu(User user) {

        application = new App(leadRepository, accountRepository, opportunityRepository, contactRepository, userRepository);

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String action;
        String userAction;
        boolean exit = false;
        do {
            print("");
            print("================================================================================");
            print("                        - Sales representative´s menu -                         ");
            print("================================================================================");
            print("Enter a command or 'Exit' to exit (input help to show available commands):");
            try {
                action = bufferedReader.readLine().toUpperCase(Locale.ROOT);
                userAction = action;
                if (getIdOfAction(action) != -1) {
                    userAction = getAction(action);
                }
                switch (userAction) {
                    case "EXIT":
                        exit = true;
                        break;
                    case "NEW LEAD":
                        DataEntry dataEntry = new DataEntry();
                        Lead newLead = application.newLead(dataEntry.entryName(scanner), dataEntry.entryPhone(scanner),
                                dataEntry.entryMail(scanner), dataEntry.entryCompany(scanner), new Date(), new Date(0L), user.getName(), user.getName(), user);
                        System.out.println(leadInfo(application.lookUpLead(newLead.getId())));
                        break;
                    case "SHOW LEADS":
                        List<Lead> leadList = application.showLeadsByUserId(user.getId());
                        if (leadList == null) {
                            System.out.println("There are no leads associated with your ID in the app");
                        } else {
                            printHeaderShowLeads();
                            for (int i = 0; i < leadList.size(); i++) {
                                System.out.println(leadList.get(i));
                            }
                        }
                        break;
                    case "LOOKUP LEAD":
                        int id = getIdOfAction(action);
                        Optional<Lead> optionalLead = leadRepository.findById(id);
                        if (optionalLead.isPresent()) {
                            if (optionalLead.get().getUser().getId() != user.getId()) {
                                System.out.println("That lead was not created with your username");
                            } else {
                                System.out.println(leadInfo(application.lookUpLead(id)));
                            }
                        } else {
                            System.out.println("There is no Lead with the provided id");
                        }
                        break;
                    case "SHOW OPPORTUNITIES":
                        List<Opportunity> opportunityList = application.showOpportunitiesByUserId(user.getId());
                        if (opportunityList == null) {
                            System.out.println("There are no opportunities associated with your ID in the app");
                        } else {
                            printHeaderShowOpportunities();
                            for (int i = 0; i < opportunityList.size(); i++) {
                                System.out.println(opportunityList.get(i));
                            }
                        }
                        break;
                    case "CONVERT":
                        id = getIdOfAction(action);
                        Optional<Lead> optionalLead2 = leadRepository.findById(id);
                        if (optionalLead2.isPresent()) {
                            if (optionalLead2.get().getUser().getId() != user.getId()) {
                                System.out.println("That lead was not created with your username");
                            } else {
                                application.convert(application.lookUpLead(id), application, scanner, user);
                            }
                        } else {
                            System.out.println("There is no Lead with the provided id");
                        }

                        break;
                    case "CLOSE-WON":
                        id = getIdOfAction(action);
                        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(id);
                        if (optionalOpportunity.isPresent()) {
                            if (optionalOpportunity.get().getUser().getId() != user.getId()) {
                                System.out.println("That opportunity was not created with your username");
                            } else {
                                application.closeWon(id);
                            }
                        } else {
                            System.out.println("There is no opportunity with the provided id");
                        }
                        break;
                    case "CLOSE-LOST":
                        id = getIdOfAction(action);
                        optionalOpportunity = opportunityRepository.findById(id);
                        if (optionalOpportunity.isPresent()) {
                            if (optionalOpportunity.get().getUser().getId() != user.getId()) {
                                System.out.println("That opportunity was not created with your username");
                            } else {
                                application.closeLost(id);
                            }
                        } else {
                            System.out.println("There is no opportunity with the provided id");
                        }

                        break;
                    case "HELP":
                        helpSalesMenu();
                        break;
                    default:
                        System.out.println("Incorrect option");
                }
            } catch (Exception e) {
                System.out.println("Incorrect option. Please try again");
            }
        } while (!exit);
    }

    public static void printHeaderShowLeads() {

        String id = String.format("%-10s", "ID");
        String name = String.format("%-40s", "NAME");
        System.out.println(id + name);
    }

    public int getIdOfAction(String string) {
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

    public String getAction(String string) {

        String userAction = "";
        String[] stringArray = string.split(" ");
        String[] action = new String[stringArray.length - 1];

        System.arraycopy(stringArray, 0, action, 0, action.length);

        for (String s : action) {
            userAction = userAction + s + " ";
        }
        return userAction.trim();
    }

    public String leadInfo(Optional<Lead> lead) throws exceptions.InvalidLeadException {
        if (lead.isEmpty()) throw new exceptions.InvalidLeadException("Lead not found");

        printHeaderLookUpLead();

        String id = String.format("%-10s", lead.get().getId());
        String name = String.format("%-30s", lead.get().getName());
        String phoneNumber = String.format("%-24s", lead.get().getPhoneNumber());
        String email = String.format("%-40s", lead.get().getEmail());
        String company = String.format("%-40s", lead.get().getCompanyName());
        return (id + name + phoneNumber + email + company).trim();

    }

    public void printHeaderLookUpLead() {

        String idTitle = String.format("%-10s", "ID");
        String nameTitle = String.format("%-30s", "NAME");
        String phoneTitle = String.format("%-24s", "PHONE");
        String emailTitle = String.format("%-40s", "EMAIL");
        String companyTitle = String.format("%-40s", "COMPANY");
        System.out.println((idTitle + nameTitle + phoneTitle + emailTitle + companyTitle).trim());
    }

    public void printHeaderShowOpportunities() {

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
}
