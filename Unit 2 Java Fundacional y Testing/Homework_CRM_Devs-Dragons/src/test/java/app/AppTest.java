package app;

import account.Account;
import account.Industry;
import opportunity.Opportunity;
import opportunity.Product;
import opportunity.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import person.Contact;
import person.Lead;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    App app;

    private final PrintStream standardOut = System.out;
    private final PrintStream originalErr = System.err;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        app = new App();
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setErr(new PrintStream(errContent));
    }

    /**
     * As the standard output stream is a shared static resource used by other parts of the system, we should take
     * care of restoring it to its original state when our test terminates
     */
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setErr(originalErr);
    }

    @Test
    void consultAccount_ReturnNull_IdNotFound() {
        List<Account> accounts = new ArrayList<>();
        List<Contact> contacts = new ArrayList<>();
        List<Opportunity> opportunities = new ArrayList<>();
        accounts.add(new Account(Industry.ECOMMERCE, 3465, "Arizona", "USA", contacts, opportunities));
        accounts.add(new Account(Industry.MANUFACTURING, 543, "Montana", "USA", contacts, opportunities));
        accounts.add(new Account(Industry.MEDICAL, 5765, "Texas", "USA", contacts, opportunities));
        app.setAccounts(accounts);

        assertNull(app.consultAccount(223));
        assertNull(app.consultAccount(33));
        assertNull(app.consultAccount(8));
    }

    @Test
    void consultAccount_ReturnAccount_IdFound() {
        List<Account> accounts = new ArrayList<>();
        List<Contact> contacts = new ArrayList<>();
        List<Opportunity> opportunities = new ArrayList<>();
        Account a1 = new Account(Industry.ECOMMERCE, 3465, "Arizona", "USA", contacts, opportunities);
        Account a2 = new Account(Industry.MANUFACTURING, 543, "Montana", "USA", contacts, opportunities);
        Account a3 = new Account(Industry.MEDICAL, 5765, "Texas", "USA", contacts, opportunities);
        accounts.addAll(List.of(a1, a2, a3));
        app.setAccounts(accounts);

        assertEquals(a1, app.consultAccount(a1.getId()));
        assertEquals(a2, app.consultAccount(a2.getId()));
        assertEquals(a3, app.consultAccount(a3.getId()));
    }

    @Test
    public void consultOpportunity_ReturnNull_IdNotFound() {
        Contact decisionMaker = new Contact("Albus Dumbledore", 395837, "albus@example.com", "Hogwarts.inc");
        Opportunity o1 = new Opportunity(Product.BOX, 2, decisionMaker, Status.OPEN);
        Opportunity o2 = new Opportunity(Product.HYBRID, 7, decisionMaker, Status.OPEN);
        List<Opportunity> opportunities = new ArrayList<>();
        opportunities.add(o1);
        opportunities.add(o2);
        app.setOpportunities(opportunities);

        assertNull(app.consultAccount(223));
        assertNull(app.consultAccount(22));
        assertNull(app.consultAccount(1234));
    }

    @Test
    public void consultOpportunity_ReturnOpportunity_IdFound() {
        Contact decisionMaker = new Contact("Albus Dumbledore", 395837, "albus@example.com", "Hogwarts.inc");
        Opportunity o1 = new Opportunity(Product.BOX, 2, decisionMaker, Status.OPEN);
        Opportunity o2 = new Opportunity(Product.HYBRID, 7, decisionMaker, Status.OPEN);
        List<Opportunity> opportunities = new ArrayList<>();
        opportunities.add(o1);
        opportunities.add(o2);
        app.setOpportunities(opportunities);

        assertEquals(o1, app.consultOpportunity(o1.getId()));
        assertEquals(o2, app.consultOpportunity(o2.getId()));
    }

    @Test
    void newLead_createNewLead_NewLeadCreated() {
        app.newLead("Mario Lopez", 163406406406L, "Mariolopez@gmail.com", "Telefonica");
        app.newLead("Ana Garcia", 1234L, "ana@correo.com", "Ana S.A.");

        assertEquals("Mario Lopez", app.getLeads().get(0).getName());
        assertEquals(163406406406L, app.getLeads().get(0).getPhoneNumber());
        assertEquals("Mariolopez@gmail.com", app.getLeads().get(0).getEmail());
        assertEquals("Telefonica", app.getLeads().get(0).getCompanyName());
        assertEquals("Ana Garcia", app.getLeads().get(1).getName());
        assertEquals(1234L, app.getLeads().get(1).getPhoneNumber());
        assertEquals("ana@correo.com", app.getLeads().get(1).getEmail());
        assertEquals("Ana S.A.", app.getLeads().get(1).getCompanyName());
    }

    @Test
    void lookUpLead_ReturnNull_IdNotFound() {
        assertNull(app.lookUpLead(50));
        assertNull(app.lookUpLead(-10));
    }

    @Test
    void lookUpLead_ReturnLead_IdFound() {
        app.newLead("Mario López", 666111222L, "mariolopez@gmail.com", "Telefónica");
        app.newLead("Lucía Sánchez", 666115422L, "lsanchez@gmail.com", "Citröen");
        app.newLead("Nuria Puente", 635111222L, "nupuente@gmail.com", "AT&T");

        Lead exampleLead = app.lookUpLead(Lead.getTotalLead() - 3);
        assertEquals(Lead.getTotalLead() - 3, exampleLead.getId());
        assertEquals("Mario López", exampleLead.getName());
        assertEquals(666111222L, exampleLead.getPhoneNumber());
        assertEquals("mariolopez@gmail.com", exampleLead.getEmail());
        assertEquals("Telefónica", exampleLead.getCompanyName());

        exampleLead = app.lookUpLead(Lead.getTotalLead() - 2);
        assertEquals(Lead.getTotalLead() - 2, exampleLead.getId());
        assertEquals("Lucía Sánchez", exampleLead.getName());
        assertEquals(666115422L, exampleLead.getPhoneNumber());
        assertEquals("lsanchez@gmail.com", exampleLead.getEmail());
        assertEquals("Citröen", exampleLead.getCompanyName());

        exampleLead = app.lookUpLead(Lead.getTotalLead() - 1);
        assertEquals(Lead.getTotalLead() - 1, exampleLead.getId());
        assertEquals("Nuria Puente", exampleLead.getName());
        assertEquals(635111222L, exampleLead.getPhoneNumber());
        assertEquals("nupuente@gmail.com", exampleLead.getEmail());
        assertEquals("AT&T", exampleLead.getCompanyName());
    }

    @Test
    void printHelp_OutputCaptorSuccess_givenSystemOutRedirection() {
        App.printHelp();
        assertEquals("'New Lead' (case insensitive) to add leads" + System.lineSeparator() +
                        "'Show Leads' (case insensitive) to view all leads" + System.lineSeparator() +
                        "'Lookup Lead id' (case insensitive) to view individual lead's details where id is the actual id" + System.lineSeparator() +
                        "'Show Opportunities' (case insensitive) to view all opportunities" + System.lineSeparator() +
                        "'convert id' (case insensitive) to convert a lead to an Opportunity where id is the actual id" + System.lineSeparator() +
                        "'close-lost id' (case insensitive) to close Opportunity status where id is the actual id" + System.lineSeparator() +
                        "'close-won id' (case insensitive) to close Opportunity status where id is the actual id"
                , outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    @Test
    void convert_ConvertedLead_ValidLead() {
        InputStream standardInput = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(("FLATBED" + System.lineSeparator() +
                2 + System.lineSeparator() +
                "PRODUCE" + System.lineSeparator() +
                50 + System.lineSeparator() +
                "Spain" + System.lineSeparator() +
                "Barcelona").getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        app.newLead("Mario López", 666111222L, "mariolopez@gmail.com", "Telefónica");
        Lead lead = app.getLeads().get(app.getLeads().size() - 1);
        int leads = app.getLeads().size();
        int id = app.getLeads().get(app.getLeads().size() - 1).getId();
        int opportunities = app.getOpportunities().size();
        int accounts = app.getAccounts().size();
        app.convert(lead, app, new Scanner(System.in, StandardCharsets.UTF_8));

        Opportunity opportunity = app.getOpportunities().get(app.getOpportunities().size() - 1);
        Account account = app.getAccounts().get(app.getAccounts().size() - 1);

        assertEquals(leads - 1, app.getLeads().size());
        assertEquals(opportunities + 1, app.getOpportunities().size());
        assertEquals(accounts + 1, app.getAccounts().size());
        assertNull(app.lookUpLead(id));
        assertEquals("Mario López", opportunity.getDecisionMaker().getName());
        assertEquals(Status.OPEN, opportunity.getStatus());
        assertEquals(Product.FLATBED, opportunity.getProduct());
        assertEquals(2, opportunity.getQuantity());
        assertEquals(Industry.PRODUCE, account.getIndustry());
        assertEquals(50, account.getEmployeeCount());
        assertEquals("Spain", account.getCountry());
        assertEquals("Barcelona", account.getCity());

        System.setIn(standardInput);
    }

    @Test
    void getOpportunityData_ReturnNull_InputNotValid() {
        assertNull(app.getOpportunityData(new Scanner("Yellow Tractor")));
        assertNull(app.getOpportunityData(new Scanner("Juan Mota")));
        assertNull(app.getOpportunityData(new Scanner("Leo Messi")));
    }


    @Test
    void getOpportunityData_ReturnProduct_CorrectInput() {
        Product product = Product.HYBRID;
        assertEquals(product, app.getOpportunityData(new Scanner("HYBRID")));

        product = Product.FLATBED;
        assertEquals(product, app.getOpportunityData(new Scanner("FLATBED")));

        product = Product.BOX;
        assertEquals(product, app.getOpportunityData(new Scanner("BOX")));
    }

    @Test
    void getTruckNumber_ThrowsInputMismatchException_InputNotANumber() {
        assertThrows(InputMismatchException.class, () -> app.getTruckNumber(new Scanner("Yellow Submarine")));
        assertThrows(InputMismatchException.class, () -> app.getTruckNumber(new Scanner("FLATBED")));
    }

    @Test
    void getTruckNumber_ReturnInteger_InputPositiveNumber() {
        assertEquals(3, app.getTruckNumber(new Scanner("3")));
        assertEquals(12, app.getTruckNumber(new Scanner("12")));
        assertEquals(1, app.getTruckNumber(new Scanner("1")));
    }

    @Test
    void getTruckNumber_ReturnInteger_InputNegativeNumber() {
        assertEquals(-3, app.getTruckNumber(new Scanner("-3")));
        assertEquals(-12, app.getTruckNumber(new Scanner("-12")));
        assertEquals(-1, app.getTruckNumber(new Scanner("-1")));
    }

    @Test
    void getTruckNumber_ReturnZero_InputZeroNumber() {
        assertEquals(0, app.getTruckNumber(new Scanner("0")));
        assertEquals(0, app.getTruckNumber(new Scanner("000000")));
    }

    @Test
    void getIndustryData_ReturnNull_InputNotValid() {
        assertNull(app.getIndustryData(new Scanner("Yellow Tractor")));
        assertNull(app.getIndustryData(new Scanner("Pepe")));
        assertNull(app.getIndustryData(new Scanner("Cristiano Ronaldo")));
    }

    @Test
    void getIndustryData_ReturnProduct_CorrectInput() {
        Industry industry = Industry.ECOMMERCE;
        assertEquals(industry, app.getIndustryData(new Scanner("ECOMMERCE")));

        industry = Industry.OTHER;
        assertEquals(industry, app.getIndustryData(new Scanner("OTHER")));

        industry = Industry.PRODUCE;
        assertEquals(industry, app.getIndustryData(new Scanner("PRODUCE")));

        industry = Industry.MANUFACTURING;
        assertEquals(industry, app.getIndustryData(new Scanner("MANUFACTURING")));

        industry = Industry.MEDICAL;
        assertEquals(industry, app.getIndustryData(new Scanner("MEDICAL")));
    }

    @Test
    void getEmployeeNumber_ThrowsInputMismatchException_InputNotANumber() {
        assertThrows(InputMismatchException.class, () -> app.getTruckNumber(new Scanner("Yellow Submarine")));
        assertThrows(InputMismatchException.class, () -> app.getTruckNumber(new Scanner("Elvis Presley")));
    }

    @Test
    void getEmployeeNumber_ReturnInteger_InputPositiveNumber() {
        assertEquals(3, app.getEmployeeNumber(new Scanner("3")));
        assertEquals(12, app.getEmployeeNumber(new Scanner("12")));
        assertEquals(1, app.getEmployeeNumber(new Scanner("1")));
    }

    @Test
    void getEmployeeNumber_ReturnInteger_InputNegativeNumber() {
        assertEquals(-3, app.getEmployeeNumber(new Scanner("-3")));
        assertEquals(-12, app.getEmployeeNumber(new Scanner("-12")));
        assertEquals(-1, app.getEmployeeNumber(new Scanner("-1")));
    }

    @Test
    void getEmployeeNumber_ReturnZero_InputZeroNumber() {
        assertEquals(0, app.getEmployeeNumber(new Scanner("0")));
        assertEquals(0, app.getEmployeeNumber(new Scanner("000000")));
    }

    @Test
    void getCountry_ReturnStringTrim_InputWithSpacesAtTheBeginningAndAtTheEnd() {
        assertEquals("Pepe", app.getCountry(new Scanner(" Pepe")));
        assertEquals("Pepe", app.getCountry(new Scanner("Pepe ")));
        assertEquals("Spain", app.getCountry(new Scanner("  Spain       ")));
        assertEquals("United States", app.getCountry(new Scanner(" United States")));
        assertEquals("United States", app.getCountry(new Scanner("United States ")));
        assertEquals("United States", app.getCountry(new Scanner("  United States       ")));
    }

    @Test
    void getCountry_ReturnString_InputWithoutSpacesAtTheBeginningAndAtTheEnd() {
        assertEquals("Norway", app.getCountry(new Scanner("Norway")));
        assertEquals("United States", app.getCountry(new Scanner("United States")));
        assertEquals("Democratic Republic of the Congo", app.getCountry(new Scanner("Democratic Republic of the Congo")));
    }

    @Test
    void getCity_ReturnStringTrim_InputWithSpaces() {
        assertEquals("Madrid", app.getCity(new Scanner(" Madrid")));
        assertEquals("Madrid", app.getCity(new Scanner("Madrid ")));
        assertEquals("Madrid", app.getCity(new Scanner("  Madrid       ")));
        assertEquals("Rio de Janeiro", app.getCity(new Scanner(" Rio de Janeiro")));
        assertEquals("Rio de Janeiro", app.getCity(new Scanner("Rio de Janeiro ")));
        assertEquals("Rio de Janeiro", app.getCity(new Scanner("  Rio de Janeiro     ")));
    }

    @Test
    void getCity_ReturnString_InputWithoutSpacesAtTheBeginningAndAtTheEnd() {
        assertEquals("Sevilla", app.getCity(new Scanner("Sevilla")));
        assertEquals("La Coruña", app.getCity(new Scanner("La Coruña")));
        assertEquals("Rio de Janeiro", app.getCity(new Scanner("Rio de Janeiro")));
    }








    @Test
    void closeWon_StatusChange_IdFound() {
        Opportunity o1;
        Opportunity o2;
        Contact decisionMaker = new Contact("Albus Dumbledore", 395837, "albus@example.com", "Hogwarts.inc");
        List<Opportunity> opportunities = new ArrayList<>();
        o1 = new Opportunity(Product.BOX, 2, decisionMaker, Status.OPEN);
        o2 = new Opportunity(Product.HYBRID, 7, decisionMaker, Status.OPEN);
        opportunities.add(o1);
        opportunities.add(o2);
        app.setOpportunities(opportunities);
        app.closeWon(opportunities.get(0).getId());

        assertEquals(Status.CLOSED_WON, o1.getStatus());
    }

    @Test
    void closeLost_StatusChange_IdFound() {
        Opportunity o1;
        Opportunity o2;
        Contact decisionMaker = new Contact("Albus Dumbledore", 395837, "albus@example.com", "Hogwarts.inc");
        List<Opportunity> opportunities = new ArrayList<>();
        o1 = new Opportunity(Product.BOX, 2, decisionMaker, Status.OPEN);
        o2 = new Opportunity(Product.HYBRID, 7, decisionMaker, Status.OPEN);
        opportunities.add(o1);
        opportunities.add(o2);
        app.setOpportunities(opportunities);
        app.closeLost(opportunities.get(1).getId());

        assertEquals(Status.CLOSED_LOST, o2.getStatus());
    }

    @Test
    void closeLost_StatusChange_IdNotFound() {
        Opportunity o1;
        Opportunity o2;
        Contact decisionMaker = new Contact("Albus Dumbledore", 395837, "albus@example.com", "Hogwarts.inc");
        List<Opportunity> opportunities = new ArrayList<>();
        o1 = new Opportunity(Product.BOX, 2, decisionMaker, Status.OPEN);
        o2 = new Opportunity(Product.HYBRID, 7, decisionMaker, Status.OPEN);
        opportunities.add(o1);
        opportunities.add(o2);
        app.setOpportunities(opportunities);
        app.closeLost(888888);
        // If this message is printed to the user, then it means that opportunity was not found
        assertEquals("Opportunity not found", errContent.toString().replaceAll("[\n\r]", ""));
    }
    @Test
    void closeLost_StatusChange_StatusCannotBeChanged() {
        Opportunity o1;
        Contact decisionMaker = new Contact("Albus Dumbledore", 395837, "albus@example.com", "Hogwarts.inc");
        List<Opportunity> opportunities = new ArrayList<>();
        o1 = new Opportunity(Product.HYBRID, 7, decisionMaker, Status. CLOSED_WON);
        opportunities.add(o1);
        app.setOpportunities(opportunities);
        app.closeLost(o1.getId());

        // If this message is printed to the user, then it means that opportunity can't be changed because is already closed
        assertEquals("Opportunity status cannot be changed from " + o1.getStatus() + " to CLOSED_LOST",errContent.toString().replaceAll("[\n\r]", ""));
    }

    @Test
    void closeWon_StatusChange_IdNotFound() {
        Opportunity o1;
        Opportunity o2;
        Contact decisionMaker = new Contact("Albus Dumbledore", 395837, "albus@example.com", "Hogwarts.inc");
        List<Opportunity> opportunities = new ArrayList<>();
        o1 = new Opportunity(Product.BOX, 2, decisionMaker, Status.OPEN);
        o2 = new Opportunity(Product.HYBRID, 7, decisionMaker, Status.OPEN);
        opportunities.add(o1);
        opportunities.add(o2);
        app.setOpportunities(opportunities);
        app.closeWon(888888);
        // If this message is printed to the user, then it means that opportunity was not found
        assertEquals("Opportunity not found", errContent.toString().replaceAll("[\n\r]", ""));
    }

    @Test
    void closeWon_StatusChange_StatusCannotBeChanged() {
        Opportunity o1;
        Contact decisionMaker = new Contact("Albus Dumbledore", 395837, "albus@example.com", "Hogwarts.inc");
        List<Opportunity> opportunities = new ArrayList<>();
        o1 = new Opportunity(Product.HYBRID, 7, decisionMaker, Status. CLOSED_LOST);
        opportunities.add(o1);
        app.setOpportunities(opportunities);
        app.closeWon(o1.getId());

        // If this message is printed to the user, then it means that opportunity can't be changed because is already closed
        assertEquals("Opportunity status cannot be changed from " + o1.getStatus() + " to CLOSED_WON",errContent.toString().replaceAll("[\n\r]", ""));
    }




}

