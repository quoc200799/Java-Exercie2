import java.util.Scanner;

public class Bai12 {
    public static void main(String[] args) {
        //Bài 12: Nhập vào 2 số tự nhiên m và n,sao cho m < n.
        // Hãy liệt kê các số chính phương trong đoạn [m,n].
        // Có bao nhiêu số chính phương?
        Scanner sc = new Scanner(System.in);
        int s = 0;
        int x = 0;
        System.out.print("Nhập n : ");
        int n = sc.nextInt();
        System.out.print("Nhập m : ");
        int m = sc.nextInt();
        if (m < n) {
            System.out.print("Các số chính phương trong đoạn [m,n]: ");
            for (int i = 0; i < m; i++) {
                if (i * i <= n && i * i >= m) {
                    s = i * i;
                    System.out.print(" " + s);
                    x++;
                }
            }
            System.out.println("\nCó " + x + " số chính phương");
        } else {
            System.out.println("khong thoa man dieu kien m < n cua de bai");
        }
    }
}
