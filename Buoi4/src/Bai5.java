import java.util.Arrays;
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        int[] newArr = Nhapmang();
        System.out.println(Arrays.toString(newArr));
        SearchMaxSe(newArr);
    }

    public static int NhapSo() {
        return new Scanner(System.in).nextInt();
    }

    public static int[] Nhapmang() {
        System.out.print("Nhập sô phần tử trong mảng: ");
        int n = NhapSo();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] ", i);
            arr[i] = NhapSo();
        }
        return arr;
    }

    public static void SearchMaxSe(int[] a) {
        int max = a[0];
        int max2 = a[1];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max2 = max;
                max = a[i];
            } else if (a[i] < max && a[i] > max2) {
                max2 = a[i];
            }
        }
        System.out.println("Số lớn thu 2 trong mảng là: " + max2);
    }
}
