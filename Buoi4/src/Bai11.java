import java.util.Arrays;
import java.util.Scanner;

public class Bai11 {
    //Bài 11: Viết chương trình nhập số liệu cho ma trận các số nguyên A cấp m x n trong đó m, n là các số tự nhiên.
    // Sau đó tìm ma trận chuyển vị B = (b[i][j]) cấp n x m của A, với b[i][j] = a[j][i]
    public static void main(String[] args) {
        int m = NhapSo("Nhập số dòng của ma trận: ");
        int n = NhapSo("Nhập số cột của ma trận: ");
        int[][] a =MatrixA(m, n);
        xuatMatrix(a);
        xuatMatrix(MatrixB(a));
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
    public static void xuatMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] MatrixB(int[][] A) {
        int[][] B = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
