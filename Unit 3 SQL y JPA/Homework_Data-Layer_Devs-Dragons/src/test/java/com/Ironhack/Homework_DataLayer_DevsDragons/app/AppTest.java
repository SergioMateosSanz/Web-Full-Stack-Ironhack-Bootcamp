package com.Ironhack.Homework_DataLayer_DevsDragons.app;

import com.Ironhack.Homework_DataLayer_DevsDragons.HomeworkDataLayerDevsDragonsApplication;
import com.Ironhack.Homework_DataLayer_DevsDragons.Main;
import com.Ironhack.Homework_DataLayer_DevsDragons.enums.UserType;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.Account;
import com.Ironhack.Homework_DataLayer_DevsDragons.enums.Industry;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.Opportunity;
import com.Ironhack.Homework_DataLayer_DevsDragons.enums.Product;
import com.Ironhack.Homework_DataLayer_DevsDragons.enums.Status;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.User;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.person.Contact;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.person.Lead;
import com.Ironhack.Homework_DataLayer_DevsDragons.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AppTest {

    @MockBean
    private HomeworkDataLayerDevsDragonsApplication homeworkDataLayerDevsDragonsApplication;

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ContactRepository contactRepository;

    User userTest1;
    User userTest2;
    Opportunity opportunityTes1;
    Opportunity opportunityTes2;
    Account accountTest1;
    Account accountTest2;
    Account accountTest3;
    Contact contactTest1;
    Contact contactTest2;
    Contact contactTest3;
    Lead leadOne;
    Lead leadTwo;
    Lead leadThree;

    App app;

    private final PrintStream standardOut = System.out;
    private final PrintStream originalErr = System.err;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {

        userTest1 = new User("user one", UserType.DIRECTOR, "12345678", "ACTIVE", new Date(),
                new Date(0L), "test", "");
        userTest2 = new User("user two", UserType.SALESREPRESENTATIVE, "12345678", "ACTIVE", new Date(),
                new Date(0L), "test", "");
        opportunityTes1 = new Opportunity(Product.HYBRID, 22, null, Status.OPEN);
        opportunityTes1.setUser(userTest2);
        userTest2.setOpportunityList(List.of(opportunityTes1));

        opportunityTes2 = new Opportunity(Product.FLATBED, 100, null, Status.CLOSED_LOST);
        opportunityTes2.setUser(userTest2);

        userRepository.saveAll(List.of(userTest1, userTest2));
        opportunityRepository.saveAll(List.of(opportunityTes1, opportunityTes2));

        contactTest1 = new Contact("contact one", 641646416L, "contactone@test.com", "CompanyTest1", new Date(), new Date(0L), userTest2.getName(), userTest2.getName(), null);
        contactTest2 = new Contact("contact two", 660610606L, "contacttwo@test.com", "CompanyTest2", new Date(), new Date(0L), userTest2.getName(), userTest2.getName(), null);
        contactTest3 = new Contact("contact three", 684848464L, "contactthree@test.com", "CompanyTest3", new Date(), new Date(0L), userTest2.getName(), userTest2.getName(), null);
        contactRepository.saveAll(List.of(contactTest1, contactTest2, contactTest3));

        accountTest1 = new Account(Industry.ECOMMERCE, 3, "Madrid", "Spain", new Date(), new Date(0L), userTest2.getName(), userTest2.getName(), contactRepository.findAll(), opportunityRepository.findAll());
        accountRepository.save(accountTest1);

        leadOne = new Lead("lead one", 641564611L, "leadone@test.com", "Company test 1", new Date(), new Date(0L), "user one", "user one", userTest1);
        leadTwo = new Lead("lead two", 641564612L, "leadtwo@test.com", "Company test 2", new Date(), new Date(0L), "user one", "user one", userTest1);
        leadThree = new Lead("lead three", 641564613L, "leadthree@test.com", "Company test 3", new Date(), new Date(0L), "user two", "user one", userTest2);
        leadRepository.saveAll(List.of(leadOne, leadTwo, leadThree));

        app = new App(leadRepository, accountRepository, opportunityRepository, contactRepository, userRepository);
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setErr(new PrintStream(errContent));
    }

    /**
     * As the standard output stream is a shared static resource used by other parts of the system, we should take
     * care of restoring it to its original state when our test terminates
     */
    @AfterEach
    public void tearDown() {

        leadRepository.deleteAll();
        accountRepository.deleteAll();
        contactRepository.deleteAll();
        opportunityRepository.deleteAll();
        userRepository.deleteAll();

        System.setOut(standardOut);
        System.setErr(originalErr);
    }

    @Test
    void consultAccount_ReturnNull_IdNotFound() {
        Optional<Account> optionalAccount = app.consultAccount(999);
        assertFalse(optionalAccount.isPresent());
    }

    @Test
    void consultAccount_ReturnAccount_IdFound() {
        Optional<Account> optionalAccount = app.consultAccount(accountTest1.getId());
        assertTrue(optionalAccount.isPresent());
        assertEquals(Industry.ECOMMERCE, optionalAccount.get().getIndustry());
        assertEquals(3, optionalAccount.get().getEmployeeCount());
        assertEquals("Madrid", optionalAccount.get().getCity());
        assertEquals("user two", optionalAccount.get().getUserCreation());
    }

    @Test
    public void consultOpportunity_ReturnNull_IdNotFound() {
        Optional<Opportunity> optionalOpportunity = app.consultOpportunity(999);
        assertFalse(optionalOpportunity.isPresent());
    }

    @Test
    public void consultOpportunity_ReturnOpportunity_IdFound() {
        Optional<Opportunity> optionalOpportunity = app.consultOpportunity(opportunityTes1.getId());
        assertTrue(optionalOpportunity.isPresent());
        assertEquals(Product.HYBRID, optionalOpportunity.get().getProduct());
        assertEquals(22, optionalOpportunity.get().getQuantity());
        assertEquals(Status.OPEN, optionalOpportunity.get().getStatus());

    }

    @Test
    void newLead_createNewLead_NewLeadCreated() {

        Lead lead1 = new Lead("Mario Lopez", 163406406406L, "Mariolopez@gmail.com", "Telefonica",
                new Date(), new Date(0L), userTest1.getName(), userTest1.getName(), userTest1);

        Lead lead2 = new Lead("Ana Garcia", 1234L, "ana@correo.com", "Ana S.A.",
                new Date(), new Date(0L), userTest2.getName(), userTest2.getName(), userTest2);

        app.newLead(lead1.getName(), lead1.getPhoneNumber(), lead1.getEmail(), lead1.getCompanyName(), lead1.getCreationDate(), lead1.getModificationDate(),
                lead1.getUserCreation(), lead1.getUserModification(), lead1.getUser());
        app.newLead(lead2.getName(), lead2.getPhoneNumber(), lead2.getEmail(), lead2.getCompanyName(), lead2.getCreationDate(), lead2.getModificationDate(),
                lead2.getUserCreation(), lead2.getUserModification(), lead2.getUser());

        List<Lead> leadList = leadRepository.findAll();
        assertTrue(leadList.size() == 5);

        assertEquals("Mario Lopez", leadList.get(3).getName());
        assertEquals(163406406406L, leadList.get(3).getPhoneNumber());
        assertEquals("Mariolopez@gmail.com", leadList.get(3).getEmail());
        assertEquals("Telefonica", leadList.get(3).getCompanyName());
        assertEquals("user one", leadList.get(3).getUserCreation());
        assertEquals("Ana Garcia", leadList.get(4).getName());
        assertEquals(1234L, leadList.get(4).getPhoneNumber());
        assertEquals("ana@correo.com", leadList.get(4).getEmail());
        assertEquals("Ana S.A.", leadList.get(4).getCompanyName());
        assertEquals("user two", leadList.get(4).getUserCreation());
    }

    @Test
    void lookUpLead_ReturnNull_IdNotFound() {
        Optional<Lead> optionalLead = app.lookUpLead(50);
        assertTrue(optionalLead.isEmpty());

    }

    @Test
    void lookUpLead_ReturnLead_IdFound() {

        Optional<Lead> optionalLead1 = app.lookUpLead(leadOne.getId());
        Optional<Lead> optionalLead2 = app.lookUpLead(leadTwo.getId());
        Optional<Lead> optionalLead3 = app.lookUpLead(leadThree.getId());
        assertTrue(optionalLead1.isPresent());
        assertTrue(optionalLead2.isPresent());
        assertTrue(optionalLead3.isPresent());

        assertEquals("lead one", optionalLead1.get().getName());
        assertEquals("lead two", optionalLead2.get().getName());
        assertEquals("lead three", optionalLead3.get().getName());
    }


//    @Test
//    void convert_ConvertedLead_ValidLead() {
//        InputStream standardInput = System.in;
//        ByteArrayInputStream in = new ByteArrayInputStream(("FLATBED" + System.lineSeparator() +
//                2 + System.lineSeparator() +
//                "PRODUCE" + System.lineSeparator() +
//                50 + System.lineSeparator() +
//                "Spain" + System.lineSeparator() +
//                "Barcelona").getBytes(StandardCharsets.UTF_8));
//        System.setIn(in);
//
//        app.newLead("Mario López", 666111222L, "mariolopez@gmail.com", "Telefónica");
//        Lead lead = app.getLeads().get(app.getLeads().size() - 1);
//        int leads = app.getLeads().size();
//        int id = app.getLeads().get(app.getLeads().size() - 1).getId();
//        int opportunities = app.getOpportunities().size();
//        int accounts = app.getAccounts().size();
//        app.convert(lead, app, new Scanner(System.in, StandardCharsets.UTF_8));
//
//        Opportunity opportunity = app.getOpportunities().get(app.getOpportunities().size() - 1);
//        Account account = app.getAccounts().get(app.getAccounts().size() - 1);
//
//        assertEquals(leads - 1, app.getLeads().size());
//        assertEquals(opportunities + 1, app.getOpportunities().size());
//        assertEquals(accounts + 1, app.getAccounts().size());
//        assertNull(app.lookUpLead(id));
//        assertEquals("Mario López", opportunity.getDecisionMaker().getName());
//        assertEquals(Status.OPEN, opportunity.getStatus());
//        assertEquals(Product.FLATBED, opportunity.getProduct());
//        assertEquals(2, opportunity.getQuantity());
//        assertEquals(Industry.PRODUCE, account.getIndustry());
//        assertEquals(50, account.getEmployeeCount());
//        assertEquals("Spain", account.getCountry());
//        assertEquals("Barcelona", account.getCity());
//
//        System.setIn(standardInput);
//    }

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
        app.closeWon(opportunityTes1.getId());
        Optional<Opportunity> opportunityUpdated = opportunityRepository.findById(opportunityTes1.getId());
        assertEquals(Status.CLOSED_WON, opportunityUpdated.get().getStatus());
    }

    @Test
    void closeLost_StatusChange_IdFound() {
        app.closeLost(opportunityTes1.getId());
        Optional<Opportunity> opportunityUpdated = opportunityRepository.findById(opportunityTes1.getId());
        assertEquals(Status.CLOSED_LOST, opportunityUpdated.get().getStatus());
    }

    @Test
    void closeLost_StatusChange_IdNotFound() {
        app.closeLost(888888);
        // If this message is printed to the user, then it means that opportunity was not found
        assertEquals("Opportunity not found", errContent.toString().replaceAll("[\n\r]", ""));
    }

    @Test
    void closeLost_StatusChange_StatusCannotBeChanged() {
        app.closeLost(opportunityTes2.getId());
        // If this message is printed to the user, then it means that opportunity can't be changed because is already closed
        assertEquals("Opportunity status cannot be changed from " + opportunityTes2.getStatus() + " to CLOSED_LOST",errContent.toString().replaceAll("[\n\r]", ""));
    }

    @Test
    void closeWon_StatusChange_IdNotFound() {
        app.closeWon(888888);
        // If this message is printed to the user, then it means that opportunity was not found
        assertEquals("Opportunity not found", errContent.toString().replaceAll("[\n\r]", ""));
    }

    @Test
    void closeWon_StatusChange_StatusCannotBeChanged() {
        app.closeWon(opportunityTes2.getId());
        // If this message is printed to the user, then it means that opportunity can't be changed because is already closed
        assertEquals("Opportunity status cannot be changed from " + opportunityTes2.getStatus() + " to CLOSED_WON",errContent.toString().replaceAll("[\n\r]", ""));
    }


    @Test
    void showLeads_ReturnNull_EmptyListLeads() {
        leadRepository.deleteAll();
        assertNull(app.showLeads());
    }

    @Test
    void showLeads_ReturnList_AppWithLeads() {
        List<Lead> listLead = leadRepository.findAll();

        assertEquals(listLead, app.showLeads());

        Lead newLead = new Lead("lead test", 641564611L, "leadone@test.com", "Company test 1", new Date(), new Date(0L), "user one", "user one", userTest1);
        leadRepository.save(newLead);
        listLead = leadRepository.findAll();
        assertEquals(listLead, app.showLeads());
    }

    @Test
    void showOpportunities_ReturnNull_EmptyListOpportunities() {
        leadRepository.deleteAll();
        accountRepository.deleteAll();
        contactRepository.deleteAll();
        opportunityRepository.deleteAll();
        assertNull(app.showOpportunities());
    }

    @Test
    void showOpportunities_ReturnList_AppWithOpportunities() {

        List<Opportunity> listOpportunities = opportunityRepository.findAll();

        assertEquals(listOpportunities, app.showOpportunities());

        Opportunity newOpportunity = new Opportunity(Product.HYBRID, 22, null, Status.OPEN);
        newOpportunity.setUser(userTest2);
        userTest2.setOpportunityList(List.of(newOpportunity));
        opportunityRepository.save(newOpportunity);
        listOpportunities = opportunityRepository.findAll();

        assertEquals(listOpportunities, app.showOpportunities());
    }
}