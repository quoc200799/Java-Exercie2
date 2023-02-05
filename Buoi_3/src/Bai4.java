import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tu nhien: ");
        int n = sc.nextInt();
        boolean check = true;
        System.out.print("Day so nguyen to la:");
        for (int i = 2; i < n; i++) {
            check = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    check = false;
                    break;
                }
            }
            if (check){
                System.out.print(" " + i);
            }
        }

    }
}
