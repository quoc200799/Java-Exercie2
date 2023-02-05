import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        System.out.print("Nhap n: ");
        int n = sc.nextInt();

        while (n <= 0 ){
            System.out.print("So n phai lon hon 0, moi nhap lai: ");
            n = sc.nextInt();
        }
        while (n > 0){
            int number = n % 10;
            sum += number;
            n /= 10;
        }
        System.out.print("Tong chu so cua so nguyen n: "+ sum);
    }
}
