package entity;

import constant.BookType;
import constant.ReaderType;

import java.util.Scanner;

public class Book {
    private int id;
    private String name;
    private String author;
    private int publishedYear;
    private BookType bookType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
    int AUTO_ID = 100000;
    public void bookInfor(){
        this.id = AUTO_ID;
        AUTO_ID+=1;
        System.out.print("Nhập tên sách: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập tên tác giả: ");
        this.author = new Scanner(System.in).nextLine();
        System.out.print("Nhập năm xuất bản: ");
        this.publishedYear = new Scanner(System.in).nextInt();
        System.out.println("Phân loại sách");
        System.out.println("1. Khoa học tự nhiên");
        System.out.println("2. Nghê thuật - Văn học");
        System.out.println("3. Điện tử - Viễn thông");
        System.out.println("3. Công nghệ thông tin");

        System.out.print("Chọn loại sách: ");
        int temp;
        do {
            temp = new Scanner(System.in).nextInt();
            if (temp >= 1 && temp <= 4) {
                break;
            }
            System.out.print("Chọn sai mời chọn lại: ");
        } while (true);
        switch (temp) {
            case 1:
                this.bookType = BookType.KHTN;
                break;
            case 2:
                this.bookType = BookType.VH_NT;
                break;
            case 3:
                this.bookType = BookType.DTVT;
                break;
            case 4:
                this.bookType = BookType.CNTT;
                break;
        }
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishedYear=" + publishedYear +
                ", bookType=" + bookType.value +
                '}';
    }

}
