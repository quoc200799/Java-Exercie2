import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Canh Ngang: ");
        int a = sc.nextInt();
        System.out.print("Nhap Canh Dung: ");
        int b = sc.nextInt();
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if ((j == 1) || (j == a) || (i == 1) || (i == b)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
