import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
//Bài 7. Nhập hai xâu S1 và S2. Tìm xâu S2 trong S1.
// Nếu có hãy loại bỏ S2 trong S1.
// Chú ý: phải loại bỏ cho đến khi không tìm được S2 trong S1 nữa.
        System.out.print("Nhập chuỗi kí tự S1: ");
        String str = new Scanner(System.in).nextLine();
        System.out.print("Nhập chuỗi kí tự S2: ");
        String str2 = new Scanner(System.in).nextLine();
        searchStrAndDelete(str, str2);

    }

    private static void searchStrAndDelete(String str, String str2) {
        String newStr = str.replace(str2, "");
        String s = "";
        System.out.print("Vị trí của S2 xuất hiện ở S1 là:");
        for (int i = 0; i < str.length(); i++) {
            s += str.charAt(i);
            if (s.contains(str2)) {
                System.out.print(" " + (i + 2 - str2.length()));
                for (int j = i; j < str.length(); j++) {
                    s = "";
                }
            }
        }
        System.out.println("\nChuỗi S1 sau khi được xóa là: " + newStr);
    }
}
