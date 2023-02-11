import java.util.Scanner;

public class Bai12 {
    //    Bài 12: Viết chương trình tính tích 2 ma trận các số nguyên A cấp mxn và B cấp n x k.
    public static void main(String[] args) {
        int m = NhapSo("Nhập số dòng của ma trận 1: ");
        int n = NhapSo("Nhập số cột va dong của ma trận 1 va 2: ");
        int k = NhapSo("Nhập số cột của ma trận 2: ");
        int[][] a = MatrixA(m, n);
        int[][] b = MatrixB(n, k);
        System.out.println("Ma trận 1: ");
        xuatMatrix(a);
        System.out.println("Ma trận 2: ");
        xuatMatrix(b);
        System.out.println("Tich 2 ma tran 1 va 2 la: ");
        xuatMatrix(TichMatrix(a, b));
    }
    public static int NhapSo(String ThongDiep) {
        System.out.print(ThongDiep);
        return new Scanner(System.in).nextInt();
    }
    public static int[][] MatrixA(int m, int n) {
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = NhapSo("a[" + i + "][" + j + "]: ");
            }
        }
        return a;
    }
    public static int[][] MatrixB(int n, int k) {
        int[][] b = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                b[i][j] = NhapSo("b[" + i + "][" + j + "]: ");
            }
        }
        return b;
    }
    public static int[][] TichMatrix(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
    public static void xuatMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
