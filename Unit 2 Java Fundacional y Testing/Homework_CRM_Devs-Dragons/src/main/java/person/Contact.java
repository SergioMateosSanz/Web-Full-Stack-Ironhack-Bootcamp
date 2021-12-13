package person;

public class Contact extends Person {

    private static int totalContact = 0;
    private int id;


    public Contact(String name, long phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
        this.id = totalContact++;
    }


    public int getId() {
        return id;
    }

    public int getTotalContact() {
        return totalContact;
    }

    public String toString() {

        String name = String.format("%-30s", this.getName());
        String phoneNumber = String.format("%-24s", this.getPhoneNumber());
        String email = String.format("%-40s", this.getEmail());
        String companyName = String.format("%-40s", this.getCompanyName());

        return  name + phoneNumber + email + companyName;

    }
}
