import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        System.out.print("Nhập chuỗi kí tự: ");
        String str = new Scanner(System.in).nextLine();
        nameFirstName(str);
    }

    private static void nameFirstName(String str) {
        String regex = "\\s+";
        String[] split = str.trim().split(regex);
        String s = "";
        s= split[split.length -1] ;
        for (int i = 0; i < split.length-1; i++) {
            s += " " + split[i];
        }
        System.out.println(s);
    }

}
