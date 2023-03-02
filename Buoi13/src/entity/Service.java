package entity;

import java.util.Scanner;

public class Service implements Inforable {
    private int id;
    private String name;
    private int price;
    private String unit;
    private static int AUTO_ID = 100;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public void inforInput() {
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập tên dịch vụ: ");
        while (true){
            name = new Scanner(System.in).nextLine();
            if(!name.trim().equals("")){
                break;
            }
            System.out.print("Tên không được để trống, mời nhập lại: ");
        }

        System.out.print("Nhập giá: ");
        while (true){
            try {
                price = new Scanner(System.in).nextInt();
                if(price >= 1000){
                    break;
                }
                System.out.print("Giá phải lớn hơn 1000 , mời chọn lại: ");

            }catch (RuntimeException e){
                System.out.print("Giá không đúng định dạng, mời chọn lại: ");
            }
        }

        System.out.print("Nhập đơn vị tính: ");
        while (true){
            unit = new Scanner(System.in).nextLine();
            if(!unit.trim().equals("")){
                break;
            }
            System.out.print("Tên không được để trống, mời nhập lại: ");
        }
    }
}
