package entity;

import java.util.Scanner;

public class Buses implements Inputable{
    private int id;
    private double distance;
    private int point;

    private static int AUTO_ID = 100;

    public Buses() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Buses(int id, double distance, int point) {
        this.id = id;
        this.distance = distance;
        this.point = point;
    }
    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", distance=" + distance +
                ", point=" + point +
                '}';
    }

    @Override
    public void infor() {
        setId(AUTO_ID);
        Buses.AUTO_ID++;
        System.out.print("Nhập khoảng cách: ");
        this.distance = new Scanner(System.in).nextDouble();
        System.out.print("Số điểm dừng: ");
        this.point = new Scanner(System.in).nextInt();
    }
}
