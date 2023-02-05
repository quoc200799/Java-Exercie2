import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chieu cao: ");
        int a = sc.nextInt();
        String x = "* ";
        String rs = "";
        for (int i = 1; i <= a; i++) {
                rs += x;
                System.out.println(rs);

        }
    }
}