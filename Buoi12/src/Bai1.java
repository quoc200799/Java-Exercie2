
public class Bai1 {
    public static void main(String[] args) {
        for (int i = 100000; i <= 999999; i++) {
            if (testSoThuanNghich(i)) {
                System.out.println(i);
            }
        }
    }
    public static boolean testSoThuanNghich(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "" + i;
        stringBuilder.append(str);
        String check = "" + stringBuilder.reverse();
        if (str.equals(check)){
            return true;

        }
        else return false;
    }
}