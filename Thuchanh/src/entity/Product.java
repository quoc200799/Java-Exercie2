package entity;

import constant.ProductType;

import java.util.Scanner;

public class Product implements Inforable {
    private int id;
    private String name;
    private ProductType productType;
    private double price;
    private int quantity;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private static int AUTO_ID = 1000;

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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productType=" + productType.value +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public void inforInput() {
        this.id = AUTO_ID;
        setId(AUTO_ID++);
        System.out.print("Nhập tên mặt hàng: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Các Nhóm hàng");
        System.out.println("1. Điện tử");
        System.out.println("2. Điện lạnh");
        System.out.println("3. Máy tính");
        System.out.println("4. Thiết bị văn phòng");
        System.out.print("Nhập mặt hàng: ");

        int temp;
        while (true) {
            temp = new Scanner(System.in).nextInt();
            if (temp >= 1 && temp <= 4) {
                break;
            }
            System.out.print("Nhập sai, mời nhập lại");
        }
        switch (temp) {
            case 1:
                this.productType = ProductType.DT;
                break;
            case 2:
                this.productType = ProductType.DL;
                break;
            case 3:
                this.productType = ProductType.MT;
                break;
            case 4:
                this.productType = ProductType.TBVP;
                break;
        }
        System.out.print("Giá sản phẩm: ");
        this.price  = new Scanner(System.in).nextDouble();
        System.out.print("Số lượng: ");
        this.quantity = new Scanner(System.in).nextInt();
    }
}
