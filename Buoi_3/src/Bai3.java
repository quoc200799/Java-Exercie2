import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so a: ");
        int a = sc.nextInt();
        System.out.print("Nhap so b: ");
        int b = sc.nextInt();
        System.out.print("Uoc chung cua so a va b: ");
        for (int i = 1; i <= a && i <= b ; i++) {
            if (a % i == 0 && b % i == 0) {
                System.out.print(" "+ i);
            }
        }
        // Tim uoc chung lon nhat
        int ucln = Math.min(a,b);
        while(true) {
            if( a % ucln == 0 && b % ucln == 0 ) {
                System.out.printf("\nUoc chung lon nhat cua a va b la: "+ ucln);
                break;
            }
            ucln--;
        }

        // Tim boi chung nho nhat
        int bcnn = Math.max(a, b);
        while(true) {
            if( bcnn % a == 0 && bcnn % b == 0 ) {
                System.out.printf("\nBội chung nhỏ nhất của %d và %d là %d.", a, b, bcnn);
                break;
            }
            bcnn++;
        }
    }
}
