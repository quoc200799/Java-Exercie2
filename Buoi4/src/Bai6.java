import java.util.Arrays;
import java.util.Scanner;

public class Bai6 {
    //Bài 6: Nhập số liệu cho dãy số nguyên a[0], a[1],..., a[n-1] và 2 số nguyên b, c (b < c).
    // Tính trung bình cộng các phần tử của dãy nằm trong đoạn [b, c].
    public static void main(String[] args) {
        System.out.print("Nhập b: ");
        int b = NhapSo();
        System.out.print("Nhập c: ");
        int c = NhapSo();
        if (b > c) {
            System.out.println("b < c.Mời nhập lại c: ");
            c = NhapSo();
        }
        int[] newArr = Nhapmang();
        System.out.println(Arrays.toString(newArr));
        System.out.println("trung bình cộng các phần tử của dãy nằm trong đoạn [b, c] là: " + TinhTrungBinhCong(newArr, b, c));
    }

    public static int NhapSo() {
        return new Scanner(System.in).nextInt();
    }

    public static int[] Nhapmang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập sô phần tử trong mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] ", i);
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static double TinhTrungBinhCong(int[] arr, int b, int c) {
        int sum = 0;
        int k = 0;
        for (int j : arr) {
            if (j >= b && j <= c) {
                sum += j;
                k++;
            }
        }
        if (k != 0) {
            return (double) sum / k;
        }
        return sum;
    }
}
