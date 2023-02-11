import java.util.Arrays;
import java.util.Scanner;

public class Bai20 {
    public static void main(String[] args) {
        int[] newArr = Nhapmang();
        System.out.println(Arrays.toString(newArr));
        TimSoLN(newArr);
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

    public static void TimSoLN(int[] Arr) {
        int max = Arr[0];
        int vitri = 0;
        for (int i = 1; i < Arr.length - 1; i++) {
            if (max < Arr[i]) {
                max = Arr[i];
                vitri = i;
            }
        }
        System.out.println("Số lớn nhất xuất hiện trong mảng: " + max);
        System.out.println("Vị trí xuất hiện đầu tiên của nó là: " + vitri);
    }
}
