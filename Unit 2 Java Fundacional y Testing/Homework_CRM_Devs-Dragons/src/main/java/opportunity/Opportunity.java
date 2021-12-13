package opportunity;

import person.Contact;

public class Opportunity {
    private static int totalOpportunity = 0;
    private int id;
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status) {
        this.id = totalOpportunity++;
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
    }

    public Opportunity() {
    }

    public static int getTotalOpportunity() {
        return totalOpportunity;
    }

    public static void setTotalOpportunity(int totalOpportunity) {
        Opportunity.totalOpportunity = totalOpportunity;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {

        String idToShow = String.format("%-10s", id);
        String productToShow = String.format("%-15s", product);
        String quantityToShow = String.format("%-10s", quantity);
        String decisionMakerToShow = String.format("%-40s", decisionMaker);
        String statusToShow = String.format("%-10s", status);

        return  idToShow + productToShow + quantityToShow + decisionMakerToShow + statusToShow;

    }

    /**
     * method to change Opportunity status
     *
     * @param status new status
     */
    public void changeOpportunityStatus(Status status) {
        if (this.getStatus() != status) {
            this.setStatus(status);
        }
    }
}
