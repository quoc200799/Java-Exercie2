package entity;

import java.util.Scanner;

public class Person {
    protected String fullName;
    protected String andress;
    protected int phone;

    public Person() {}
    public String getfullName() {
        return fullName;
    }
    public void setfullName(String fullName) {
        this.fullName = fullName;
    }
    public String getAndress() {
        return andress;
    }
    public void setAndress(String andress) {
        this.andress = andress;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", andress='" + andress + '\'' +
                ", phone=" + phone +
                '}';
    }
    public void inputInfor(){
        System.out.print("Nhập họ tên: ");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.andress = new Scanner(System.in).nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.phone = new Scanner(System.in).nextInt();
    }
}
