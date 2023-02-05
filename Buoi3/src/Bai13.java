import java.util.Scanner;

public class Bai13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = 0;
        System.out.printf("Nhập n : ");
        int n = sc.nextInt();

        for (int i = 1; i < n / 2; i++) {
            if ((s + i) < n && (s + i) % 7 == 0) {
                s += i;
            }
        }
        if (s == 0) {
            System.out.println("So do khong thoa man dieu kien!");
        } else {
            System.out.println("Tổng các số tự nhiên: " + s);
        }

    }
}
