package logic;

import entity.Customer;

import java.util.Scanner;

public class CustomerLogic {
    private Customer customer;
    private Customer[] customers;
    private int totalCustomer;

    public CustomerLogic(Customer[] customers) {
        this.customers = customers;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public int getTotalCustomer() {
        return totalCustomer;
    }

    public void setTotalCustomer(int totalCustomer) {
        this.totalCustomer = totalCustomer;
    }
    public void InputCustomer() {
        System.out.print("Nhập số lượng khách hàng: ");
        int numberCustomer;
        while (true) {
            try {
                numberCustomer = new Scanner(System.in).nextInt();
                if (numberCustomer > 0) {
                    break;
                }
                System.out.print("Danh sách khách hàng phải nhiều hơn 0, nhập lại: ");
            }catch (Exception e){
                System.out.print("Nhập sai định dạng, mời nhập laại: ");
            }

        }
        for (int i = 0; i < numberCustomer; i++) {
            if (customers[i] == null) {
                customer = new Customer();
                customer.inforInput();
                saveCustomer(customer);
                System.out.println("----------------------");
            }
        }
        totalCustomer += numberCustomer;
    }
    private void saveCustomer(Customer customer) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = customer;
                break;
            }
        }
    }
    public void showCustomer() {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null) {
                System.out.println(customers[i]);
            }
        }
    }
    public Customer searchCustomerById(int id){
        Customer customer = null;
        for (int k = 0; k < customers.length; k++) {
            if (customers[k] != null && customers[k].getId() == id) {
                customer = customers[k];
                break;
            }
        }
        return customer;
    }
}
