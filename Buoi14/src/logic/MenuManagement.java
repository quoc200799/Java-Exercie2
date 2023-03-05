package logic;

import entity.BankPassbook;
import entity.Banking;
import entity.Customer;
import util.DataUtil;
import util.file.FileUltil;

import java.util.Scanner;

public class MenuManagement {
    private Customer[] customers;
    private CustomerLogic customerLogic;
    private Banking[] bankings;
    private BankingLogic bankingLogic;
    private BankPassbook[] bankPassbook;

    private BankPassbookLogic bankPassbookLogic;

    private FileUltil fileUltil;

    public MenuManagement() {
        customers = new Customer[100];
        customerLogic = new CustomerLogic(customers);
        bankings = new Banking[100];
        bankingLogic = new BankingLogic(bankings);
        bankPassbook = new BankPassbook[100];
        bankPassbookLogic = new BankPassbookLogic(bankPassbook, customerLogic, bankingLogic);
    }

    public void menu() {
        while (true) {
            contentMenu();
            functionChoiceMenu();
        }
    }

    private void contentMenu() {
        System.out.println("==== QUẢN LÝ SỔ TIẾT KIỆM CHO KHÁCH HÀNG ====");
        System.out.println("1. Nhập danh sách khách hàng");
        System.out.println("2. In danh sách khách hàng");
        System.out.println("3. Nhập danh sách ngân hàng");
        System.out.println("4. In danh sách ngân hàng");
        System.out.println("5. Nhập hóa đơn cho khách hàng");
        System.out.println("6. Sắp xếp danh sách hóa đơn");
        System.out.println("7. Lập bảng kê số tiền phải trả cho mỗi khác hàng ");
        System.out.println("8. Thoát");
        System.out.print("Mời bạn chọn chức năng: ");
    }

    private void functionChoiceMenu() {
        int n;
        while (true) {
            try {
                n = new Scanner(System.in).nextInt();
                if (n >= 1 && n <= 8) {
                    break;
                }
                System.out.print("Nhập sai, mời nhập lại");
            } catch (Exception e) {
                System.out.print("Nhập sai định dạng, mời nhập lại: ");
            }

        }
        switch (n) {
            case 1:
                customerLogic.addNewCustomers();
                break;
            case 2:
                customerLogic.showCustomers();
                break;
            case 3:
                    bankingLogic.addNewBankings();
                break;
            case 4:
                bankingLogic.showBankings();
                break;
            case 5:
                    bankPassbookLogic.inputBankpassBook();
                break;
            case 6:
                bankPassbookLogic.sortByCustomName();
                bankPassbookLogic.sortByBankpassbookQuantity();
                break;
            case 7:
                bankPassbookLogic.tinhThuNhap();
                break;
            case 8:
                System.exit(0);
                break;

        }
    }

}
