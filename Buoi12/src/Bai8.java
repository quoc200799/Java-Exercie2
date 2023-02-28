import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        //Bài 8. Tìm kiếm vị trí xuất hiện đầu tiên của chuỗi S1 trong S2.
        // Nếu không tìm thấy trả về -1.
        System.out.print("Nhập chuỗi kí tự S2: ");
        String str = new Scanner(System.in).nextLine();
        System.out.print("Nhập chuỗi kí tự S1: ");
        String str2 = new Scanner(System.in).nextLine();
        if (searchStr(str, str2) == -1) {
            System.out.println("Chuỗi S1 không xuất hiện trong S2");
        } else {
            System.out.print("Chuỗi S1 xuất hiện lần đầu tiên ở vị trí thứ: " + searchStr(str, str2) + " trong chuỗi s2");

        }

    }

    private static int searchStr(String str, String str2) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            s.append(str.charAt(i));
            if (s.toString().contains(str2.trim())) {
                return i + 1 - str2.length();
            }
        }
        return -1;
    }
}
