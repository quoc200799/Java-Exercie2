import java.util.Locale;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        System.out.print("Nhập chuỗi kí tự: ");
        String str = new Scanner(System.in).nextLine();
        System.out.println(stringlowUp(str.trim()));
    }
    private static String stringlowUp(String str){
        StringBuilder s;
        s = new StringBuilder(String.valueOf(str.charAt(0)).toUpperCase());
        for (int i = 1; i < str.length(); i++) {
            if (i % 2 == 0) {
                s.append(String.valueOf(str.charAt(i)).toUpperCase());
            } else {
                s.append(String.valueOf(str.charAt(i)).toLowerCase());
            }
        }
        return s.toString();
    }
}
