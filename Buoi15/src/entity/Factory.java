package entity;

import java.util.Scanner;

public class Factory implements Inforable {
    private int id;
    private String name;
    private String describe;
    private int workFactor;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getWorkFactor() {
        return workFactor;
    }

    public void setWorkFactor(int workFactor) {
        this.workFactor = workFactor;
    }

    @Override
    public void inputInfor() {
        this.id = AUTO_ID++;
        System.out.print("Nhập tên: ");
        while (true) {
            this.name = new Scanner(System.in).nextLine();
            if (!name.trim().equals("")) {
                break;
            }
            System.out.print("Tên không được để trống, mời nhập lại: ");
        }
        System.out.print("Nhập mô tả công việc : ");
        while (true) {
            this.describe = new Scanner(System.in).nextLine();
            if (!describe.trim().equals("")) {
                break;
            }
            System.out.print("Mô tả không được để trống, mời nhập lại: ");
        }
        System.out.print("Chọn hệ số công việc(1, 20): ");
        int temp;
        while (true){
            try {
                temp = new Scanner(System.in).nextInt();
                if(temp >= 1 && temp <= 20){
                    break;
                }
                System.out.print("chọn  hệ số công việc(1, 20) , mời chọn lại: ");

            }catch (RuntimeException e){
                System.out.print("Chọn không đúng định dạng, mời chọn lại: ");
            }
        }
        this.workFactor = temp;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", workFactor=" + workFactor +
                '}';
    }
}
