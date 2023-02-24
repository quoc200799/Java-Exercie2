package logic;

import entity.Product;
import entity.Staff;
import entity.StaffManagement;
import entity.StaffManagementDetail;

import java.util.Scanner;

public class StaffManagementLogic {
    private StaffManagement[] staffManagements;
    private ProductLogic productLogic;
    private StaffLogic staffLogic;

    public StaffManagementLogic(StaffManagement[] staffManagements, ProductLogic productLogic, StaffLogic staffLogic) {
        this.staffManagements = staffManagements;
        this.productLogic = productLogic;
        this.staffLogic = staffLogic;
    }

    //Danh sách bán hàng của mỗi nhân viene
    public void ListSell() {
        if (!checkData()) {
            System.out.println("Chưa có dữ liêuh của nhân viên và mặt hàng ");
            return;
        }
        System.out.print("Số lượng nhân viên bán hàng: ");
        int staffNum;
        do {
            staffNum = new Scanner(System.in).nextInt();
            if (staffNum > 0 && staffNum <= staffLogic.getTotallStaff()
            ) {
                break;
            }
            System.out.println("Số lượng nhân viên cần phải là số dương và nhỏ hơn số lượng nhân viên trong cửa hàng");
        } while (true);
        for (int i = 0; i < staffNum; i++) {
            System.out.print("Nhân viên thứ " + (i + 1) + " muốn lập bảng tính công là ");
            Staff staff = inputStaff();
            //
            System.out.print("Nhân viên này bán bao nhiêu mặt hàng: ");
            int productNum;
            do {
                productNum = new Scanner(System.in).nextInt();
                if (productNum >= 1 && productNum <= 5 && productNum <= productLogic.getTotalProduct()) {
                    break;
                }
                System.out.print("Số mặt hàng phải là số dương nhỏ hơn 5 và nhỏ hơn tổng số lượng mặt hàng đang có, vui lòng nhập lại: ");
            } while (true);
            StaffManagementDetail[] staffManagementDetails = staffManagementDetails(productNum);
            StaffManagement staffManagement = new StaffManagement(staff, staffManagementDetails);
            saveStaffManagemt(staffManagement);
        }
        showListSell();
    }

    private void showListSell() {
        for (int i = 0; i < staffManagements.length; i++) {
            if (staffManagements[i] != null) {
                System.out.println(staffManagements[i]);
            }
        }
    }

    private void saveStaffManagemt(StaffManagement staffManagement) {
        for (int i = 0; i < staffManagements.length; i++) {
            if (staffManagements[i] == null) {
                staffManagements[i] = staffManagement;
                break;
            }
        }
    }

    private StaffManagementDetail[] staffManagementDetails(int productNum) {
        StaffManagementDetail[] listItem = new StaffManagementDetail[productNum];
        for (int j = 0; j < productNum; j++) {
            System.out.print("Nhập thông tin cho mặt hàng thứ " + (j + 1) + ", nhập ID mặt hàng: ");
            Product product = inputProduct();

            System.out.print("Nhân viên bán được bao nhiêu số mặt hàng này: ");
            int itemNum;
            while (true) {
                itemNum = new Scanner(System.in).nextInt();
                if (itemNum > 0 && itemNum <= productLogic.getProduct().getQuantity()) {
                    break;
                }
                System.out.print("Nhân viên phải bán nhiều hơn 0 và ít hơn số lượng mặt hàng hiện có: ");
            }
            StaffManagementDetail detail = new StaffManagementDetail(product, itemNum);
            saveProduct(detail, listItem);
        }
        return listItem;
    }

    private void saveProduct(StaffManagementDetail detail, StaffManagementDetail[] listItem) {
        for (int i = 0; i < listItem.length; i++) {
            if (listItem[i] == null) {
                listItem[i] = detail;
                break;
            }
        }
    }

