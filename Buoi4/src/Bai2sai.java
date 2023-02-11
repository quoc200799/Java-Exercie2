public class Bai2sai {
    public static void main(String[] args) {
        for (int i = 10000000; i < 100000000; i++) {
            if (isNguyenTo(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isNguyenTo(int n) {
        for (int i = 2; i < n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean AllNguyenTo(int n) {
        for (int i = 2; i < n; i++) {
           int x = n % 10;
        }
        return true;
    }
}
