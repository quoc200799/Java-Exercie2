package mypoint;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("So diem: ");
        int n = new Scanner(System.in).nextInt();
        MyPoint[] listPoints = new MyPoint[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap toa do x cua diem " + (i + 1) + " : ");
            double x = new Scanner(System.in).nextDouble();
            System.out.print("Nhap toa do y cua diem " + (i + 1) + " : ");
            double y = new Scanner(System.in).nextDouble();
            listPoints[i] = new MyPoint(x, y);
            System.out.println("Toa do diem " + (i + 1) + " : " + listPoints[i]);

        }
        System.out.println(Arrays.toString(listPoints));
        MyPoint point = new MyPoint();

        double max = point.distances(listPoints[0], listPoints[1]);

        double xmax1 = 0;
        double ymax1 = 0;
        double xmax2 = 0;
        double ymax2 = 0;
        int imax = 0;
        int jmax = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double cout = point.distances(listPoints[i], listPoints[j]);
                if (max < cout) {
                    max = cout;
                    xmax1 = listPoints[i].getX();
                    ymax1 = listPoints[i].getY();
                    xmax2 = listPoints[j].getX();
                    ymax2 = listPoints[j].getY();
                    imax = i + 1;
                    jmax = j + 1;
                }
            }
        }
        System.out.println("Toa do diem 2 diem co khoang cach lon nhat la: ");

        System.out.printf("Toa do diem %d : {x=%.2f, y=%.2f} \n", imax, xmax1, ymax1);
        System.out.printf("Toa do diem %d : {x=%.2f, y=%.2f} \n", jmax, xmax2, ymax2);

        System.out.printf("Gia tri khoang cach cua chung %.2f", max);
    }
}
