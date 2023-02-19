package constant;

public enum BookType {
    KHTN("Khoa học tự nhiên"),
    VH_NT("Văn học - Nghệ thuật"),
    DTVT("Điện tử Viễn thông"),
    CNTT("Công nghệ thông tin");
    public String value;

    BookType(String value) {
        this.value = value;
    }
}
