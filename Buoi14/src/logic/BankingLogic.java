package logic;

import entity.Banking;
import entity.Customer;
import util.DataUtil;
import util.file.FileUltil;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingLogic implements Serializable {
    public static String BANKING_DATA_FILE = "./customer.txt";
    private FileUltil fileUltil;
    private DataUtil dataUtil;
    private Banking banking;
    private Banking[] bankings;
    private int totalBanking;

    public BankingLogic(Banking[] bankings) {
        this.bankings = bankings;
    }

    public int getTotalBanking() {
        return totalBanking;
    }

    public void setTotalBanking(int totalBanking) {
        this.totalBanking = totalBanking;
    }

    public Banking[] getBankings() {
        return bankings;
    }

    private void initializeData() {
        Object bankingFromFile = fileUltil.readDataFromFile(BANKING_DATA_FILE);
        bankings = DataUtil.isNullOrEmpty(bankingFromFile) ? new Banking[100] : (Banking []) bankingFromFile;
    }
    public void showBankings() {
        initializeData();
        for (int i = 0; i < bankings.length; i++) {
            if (bankings[i] != null) {
                System.out.println(bankings[i]);

            }
        }
    }

    public void addNewBankings() {
        System.out.print("Nhập số ngân hàng: ");
        int bankingNumber;
        do {
            try {
                bankingNumber = new Scanner(System.in).nextInt();
                if (bankingNumber > 0) {
                    break;
                }
                System.out.print("Số ngân hàng muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số ngân hàng muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < bankingNumber; i++) {
            Banking banking = new Banking();
            banking.inputInfor();
            addBankingToArray(banking);
        }
        totalBanking += bankingNumber;
        fileUltil.writeDataToFile(bankings, BANKING_DATA_FILE);
    }

    public void addBankingToArray(Banking banking) {
        for (int i = 0; i < bankings.length; i++) {
            if (bankings[i] == null) {
                bankings[i] = banking;
                break;
            }
        }
    }

    public Banking findBankingById(int bankingId) {
        for (int i = 0; i < bankings.length; i++) {
            if (bankingId == bankings[i].getId()) {
                return bankings[i];
            }
        }
        return null;
    }
}
