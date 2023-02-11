import java.util.Arrays;
import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        int[] newArr = Nhapmang();
        System.out.println(Arrays.toString(newArr));
//        System.out.println(Arrays.toString(SapXep(newArr)));
    }

    public static int[] Nhapmang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] ", i);
            arr[i] = sc.nextInt();
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]){
                    System.out.printf("Đã nhập trùng với phần tử a[%d] trong mảng, mời nhập lại a[%d]: ", j, i );
                    arr[i] = sc.nextInt();
                }
            }
        }
        return arr;
    }
}
