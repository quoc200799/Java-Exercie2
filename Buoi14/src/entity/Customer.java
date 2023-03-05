package entity;

import contants.CustomerType;

import java.util.Scanner;

public class Customer extends Person{
    private int id;
    private CustomerType customerType;
    private static int AUTO_ID = 10000;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerType=" + customerType.value +
                ", name='" + name.trim() + '\'' +
                ", phone='" + phone.trim() + '\'' +
                ", andress='" + andress.trim() + '\'' +
                '}';
    }

    @Override
    public void inputInfor() {
        super.inputInfor();
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.println("Mời chọn loại khách hàng:");
        System.out.println("1. Cá nhân");
        System.out.println("2. Tập thể");
        System.out.println("3. Doanh nghiệp");
        System.out.print("Mời chọn: ");
        int temp;
        while (true){
            try {
                temp = new Scanner(System.in).nextInt();
                if(temp >= 1 && temp <= 3){
                    break;
                }
                System.out.print("chọn loại sai , mời chọn lại: ");

            }catch (RuntimeException e){
                System.out.print("chọn loại không đúng định dạng, mời chọn lại: ");
            }
        }
        switch (temp){
            case 1:
                this.customerType = CustomerType.CN;
                break;
            case 2:
                this.customerType = CustomerType.TT;
                break;
            case 3:
                this.customerType = CustomerType.DN;
                break;
        }

    }
}