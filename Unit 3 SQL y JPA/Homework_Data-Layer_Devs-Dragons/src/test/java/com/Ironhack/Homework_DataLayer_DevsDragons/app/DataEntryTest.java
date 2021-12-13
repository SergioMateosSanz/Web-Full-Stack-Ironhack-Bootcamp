package com.Ironhack.Homework_DataLayer_DevsDragons.app;

import com.Ironhack.Homework_DataLayer_DevsDragons.HomeworkDataLayerDevsDragonsApplication;
import com.Ironhack.Homework_DataLayer_DevsDragons.validations.EmailInvalidFormat;
import com.Ironhack.Homework_DataLayer_DevsDragons.validations.NameInvalidFormat;
import com.Ironhack.Homework_DataLayer_DevsDragons.validations.PasswordInvalidFormat;
import com.Ironhack.Homework_DataLayer_DevsDragons.validations.PhoneInvalidFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class DataEntryTest {

    @MockBean
    private HomeworkDataLayerDevsDragonsApplication homeworkDataLayerDevsDragonsApplication;

    DataEntry dataEntry;
    Scanner scanner;

    @BeforeEach
    void setUp() {
        dataEntry = new DataEntry();
    }

    @Test
    public void getNextLine_ReturnLine_CorrectExecution() {
        String data = "Mario Lopez";
        scanner = new Scanner("Mario Lopez");
        String result = dataEntry.getNextLine(scanner, "getNextLine_ReturnLine_CorrectExecution");
        if (!result.equals(data)) {
            fail("String input not valid");
        }

        result = dataEntry.getNextLine(new Scanner("Pepito"), "getNextLine_ReturnLine_CorrectExecution");
        if (!result.equals("Pepito")) {
            fail("String input not valid");
        }
    }

    @Test
    void entryName_returnName_ValidName() {
        String data = "Miguel de Cervantes";
        scanner = new Scanner("Miguel de Cervantes");
        String result = dataEntry.entryName(scanner);
        if (!result.equals(data)) {
            fail("String input not valid");
        }

        result = dataEntry.entryName(new Scanner("Pepito Perez"));
        if (!result.equals("Pepito Perez")) {
            fail("String input not valid");
        }
    }

    @Test
    void entryPhone_ThrowsNullPointerException_InputNotInformed() {
        assertThrows(NullPointerException.class, () -> dataEntry.entryPhone(null));
    }

    @Test
    void entryPhone_returnPhone_ValidPhone() {
        Long data = 34678123456L;
        scanner = new Scanner("+34678123456");
        Long result = dataEntry.entryPhone(scanner);
        assertEquals(data, result);

        result = dataEntry.entryPhone(new Scanner("12345"));
        assertEquals(12345L, result);
    }

    @Test
    void entryMail_returnMail_ValidMail() {
        String data = "Mariolopez@gmail.com";
        scanner = new Scanner("Mariolopez@gmail.com");
        String result = dataEntry.entryMail(scanner);
        if (!result.equals(data)) {
            fail("Email input not valid");
        }

        result = dataEntry.entryMail(new Scanner("pepito@correo.es"));
        if (!result.equals("pepito@correo.es")) {
            fail("Email input not valid");
        }
    }

    @Test
    void entryCompany_returnCompanyName_ValidCompanyName() {
        String data = "My Company S.A.";
        scanner = new Scanner("My Company S.A.");
        String result = dataEntry.entryCompany(scanner);
        if (!result.equals(data)) {
            fail("Company is not valid");
        }

        result = dataEntry.entryCompany(new Scanner("Ironhack"));
        if (!result.equals("Ironhack")) {
            fail("Company is not valid");
        }
    }

    @Test
    void validateName_ThrowsNameInvalidFormat_InvalidName() {
        assertThrows(NameInvalidFormat.class, () -> dataEntry.validateName("MarioLopez"));
        assertThrows(NameInvalidFormat.class, () -> dataEntry.validateName("Mario"));
        assertThrows(NameInvalidFormat.class, () -> dataEntry.validateName(""));
    }

    @Test
    void validatePhoneNumber_Throws_InvalidPhoneNumber() {
        assertThrows(PhoneInvalidFormat.class, () -> dataEntry.validatePhoneNumber(00460606061003140642016L));
        assertThrows(PhoneInvalidFormat.class, () -> dataEntry.validatePhoneNumber(0046L));
    }

    @Test
    void validateMail_Throws_InvalidEmail() {
        assertThrows(EmailInvalidFormat.class, () -> dataEntry.validateMail("Mariogmail.com"));
        assertThrows(EmailInvalidFormat.class, () -> dataEntry.validateMail("Mariogmail@asdascom"));
        assertThrows(EmailInvalidFormat.class, () -> dataEntry.validateMail("...Mariogmail@asfasf.com"));
    }

    @Test
    void validatePassword_Throws_InvalidPassword() {
        assertThrows(PasswordInvalidFormat.class, () -> dataEntry.validatePassword("123"));

    }

}