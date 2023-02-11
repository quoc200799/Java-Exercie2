public class Bai1 {
    public static void main(String[] args) {

        for (int i = 100000000; i < 1000000000; i++) {
            if (isThuanNghich(i) && chooseNumber(i) && sumTen(i)) {
                System.out.print(" " + i);
            }
        }
    }

    public static boolean isThuanNghich(int n) {
        boolean check = true;
        String s = String.valueOf(n);
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) != s.charAt(size - i - 1)) {
                check = false;
                return check;
            }
        }
        return check;
    }

    public static boolean sumTen(int n) {
        int sum = 0;
        while (n > 0) {
            int number = n % 10;
            sum += number;
            n /= 10;
        }
        return sum == 10;
    }

    public static boolean chooseNumber(int n) {
        boolean check = false;
        String s = String.valueOf(n);
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '7' || s.charAt(i) == '9') {
                return false;
            }
        }
        return true;
    }
}
