package logic;

import entity.BankPassbook;
import entity.BankPassbookDetail;
import entity.Banking;
import entity.Customer;
import util.DataUtil;
import util.file.FileUltil;

import java.io.Serializable;
import java.util.Scanner;

public class BankPassbookLogic implements Serializable {
    public static String BANKINGPASSBOOK_DATA_FILE = "./bankpassbook.txt";
    private FileUltil fileUltil;
    private DataUtil dataUtil;
    private BankPassbook[] bankPassbooks;
    private CustomerLogic customerLogic;
    private BankingLogic bankingLogic;

    public BankPassbookLogic(BankPassbook[] bankPassbooks, CustomerLogic customerLogic, BankingLogic bankingLogic) {
        this.bankPassbooks = bankPassbooks;
        this.customerLogic = customerLogic;
        this.bankingLogic = bankingLogic;
    }
    private void initializeData() {
        Object bankPassbooksFromFile = fileUltil.readDataFromFile(BANKINGPASSBOOK_DATA_FILE);
        bankPassbooks = DataUtil.isNullOrEmpty(bankPassbooksFromFile) ? new BankPassbook[100] : (BankPassbook []) bankPassbooksFromFile;
    }
    public void inputBankpassBook() {
        if (!checkData()) {
            System.out.println("Chưa có dữ liêu của khách hàng hoặc dịch vụ");
            return;
        }
        System.out.print("Nhập số lượng khách hàng: ");
        int cusNum;
        while (true) {
            try {
                cusNum = new Scanner(System.in).nextByte();
                if (cusNum > 0 && cusNum <= customerLogic.getTotalCustomer()) {
                    break;
                }
                System.out.print("Số lượng khách phải lớn hơn 0, nhập lại: ");
            } catch (RuntimeException e) {
                System.out.print("Nhập sai định dạng, mời nhập lại: ");
            }
        }
        for (int i = 0; i < cusNum; i++) {
            System.out.print("Khách hàng thứ " + (i + 1) + " muốn lấy sổ tiết kiệm là: ");
            Customer customerid = inputCustomerid();
            System.out.print("Số lần khach hàng dùng dịch vụ này: ");
            int bankPassbookNum;
            do {
                try {
                    bankPassbookNum = new Scanner(System.in).nextInt();
                    if (bankPassbookNum >= 1 && bankPassbookNum <= 5 && bankPassbookNum <= bankingLogic.getTotalBanking()) {
                        break;
                    }
                    System.out.print("Số mặt hàng phải là số dương nhỏ hơn 5 và nhỏ hơn tổng số lượng mặt hàng đang có, vui lòng nhập lại: ");
                }catch (Exception e){
                    System.out.print("Nhập sai định dạng, mời nhập lại: ");
                }
            } while (true);
            BankPassbookDetail[] bankPassbookDetails = bankPassbookDetails(bankPassbookNum);
            BankPassbook bankPassbook = new BankPassbook(customerid, bankPassbookDetails);
            saveBankPassbook(bankPassbook);
        }
        fileUltil.writeDataToFile(bankPassbooks, BANKINGPASSBOOK_DATA_FILE);

        showBankPassbook();
    }

    private void showBankPassbook() {
        initializeData();
        for (int i = 0; i < bankPassbooks.length; i++) {
            if(bankPassbooks[i] != null){
                System.out.println(bankPassbooks[i]);
            }
        }
    }

    private void saveBankPassbook(BankPassbook bankPassbook) {
        for (int i = 0; i < bankPassbooks.length; i++) {
            if(bankPassbooks[i] == null){
                bankPassbooks[i] =bankPassbook;
                break;
            }
        }
    }


    private Customer inputCustomerid() {
        int customerId;
        Customer customer;
        while (true) {
            try {
                customerId = new Scanner(System.in).nextByte();
                customer = customerLogic.findCustomerById(customerId);
                if (customer != null) {
                    break;
                }
                System.out.print("Không tìm thấy nhân viên có mã " + customerId + ", vui lòng nhập lại: ");
            } catch (RuntimeException e) {
                System.out.print("Nhập sai định dạng, mời nhập lại: ");
            }
        }
        return customer;
    }
    private BankPassbookDetail[] bankPassbookDetails(int Num) {
        BankPassbookDetail[] listItem = new BankPassbookDetail[Num];
        for (int j = 0; j < Num; j++) {
            System.out.print("Nhập thông tin ngân hàng thứ " + (j + 1) + ", nhập ID ngân hàngụ: ");
            Banking banking = inputBanking();

            System.out.print("Khách hàng được sử dụng dịch vụ này: ");
            int itemNum;
            while (true) {
                try {
                    itemNum = new Scanner(System.in).nextInt();
                    if (itemNum > 0) {
                        break;
                    }
                    System.out.print("Khách hàng phải dùng Ngân hàng: ");
                }catch (Exception e){
                    System.out.print("Nhập sai định dạng, mời nhập lại: ");

                }

            }
            BankPassbookDetail detail = new BankPassbookDetail(banking, itemNum);
            saveBillDetail(detail, listItem);
        }
        return listItem;
    }

