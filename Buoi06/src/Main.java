import entity.Book;
import entity.BookBorrow;
import entity.BookBorrowDetail;
import entity.Reader;

import java.util.Scanner;

public class Main {
    public static Reader[] readers;
    public static Book[] books;
    public static BookBorrow[] bookBorrows;
    public static BookBorrow bookBorrowst;


    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            showMenuContent();
            logicHandle();
        }
    }

    private static void logicHandle() {
        int functionChoice = handleFunctionChoice();
        switch (functionChoice) {
            case 1:
                inputReader();
                break;
            case 2:
                showReader();
                break;
            case 3:
                inputBook();
                break;
            case 4:
                showBook();
                break;
            case 5:
                borrow();
                break;
            case 6:
                sortByReader();
                sortByQuantityBook();
                break;
            case 7:
                searchReader();
                break;
            case 8:
                System.exit(0);
        }
    }

    private static void borrow() {
        System.out.println("Có bao nhiêu khách muốn mượn sách");
        int readerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNumber; i++) {
            System.out.println("Nhập mã bạn đọc thứ " + (i + 1) + " muốn mượn sách: ");
            int readerId;
            Reader reader = null;
            do {
                readerId = new Scanner(System.in).nextInt();
                for (int j = 0; j < readers.length; j++) {
                    if (readers[j].getCodeReader() == readerId) {
                        reader = readers[j];
                        break;
                    }
                }
                if (reader != null) {
                    break;
                }
                System.out.println("Nhập sai mã bạn đọc, mời nhập lại: ");
            } while (true);

            System.out.print("Nhập số lượng đầu sách bạn đọc muốn mượn sách: ");
            int bookQuantity;
            do {
                bookQuantity = new Scanner(System.in).nextInt();
                if (bookQuantity <= 5 && bookQuantity > 0) {
                    break;
                }
                System.out.print("Số lượng không hợp lệ vui lòng nhập lại: ");

            } while (true);
            BookBorrowDetail[] bookBorrows = new BookBorrowDetail[bookQuantity]; // sách mượn
            for (int j = 0; j < bookQuantity; j++) {
                System.out.println("Cuốn sách thứ " + (j + 1) + " mà bạn đọc này muốn mượn mã là: ");
                int bookId;
                Book book;
                do {
                    bookId = new Scanner(System.in).nextInt();
                    book = null;
                    for (Book value : books) {
                        if (value.getId() == bookId) {
                            book = value;
                            break;
                        }
                    }
                    if (book != null) {
                        break;
                    }
                    System.out.println("Nhập sai mã bạn đọc, mời nhập lại: ");
                } while (true);

                System.out.print("Số lượng cuốn muốn mượn ở đầu sách này: ");
                int temp;
                do {
                    temp = new Scanner(System.in).nextInt();
                    if (temp <= 3 && temp > 0) {
                        break;
                    }
                    System.out.print("Số lượng không hợp lệ vui lòng nhập lại: ");
                } while (true);
                BookBorrowDetail bookBorrowDetail = new BookBorrowDetail(book, temp);
                bookBorrows[j] = bookBorrowDetail;
            }

            BookBorrow bookBorrow = new BookBorrow(reader, bookBorrows);
            saveBookBorrow(bookBorrow);
            showBookBorrow();
        }

    }

    private static void saveBookBorrow(BookBorrow bookBorrow) {
        for (int i = 0; i < bookBorrows.length; i++) {
            if (bookBorrows[i] == null) {
                bookBorrows[i] = bookBorrow;
                break;
            }
        }
    }

    private static void showBookBorrow() {
        if (bookBorrows == null || bookBorrows.length == 0) {
            System.out.println("Chưa có danh sách bạn đọc mượn sách");
            return;
        }
        System.out.println("In danh sách bạn đọc mượn sách: ");
        for (int i = 0; i < bookBorrows.length; i++) {
            System.out.println(bookBorrows[i]);
        }

    }

    private static int handleFunctionChoice() {
        System.out.print("Xin mời nhập chức năng: ");
        int functionChoice;
        while (true) {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 8) {
                break;

            }
            System.out.print("Nhập sai, mời nhập lại: ");
        }
        return functionChoice;
    }

    private static void showMenuContent() {
        System.out.println("===== Phần mềm quản lý mượn sách =====");
        System.out.println("1. Nhập danh sách bạn đọc mới");
        System.out.println("2. In ra danh sách bạn đọc");
        System.out.println("3. Nhập danh sách cuốn sách mới");
        System.out.println("4. In danh sách cuốn sách");
        System.out.println("5. Cho mượn sách");
        System.out.println("6. Sắp xếp danh sách mượn sách");
        System.out.println("7. Tìm kiếm danh sách mượn sách");
        System.out.println("8. Thoát");
        System.out.println("----------------------------------------");
    }

    private static void showReader() {
        if (readers == null || readers.length == 0) {
            System.out.println("Chưa có danh sách bạn đọc");
            return;
        }
        System.out.println("In danh sách bạn đọc: ");
        for (int i = 0; i < readers.length; i++) {
            System.out.println(readers[i]);
        }

    }

    private static void inputReader() {
        System.out.print("Mời bạn nhập số lượng bạn đọc mới: ");
        int numberReaders = new Scanner(System.in).nextInt();
        readers = new Reader[numberReaders];
        for (int i = 0; i < numberReaders; i++) {
            readers[i] = new Reader();
            readers[i].inputInfor();
        }
    }

    private static void showBook() {
        if (books == null || books.length == 0) {
            System.out.println("Chưa có danh sách bạn đọc");
            return;
        }
        System.out.println("In danh sách bạn đọc: ");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }

    }

    private static void inputBook() {
        System.out.print("Mời bạn nhập số lượng bạn đọc mới: ");
        int numberBook = new Scanner(System.in).nextInt();
        books = new Book[numberBook];
        for (int i = 0; i < numberBook; i++) {
            books[i] = new Book();
            books[i].bookInfor();
        }
    }

    public static void searchReader() {
        System.out.print("Nhập tên bạn đọc bạn muốn tìm kiếm: ");
        String name;
        for (BookBorrow bookBorrow : bookBorrows) {
            do {
                name = new Scanner(System.in).nextLine();
                if (bookBorrow.getReader().getfullName().equalsIgnoreCase(name)) {
                    System.out.println(bookBorrow);
                    break;
                }
                System.out.println("Sai tên, cần nhập lại: ");
            } while (true);
        }
    }

    public static void sortByReader() {
        String bookBorro;
        for (int i = 0; i < bookBorrows.length; i++) {
            for (int j = i + 1; j < bookBorrows.length; j++) {
                bookBorro = bookBorrows[j + 1].getReader().getfullName();
                if (bookBorrows[j].getReader().getfullName().compareTo(bookBorro) > 0) {
                    bookBorrowst = bookBorrows[j];
                    bookBorrows[j] = bookBorrows[j + 1];
                    bookBorrows[j + 1] = bookBorrowst;
                }
            }
        }
    }
    public static void sortByQuantityBook() {
        for (int i = 0; i < bookBorrows.length; i++) {
            for (int j = i + 1; j < bookBorrows.length; j++) {
                if (bookBorrows[j].totalQuantityBook() < bookBorrows[j + 1].totalQuantityBook()) {
                    bookBorrowst = bookBorrows[j];
                    bookBorrows[j] = bookBorrows[j + 1];
                    bookBorrows[j + 1] = bookBorrowst;
                }
            }
        }
    }
}