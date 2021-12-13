package com.Ironhack.Homework_DataLayer_DevsDragons.menu;

import com.Ironhack.Homework_DataLayer_DevsDragons.HomeworkDataLayerDevsDragonsApplication;
import com.Ironhack.Homework_DataLayer_DevsDragons.Main;
import com.Ironhack.Homework_DataLayer_DevsDragons.app.App;
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

import static com.Ironhack.Homework_DataLayer_DevsDragons.Main.print;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalesRepresentativeMenuTest {

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

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
        contactRepository.deleteAll();
        leadRepository.deleteAll();
        accountRepository.deleteAll();
        userRepository.deleteAll();
        System.setOut(standardOut);
    }


    @Test
    void helpSalesMenu_OutputCaptorSuccess_givenSystemOutRedirection() {
        SalesRepresentativeMenu.helpSalesMenu();

        assertEquals("------------------------        H E L P       ----------------------------------" + System.lineSeparator() +
                        "'New Lead' (case insensitive) to add leads" + System.lineSeparator() +
                        "'Show Leads' (case insensitive) to view all leads" + System.lineSeparator() +
                        "'Lookup Lead id' (case insensitive) to view individual lead's details where id is the actual id" + System.lineSeparator() +
                        "'Show Opportunities' (case insensitive) to view all opportunities" + System.lineSeparator() +
                        "'convert id' (case insensitive) to convert a lead to an Opportunity where id is the actual id" + System.lineSeparator() +
                        "'close-lost id' (case insensitive) to close Opportunity status where id is the actual id" + System.lineSeparator() +
                        "'close-won id' (case insensitive) to close Opportunity status where id is the actual id"
                , outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    @Test
    void menu() {
    }

    @Test
    void printHeaderShowLeads() {
    }

    @Test
    void getIdOfAction() {
    }

    @Test
    void getAction() {
    }

    @Test
    void leadInfo() {
    }

    @Test
    void printHeaderLookUpLead() {
    }

    @Test
    void printHeaderShowOpportunities() {
    }
}