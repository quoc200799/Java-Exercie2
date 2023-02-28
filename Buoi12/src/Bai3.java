import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        System.out.print("Nhập chuỗi kí tự: ");
        String str = new Scanner(System.in).nextLine();

        bai3(str);
    }

    private static void bai3(String str) {
        String regex = "\\s+";
        StringBuilder s = new StringBuilder();
        String[] split =str.trim().split(regex);
        for (String value : split) {
            for (int j = 0; j < value.length(); j++) {
                if (j == 0) {
                    s.append(" ").append(String.valueOf(value.charAt(j)).toUpperCase());
                } else {
                    s.append(String.valueOf(value.charAt(j)).toLowerCase());

                }
            }
        }
        System.out.println(s.toString().trim());
    }
}
