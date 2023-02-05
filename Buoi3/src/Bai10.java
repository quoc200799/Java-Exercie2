import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 0;
        System.out.printf("Nhập vào chiều cao : ");
        int h = sc.nextInt();
        for (int i = 1; i <= h; ++i, k = 0) {
            for (int j = 1; j <= h - i; ++j) {
                System.out.print(" ");
            }
            while (k != 2 * i - 1) {
                System.out.print("* ");
                ++k;
            }
            System.out.print("\n");
        }
    }
}
