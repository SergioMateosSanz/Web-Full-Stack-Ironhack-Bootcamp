package app;

import account.Account;
import account.Industry;
import opportunity.Opportunity;
import opportunity.Product;
import opportunity.Status;
import person.Contact;
import person.Lead;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    private List<Lead> leads;
    private List<Account> accounts;
    private List<Opportunity> opportunities;


    public App() {
        this.leads = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.opportunities = new ArrayList<>();
    }

    /**
     * Method to consult Account by ID
     *
     * @param id int
     * @return Account
     */
    public Account consultAccount(int id) {

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId() == id) {
                return accounts.get(i);
            }
        }
        return null;
    }

    /**
     * Method to consult Opportunity by ID
     *
     * @param id int
     * @return Opportunity
     */
    public Opportunity consultOpportunity(int id) {

        for (int i = 0; i < opportunities.size(); i++) {
            if (opportunities.get(i).getId() == id) {
                return opportunities.get(i);
            }
        }
        return null;
    }

    /**
     * Method to create a New Lead
     */
    public void newLead(String name, Long phoneNumber, String email, String companyName) {
        Lead lead = new Lead(name, phoneNumber, email, companyName);
        leads.add(lead);
    }

    /**
     * Method to consult a specific Lead by ID
     *
     * @return lead
     */
    public Lead lookUpLead(int id) {
        for (int i = 0; i < leads.size(); i++) {
            if (leads.get(i).getId() == id) return leads.get(i);
        }
        return null;
    }

    /**
     * Method to print help
     */
    public static void printHelp() {
        System.out.println("'New Lead' (case insensitive) to add leads");
        System.out.println("'Show Leads' (case insensitive) to view all leads");
        System.out.println("'Lookup Lead id' (case insensitive) to view individual lead's details where id is the actual id");
        System.out.println("'Show Opportunities' (case insensitive) to view all opportunities");
        System.out.println("'convert id' (case insensitive) to convert a lead to an Opportunity where id is the actual id");
        System.out.println("'close-lost id' (case insensitive) to close Opportunity status where id is the actual id");
        System.out.println("'close-won id' (case insensitive) to close Opportunity status where id is the actual id");
    }

    /**
     * Method to convert a Lead into an Opportunity
     *
     * @param lead Lead that is going to be converted
     * @param app  App
     */
    public void convert(Lead lead, App app, Scanner input) throws InputMismatchException {

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

        opportunities.add(new Opportunity(product, quantity, new Contact(lead.getName(), lead.getPhoneNumber(),
                lead.getEmail(), lead.getCompanyName()), Status.OPEN));

        input.nextLine();

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

        accounts.add(new Account(industry, employeeCount, city, country));

        System.out.println("Lead successfully converted");
        app.getLeads().remove(leads.indexOf(lead));
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
        Opportunity opportunity = consultOpportunity(id);
            if (opportunity == null) {
                System.err.println("Opportunity not found");
            } else {
                if(opportunity.getStatus()==Status.OPEN) {
                    opportunity.changeOpportunityStatus(Status.CLOSED_LOST);
                    System.out.println("Opportunity " + opportunity.getId() + " status change to CLOSED_LOST");
                } else {
                    System.err.println("Opportunity status cannot be changed from " + opportunity.getStatus() + " to CLOSED_LOST");
                }
            }
    }

    /**
     * Method to change Opportunity status from OPEN, to CLOSED_WON, by Id
     */

    public void closeWon(int id) {
        Opportunity opportunity = consultOpportunity(id);
        if (opportunity == null) {
            System.err.println("Opportunity not found");
        } else {
            if(opportunity.getStatus()==Status.OPEN) {
                opportunity.changeOpportunityStatus(Status.CLOSED_WON);
                System.out.println("Opportunity " + opportunity.getId() + " status change to CLOSED_WON");
            } else {
                System.err.println("Opportunity status cannot be changed from " + opportunity.getStatus() + " to CLOSED_WON");
            }

        }
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }
}
