import java.util.Scanner;

public class Bai14 {
    public static void main(String[] args) {
        //Bài 14: Nhập số tự nhiên n rồi in ra các số chẵn nhỏ hơn n và các số lẻ nhỏ hơn n.
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        System.out.print("chan:");
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print(" " + i);
            }
        }
        System.out.print("\nle:");

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                System.out.print(" " + i);
            }
        }


    }
}
