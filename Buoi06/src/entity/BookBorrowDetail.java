package entity;

public class BookBorrowDetail {
    private Book book;
    private int quantityBook;

    public BookBorrowDetail(Book book, int quantityBook) {
        this.book = book;
        this.quantityBook = quantityBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantityBook() {
        return quantityBook;
    }

    public void setQuantityBook(int quantityBook) {
        this.quantityBook = quantityBook;
    }

    @Override
    public String toString() {
        return "BookBorrowDetail{" +
                "book=" + book +
                ", quantityBook=" + quantityBook +
                '}';
    }
}
