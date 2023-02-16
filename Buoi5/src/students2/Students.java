package students2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Students {
    int Code;
    String nameStudent;
    String ClassName;
    String Course;
    Scanner sc = new Scanner(System.in);
    public void Information() {

        System.out.print("Nhap ma sinh vien: ");
        this.Code = new Scanner(System.in).nextInt();

        System.out.print("Nhap ten sinh vien: ");
        this.nameStudent = new Scanner(System.in).nextLine();

        System.out.print("Nhap lop sinh vien: ");
        this.ClassName = new Scanner(System.in).nextLine();

        System.out.print("Nhap khoa hoc sinh vien: ");
        this.Course = new Scanner(System.in).nextLine();
    }

    public void nhapDanhSach() {
        System.out.print("Nhap so luong sinh vien: ");
        int n = sc.nextInt();
        Students[] newStudents = new Students[n];
        System.out.println("Nhap danh sach sinh vien: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Thong tin sinh vien thu " + (i + 1) + " la:");
            newStudents[i] = new Students();
            newStudents[i].Information();
        }
        System.out.println(Arrays.toString(newStudents));

        sortByName(newStudents);

    }

    public void sortByName(Students[] Arr) {
        System.out.println("Sap xep sinh vien theo ten: ");
        Arrays.sort(Arr, Comparator.comparing(a -> a.nameStudent));
        System.out.println(Arrays.toString(Arr));
    }
    public void getByClassName(Students[] Arr) {
        System.out.println("In danh sach sinh vien theo : ");
        for (Students student: Arr) {
//            student.ClassName;
        }
        
        Arrays.sort(Arr, Comparator.comparing(a -> a.nameStudent));
        System.out.println(Arrays.toString(Arr));
    }


}
