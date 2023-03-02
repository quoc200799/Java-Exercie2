package entity;

import java.util.Scanner;

public class Person implements Inforable{
    protected String name;
    protected String phone;
    protected String andress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAndress() {
        return andress;
    }

    public void setAndress(String andress) {
        this.andress = andress;
    }

    @Override
    public void inforInput() {
        System.out.print("Nhập tên: ");
        while (true){
            this.name = new Scanner(System.in).nextLine();
            if(!name.trim().equals("")){
                break;
            }
            System.out.print("Tên không được để trống, mời nhập lại: ");
        }
        System.out.print("Nhập số điện thoại: ");
        while (true){
            this.phone = new Scanner(System.in).nextLine();
            if(!phone.trim().equals("") && !phone.matches("/(84|0[3|5|7|8|9])+([0-9]{8})\\b/")){
                break;
            }
            System.out.print("Số điện thoại sai định dạng, mời nhập lại: ");
        }
        System.out.print("Nhập địa chỉ: ");
        while (true){
            this.andress = new Scanner(System.in).nextLine();
            if(!andress.trim().equals("")){
                break;
            }
            System.out.print("Địa chỉ không được để trống, mời nhập lại: ");
        }
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", andress='" + andress + '\'' +
                '}';
    }
}
