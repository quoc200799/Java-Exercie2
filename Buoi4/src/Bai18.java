import java.util.Scanner;
public class Bai18 {
    public static void main(String[] args) {
        int m = NhapSo("Nhập m: ");
        int n = NhapSo("Nhập n: ");
        if (CheckNT(m, n)) {
            System.out.print("Là số nguyên tố cùng nhau");
        } else {
            System.out.print("Khong la so nguyên tố cùng nhau");
        }
    }
    public static int NhapSo(String Lenh) {
        System.out.print(Lenh);
        return new Scanner(System.in).nextInt();
    }

    public static boolean CheckNT(int m, int n) {
        int uc = 1;
        for (int i = 2; i <= m && i <= n; i++) {
            if (m % i == 0 && n % i == 0) {
                uc = i;
            }
        }
        return uc == 1;
    }
}