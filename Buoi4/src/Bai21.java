import java.util.Arrays;
import java.util.Scanner;

public class Bai21 {
    public static void main(String[] args) {
        System.out.print("Nhap n: ");
        int n = NhapSo();
        System.out.println("So le: ");
        Sole(n);
        System.out.println("So chan:");
        SoChan(n);
    }

    public static int NhapSo() {
        return new Scanner(System.in).nextInt();
    }

    public static void Sole(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % 2 == 0) {
                System.out.println(" " + i);
            }
        }
    }

    public static void SoChan(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % 2 == 1) {
                System.out.println(" " + i);
            }
        }
    }
}
