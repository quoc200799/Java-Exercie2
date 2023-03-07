package logic;

import entity.Staff;
import ulti.FileUtil;

import java.util.List;
import java.util.Scanner;

public class StaffLogic {
    private List<Staff> staffList;
    private int totalStaff;
    public StaffLogic(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public int getTotalStaff() {
        return totalStaff;
    }

    public void inputStaff() {
        System.out.println("Nhập số lượng công nhân muốn thêm:");
        int staffNum = new Scanner(System.in).nextInt();
        Staff staff = null;
        for (int i = 0; i < staffNum; i++) {
            staff = new Staff();
            staff.inputInfor();
            staffList.add(staff);
        }
        totalStaff += staffNum;
        FileUtil.writeDateToFile(staffList, "staff.dat");
    }

    public void showStaff(){
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }
    public Staff findStaffById(int cusomerId) {
        for (int i = 0; i < staffList.size(); i++) {
            if (cusomerId == staffList.get(i).getId()) {
                return staffList.get(i);
            }
        }
        return null;
    }

}
