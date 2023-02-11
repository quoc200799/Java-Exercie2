import java.util.Arrays;
import java.util.Scanner;

public class Bai26 {
    public static void main(String[] args) {
        System.out.print("Nhập x: ");
        int x = NhapSo();
        int[] newArr = Nhapmang();
        System.out.println(Arrays.toString(newArr));
        SearchX(newArr,x);
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

    public static void SearchX(int[] a, int x) {
        int check = 0;
        for (int i = 0; i < a.length; i++) {
            if (x == a[i]) {
                check++;
            }
        }
        if (check == 0){
            System.out.println("x không xuất hiện trong mảng");
        }else {
            System.out.println("x xuất hiện " + check+ " lần trong mảng");
        }
    }
}
