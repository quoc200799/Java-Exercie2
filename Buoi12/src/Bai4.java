import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        System.out.print("Nhập chuỗi kí tự: ");
        String str = new Scanner(System.in).nextLine();
        searchMaxStr(str);
    }
    public static void searchMaxStr(String str){
        String regex = "\\s+";
        String[] split = str.trim().split(regex);
        int max = split[0].length();
        for (int i = 1; i < split.length; i++) {
            if (split[i].length() > max) {
                System.out.println("Từ dài nhất là từ: "+ split[i] + ". Xuất hiện ở vị trí thứ " + (i + 1));
            }
        }
    }
}
