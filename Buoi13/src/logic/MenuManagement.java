package logic;

import entity.Bill;
import entity.Customer;
import entity.Service;

import java.util.Scanner;

public class MenuManagement {
    private  CustomerLogic customerLogic;
    private ServiceLogic serviceLogic;
    private BillLogic billLogic;
    public MenuManagement() {
        Customer[] customers = new Customer[100];
        customerLogic = new CustomerLogic(customers);
        Service[] services = new Service[100];
        serviceLogic = new ServiceLogic(services);
        Bill[] bills = new Bill[100];
        billLogic = new BillLogic(bills, customerLogic, serviceLogic);
    }

    public void menu() {
        while (true) {
            contentMenu();
            functionChoiceMenu();
        }
    }

    private void contentMenu() {
        System.out.println("==== QUẢN LÝ DỊCH VỤ CHO KHÁCH HÀNG ====");
        System.out.println("1. Nhập danh sách khách hàng");
        System.out.println("2. In danh sách khách hàng");
        System.out.println("3. Nhập danh sách dịch vụ");
        System.out.println("4. In danh sách dịch vụ");
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
            }catch (Exception e){
                System.out.print("Nhập sai định dạng, mời nhập lại: ");
            }

        }
        switch (n) {
            case 1:
                customerLogic.InputCustomer();
                break;
            case 2:
                customerLogic.showCustomer();
                break;
            case 3:
                serviceLogic.inputService();
                break;
            case 4:
                serviceLogic.showService();
                break;
            case 5:
                billLogic.inputBill();
                break;
            case 6:
                billLogic.sortByCustomName();
                billLogic.sortByBillQuantity();
                break;
            case 7:
                billLogic.tinhThuNhap();
                break;
            case 8:
                System.exit(0);
                break;

        }
    }


}
