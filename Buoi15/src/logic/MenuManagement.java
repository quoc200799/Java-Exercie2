package logic;

import entity.Factory;
import entity.Staff;
import entity.Timesheets;
import ulti.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuManagement {
    private final StaffLogic staffLogic;
    private FactoryLogic factoryLogic;
private TimesheetsManagement timesheetsManagement;
    public MenuManagement() {
        List staffFile = FileUtil.readDataFromFileVer2("staff.dat");
        List<Staff> staffList = staffFile == null ? new ArrayList<>() : (List<Staff>) staffFile;
        staffLogic = new StaffLogic(staffList);

        List factoryFile = FileUtil.readDataFromFileVer2("factory.dat");
        List<Factory> factoryList = factoryFile == null ? new ArrayList<>() : (List<Factory>) factoryFile;
        factoryLogic = new FactoryLogic(factoryList);

        List timeSheetFile = FileUtil.readDataFromFileVer2("timesheets.dat");
        List<Timesheets> timesheetsList = timeSheetFile == null ? new ArrayList<>() : (List<Timesheets>) timeSheetFile;
        timesheetsManagement = new TimesheetsManagement(staffLogic,factoryLogic,timesheetsList);

    }


    public void menu() {
        while (true) {
            showMenu();
            handleLogicMenu();
        }
    }

    private void handleLogicMenu() {
        int choice = functionChoice();
        switch (choice) {
            case 1:
                staffLogic.inputStaff();
                break;
            case 2:
                staffLogic.showStaff();
                break;
            case 3:
                factoryLogic.inputFactory();
                break;
            case 4:
                factoryLogic.showFactory();
                break;
            case 5:
                timesheetsManagement.inputTimeSheets();
                break;
            case 6:
//                timesheetsManagement.sortByName;
                break;
            case 7:
                timesheetsManagement.showThuNhap();
                break;
            case 8:
                System.exit(0);
                break;

        }
    }

    private int functionChoice() {
        System.out.println("Chọn: ");
        int temp;
        do {
            temp = new Scanner(System.in).nextInt();
            if (temp >= 1 && temp <= 8) {
                break;
            }
            System.out.println("Nhập sai, yêu cầu nhập lại: ");
        } while (true);
        return temp;
    }

    private void showMenu() {
        System.out.println("==============PHẦN MỀM QUẢN LÝ SỔ TIẾT KIỆM=================");
        System.out.println("1. Nhập danh sách khách hàng");
        System.out.println("2. Hiển thị danh sách khách hàng");
        System.out.println("3. ...");
    }

}
