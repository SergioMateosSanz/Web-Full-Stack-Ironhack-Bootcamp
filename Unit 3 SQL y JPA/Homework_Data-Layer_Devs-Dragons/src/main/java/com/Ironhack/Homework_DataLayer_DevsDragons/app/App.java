package com.Ironhack.Homework_DataLayer_DevsDragons.app;

import com.Ironhack.Homework_DataLayer_DevsDragons.enums.Industry;
import com.Ironhack.Homework_DataLayer_DevsDragons.enums.Product;
import com.Ironhack.Homework_DataLayer_DevsDragons.enums.Status;
import com.Ironhack.Homework_DataLayer_DevsDragons.enums.UserType;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.Account;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.Opportunity;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.User;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.person.Contact;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.person.Lead;
import com.Ironhack.Homework_DataLayer_DevsDragons.repository.*;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class App {

    private static LeadRepository leadRepository;

    private static AccountRepository accountRepository;

    private static OpportunityRepository opportunityRepository;

    private static ContactRepository contactRepository;

    private static UserRepository userRepository;


    public App() {
    }

    public App(LeadRepository leadRepository, AccountRepository accountRepository, OpportunityRepository opportunityRepository, ContactRepository contactRepository, UserRepository userRepository) {
        App.leadRepository = leadRepository;
        App.accountRepository = accountRepository;
        App.opportunityRepository = opportunityRepository;
        App.contactRepository = contactRepository;
        App.userRepository = userRepository;
    }


    /**
     * Method to consult Account by ID
     *
     * @param id int
     * @return Optional<Account>
     */
    public Optional<Account> consultAccount(int id) {
        return accountRepository.findById(id);
    }

    /**
     * Method to consult Opportunity by ID
     *
     * @param id int
     * @return Optional<Opportunity>
     */
    public Optional<Opportunity> consultOpportunity(int id) {
        return opportunityRepository.findById(id);
    }

    /**
     * Method to show a a list of Opportunities
     */
    public List<Opportunity> showOpportunities() {
        List<Opportunity> opportunityList = opportunityRepository.findAll();
        if (opportunityList.size() == 0) {
            return null;
        }
        return opportunityList;
    }

    /**
     * Method to show a list of Opportunities by userId
     */
    public List<Opportunity> showOpportunitiesByUserId(int id) {
        List<Opportunity> opportunityList = opportunityRepository.findByUserId(id);
        if (opportunityList.size() == 0) {
            return null;
        }
        return opportunityList;
    }

    /**
     * Method to create a New Lead
     */
    public Lead newLead(String name, long phoneNumber, String email, String companyName, Date creationDate, Date modificationDate, String userCreation, String userModification, User user) {

        Lead lead = new Lead(name, phoneNumber, email, companyName, creationDate, modificationDate, userCreation, userModification, user);
        return leadRepository.save(lead);
    }

    /**
     * Method to show a a list of Leads
     */
    public List<Lead> showLeads() {
        List<Lead> leadList = leadRepository.findAll();
        if (leadList.size() == 0) {
            return null;
        }
        return leadList;
    }

    /**
     * Method to show a a list of Leads by userId
     */
    public List<Lead> showLeadsByUserId(int id) {
        List<Lead> leadList = leadRepository.findByUserId(id);
        if (leadList.size() == 0) {
            return null;
        }
        return leadList;
    }

    /**
     * Method to create a New Sales Representative
     */
    public void newSales(String name, String password, Date creationDate, Date modificationDate, String userCreation, String userModification) {

        User sales = new User(name, UserType.SALESREPRESENTATIVE, password, "Active", creationDate, modificationDate, userCreation, userModification);
        userRepository.save(sales);

    }

    /**
     * Method to show a a list of Sales representatives
     */
    public List<User> showSales() {
        List<User> salesList = userRepository.getAllUserByUserType(UserType.SALESREPRESENTATIVE);
        if (salesList.size() == 0) {
            return null;
        }
        return salesList;
    }

    /**
     * Method to consult a specific User by username
     *
     * @return user
     */
    public Optional<User> findUser(String username) {
        return userRepository.findByName(username);
    }

    public void UsertestCreation() {

        Optional<User> optionalUser1 = userRepository.findByName("Dummy");
        if (optionalUser1.isEmpty()) {
            User dummy = new User("Dummy", UserType.DIRECTOR, "123456", "Active", new Date(), new Date(0L), null, null);
            userRepository.save(dummy);
        }

        Optional<User> optionalUser2 = userRepository.findByName("DirectorTest");
        if (optionalUser2.isEmpty()) {
            User director = new User("DirectorTest", UserType.DIRECTOR, "123456", "Active", new Date(),
                    new Date(0L), userRepository.findByName("dummy").get().getName(), userRepository.findByName("dummy").get().getName());
            userRepository.save(director);
        }
        Optional<User> optionalUser3 = userRepository.findByName("SalesTest");
        if (optionalUser3.isEmpty()) {
            User sales = new User("SalesTest", UserType.SALESREPRESENTATIVE, "123456", "Active", new Date(),
                    new Date(0L), userRepository.findByName("dummy").get().getName(), userRepository.findByName("dummy").get().getName());
            userRepository.save(sales);
        }

    }

    /**
     * Method to consult a specific Lead by ID
     *
     * @return lead
     */
    public Optional<Lead> lookUpLead(int id) {
        return leadRepository.findById(id);
    }

    /**
     * Method to convert a Lead into an Opportunity
     *
     * @param app App
     */
    public void convert(Optional<Lead> optionalLead, App app, Scanner input, User user) throws InputMismatchException {
        if (optionalLead.isPresent()) {
            Product product;
            do {
                product = getOpportunityData(input);
            } while (product == null);

            int quantity = -1;
            while (quantity < 1) {
                try {
                    quantity = getTruckNumber(input);
                } catch (InputMismatchException e) {
                    System.out.println("Incorrect input. Please try again.");
                    input.nextLine();
                }
            }
            Contact contact = new Contact(optionalLead.get().getName(), optionalLead.get().getPhoneNumber(), optionalLead.get().getEmail(), optionalLead.get().getCompanyName(),
                    new Date(), new Date(0L), user.getName(), user.getName(), null);
            Opportunity opportunity = new Opportunity(product, quantity, Status.OPEN, user, contact, null, new Date(), new Date(0L), user.getName(), user.getName());


            String option;
            do {
                option = newAccount(input, user);
            } while (option == null);


            if (option.equals("N")) {

                List<Account> accountList = accountRepository.findByUserCreation(user.getName());

                boolean validAccount = false;

                while (!validAccount) {

                    System.out.println("Accounts available:");
                    printHeaderAccount();
                    for (int i = 0; i < accountList.size(); i++) {

                        String id = String.format("%-10s", accountList.get(i).getId());
                        String industry = String.format("%-15s", accountList.get(i).getIndustry());
                        String employeeCount = String.format("%-25s", accountList.get(i).getEmployeeCount());
                        String city = String.format("%-15s", accountList.get(i).getCity());
                        String country = String.format("%-15s", accountList.get(i).getCountry());
                        String creationDate = String.format("%-15s", accountList.get(i).getCreationDate());

                        System.out.println((id + industry + employeeCount + city + country + creationDate).trim());
                    }
                    int id = getAccountNumber(input);
                    Optional<Account> optionalAccount = accountRepository.findById(id);

                    if (optionalAccount.isPresent()) {
                        if (!optionalAccount.get().getUserCreation().equals(user.getName())) {
                            System.out.println("That account was not created with your username, please try again");
                        } else {
                            validAccount = true;
                            contact.setAccount(optionalAccount.get());
                            opportunity.setAccount(optionalAccount.get());
                            contactRepository.save(contact);
                            opportunityRepository.save(opportunity);
                        }
                    } else {
                        System.out.println("There is no account with the provided id");
                    }

                }


            } else {

                Industry industry;
                do {
                    industry = getIndustryData(input);
                } while (industry == null);

                int employeeCount = -1;
                while (employeeCount < 1) {
                    try {
                        employeeCount = getEmployeeNumber(input);
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input. Please try again.");
                        input.nextLine();
                    }
                }

                input.nextLine();

                String country;
                do {
                    country = getCountry(input);
                } while ("".equals(country) || " ".equals(country));

                String city;
                do {
                    city = getCity(input);
                } while ("".equals(city) || " ".equals(city));

                Account account = new Account(industry, employeeCount, city, country, new Date(), new Date(0L), user.getName(), user.getName(), List.of(contact), List.of(opportunity));
                accountRepository.save(account);
                contact.setAccount(account);
                opportunity.setAccount(account);
                contactRepository.save(contact);
                opportunityRepository.save(opportunity);
            }

            System.out.println("Lead successfully converted");
            leadRepository.delete(optionalLead.get());
        }

    }

    /**
     * method to get kind of truck
     *
     * @param scanner Scanner
     * @return Product
     */
    public Product getOpportunityData(Scanner scanner) {

        System.out.println("OPPORTUNITY DATA");
        Product product = null;
        System.out.println("Kind of truck (hybrid, flatbed or box):");
        switch (scanner.nextLine().toUpperCase().trim()) {
            case "HYBRID":
                product = Product.HYBRID;
                break;
            case "FLATBED":
                product = Product.FLATBED;
                break;
            case "BOX":
                product = Product.BOX;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }

        return product;
    }

    /**
     * method to get number of trucks
     *
     * @param scanner Scanner
     * @return int, number of trucks
     * @throws InputMismatchException if the next token does not match the Integer regular expression, or is out of range
     */
    public int getTruckNumber(Scanner scanner) throws InputMismatchException {
        System.out.println("Number of trucks (can not be zero):");
        return scanner.nextInt();
    }

    /**
     * method to answer if user like to create a new Account.
     *
     * @param scanner Scanner
     * @return String, yes or no
     * @throws InputMismatchException if the next token does not match the Integer regular expression, or is out of range
     */
    public String newAccount(Scanner scanner, User user) {
        System.out.println("Would you like to create a new Account? (Y/N):");
        String option = "";
        do {
            try {
                option = scanner.nextLine().toUpperCase().trim();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input. Please try again.");
            }
        } while (!option.equals("Y") && !option.equals("N"));

        if (option.equals("N")) {
            List<Account> accountList = accountRepository.findByUserCreation(user.getName());
            if (accountList.size() == 0) {
                System.out.println("There are no accounts associated with your ID in the app. Yo need to create a new account.");
                option = "Y";
            }
        }
        return option;
    }

    /**
     * method to get number of account
     *
     * @param scanner Scanner
     * @return int, number of account
     * @throws InputMismatchException if the next token does not match the Integer regular expression, or is out of range
     */
    public int getAccountNumber(Scanner scanner) throws InputMismatchException {
        System.out.println("Please provide the account number:");
        int accountNumber = -1;
        while (accountNumber < 1) {
            try {
                accountNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input. Please try again.");
            }
        }
        return accountNumber;
    }

    /**
     * method to get kind of Industry
     *
     * @param scanner Scanner
     * @return Industry
     */
    public Industry getIndustryData(Scanner scanner) {

        Industry industry = null;
        System.out.println("COMPANY DATA");
        System.out.println("Industry of the organization (produce, ecommerce, manufacturing, medical, other):");
        switch (scanner.nextLine().toUpperCase().trim()) {
            case "PRODUCE":
                industry = Industry.PRODUCE;
                break;
            case "ECOMMERCE":
                industry = Industry.ECOMMERCE;
                break;
            case "MANUFACTURING":
                industry = Industry.MANUFACTURING;
                break;
            case "MEDICAL":
                industry = Industry.MEDICAL;
                break;
            case "OTHER":
                industry = Industry.OTHER;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
        return industry;
    }

    /**
     * method to get number of employees
     *
     * @param scanner Scanner
     * @return int if the next token does not match the Integer regular expression, or is out of range
     * @throws InputMismatchException
     */
    public int getEmployeeNumber(Scanner scanner) throws InputMismatchException {
        System.out.println("Number of employees (can not be zero):");
        return scanner.nextInt();
    }

    /**
     * method to get Country name
     *
     * @param scanner Scanner
     * @return String
     */
    public String getCountry(Scanner scanner) {
        System.out.println("Country:");
        return scanner.nextLine().trim();
    }

    /**
     * method to get City name
     *
     * @param scanner Scanner
     * @return String
     */
    public String getCity(Scanner scanner) {
        System.out.println("City:");
        return scanner.nextLine().trim();
    }

    /**
     * Method to change Opportunity status from OPEN, to CLOSED_LOST, by Id
     */

    public void closeLost(int id) {
        Optional<Opportunity> opportunity = opportunityRepository.findById(id);
        if (!opportunity.isPresent()) {
            System.err.println("Opportunity not found");
        } else {
            if (opportunity.get().getStatus() == Status.OPEN) {
                opportunity.get().changeOpportunityStatus(Status.CLOSED_LOST);
                opportunityRepository.save(opportunity.get());
                System.out.println("Opportunity " + opportunity.get().getId() + " status change to CLOSED_LOST");
            } else {
                System.err.println("Opportunity status cannot be changed from " + opportunity.get().getStatus() + " to CLOSED_LOST");
            }
        }
    }

    /**
     * Method to change Opportunity status from OPEN, to CLOSED_WON, by Id
     */
    public void closeWon(int id) {
        Optional<Opportunity> opportunity = opportunityRepository.findById(id);
        if (!opportunity.isPresent()) {
            System.err.println("Opportunity not found");
        } else {
            if (opportunity.get().getStatus() == Status.OPEN) {
                opportunity.get().changeOpportunityStatus(Status.CLOSED_WON);
                opportunityRepository.save(opportunity.get());
                System.out.println("Opportunity " + opportunity.get().getId() + " status change to CLOSED_WON");
            } else {
                System.err.println("Opportunity status cannot be changed from " + opportunity.get().getStatus() + " to CLOSED_WON");
            }
        }
    }

    public static LeadRepository getLeadRepository() {
        return leadRepository;
    }

    public static void setLeadRepository(LeadRepository leadRepository) {
        App.leadRepository = leadRepository;
    }

    public static AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public static void setAccountRepository(AccountRepository accountRepository) {
        App.accountRepository = accountRepository;
    }

    public static OpportunityRepository getOpportunityRepository() {
        return opportunityRepository;
    }

    public static void setOpportunityRepository(OpportunityRepository opportunityRepository) {
        App.opportunityRepository = opportunityRepository;
    }

    public static ContactRepository getContactRepository() {
        return contactRepository;
    }

    public static void setContactRepository(ContactRepository contactRepository) {
        App.contactRepository = contactRepository;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static void setUserRepository(UserRepository userRepository) {
        App.userRepository = userRepository;
    }


    public static void reportLeadBySalesRep() {

        if (leadRepository.getCountOfLeadsBySalesRep().isEmpty()) {
            System.out.println("There are not leads in system");
        } else {
            printReportLeadBySalesRep();
            List<Object[]> objectList = leadRepository.getCountOfLeadsBySalesRep();

            for (int i = 0; i < objectList.size(); i++) {
                String name = String.format("%-25s", objectList.get(i)[0].toString());
                String totalLeads = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((name + totalLeads).trim());
            }

        }
    }

    public static void reportOpportunityBySalesRep() {

        if (userRepository.getAllUserWithOpportunityByUserType(UserType.SALESREPRESENTATIVE).isEmpty()) {
            System.out.println("There are not leads in system");
        } else {
            printReportLeadBySalesRep();
            List<User> userList = userRepository.getAllUserWithOpportunityByUserType(UserType.SALESREPRESENTATIVE);
            for (User user : userList) {

                String name = String.format("%-25s", user.getName());
                String totalOpportunities = String.format("%-10s", user.getOpportunityList().size());

                System.out.println((name + totalOpportunities).trim());
            }
        }
    }

    public static void reportClosedWonBySalesRep() {

        if (userRepository.getAllUserWithOpportunityByUserTypeAndStatus(UserType.SALESREPRESENTATIVE, Status.CLOSED_WON).isEmpty()) {
            System.out.println("There are not leads with close-won opportunities in system");
        } else {
            printHeaderOpportunitiesClosedWon();
            List<User> userList = userRepository.getAllUserWithOpportunityByUserTypeAndStatus(UserType.SALESREPRESENTATIVE, Status.CLOSED_WON);
            for (User user : userList) {

                String name = String.format("%-25s", user.getName());
                String totalOpportunities = String.format("%-10s", user.getOpportunityList().size());

                System.out.println((name + totalOpportunities).trim());
            }
        }
    }

    public static void reportCloseLostBySalesRep() {

        if (userRepository.getAllUserWithOpportunityByUserTypeAndStatus(UserType.SALESREPRESENTATIVE, Status.CLOSED_LOST).isEmpty()) {
            System.out.println("There are not leads with close-lost opportunities in system");
        } else {
            printHeaderOpportunitiesClosedLost();
            List<User> userList = userRepository.getAllUserWithOpportunityByUserTypeAndStatus(UserType.SALESREPRESENTATIVE, Status.CLOSED_LOST);
            for (User user : userList) {

                String name = String.format("%-25s", user.getName());
                String totalOpportunities = String.format("%-10s", user.getOpportunityList().size());

                System.out.println((name + totalOpportunities).trim());
            }
        }
    }

    public static void reportOpenBySalesRep() {

        if (userRepository.getAllUserWithOpportunityByUserTypeAndStatus(UserType.SALESREPRESENTATIVE, Status.OPEN).isEmpty()) {
            System.out.println("There are not leads with open opportunities in system");
        } else {
            printHeaderOpportunitiesOpen();
            List<User> userList = userRepository.getAllUserWithOpportunityByUserTypeAndStatus(UserType.SALESREPRESENTATIVE, Status.OPEN);
            for (User user : userList) {
                String name = String.format("%-25s", user.getName());
                String totalOpportunities = String.format("%-10s", user.getOpportunityList().size());

                System.out.println((name + totalOpportunities).trim());
            }
        }
    }

    public static void reportOpportunityByProduct() {

        if (accountRepository.countOppsByProduct().isEmpty()) {
            System.out.println("There are not opportunities in system");
        } else {

            printHeaderReportOpportunityByProduct();
            List<Object[]> objectList = accountRepository.countOppsByProduct();

            for (int i = 0; i < objectList.size(); i++) {
                String product = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((product + total).trim());
            }
        }
    }

    public static void reportClosedWonByProduct() {

        if (accountRepository.countOppsByStatusAndProduct(Status.CLOSED_WON).isEmpty()) {
            System.out.println("There are not opportunities close-won in system");
        } else {

            printHeaderReportOpportunityByProduct();
            List<Object[]> objectList = accountRepository.countOppsByStatusAndProduct(Status.CLOSED_WON);

            for (int i = 0; i < objectList.size(); i++) {
                String product = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((product + total).trim());
            }
        }
    }

    public static void reportCloseLostByProduct() {

        if (accountRepository.countOppsByStatusAndProduct(Status.CLOSED_LOST).isEmpty()) {
            System.out.println("There are not opportunities close-lost in system");
        } else {

            printHeaderReportOpportunityByProduct();
            List<Object[]> objectList = accountRepository.countOppsByStatusAndProduct(Status.CLOSED_LOST);

            for (int i = 0; i < objectList.size(); i++) {
                String product = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((product + total).trim());
            }
        }
    }

    public static void reportOpenByProduct() {

        if (accountRepository.countOppsByStatusAndProduct(Status.OPEN).isEmpty()) {
            System.out.println("There are not opportunities open in system");
        } else {

            printHeaderReportOpportunityByProduct();
            List<Object[]> objectList = accountRepository.countOppsByStatusAndProduct(Status.OPEN);

            for (int i = 0; i < objectList.size(); i++) {
                String product = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((product + total).trim());
            }
        }
    }

    public static void reportOpportunityByCountry() {

        if (accountRepository.countOppsByCountry().isEmpty()) {
            System.out.println("There are not opportunities in system");
        } else {

            printHeaderReportOpportunityByCountry();
            List<Object[]> objectList = accountRepository.countOppsByCountry();

            for (int i = 0; i < objectList.size(); i++) {
                String country = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((country + total).trim());
            }
        }
    }

    public static void reportClosedWonByCountry() {

        if (accountRepository.countOppsByStatusAndCountry(Status.CLOSED_WON).isEmpty()) {
            System.out.println("There are not opportunities close-won in system");
        } else {

            printHeaderReportOpportunityByCountry();
            List<Object[]> objectList = accountRepository.countOppsByStatusAndCountry(Status.CLOSED_WON);

            for (int i = 0; i < objectList.size(); i++) {
                String country = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((country + total).trim());
            }
        }
    }

    public static void reportCloseLostByCountry() {

        if (accountRepository.countOppsByStatusAndCountry(Status.CLOSED_LOST).isEmpty()) {
            System.out.println("There are not opportunities close-lost in system");
        } else {

            printHeaderReportOpportunityByCountry();
            List<Object[]> objectList = accountRepository.countOppsByStatusAndCountry(Status.CLOSED_LOST);

            for (int i = 0; i < objectList.size(); i++) {
                String country = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((country + total).trim());
            }
        }
    }

    public static void reportOpenByCountry() {

        if (accountRepository.countOppsByStatusAndCountry(Status.OPEN).isEmpty()) {
            System.out.println("There are not opportunities open in system");
        } else {

            printHeaderReportOpportunityByCountry();
            List<Object[]> objectList = accountRepository.countOppsByStatusAndCountry(Status.OPEN);

            for (int i = 0; i < objectList.size(); i++) {
                String country = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((country + total).trim());
            }
        }
    }

    public static void reportOpportunityByCity() {

        if (accountRepository.countOppsByCity().isEmpty()) {
            System.out.println("There are not opportunities in system");
        } else {

            printHeaderReportOpportunityByCity();
            List<Object[]> objectList = accountRepository.countOppsByCity();

            for (int i = 0; i < objectList.size(); i++) {
                String city = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((city + total).trim());
            }
        }
    }

    public static void reportClosedWonByCity() {

        if (accountRepository.countOppsByStatusAndCity(Status.CLOSED_WON).isEmpty()) {
            System.out.println("There are not opportunities close-won in system");
        } else {

            printHeaderReportOpportunityByCity();
            List<Object[]> objectList = accountRepository.countOppsByStatusAndCity(Status.CLOSED_WON);

            for (int i = 0; i < objectList.size(); i++) {
                String city = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((city + total).trim());
            }
        }
    }

    public static void reportCloseLostByCity() {

        if (accountRepository.countOppsByStatusAndCity(Status.CLOSED_LOST).isEmpty()) {
            System.out.println("There are not opportunities close-lost in system");
        } else {

            printHeaderReportOpportunityByCity();
            List<Object[]> objectList = accountRepository.countOppsByStatusAndCity(Status.CLOSED_LOST);

            for (int i = 0; i < objectList.size(); i++) {
                String city = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((city + total).trim());
            }
        }
    }

    public static void reportOpenByCity() {

        if (accountRepository.countOppsByStatusAndCity(Status.OPEN).isEmpty()) {
            System.out.println("There are not opportunities open in system");
        } else {

            printHeaderReportOpportunityByCity();
            List<Object[]> objectList = accountRepository.countOppsByStatusAndCity(Status.OPEN);

            for (int i = 0; i < objectList.size(); i++) {
                String city = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((city + total).trim());
            }
        }
    }

    public static void reportOpportunityIndustry() {

        if (accountRepository.countOppsByIndustry().isEmpty()) {
            System.out.println("There are not opportunities in system");
        } else {

            printHeaderReportOpportunityByIndustry();
            List<Object[]> objectList = accountRepository.countOppsByIndustry();

            for (int i = 0; i < objectList.size(); i++) {
                String industry = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((industry + total).trim());
            }
        }
    }

    public static void reportClosedWonByIndustry() {

        if (accountRepository.countOppsByStatusAndIndustry(Status.CLOSED_WON).isEmpty()) {
            System.out.println("There are not opportunities close-won in system");
        } else {

            printHeaderReportOpportunityByIndustry();
            List<Object[]> objectList = accountRepository.countOppsByStatusAndIndustry(Status.CLOSED_WON);

            for (int i = 0; i < objectList.size(); i++) {
                String industry = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((industry + total).trim());
            }
        }
    }

    public static void reportCloseLostByIndustry() {

        if (accountRepository.countOppsByStatusAndIndustry(Status.CLOSED_LOST).isEmpty()) {
            System.out.println("There are not opportunities close-lost in system");
        } else {

            printHeaderReportOpportunityByIndustry();
            List<Object[]> objectList = accountRepository.countOppsByStatusAndIndustry(Status.CLOSED_LOST);

            for (int i = 0; i < objectList.size(); i++) {
                String industry = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((industry + total).trim());
            }
        }
    }

    public static void reportOpenByIndustry() {

        if (accountRepository.countOppsByStatusAndIndustry(Status.OPEN).isEmpty()) {
            System.out.println("There are not opportunities open in system");
        } else {

            printHeaderReportOpportunityByIndustry();
            List<Object[]> objectList = accountRepository.countOppsByStatusAndIndustry(Status.OPEN);

            for (int i = 0; i < objectList.size(); i++) {
                String industry = String.format("%-25s", objectList.get(i)[0].toString());
                String total = String.format("%-10s", objectList.get(i)[1].toString());

                System.out.println((industry + total).trim());
            }
        }
    }

    public static void meanEmployeeCount() {

        if (accountRepository.meanEmployeeCount() == null) {
            System.out.println("Mean Employee Count is: 0");
        } else {

            System.out.println("Mean Employee Count is: " + accountRepository.meanEmployeeCount());
        }
    }

    public static void medianEmployeeCount() {

        if (accountRepository.medianEmployeeCount() == null) {
            System.out.println("Median Employee Count is: 0");
        } else {
            System.out.println("Median Employee Count is: " + accountRepository.medianEmployeeCount());
        }
    }

    public static void maxEmployeeCount() {

        if (accountRepository.maxEmployeeCount().isEmpty()) {
            System.out.println("Max Employee Count is: 0");
        } else {
            System.out.println("Max Employee Count is: " + accountRepository.maxEmployeeCount().get(0)[1] + ", From account: " + accountRepository.maxEmployeeCount().get(0)[0] );
        }
    }

    public static void minEmployeeCount() {
        if (accountRepository.minEmployeeCount().isEmpty()) {
            System.out.println("Min Employee Count is: 0");
        } else {
            System.out.println("Min Employee Count is: " + accountRepository.minEmployeeCount().get(0)[1] + ", From account: " + accountRepository.minEmployeeCount().get(0)[0] );
        }
    }

    public static void meanQuantity() {

        if (opportunityRepository.meanQuantity() == null) {
            System.out.println("Mean Quantity is: 0");
        } else {
            System.out.println("Mean Quantity is: " + opportunityRepository.meanQuantity());
        }
    }

    public static void medianQuantity() {

        if (opportunityRepository.medianQuantity() == null) {
            System.out.println("Median Quantity is: 0");
        } else {
            System.out.println("Median Quantity is: " + opportunityRepository.medianQuantity());
        }
    }

    public static void maxQuantity() {

        if (opportunityRepository.maxQuantity().isEmpty()) {
            System.out.println("Max Quantity is: 0");
        } else {
            System.out.println("Max Quantity is: " + opportunityRepository.maxQuantity().get(0)[1] + ", From opportunity: " + opportunityRepository.maxQuantity().get(0)[0] );
        }
    }

    public static void minQuantity() {

        if (opportunityRepository.minQuantity().isEmpty()) {
            System.out.println("Min Quantity is: 0");
        } else {
            System.out.println("Min Quantity is: " + opportunityRepository.minQuantity().get(0)[1] + ", From opportunity: " + opportunityRepository.minQuantity().get(0)[0] );
        }
    }

    public static void meanOpps() {
        if (opportunityRepository. meanOpportunitiesByAccount() == null) {
            System.out.println("There are not opportunities in any Account");
        } else {
            System.out.println("Mean Opportunities per Account is: " + opportunityRepository.meanOpportunitiesByAccount());
        }
    }

    public static void medianOpps() {
        if (opportunityRepository. medianOpportunitiesByAccount() == null) {
            System.out.println("There are not opportunities in any Account");
        } else {
            System.out.println("Median Opportunities per Account is: " + opportunityRepository.medianOpportunitiesByAccount());
        }
    }

    public static void maxOpps() {
        if (opportunityRepository. maxOpportunitiesByAccount() == null) {
            System.out.println("There are not opportunities in any Account");
        } else {
            System.out.println("Max Opportunities per Account is: " + opportunityRepository.maxOpportunitiesByAccount());
        }
    }

    public static void minOpps() {
        if (opportunityRepository. minOpportunitiesByAccount() == null) {
            System.out.println("There are not opportunities in any Account");
        } else {
            System.out.println("Min Opportunities per Account is: " + opportunityRepository.minOpportunitiesByAccount());
        }
    }

    public static void printReportLeadBySalesRep() {

        String nameTitle = String.format("%-25s", "NAME");
        String totalLeadsTitle = String.format("%-10s", "TOTAL LEADS");

        System.out.println((nameTitle + totalLeadsTitle).trim());
    }

    public static void printHeaderReportOpportunityByProduct() {

        String product = String.format("%-25s", "PRODUCT");
        String total = String.format("%-10s", "TOTAL");

        System.out.println((product + total).trim());
    }

    public static void printHeaderReportOpportunityByCountry() {

        String product = String.format("%-25s", "COUNTRY");
        String total = String.format("%-10s", "TOTAL");

        System.out.println((product + total).trim());
    }

    public static void printHeaderReportOpportunityByCity() {

        String product = String.format("%-25s", "CITY");
        String total = String.format("%-10s", "TOTAL");

        System.out.println((product + total).trim());
    }

    public static void printHeaderReportOpportunityByIndustry() {

        String product = String.format("%-25s", "INDUSTRY");
        String total = String.format("%-10s", "TOTAL");

        System.out.println((product + total).trim());
    }


    public static void printHeaderAccount() {

        String id = String.format("%-10s", "ID");
        String industry = String.format("%-15s", "INDUSTRY");
        String employeeCount = String.format("%-25s", "NUMBER OF EMPLOYEES");
        String city = String.format("%-15s", "CITY");
        String country = String.format("%-15s", "COUNTRY");
        String creationDate = String.format("%-15s", "CREATION DATE");
        System.out.println((id + industry + employeeCount +
                city + country + creationDate).trim());
    }

    public static void printHeaderOpportunitiesClosedWon() {

        String nameTitle = String.format("%-25s", "NAME");
        String totalLeadsTitle = String.format("%-10s", "TOTAL OPPORTUNITIES CLOSED_WON");

        System.out.println((nameTitle + totalLeadsTitle).trim());
    }

    public static void printHeaderOpportunitiesClosedLost() {

        String nameTitle = String.format("%-25s", "NAME");
        String totalLeadsTitle = String.format("%-10s", "TOTAL OPPORTUNITIES CLOSED_LOST");

        System.out.println((nameTitle + totalLeadsTitle).trim());
    }

    public static void printHeaderOpportunitiesOpen() {

        String nameTitle = String.format("%-25s", "NAME");
        String totalLeadsTitle = String.format("%-10s", "TOTAL OPPORTUNITIES OPEN");

        System.out.println((nameTitle + totalLeadsTitle).trim());
    }

}
