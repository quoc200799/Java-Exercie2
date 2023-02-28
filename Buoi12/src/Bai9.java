import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        //Bài 9. Chèn chuỗi S1 vào chuỗi S2 ở vị trí k biết trước với S1, S2 và k nhập vào từ bàn phím.
        System.out.print("Nhập chuỗi kí tự S2: ");
        String str = new Scanner(System.in).nextLine();
        System.out.print("Nhập chuỗi kí tự S1: ");
        String str2 = new Scanner(System.in).nextLine();
        System.out.print("Nhập k: ");
        int k = new Scanner(System.in).nextInt();
        System.out.println("chuỗi sau khi được chèn: " + insertStr(str.trim(), str2.trim(), k));
    }

    public static String insertStr(String str, String str2, int k) {
        StringBuilder newStr = new StringBuilder(str);
        newStr.insert(k, str2);
        return newStr.toString();
    }
}
