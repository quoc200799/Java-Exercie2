package entity;

public class BookBorrow {
    private Reader reader;
    private BookBorrowDetail[] bookBorrowDetails;

    public BookBorrow(Reader reader, BookBorrowDetail[] bookBorrowDetails) {
        this.reader = reader;
        this.bookBorrowDetails = bookBorrowDetails;
    }

    public BookBorrow() {

    }


    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public BookBorrowDetail[] getBookBorrowDetails() {
        return bookBorrowDetails;
    }
    public int totalQuantityBook (){
        int total = 0;
        for (BookBorrowDetail bookBorrowDetail : bookBorrowDetails) {
            total += bookBorrowDetail.getQuantityBook();
        }
        return total;
    }

    public void setBookBorrowDetails(BookBorrowDetail[] bookBorrowDetails) {
        this.bookBorrowDetails = bookBorrowDetails;
    }
}
