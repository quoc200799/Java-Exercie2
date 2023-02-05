import java.util.Scanner;

public class Bai11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = 0;
        int s1 = 0;
        int s2 = 0;

        System.out.printf("Nhập n : ");
        int n = sc.nextInt();

        for (int i = 1; i < n/2; i++) {
            if ((s + i) < n) {
                s += i;
            }
        }
        System.out.println("Tổng các số tự nhiên: "+s);
        for (int i = 1; i < n/2; i++) {
            if ((s1 + i) < n && i % 2 == 0) {
                s1 += i;
            }
        }
        System.out.println("Tổng các số tự nhiên le: "+s1);
        for (int i = 1; i < n/2; i++) {
            if ((s2 + i) < n && i % 2 == 1) {
                s2 += i;
            }
        }
        System.out.println("Tổng các số tự nhiên chan: "+s2);
    }
}
