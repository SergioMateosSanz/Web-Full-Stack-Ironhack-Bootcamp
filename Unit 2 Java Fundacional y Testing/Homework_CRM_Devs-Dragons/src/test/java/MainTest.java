import app.App;
import exceptions.InvalidLeadException;
import opportunity.Opportunity;
import opportunity.Product;
import opportunity.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import person.Contact;
import person.Lead;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    App app;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        app = new App();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * As the standard output stream is a shared static resource used by other parts of the system, we should take
     * care of restoring it to its original state when our test terminates
     */
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void menu_OutputCaptorSuccess_givenSystemOutRedirection() {
        Main.menu();
        assertEquals("=================================================" + System.lineSeparator() +
                        "-  Welcome to IronHack CRM LBL Trucking Company -" + System.lineSeparator() +
                        "=================================================" + System.lineSeparator() +
                        "Select one option:" + System.lineSeparator() +
                        "1: Enter a command" + System.lineSeparator() +
                        "0: Exit"
                , outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    @Test
    public void print_OutputCaptorSuccess_givenSystemOutRedirection() {
        Main.print("Welcome to IronHack CRM LBL Trucking Company");

        assertEquals("Welcome to IronHack CRM LBL Trucking Company", outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    @Test
    void showLeads_ReturnNull_EmptyListLeads() {
        assertNull(Main.showLeads(app));
    }

    @Test
    void showLeads_ReturnList_AppWithOneLead() {
        List<Lead> listLead = new ArrayList<>();
        listLead.add(new Lead("Leader One", 123456789L,
                "leader@email.com", "company S.A"));
        app.setLeads(listLead);
        assertEquals(listLead, Main.showLeads(app));
    }

    @Test
    void showLeads_ReturnList_AppWithLeads() {
        List<Lead> listLead = new ArrayList<>();
        listLead.add(new Lead("Leader One", 123456789L,
                "leader@email.com", "company S.A"));
        listLead.add(new Lead("Leader Two", 123456789L,
                "leader@email.com", "company S.A"));
        app.setLeads(listLead);
        assertEquals(listLead, Main.showLeads(app));

        listLead.add(new Lead("Leader Three", 123456789L,
                "leader@email.com", "company S.A"));
        app.setLeads(listLead);
        assertEquals(listLead, Main.showLeads(app));
    }

    @Test
    void showOpportunities_ReturnNull_EmptyListOpportunities() {
        assertNull(Main.showOpportunities(app));
    }

    @Test
    void showOpportunities_ReturnList_AppWithOneOpportunity() {
        Contact contactTest = new Contact("Name", 641654656, "email@aggagag.com", "Test");
        List<Opportunity> listOpportunities = new ArrayList<>();
        listOpportunities.add(new Opportunity(Product.HYBRID, 3,
                contactTest, Status.OPEN));
        app.setOpportunities(listOpportunities);
        assertEquals(listOpportunities, Main.showOpportunities(app));
    }

    @Test
    void showOpportunities_ReturnList_AppWithOpportunities() {
        List<Opportunity> listOpportunities = new ArrayList<>();
        listOpportunities.add(new Opportunity(Product.HYBRID, 3,
                new Contact("Name1", 641654656, "email@aggagag.com", "Test1"), Status.OPEN));
        listOpportunities.add(new Opportunity(Product.FLATBED, 2,
                new Contact("Name2", 666616166, "email@fsdfssdf.com", "Test2"), Status.OPEN));
        app.setOpportunities(listOpportunities);
        assertEquals(listOpportunities, Main.showOpportunities(app));

        listOpportunities.add(new Opportunity(Product.BOX, 4,
                new Contact("Name3", 616516161, "email@fsdfsdfs.com", "Test3"), Status.OPEN));
        app.setOpportunities(listOpportunities);
        assertEquals(listOpportunities, Main.showOpportunities(app));

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
        assertThrows(InvalidLeadException.class, () -> Main.print(Main.leadInfo(app.lookUpLead(0))));
    }

    @Test
    void leadInfo_PrintInfo_ValidLead() throws InvalidLeadException {
        app.newLead("Mario López", 666111222L, "mariolopez@gmail.com", "Telefónica");
        Main.print(Main.leadInfo(app.lookUpLead(Lead.getTotalLead() - 1)));

        String idTitle = String.format("%-10s", "ID");
        String nameTitle = String.format("%-30s", "NAME");
        String phoneTitle = String.format("%-24s", "PHONE");
        String emailTitle = String.format("%-40s", "EMAIL");
        String companyTitle = String.format("%-40s", "COMPANY");
        String id = String.format("%-10s", (Lead.getTotalLead() - 1));
        String name = String.format("%-30s", "Mario López");
        String phoneNumber = String.format("%-24s", "666111222");
        String email = String.format("%-40s", "mariolopez@gmail.com");
        String company = String.format("%-40s", "Telefónica");

        assertEquals(((idTitle + nameTitle + phoneTitle + emailTitle + companyTitle).trim() + System.lineSeparator() +
                        id + name + phoneNumber + email + company).trim()
                , outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }



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
