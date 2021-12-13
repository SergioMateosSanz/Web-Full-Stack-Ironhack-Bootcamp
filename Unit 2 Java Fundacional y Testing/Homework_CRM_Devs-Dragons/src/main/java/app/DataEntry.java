package app;

import validations.EmailInvalidFormat;
import validations.NameInvalidFormat;
import validations.PhoneInvalidFormat;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataEntry {

    /**
     * Method to read next line from the Scanner
     *
     * @param scanner Scanner
     * @return String
     */
    protected String getNextLine(Scanner scanner, String text) {
        System.out.println(text);
        return scanner.nextLine();
    }

    /**
     * method to add name from Input Standard into DataEntry
     *
     * @param scanner Scanner
     * @return String
     */
    public String entryName(Scanner scanner) {
        boolean validName;
        String name = null;
        do {
            validName = false;
            try {
                name = getNextLine(scanner, "Please enter name and surname");
                validateName(name);
                validName = true;
            } catch (NameInvalidFormat e) {
                System.out.println(e.getMessage());
            }
        } while (!validName);
        return name;
    }

    /**
     * method to add phone number from Input Standard into DataEntry
     *
     * @param scanner Scanner
     * @return Long
     */
    public Long entryPhone(Scanner scanner) {
        Long phoneNumber = null;
        boolean validPhone;
        do {
            validPhone = false;
            try {
                phoneNumber = Long.valueOf(getNextLine(scanner, "Please enter phone number"));
                validatePhoneNumber(phoneNumber);
                validPhone = true;
            } catch (NumberFormatException e) {
                System.out.println("The phone number entered is invalid");
            } catch (PhoneInvalidFormat e) {
                System.out.println(e.getMessage());
            }
        } while (!validPhone);
        return phoneNumber;
    }

    /**
     * Method to add email form Input Standard into DataEntry
     *
     * @param scanner Scanner
     * @return String
     */
    public String entryMail(Scanner scanner) {
        String email = null;
        boolean validMail;
        do {
            validMail = false;
            try {
                email = getNextLine(scanner, "Please enter e-mail");
                validateMail(email);
                validMail = true;
            } catch (EmailInvalidFormat e) {
                System.out.println(e.getMessage());
            }
        } while (!validMail);
        return email;
    }

    /**
     * method to add companyName into DataEntry
     *
     * @param scanner Scanner
     * @return String
     */
    public String entryCompany(Scanner scanner) {
        return getNextLine(scanner, "Please enter company name");
    }

    /**
     * method to validate a correct name
     *
     * @param name Should "firstName lastName"
     * @throws NameInvalidFormat validation of the correct imputation of the name
     */
    public void validateName(String name) throws NameInvalidFormat {
        name = name.trim();
        StringTokenizer words = new StringTokenizer(name);
        if (words.countTokens() < 2) {
            throw new NameInvalidFormat("The name entered is invalid. It must contain at least name and surname");
        }
    }

    /**
     * method to validate if the entered mail is correct
     *
     * @param phoneNumber long phoneNumber
     * @throws PhoneInvalidFormat validation of the correct imputation of the phone number
     */
    public void validatePhoneNumber(long phoneNumber) throws PhoneInvalidFormat {
        String strLong = Long.toString(phoneNumber);
        if (strLong.length() > 15 || strLong.length() < 5) {
            throw new PhoneInvalidFormat("The phone number entered is invalid");
        }
    }

    /**
     * method to validate if the phone number is correct
     *
     * @param email String email
     * @throws EmailInvalidFormat validation of the correct imputation of the email
     */
    public void validateMail(String email) throws EmailInvalidFormat {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        if (!mather.find()) {
            throw new EmailInvalidFormat("The email entered is invalid");
        }
    }

}
