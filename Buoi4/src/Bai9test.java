import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bai9test {
    public static void main(String[] args) {
        int[] newArr = Nhapmang();
        System.out.println(Arrays.toString(newArr));
    }

    public static int[] Nhapmang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] ", i);
            arr[i] = n;
        }
        return arr;
    }

//    public static int kiemTraMang(int n) {
//        Random generator = new Random();
//        int number = generator.nextInt(n);
//        if () {
//            return number;
//        }
//        return kiemTraMang(n);
//    }
}
