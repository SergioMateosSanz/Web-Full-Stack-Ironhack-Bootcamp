package person;

public class Lead extends Person {

    private static int totalLead = 0;
    private int id;

    public Lead(String name, long phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
        this.id = totalLead++;
    }

    public int getId() {
        return id;
    }

    public static int getTotalLead() {
        return totalLead;
    }

    @Override
    public String toString() {
        String id = String.format("%-10s", this.id);
        String name = String.format("%-40s", this.getName());

        return  id + name ;

    }

}
