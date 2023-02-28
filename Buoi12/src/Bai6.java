import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        checkStr();
    }

    private static void checkStr() {
        String str;
        String[] split;
        String regex = "\\s+";
        while (true) {
            System.out.print("Nhập chuỗi kí tự: ");
            str = new Scanner(System.in).nextLine();
            split = str.trim().split(regex);
            if (split.length < 20) {
                break;
            }
            System.out.print("Câu không được quá 20 từ, mời nhập lại: ");
        }
        checkTu(split);
    }


    private static void checkTu(String[] split) {
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() > 10) {
                System.out.print("Từ không được quá 10 ký tự, mời nhập lại: ");
                checkStr();
                break;
            }
        }
        sortByStr(split);
        showSplit(split);

    }

    private static void sortByStr(String[] split) {
        for (int i = 0; i < split.length - 1; i++) {
            for (int j = i + 1; j < split.length; j++) {
                if (split[j].compareToIgnoreCase(split[i]) < 0) {
                    String temp = split[i];
                    split[i] = split[j];
                    split[j] = temp;
                }
            }

        }
    }
    private static void showSplit(String[] split) {
        for (String s : split) {
            if (s.length() < 10) {
                System.out.println(s);
            }
        }
    }
}
