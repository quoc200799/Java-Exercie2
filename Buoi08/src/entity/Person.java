package entity;

import java.util.Scanner;

public class Person implements Inputable{
    protected String name;
    protected String andress;
    protected String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAndress() {
        return andress;
    }

    public void setAndress(String andress) {
        this.andress = andress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void infor() {
        System.out.print("Nhập tên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.andress = new Scanner(System.in).nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.phone = new Scanner(System.in).nextLine();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", andress='" + andress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
