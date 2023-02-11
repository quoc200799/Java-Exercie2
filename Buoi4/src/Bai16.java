import java.util.Arrays;
import java.util.Scanner;

public class Bai16 {
    //Bài 16: Nhập số tự nhiên n rồi
    // tính tổng các số tự nhiên không lớn hơn n và chia hết cho 7.
    public static void main(String[] args) {
        int n = NhapSo("Nhập n: ");
        if (n < 0) {
            n = NhapSo("n>0. Mời nhập lại n: ");
        }
        System.out.println("tổng các số tự nhiên không lớn hơn n và chia hết cho 7 là: " +Sum(n));
    }

    public static int NhapSo(String Lenh) {
        System.out.print(Lenh);
        return new Scanner(System.in).nextInt();
    }

    public static int Sum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
