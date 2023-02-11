import java.util.Arrays;
import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        int[] newArr = Nhapmang();
        System.out.println(Arrays.toString(newArr));
        System.out.println(CacCapSo(newArr));
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

    public static int CacCapSo(int[] arr) {
        int a = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                a++;
            }
        }
        return a;
    }
}
