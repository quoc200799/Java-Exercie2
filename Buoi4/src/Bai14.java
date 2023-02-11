import java.util.Scanner;

public class Bai14 {
    public static void main(String[] args) {
        int m = NhapSo("Nhập m: ");
        int n = NhapSo("Nhập n: ");
        if (n >= m) {
            n = NhapSo("Nhập lại n: ");
        }
        System.out.println("trong đoạn[" + m + "," + n + "] có " + CheckChinhPhuong(m, n) + " số chính phương");
    }

    public static int NhapSo(String Lenh) {
        System.out.print(Lenh);
        return new Scanner(System.in).nextInt();
    }

    public static int CheckChinhPhuong(int m, int n) {
        int k = 0;
        for (int i = 1; i <= n; i++) {
            if (i * i >= n && i * i <= m) {
                k++;
            }

        }
        return k;
    }
}
