import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
      // Nhap so tu nhien n roi liet ke uoc so cua no.
        Scanner sc = new Scanner(System.in);
        int a = 0;
        System.out.print("Nhap so tu nhien n: ");
        int n = sc.nextInt();
        System.out.print("Uoc so cua n la:");
        for (int i = 1; i <= n; i++) {
            int x = n % i;
                if (x == 0 ) {
                    System.out.print(" " + i);
                    a++;
                }
        }
        System.out.print("\nCo "+ a +" uoc so.");
    }
}
