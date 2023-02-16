package rectange;

import java.util.Scanner;

public class Rectange {
    double width;
    double height;
    String color;

    public Rectange() {
        this.width = 1;
        this.height = 1;
    }

    public Rectange(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        while (this.width < 0) {
            System.out.print("Chieu rong phai lon hon 0, Moi nhap lai: ");
            this.width = new Scanner(System.in).nextDouble();
            if (this.width > 0) {
                break;
            }
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
            while (width > height) {
                System.out.print("Chieu dai phai lon hon chieu rong, Moi nhap lai: ");
                this.height = new Scanner(System.in).nextDouble();
                if (width < this.height) {
                    break;
                }
            }
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public double findArea() {
        return getWidth() * getHeight();
    }

    public double findPerimeter() {
        return (getWidth() + getHeight()) * 2;
    }
}
