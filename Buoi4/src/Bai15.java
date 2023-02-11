import java.util.Arrays;
import java.util.Scanner;

public class Bai15 {
    public static void main(String[] args) {
        System.out.print("Nhập n: ");
        int n = NhapSo();
        if (n <= 0) {
            System.out.print("n > 0. Mời nhập lại n: ");
            n = NhapSo();
        }
        System.out.println("Tổng: " + TinhTong(n));
    }

    public static int NhapSo() {
        return new Scanner(System.in).nextInt();
    }
    public static double TinhTong(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum +=  (double) 1 / i;
        }
        return sum;
    }
}