    private void saveBillDetail(BankPassbookDetail detail, BankPassbookDetail[] listItem) {
        for (int i = 0; i < listItem.length; i++) {
            if(listItem[i] == null){
                listItem[i] =detail;
                break;
            }
        }
    }

    private Banking inputBanking() {
        int idBanking;
        Banking banking;
        do {
            try {
                idBanking = new Scanner(System.in).nextInt();

                banking = bankingLogic.findBankingById(idBanking);
                if (banking != null) {
                    break;
                }
                System.out.print("Không tìm thấy dịch vụ nào có mã " + idBanking + ", vui lòng nhập lại: ");
            }catch (Exception e){
                System.out.print("Sai định dạng, mời nhập lại");
            }

        } while (true);
        return banking;
    }
    private boolean checkData() {
        boolean checkService = false;
        for (int i = 0; i < bankingLogic.getBankings().length; i++) {
            if (bankingLogic.getBankings()[i] != null) {
                checkService = true;
                break;
            }
        }
        boolean checkCustomer = false;
        for (int i = 0; i < customerLogic.getCustomers().length; i++) {
            if (customerLogic.getCustomers()[i] != null) {
                checkCustomer = true;
                break;
            }
        }

        return checkService && checkCustomer;
    }
    public void sortByCustomName() {
        if (!checkData()) {
            System.out.println("Chưa có dữ liêu của khách hàng hoặc dịch vụ");
            return;
        }
        for (int i = 0; i < bankPassbooks.length - 1; i++) {
            if (bankPassbooks[i] == null) {
                continue;
            }
            for (int j = i + 1; j < bankPassbooks.length; j++) {
                if (bankPassbooks[j] == null) {
                    continue;
                }
                if (bankPassbooks[i].getCustomer().getName().compareToIgnoreCase(bankPassbooks[j].getCustomer().getName().trim()) > 0) {
                    BankPassbook temp = bankPassbooks[i];
                    bankPassbooks[i] = bankPassbooks[j];
                    bankPassbooks[j] = temp;
                }
            }
        }
        showBankPassbook();
    }
    public void sortByBankpassbookQuantity() {
        if (!checkData()) {
            System.out.println("Chưa có dữ liêu của khách hàng hoặc ngân h");
            return;
        }
        for (int i = 0; i < bankPassbooks.length - 1; i++) {
            if (bankPassbooks[i] == null) {
                continue;
            }
            for (int j = i + 1; j < bankPassbooks.length; j++) {
                if (bankPassbooks[j] == null) {
                    continue;
                }
                if (bankPassbooks[i].getTotalQuantity() < bankPassbooks[j].getTotalQuantity()) {
                    BankPassbook temp = bankPassbooks[i];
                    bankPassbooks[i] = bankPassbooks[j];
                    bankPassbooks[j] = temp;
                }
            }
        }
        showBankPassbook();
    }
    public void tinhThuNhap() {
        if (!checkData()) {
            System.out.println("Chưa có dữ liêu của khách hàng hoặc dịch vụ");
            return;
        }
        for (int i = 0; i < bankPassbooks.length; i++) {
            if (bankPassbooks[i] == null) {
                continue;
            }
            double total = 0;
            BankPassbook bill = bankPassbooks[i];
            BankPassbookDetail[] bankPassbookDetails = bill.getBankPassbookDetails();
            for (int j = 0; j < bankPassbookDetails.length; j++) {
                if (bankPassbooks[i] == null) {
                    continue;
                }
                total += bankPassbookDetails[j].getBanking().getInterest() * bankPassbookDetails[j].getQuantity();
            }
            System.out.println("Tổng số tiền gửi của khách hàng  " + bankPassbooks[i].getCustomer().getName() + " là: " + total);
        }
    }
}
