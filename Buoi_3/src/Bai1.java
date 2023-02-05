import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        int a = sc.nextInt();
        System.out.print("Nhap b: ");
        int b = sc.nextInt();
        System.out.print("Nhap c: ");
        int c = sc.nextInt();
        System.out.print("Nhap d: ");
        int d = sc.nextInt();

        int x = Math.max(a, b);
        int y = Math.max(c, d);
        System.out.println("So lon nhat la: " + Math.max(x, y));

    }
}
