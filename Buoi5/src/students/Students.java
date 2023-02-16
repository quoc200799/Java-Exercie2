package students;

import java.util.Scanner;

public class Students {
    int Code;
    String nameStudent;
    String ClassName;
    String Course;
    Scanner sc = new Scanner(System.in);


    public void Information(){
        System.out.print("Nhap ma sinh vien: ");
        this.Code = new Scanner(System.in).nextInt();

        System.out.print("Nhap ten sinh vien: ");
        this.nameStudent = new Scanner(System.in).nextLine();

        System.out.print("Nhap lop sinh vien: ");
        this.ClassName = new Scanner(System.in).nextLine();

        System.out.print("Nhap khoa hoc sinh vien: ");
        this.Course = new Scanner(System.in).nextLine();
    }
    @Override
    public String toString() {
        return "Students{" +
                "Code=" + Code +
                ", NameStudent='" + nameStudent + '\'' +
                ", ClassName='" + ClassName + '\'' +
                ", Course=" + Course +
                '}';
    }


}
