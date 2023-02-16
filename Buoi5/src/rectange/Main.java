package rectange;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectange rectanges = new Rectange();
        System.out.print("Chieu rong hinh chu nhat: ");
        rectanges.setWidth(sc.nextDouble());
        System.out.print("Chieu dai hinh chu nhat: ");
        rectanges.setHeight(sc.nextDouble());
        System.out.print("Mau cua hinh chu nhat: ");
        rectanges.setColor(new Scanner(System.in).nextLine());
        System.out.print("Mau HCN: ");
        System.out.println(rectanges.getColor());
        System.out.print("Chu vi HCN: ");
        System.out.println(rectanges.findArea());

        System.out.print("Dien tich HCN: ");
        System.out.println(rectanges.findPerimeter());


    }
}
