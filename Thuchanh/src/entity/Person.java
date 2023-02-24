package entity;

import java.util.Scanner;

public class Person implements Inforable{
    protected String name;
    protected String adress;
    protected String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public void inforInput() {
        System.out.print("Nhập tên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.adress = new Scanner(System.in).nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.phone = new Scanner(System.in).nextLine();
    }
}
