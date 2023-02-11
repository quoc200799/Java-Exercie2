import java.util.Scanner;

public class Bai27 {
    public static void main(String[] args) {
        int m = NhapSo("Nhập số dòng và cột của ma trận vuông: ");
        int[][] a =Matrix(m);
        xuatMatrix(a);
        System.out.println("Tổng đường chéo chính của ma trận này là: "+Sum(a) );
    }
    public static int NhapSo(String ThongDiep) {
        System.out.print(ThongDiep);
        return new Scanner(System.in).nextInt();
    }
    public static int[][] Matrix(int m) {
        int[][] a = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
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
    public static int Sum(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        return sum;
    }
}
