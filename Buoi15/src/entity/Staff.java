package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Staff extends Person implements Serializable {
    private int id;
    private int level;
    private static int AUTO_ID = 1000;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void inputInfor() {
        super.inputInfor();
        this.id = AUTO_ID++;
        int temp;
        System.out.print("Chọn bậc của thợ(1, 7): ");
        while (true){
            try {
                temp = new Scanner(System.in).nextInt();
                if(temp >= 1 && temp <= 7){
                    break;
                }
                System.out.print("chọn bậc sai(1, 7) , mời chọn lại: ");

            }catch (RuntimeException e){
                System.out.print("chọn loại không đúng định dạng, mời chọn lại: ");
            }
        }
        this.level = temp;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", andress='" + andress + '\'' +
                '}';
    }
}
