import java.util.Arrays;
import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        int[] newArr = Nhapmang();
        System.out.println(Arrays.toString(newArr));
        System.out.println(CacCapSo(newArr));
    }

    public static int[] Nhapmang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập các phần tử của mảng: ");
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
        int k = 0;
        int max = 0;
        for (int i = 0; i < arr.length- 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    a = arr[i];
                    k++;
                    if(max < k){
                        max = k;
                    }
                }
            }

        }
        return a;
    }
}
