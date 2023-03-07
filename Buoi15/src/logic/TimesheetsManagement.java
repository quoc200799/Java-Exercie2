package logic;

import entity.*;
import ulti.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimesheetsManagement {
    private StaffLogic staffLogic;
    private FactoryLogic factoryLogic;
    private List<Timesheets> timesheetsArrayList;
    private Timesheets timesheets;
    private FileUtil fileUtil;

    public TimesheetsManagement(StaffLogic staffLogic, FactoryLogic factoryLogic, List<Timesheets> timesheetsArrayList) {
        this.staffLogic = staffLogic;
        this.factoryLogic = factoryLogic;
        this.timesheetsArrayList = timesheetsArrayList;
    }

    public void inputTimeSheets() {
        List<Timesheets> timesheetsArrayList1 = new ArrayList<>();

        if (!checkData()) {
            System.out.println("Chưa có dữ liêu");
            return;
        }
        System.out.print("Nhập số lượng công nhân muốn chấm công: ");
        int staffNum;
        while (true) {
            try {
                staffNum = new Scanner(System.in).nextByte();
                if (staffNum > 0 && staffNum <= staffLogic.getTotalStaff()) {
                    break;
                }
                System.out.print("Số lượng khách phải lớn hơn 0, nhập lại: ");
            } catch (RuntimeException e) {
                System.out.print("Nhập sai định dạng, mời nhập lại: ");
            }
        }
        for (int i = 0; i < staffNum; i++) {
            System.out.print("Công nhân thứ " + (i + 1) + " làm việc ở xưởng là là: ");
            Staff staffId = inputStaffid();
            System.out.print("Số xưởng sản xuất mà công nhân muốn làm là: ");
            int factoryNum;
            do {
                try {
                    factoryNum = new Scanner(System.in).nextInt();
                    if (factoryNum >= 1 && factoryNum <= factoryLogic.getTotalFactory()) {
                        break;
                    }
                    System.out.print("Số công xưởng phải lớn hơn 1 và nhỏ hơn tổng số lượng xưởng đang có, vui lòng nhập lại: ");
                } catch (Exception e) {
                    System.out.print("Nhập sai định dạng, mời nhập lại: ");
                }
            } while (true);
            List<TimesheetsDetail> timesheetsDetails = arrayTimesheetsDetails(factoryNum);
            Timesheets timesheets1 = new Timesheets(staffId, timesheetsDetails);
            timesheetsArrayList1.add(timesheets1);
        }

        FileUtil.writeDateToFile(timesheetsArrayList1, "timesheets.dat");
        showTimesheet();
    }

    public void showTimesheet() {
        for (Timesheets timesheets1 : timesheetsArrayList) {
            System.out.println(timesheets1);
        }
    }

    private List<TimesheetsDetail> arrayTimesheetsDetails(int factoryNum) {
        List<TimesheetsDetail> timesheetsDetailArrayList = new ArrayList<>();
        for (int j = 0; j < factoryNum; j++) {
            System.out.print("Nhập thông tin công xưởng thứ " + (j + 1) + ", nhập ID công xởng: ");
            Factory factory = inputfactoryById();

            System.out.print("Số ngày nhân viên được làm việc ở công xưởng này này: ");
            int itemNum;
            while (true) {
                try {
                    itemNum = new Scanner(System.in).nextInt();
                    if (itemNum > 0 && itemNum < 30 && timesheets.getTotalDayWork() < 30) {
                        break;
                    }
                    System.out.print(": ");
                } catch (Exception e) {
                    System.out.print("Nhập sai định dạng, mời nhập lại: ");

                }

            }
            TimesheetsDetail detail = new TimesheetsDetail(factory, itemNum);
            timesheetsDetailArrayList.add(detail);
        }
        return timesheetsDetailArrayList;
    }

    private Factory inputfactoryById() {
        int factoryId;
        Factory factory;
        do {
            try {
                factoryId = new Scanner(System.in).nextInt();

                factory = factoryLogic.findFactoryById(factoryId);
                if (factory != null) {
                    break;
                }
                System.out.print("Không tìm thấy công xưởng có mã " + factoryId + ", vui lòng nhập lại: ");
            } catch (Exception e) {
                System.out.print("Sai định dạng, mời nhập lại");
            }

        } while (true);
        return factory;
    }

    private Staff inputStaffid() {
        int staffId;
        Staff staff;
        while (true) {
            try {
                staffId = new Scanner(System.in).nextByte();
                staff = staffLogic.findStaffById(staffId);
                if (staff != null) {
                    break;
                }
                System.out.print("Không tìm thấy công nhân có mã " + staffId + ", vui lòng nhập lại: ");
            } catch (RuntimeException e) {
                System.out.print("Nhập sai định dạng, mời nhập lại: ");
            }
        }
        return staff;
    }
//    public void sortByCustomName() {
//        if (!checkData()) {
//            System.out.println("Chưa có dữ liêu của khách hàng hoặc dịch vụ");
//            return;
//        }
//        for (int i = 0; i < timesheetsArrayList.size()- 1; i++) {
//            for (int j = i + 1; j < timesheetsArrayList.size(); j++) {
//                if (timesheetsArrayList.get(i).getStaff().getName().compareToIgnoreCase(timesheetsArrayList.get(j).getStaff().getName()) > 0) {
//                    Timesheets temp = timesheetsArrayList.get(i);
//                    timesheetsArrayList.get(i) = timesheetsArrayList.get(j);
//                    timesheetsArrayList.get(j) = temp;
//                }
//            }
//        }
//        showTimesheet();
//    }
    private boolean checkData() {
        boolean checkStaff = false;
        for (int i = 0; i < staffLogic.getStaffList().size(); i++) {
            if (staffLogic.getStaffList().get(i) != null) {
                checkStaff = true;
                break;
            }
        }
        boolean checkFactory = false;
        for (int i = 0; i < factoryLogic.getFactoryList().size(); i++) {
            if (factoryLogic.getFactoryList().get(i) != null) {
                checkFactory = true;
                break;
            }
        }
        return checkFactory && checkStaff;
    }

    private List<ThuNhap> tinhThuNhap() {
        List<ThuNhap> thuNhaps = new ArrayList<>();
        if (!checkData()) {
            System.out.println("Chưa có dữ liêu");
            return null;
        }
        for (int i = 0; i < timesheetsArrayList.size(); i++) {
            Timesheets timesheets1 = timesheetsArrayList.get(i);
            double total = (450000 * timesheets1.getTotalworkFactor() * timesheets1.getStaff().getLevel()) / (timesheets1.getTotalDayWork() / 22);
            ThuNhap thuNhap = new ThuNhap(timesheets1.getStaff().getName(),total);
            thuNhaps.add(thuNhap);
        }
        return thuNhaps;
    }

    public void showThuNhap(){
        System.out.println(tinhThuNhap());
    }
}
