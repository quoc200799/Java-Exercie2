package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Staff extends Person{
    private int id;
    private LocalDate date;
    private static int AUTO_ID = 1000;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void inforInput() {
        super.inforInput();
        this.id = AUTO_ID;
        setId(AUTO_ID++);
//        System.out.print("");
        this.date = addDate();

    }
    public static LocalDate addDate() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập ngày ký hợp đồng theo form [dd/MM/yyyy]: ");
        String str = scan.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(str, dtf);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
