import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Canh Dung: ");
        int a = sc.nextInt();
        System.out.print("Nhap Canh Ngang: ");
        int b = sc.nextInt();

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }

    }
}
