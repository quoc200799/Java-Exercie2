import java.util.Arrays;
import java.util.Scanner;

public class Bai19 {
    public static void main(String[] args) {
        int[] newArr = Nhapmang();
        System.out.println(Arrays.toString(newArr));
        TinhTB(newArr);
    }

    public static int[] Nhapmang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] ", i);
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void TinhTB(int[] a) {
        int k = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            k++;
        }
        System.out.println("Trung bình cộng các phần tử trong mảng: " + (double) sum / k);
    }
}
