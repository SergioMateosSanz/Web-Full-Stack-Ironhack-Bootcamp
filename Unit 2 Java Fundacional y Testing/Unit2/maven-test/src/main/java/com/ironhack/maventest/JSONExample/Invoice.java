package com.ironhack.maventest.JSONExample;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Invoice {
    private String id;
    private BigDecimal total;
    private boolean isPaid;
    private ArrayList<InvoiceItem> invoiceItems;

    public Invoice(String id, BigDecimal total, boolean isPaid, ArrayList<InvoiceItem> invoiceItems) {
        this.id = id;
        this.total = total;
        this.isPaid = isPaid;
        this.invoiceItems = invoiceItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public ArrayList<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(ArrayList<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", total=" + total +
                ", isPaid=" + isPaid +
                ", invoiceItems=" + invoiceItems +
                '}';
    }
}
