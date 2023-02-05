import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tu nhien: ");
        int n = sc.nextInt();
        boolean check = true;

        String s = String.valueOf(n);
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) != s.charAt(size - i - 1)) {
                check = false;
                break;
            }
        }
        if (check)
            System.out.println("Đây là số thuận nghịch");
        else
            System.out.println("Đây không phải số thuận nghịch");
    }
}
