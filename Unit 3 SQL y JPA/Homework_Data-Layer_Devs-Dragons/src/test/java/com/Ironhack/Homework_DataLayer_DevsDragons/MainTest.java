package com.Ironhack.Homework_DataLayer_DevsDragons;

import com.Ironhack.Homework_DataLayer_DevsDragons.app.App;
import com.Ironhack.Homework_DataLayer_DevsDragons.enums.Industry;
import com.Ironhack.Homework_DataLayer_DevsDragons.enums.UserType;
import com.Ironhack.Homework_DataLayer_DevsDragons.menu.DirectorMenu;
import com.Ironhack.Homework_DataLayer_DevsDragons.menu.SalesRepresentativeMenu;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.Account;
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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MainTest {

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

    private App app;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        app = new App(leadRepository,accountRepository,opportunityRepository,contactRepository,userRepository);
        System.setOut(new PrintStream(outputStreamCaptor));


    }

    /**
     * As the standard output stream is a shared static resource used by other parts of the system, we should take
     * care of restoring it to its original state when our test terminates
     */
    @AfterEach
    public void tearDown() {
        opportunityRepository.deleteAll();
        contactRepository.deleteAll();
        leadRepository.deleteAll();
        accountRepository.deleteAll();
        userRepository.deleteAll();
        System.setOut(standardOut);
    }

    @Test
    void menu_OutputCaptorSuccess_givenSystemOutRedirection() {
        Main.menu();
        assertEquals("=================================================" + System.lineSeparator() +
                        "-  Welcome to IronHack CRM LBL Trucking Company -" + System.lineSeparator() +
                        "=================================================" + System.lineSeparator() +
                        "Select one option:" + System.lineSeparator() +
                        "1: Login" + System.lineSeparator() +
                        "0: Exit"
                , outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    @Test
    void login_OutputCaptorSuccess_givenSystemOutRedirection() {
        Main.login();
        assertEquals("=================================================" + System.lineSeparator() +
                        "-  For test use 'DirectorTest' and password '123456' " + System.lineSeparator() +
                        "-  or 'SalesTest' and password '123456' -            " + System.lineSeparator() +
                        "=================================================" + System.lineSeparator() +
                        "Enter username or 'Exit' to cancel:"
                , outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    @Test
    public void print_OutputCaptorSuccess_givenSystemOutRedirection() {
        Main.print("Welcome to IronHack CRM LBL Trucking Company");

        assertEquals("Welcome to IronHack CRM LBL Trucking Company", outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    @Test
    void getIdOfAction_returnArray_String() {
        assertEquals(5, Main.getIdOfAction("Lookup Lead 5"));
        assertEquals(256, Main.getIdOfAction("close-lost 256"));
        assertEquals(-1, Main.getIdOfAction("Lookup Lead b545"));
        assertEquals(-1, Main.getIdOfAction("New Lead"));
    }

    @Test
    void getAction_returnStringOfAction_String() {
        assertEquals("Lookup Lead", Main.getAction("Lookup Lead 5"));
        assertEquals("close-lost", Main.getAction("close-lost 256"));
        assertEquals("", Main.getAction("pepe"));
        assertEquals("", Main.getAction(""));
    }

    @Test
    void leadInfo_ThrowException_InvalidLead() {
        assertThrows(exceptions.InvalidLeadException.class, () -> Main.print(Main.leadInfo(app.lookUpLead(0))));
    }

//    @Test
//    void leadInfo_PrintInfo_ValidLead() throws exceptions.InvalidLeadException {
//        app.newLead("Mario López", 666111222L, "mariolopez@gmail.com", "Telefónica");
//        Main.print(Main.leadInfo(app.lookUpLead(Lead.getTotalLead() - 1)));
//
//        String idTitle = String.format("%-10s", "ID");
//        String nameTitle = String.format("%-30s", "NAME");
//        String phoneTitle = String.format("%-24s", "PHONE");
//        String emailTitle = String.format("%-40s", "EMAIL");
//        String companyTitle = String.format("%-40s", "COMPANY");
//        String id = String.format("%-10s", (Lead.getTotalLead() - 1));
//        String name = String.format("%-30s", "Mario López");
//        String phoneNumber = String.format("%-24s", "666111222");
//        String email = String.format("%-40s", "mariolopez@gmail.com");
//        String company = String.format("%-40s", "Telefónica");
//
//        assertEquals(((idTitle + nameTitle + phoneTitle + emailTitle + companyTitle).trim() + System.lineSeparator() +
//                        id + name + phoneNumber + email + company).trim()
//                , outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
//    }



    @Test
    void printHeaderShowLeads_printHeader() {
        Main.printHeaderShowLeads();
        String id = String.format("%-10s", "ID");
        String name = String.format("%-40s", "NAME");

        assertEquals((id + name).trim()
                , outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    @Test
    void printHeaderShowOpportunities_printHeader() {
        Main.printHeaderShowOpportunities();
        String idTitle = String.format("%-10s", "ID");
        String productTitle = String.format("%-15s", "PRODUCT");
        String quantityTitle = String.format("%-10s", "QUANTITY");
        String nameTitle = String.format("%-30s", "NAME");
        String phoneTitle = String.format("%-24s", "PHONE");
        String emailTitle = String.format("%-40s", "EMAIL");
        String companyTitle = String.format("%-40s", "COMPANY");
        String statusTitle = String.format("%-40s", "STATUS");

        assertEquals((idTitle + productTitle + quantityTitle + nameTitle + phoneTitle +
                        emailTitle + companyTitle + statusTitle).trim()
                , outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    @Test
    void printHeaderLookUpLead_printHeader() {
        Main.printHeaderLookUpLead();
        String idTitle = String.format("%-10s", "ID");
        String nameTitle = String.format("%-30s", "NAME");
        String phoneTitle = String.format("%-24s", "PHONE");
        String emailTitle = String.format("%-40s", "EMAIL");
        String companyTitle = String.format("%-40s", "COMPANY");

        assertEquals((idTitle + nameTitle + phoneTitle + emailTitle + companyTitle).trim()
                , outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }
}
