package entity;

import constant.ReaderType;

import java.util.Scanner;

public class Reader extends Person {
    private int codeReader;
    private ReaderType readerType;

    public int getCodeReader() {
        return codeReader;
    }

    public void setCodeReader(int codeReader) {
        this.codeReader = codeReader;
    }

    public ReaderType getReaderType() {
        return readerType;
    }

    public void setReaderType(ReaderType readerType) {
        this.readerType = readerType;
    }
    private int AUTO_ID = 100000;

    @Override
    public void inputInfor() {
        super.inputInfor();
        this.codeReader = AUTO_ID++;
        System.out.println("Phân loại bạn đọc");
        System.out.println("1. Sinh viên");
        System.out.println("2. Học viên cao học");
        System.out.println("3. Giảng viên");
        System.out.print("Chọn loại bạn đọc: ");
        int temp;
        do {
            temp = new Scanner(System.in).nextInt();
            if (temp >= 1 && temp <= 3) {
                break;
            }
            System.out.print("Chọn sai mời chọn lại: ");
        } while (true);
        switch (temp) {
            case 1:
                this.readerType = ReaderType.STUDENT;
                break;
            case 2:
                this.readerType = ReaderType.POST_STUDENT;
                break;
            case 3:
                this.readerType = ReaderType.TEACHER;
                break;
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "codeReader=" + codeReader +
                ", readerType=" + readerType.value +
                ", fullName='" + fullName + '\'' +
                ", andress='" + andress + '\'' +
                ", phone=" + phone +
                '}';
    }


}