    private Staff inputStaff() {
        int idStaff;
        Staff staff = null;
        do {
            idStaff = new Scanner(System.in).nextInt();
            staff = staffLogic.searchStaffById(idStaff);
//            for (int i = 0; i < staffManagements.length; i++) {
//                if (staffManagements[i] != null && staffManagements[i].getStaff().getId() != idStaff) {
//                } else if (staffManagements[i] != null && staffManagements[i].getStaff().getId() == idStaff) {
//                    System.out.print("id trung với id nv đã được nhập trc đó: ");
//                    break;
//                }
//            }

            if (staff != null) {
                break;
            }
            System.out.print("Không tìm thấy nhân viên có mã " + idStaff + ", vui lòng nhập lại: ");
        } while (true);
        return staff;
    }

    private Product inputProduct() {
        int idProduct;
        Product product;
        do {
            idProduct = new Scanner(System.in).nextInt();

            product = productLogic.searchProductById(idProduct);
            if (product != null) {
                break;
            }
            System.out.print("Không tìm thấy mặt hàng nào có mã " + idProduct + ", vui lòng nhập lại: ");
        } while (true);
        return product;
    }

    private boolean checkData() {
        boolean checkProduct = false;
        for (int i = 0; i < productLogic.getProducts().length; i++) {
            if (productLogic.getProducts()[i] != null) {
                checkProduct = true;
                break;
            }
        }
        boolean checkStaff = false;
        for (int i = 0; i < staffLogic.getStaffs().length; i++) {
            if (staffLogic.getStaffs()[i] != null) {
                checkStaff = true;
                break;
            }
        }

        return checkProduct && checkStaff;
    }

    public void sortByStaffName() {
        if (!checkData()) {
            System.out.println("Chưa có dữ liêu của nhân viên hoặc mặt hàng");
            return;
        }
        for (int i = 0; i < staffManagements.length - 1; i++) {
            if (staffManagements[i] == null) {
                continue;
            }
            for (int j = i + 1; j < staffManagements.length; j++) {
                if (staffManagements[j] == null) {
                    continue;
                }
                if (staffManagements[i].getStaff().getName().compareToIgnoreCase(staffManagements[j].getStaff().getName().trim()) > 0) {
                    StaffManagement temp = staffManagements[i];
                    staffManagements[i] = staffManagements[j];
                    staffManagements[j] = temp;
                }
            }
        }
        showListSell();
    }

    //    public void sortByProductType() {
//        if (!checkData()) {
//            System.out.println("Chưa có dữ liêu của nhân viên hoặc mặt hàng");
//            return;
//        }
//        for (int i = 0; i < staffManagements.length - 1; i++) {
//            if (staffManagements[i] == null) {
//                continue;
//            }
//            for (int j = i + 1; j < staffManagements.length; j++) {
//                if (staffManagements[j] == null) {
//                    continue;
//                }
//                if (staffManagements[i].compareToIgnoreCase(staffManagements[j].getStaff().getName().trim()) > 0) {
//                    StaffManagement temp = staffManagements[i];
//                    staffManagements[i] = staffManagements[j];
//                    staffManagements[j] = temp;
//                }
//            }
//        }
//        showListSell();
//    }
    public void tinhThuNhap() {
        if (!checkData()) {
            System.out.println("Chưa có dữ liêu của nhân viên hoặc mặt hàng");
            return;
        }
        for (int i = 0; i < staffManagements.length; i++) {
            double total = 0;
            StaffManagement staffManagement = staffManagements[i];
            StaffManagementDetail[] staffManagementDetails = staffManagement.getStaffManagementDetails();
            for (int j = 0; j < staffManagementDetails.length; j++) {
                total += staffManagementDetails[j].getProduct().getPrice() * staffManagementDetails[j].getQuantity();
            }
            System.out.println("Tổng thu nhập của nhân viên " + staffManagements[i].getStaff().getName() + " là: " + total);
        }
    }
}

