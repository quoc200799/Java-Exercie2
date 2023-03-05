package entity;

import java.util.Arrays;

public class BankPassbook {
    private Customer customer;
    private BankPassbookDetail[] bankPassbookDetails;
    private int totalQuantity;
    public BankPassbook(Customer customer, BankPassbookDetail[] bankPassbookDetails) {
        this.customer = customer;
        this.bankPassbookDetails = bankPassbookDetails;
        int total = 0;
        for (int i = 0; i < bankPassbookDetails.length; i++) {
            total += bankPassbookDetails[i].getQuantity();
        }
        this.totalQuantity = total;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BankPassbookDetail[] getBankPassbookDetails() {
        return bankPassbookDetails;
    }

    public void setBankPassbookDetails(BankPassbookDetail[] bankPassbookDetails) {
        this.bankPassbookDetails = bankPassbookDetails;
    }

    @Override
    public String toString() {
        return "BankPassbook{" +
                "customer=" + customer +
                ", bankPassbookDetails=" + Arrays.toString(bankPassbookDetails) +
                '}';
    }
}
