package entity;

import constant.LevelType;

import java.util.Scanner;

public class Driver extends Person {
    private int id;
    private LevelType levelType;

    public Driver(int id, LevelType levelType) {
        this.id = id;
        this.levelType = levelType;
    }

    public Driver() {

    }

    private static int AUTO_ID = 10_000;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LevelType getLevelType() {
        return levelType;
    }

    public void setLevelType(LevelType levelType) {
        this.levelType = levelType;
    }


    @Override
    public void infor() {
        super.infor();
        setId(AUTO_ID);
        Driver.AUTO_ID++;
        System.out.println("Nhập trình độ lái xe: ");
        System.out.println("1.Loại A");
        System.out.println("2.Loại B");
        System.out.println("3.Loại C");
        System.out.println("4.Loại D");
        System.out.println("5.Loại E");
        System.out.println("6.Loại F");
        System.out.print("Mời bạn chọn: ");
        int temp;
        do {
            temp = new Scanner(System.in).nextInt();
            if (temp >= 1 && temp <= 6) {
                break;
            }
            System.out.print("Nhập sai, mời nhập lại: ");
        } while (true);
        switch (temp) {
            case 1:
                this.levelType = LevelType.CLASS_A;
                break;
            case 2:
                this.levelType = LevelType.CLASS_B;
                break;
            case 3:
                this.levelType = LevelType.CLASS_C;
                break;
            case 4:
                this.levelType = LevelType.CLASS_D;
                break;
            case 5:
                this.levelType = LevelType.CLASS_E;
                break;
            case 6:
                this.levelType = LevelType.CLASS_F;
                break;
        }
    }

    @Override
    public String toString() {
        super.toString();
        return "Driver{" +
                "id=" + id +
                ", levelType=" + levelType +
                '}';
    }
}
