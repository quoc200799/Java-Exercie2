package entity;

import java.util.Scanner;

public class Banking implements Inforable{
    private int id;
    private String name;
    private int interest;
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

    public int getInterest() {
        return interest;
    }

    public void setInterest(int price) {
        this.interest = price;
    }


    @Override
    public void inputInfor() {
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập tên dịch vụ: ");
        while (true){
            name = new Scanner(System.in).nextLine();
            if(!name.trim().equals("") && name.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")){
                break;
            }
            System.out.print("Tên không được để trống, mời nhập lại: ");
        }

        System.out.print("Nhập giá: ");
        while (true){
            try {
                interest = new Scanner(System.in).nextInt();
                if(interest >= 1000){
                    break;
                }
                System.out.print("Lãi suất lớn hơn 1000 , mời chọn lại: ");

            }catch (RuntimeException e){
                System.out.print("Lãi suất không đúng định dạng, mời chọn lại: ");
            }
        }


    }
}
