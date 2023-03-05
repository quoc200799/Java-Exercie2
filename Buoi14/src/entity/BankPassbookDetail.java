package entity;

public class BankPassbookDetail {
    private Banking banking;
    private int quantity;

    public BankPassbookDetail(Banking banking, int quantity) {
        this.banking = banking;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "service=" + banking +
                ", quantity=" + quantity +
                '}';
    }

    public Banking getBanking() {
        return banking;
    }

    public void setBanking(Banking banking) {
        this.banking = banking;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
