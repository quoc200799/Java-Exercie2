import java.util.Arrays;
import java.util.Scanner;

public class Bai22 {
    public static void main(String[] args) {
        System.out.print("Nhập x: ");
        int x = NhapSo();
        int[] newArr = Nhapmang();
        System.out.println(Arrays.toString(newArr));
        int[] arr = SapXep(newArr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ChenSapXep(arr, x)));

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

    public static int[] SapXep(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public static int[] ChenSapXep(int[] a, int x) {
        int[] ketqua = new int[a.length + 1];
        int marker = 0; // vị trí đánh dấu
        for (int i = 0; i < ketqua.length; i++) {
            if (a[i] > x) {
                marker = i;
                ketqua[i] = x;
                break;
            }
            ketqua[i] = a[i];
        }
        for (int i = marker + 1; i < ketqua.length; i++) {
            ketqua[i] = a[i - 1];
        }
        return ketqua;
    }
}
