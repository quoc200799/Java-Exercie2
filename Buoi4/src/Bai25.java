import java.util.Arrays;
import java.util.Scanner;

public class Bai25 {
    public static void main(String[] args) {
        int[] newArr = Nhapmang();
        System.out.println(Arrays.toString(newArr));
        CheckChanLe(newArr);
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

    public static void CheckChanLe(int[] a) {
        int n = 0;
        int l = 0;
        for (int j : a) {
            if (j % 2 == 0) {
                n++;
            }
            if (j % 2 == 1) {
                l++;
            }
        }
        System.out.println("Mảng có " + n + " Số chẵn");
        System.out.println("Mảng có " + l + " Số lẻ");

    }
}
