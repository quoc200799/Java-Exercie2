import java.util.Scanner;

public class Bai23 {
    public static void main(String[] args) {
        int m = NhapSo("Nhập số dòng của ma trận: ");
        int n = NhapSo("Nhập số cột của ma trận: ");
        int[][] a = Matrix(m, n);
        xuatMatrix(a);
        SearchMaxMin(a);
    }

    public static int NhapSo(String ThongDiep) {
        System.out.print(ThongDiep);
        return new Scanner(System.in).nextInt();
    }

    public static int[][] Matrix(int m, int n) {
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

    public static void SearchMaxMin(int[][] arr) {
        int max = arr[0][0];
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng: " + max);
        System.out.println("Phần tử nhỏ nhất trong mảng: " + min);
    }

}
