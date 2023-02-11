public class Bai13 {
    public static void main(String[] args) {
        for (int i = 100000; i < 1000000; i++) {
            if (isThuanNghich(i) && DivisibleForTen(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isThuanNghich(int n) {
        String s = String.valueOf(n);
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) != s.charAt(size - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean DivisibleForTen(int a) {
        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum % 10 == 0;
    }
}
