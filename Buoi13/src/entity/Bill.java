package entity;

import java.util.Arrays;

public class Bill {
    private Customer customer;
    private BillDetail[] billDetails;
    private int totalQuantity;

    public Bill(Customer customer, BillDetail[] billDetails) {
        this.customer = customer;
        this.billDetails = billDetails;
        int total = 0;
        for (int i = 0; i < billDetails.length; i++) {
            total += billDetails[i].getQuantity();
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

    public BillDetail[] getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(BillDetail[] billDetails) {
        this.billDetails = billDetails;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "customer=" + customer +
                ", billDetails=" + Arrays.toString(billDetails) +
                '}';
    }
}
