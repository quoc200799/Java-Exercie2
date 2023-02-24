package logic;

import entity.Product;
import entity.Staff;

import java.util.Scanner;

public class ProductLogic {
    private Product product;
    private Product[] products;
private int totalProduct;

    public int getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(int totalProduct) {
        this.totalProduct = totalProduct;
    }

    public ProductLogic(Product[] products) {
        this.products =products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    public void InputProduct() {
        System.out.print("Nhập số lượng mặt hàng: ");
        int numberProduct = 0;
        while (true) {
            numberProduct = new Scanner(System.in).nextInt();
            if (numberProduct > 0) {
                break;
            }
            System.out.print("Danh sách mặt hàng phải nhiều hơn 0, nhập lại: ");
        }
        for (int i = 0; i < numberProduct; i++) {
            if (products[i] == null) {
                product = new Product();
                product.inforInput();
                saveProduct(product);
                System.out.println("----------------------");
            }
        }
        totalProduct += numberProduct;
    }
    private void saveProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            }
        }
    }
    public void showProduct() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i]);
            }
        }
    }
    public Product searchProductById(int id){
        Product product = null;
        for (int k = 0; k < products.length; k++) {
            if (products[k] != null && products[k].getId() == id) {
                product = products[k];
                break;
            }
        }
        return product;
    }
}
