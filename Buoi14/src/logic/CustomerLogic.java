package logic;

import entity.Customer;
import util.DataUtil;
import util.file.FileUltil;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerLogic implements Serializable {
    public static String CUSTOMER_DATA_FILE = "./customer.txt";
    private FileUltil fileUltil;
    private DataUtil dataUtil;
    private Customer customer;
    private Customer[] customers;
    private int totalCustomer;

    public CustomerLogic(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public int getTotalCustomer() {
        return totalCustomer;
    }

    public void setTotalCustomer(int totalCustomer) {
        this.totalCustomer = totalCustomer;
    }

    private void initializeData() {
        Object customerFromFile = fileUltil.readDataFromFile(CUSTOMER_DATA_FILE);
        customers = DataUtil.isNullOrEmpty(customerFromFile) ? new Customer[100] : (Customer[]) customerFromFile;
    }
    public void showCustomers() {
        initializeData();
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null) {
                System.out.println(customers[i]);
            }
        }
    }

    public void addNewCustomers() {
        System.out.print("Nhập số khách hàng: ");
        int cusNumber;
        do {
            try {
                cusNumber = new Scanner(System.in).nextInt();
                if (cusNumber > 0) {
                    break;
                }
                System.out.print("Số khách hàng muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số khách hàng muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < cusNumber; i++) {
            Customer customer = new Customer();
            customer.inputInfor();
            addCustomerToArray(customer);
        }
        totalCustomer += cusNumber;
        fileUltil.writeDataToFile(customers, CUSTOMER_DATA_FILE);
    }

    public void addCustomerToArray(Customer customer) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = customer;
                break;
            }
        }
    }

    public Customer findCustomerById(int cusomerId) {
        for (int i = 0; i < customers.length; i++) {
            if (cusomerId == customers[i].getId()) {
                return customers[i];
            }
        }
        return null;
    }
}
