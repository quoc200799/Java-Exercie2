package logic;

import entity.Product;
import entity.Staff;

import java.util.Scanner;

public class StaffLogic {
    private Staff  staff;
    private Staff[] staffs;
    private int totallStaff;

    public int getTotallStaff() {
        return totallStaff;
    }

    public void setTotallStaff(int totallStaff) {
        this.totallStaff = totallStaff;
    }

    public StaffLogic(Staff[] staffs) {
        this.staffs = staffs;
    }

    public Staff[] getStaffs() {
        return staffs;
    }

    public void setStaffs(Staff[] staffs) {
        this.staffs = staffs;
    }
    public void InputStaff() {
        System.out.print("Nhập số lượng nhân viên: ");
        int numberStaff = 0;
        while (true) {
            numberStaff = new Scanner(System.in).nextInt();
            if (numberStaff > 0) {
                break;
            }
            System.out.print("Danh sách nhân viên phải nhiều hơn 0, nhập lại: ");
        }
        for (int i = 0; i < numberStaff; i++) {
            if (staffs[i] == null) {
                staff = new Staff();
                staff.inforInput();
                saveStaff(staff);
                System.out.println("----------------------");
            }
        }
        totallStaff += numberStaff;
    }
    private void saveStaff(Staff product) {
        for (int i = 0; i < staffs.length; i++) {
            if (staffs[i] == null) {
                staffs[i] = product;
                break;
            }
        }
    }
    public void showStaff() {
        for (int i = 0; i < staffs.length; i++) {
            if (staffs[i] != null) {
                System.out.println(staffs[i]);
            }
        }
    }
    public Staff searchStaffById(int id){
        Staff staff = null;
        for (int k = 0; k < staffs.length; k++) {
            if (staffs[k] != null && staffs[k].getId() == id) {
                staff = staffs[k];
                break;
            }
        }
        return staff;
    }
}
