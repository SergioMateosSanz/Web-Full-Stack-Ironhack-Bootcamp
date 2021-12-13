package com.Ironhack.Homework_DataLayer_DevsDragons.menu;

import com.Ironhack.Homework_DataLayer_DevsDragons.HomeworkDataLayerDevsDragonsApplication;
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
class DirectorMenuTest {

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
    void helpDirectorMenuOutputCaptorSuccess_givenSystemOutRedirection() {
        DirectorMenu.helpDirectorMenu();

        assertEquals("------------------------        H E L P       ----------------------------------" + System.lineSeparator() +
                        "'New Sales' to add a sale representative" + System.lineSeparator() +
                        "'Show Sales' to view all sales representatives" + System.lineSeparator() +
                        "'Consult Reporting' to view all existing reports"
                , outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    @Test
    void helpReportingMenuOutputCaptorSuccess_givenSystemOutRedirection() {
        DirectorMenu.helpReportingMenu();

        assertEquals("------------------------        H E L P       ----------------------------------" + System.lineSeparator() +
                        "  By SalesRep:" + System.lineSeparator() +
                "   - Report Lead by SalesRep" + System.lineSeparator() +
                "   - Report Opportunity by SalesRep" + System.lineSeparator() +
                "   - Report CLOSED-WON by SalesRep" + System.lineSeparator() +
                "   - Report CLOSED-LOST by SalesRep" + System.lineSeparator() +
                "   - Report OPEN by SalesRep" + System.lineSeparator() +
                "  By Product:" + System.lineSeparator() +
                "   - Report Opportunity by Product" + System.lineSeparator() +
                "   - Report CLOSED-WON by Product" + System.lineSeparator() +
                "   - Report CLOSED-LOST by Product" + System.lineSeparator() +
                "   - Report OPEN by Product" + System.lineSeparator() +
                "  By Country:" + System.lineSeparator() +
                "   - Report Opportunity by Country" + System.lineSeparator() +
                "   - Report CLOSED-WON by Country" + System.lineSeparator() +
                "   - Report CLOSED-LOST by Country" + System.lineSeparator() +
                "   - Report OPEN by Country" + System.lineSeparator() +
                "  By City:" + System.lineSeparator() +
                "   - Report Opportunity by City" + System.lineSeparator() +
                "   - Report CLOSED-WON by City" + System.lineSeparator() +
                "   - Report CLOSED-LOST by City" + System.lineSeparator() +
                "   - Report OPEN by City" + System.lineSeparator() +
                "  By Industry:" + System.lineSeparator() +
                "   - Report Opportunity by Industry" + System.lineSeparator() +
                "   - Report CLOSED-WON by Industry" + System.lineSeparator() +
                "   - Report CLOSED-LOST by Industry" + System.lineSeparator() +
                "   - Report OPEN by Industry" + System.lineSeparator() +
                "  By EmployeeCount:" + System.lineSeparator() +
                "   - Mean EmployeeCount" + System.lineSeparator() +
                "   - Median EmployeeCount" + System.lineSeparator() +
                "   - Max EmployeeCount" + System.lineSeparator() +
                "   - Min EmployeeCount" + System.lineSeparator() +
                "  By Quantity:" + System.lineSeparator() +
                "   - Mean Quantity" + System.lineSeparator() +
                "   - Median Quantity" + System.lineSeparator() +
                "   - Max Quantity" + System.lineSeparator() +
                "   - Min Quantity" + System.lineSeparator() +
                "  By Opportunity:" + System.lineSeparator() +
                "   - Mean Opps per Account" + System.lineSeparator() +
                "   - Median Opps per Account" + System.lineSeparator() +
                "   - Max Opps per Account" + System.lineSeparator() +
                "   - Min Opps per Account"

                , outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }
}