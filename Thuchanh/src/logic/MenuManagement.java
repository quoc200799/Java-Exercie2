package logic;

import entity.Product;
import entity.Staff;
import entity.StaffManagement;

import java.util.Scanner;

public class MenuManagement {
    private ProductLogic productLogic;
    private StaffLogic staffLogic;
    private StaffManagementLogic staffManagementLogic;

    public MenuManagement() {
        Product[] products = new Product[100];
        productLogic = new ProductLogic(products);
        Staff[] staffs = new Staff[100];
        staffLogic = new StaffLogic(staffs);
        StaffManagement[] staffManagements = new StaffManagement[100];
        staffManagementLogic = new StaffManagementLogic(staffManagements, productLogic, staffLogic);
    }

    public void menu() {
        while (true) {
            contentMenu();
            functionChoiceMenu();
        }
    }

    private void contentMenu() {
        System.out.println("==== QUẢN LÝ MẶT HÀNG CHO NHÂN VIÊN ====");
        System.out.println("1. Nhập danh sách mặt hàng");
        System.out.println("2. In danh sách mặt hàng");
        System.out.println("3. Nhập danh sách nhân viên");
        System.out.println("4. In danh sách nhân viên");
        System.out.println("5. Lập bảng danh sách bán hàng");
        System.out.println("6. Sắp xếp bảng danh sách bán hàng");
        System.out.println("7. Lập bảng kê doanh thu cho mỗi nhân viên ");
        System.out.println("8. Thoát");
        System.out.print("Mời bạn chọn chức năng: ");
    }
    private void functionChoiceMenu() {
        int n;
        while (true) {
            n = new Scanner(System.in).nextInt();
            if (n >= 1 && n <= 8) {
                break;
            }
            System.out.print("Nhập sai, mời nhập lại");
        }
        switch (n) {
            case 1:
                productLogic.InputProduct();
                break;
            case 2:
                productLogic.showProduct();
                break;
            case 3:
                staffLogic.InputStaff();
                break;
            case 4:
                staffLogic.showStaff();
                break;
            case 5:
                staffManagementLogic.ListSell();
                break;
            case 6:
                staffManagementLogic.sortByStaffName();
                break;
            case 7:
                staffManagementLogic.tinhThuNhap();
                break;
            case 8:
                System.exit(0);
                break;

        }
    }


}
