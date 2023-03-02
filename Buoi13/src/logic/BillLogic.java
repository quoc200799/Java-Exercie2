package logic;

import entity.Bill;
import entity.BillDetail;
import entity.Customer;
import entity.Service;

import java.util.Scanner;

public class BillLogic {
    private Bill[] bills;
    private CustomerLogic customerLogic;
    private ServiceLogic serviceLogic;

    public BillLogic(Bill[] bills, CustomerLogic customerLogic, ServiceLogic serviceLogic) {
        this.bills = bills;
        this.customerLogic = customerLogic;
        this.serviceLogic = serviceLogic;
    }

    public void inputBill() {
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
            System.out.print("Khách hàng thứ " + (i + 1) + " muốn thanh toán dịch vụ là: ");
            Customer customerid = inputCustomerid();
            System.out.print("Số lần khach hàng dùng dịch vụ này: ");
            int billNum;
            do {
                try {
                    billNum = new Scanner(System.in).nextInt();
                    if (billNum >= 1 && billNum <= 5 && billNum <= serviceLogic.getTotalServices()) {
                        break;
                    }
                    System.out.print("Số mặt hàng phải là số dương nhỏ hơn 5 và nhỏ hơn tổng số lượng mặt hàng đang có, vui lòng nhập lại: ");
                }catch (Exception e){
                    System.out.print("Nhập sai định dạng, mời nhập lại: ");
                }
            } while (true);
            BillDetail[] billDetails = billDetails(billNum);
            Bill bill = new Bill(customerid, billDetails);
            saveBill(bill);
        }
        showBill();
    }

    private void showBill() {
        for (int i = 0; i < bills.length; i++) {
            if(bills[i] != null){
                System.out.println(bills[i]);
            }
        }
    }

    private void saveBill(Bill bill) {
        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == null){
                bills[i] =bill;
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
                customer = customerLogic.searchCustomerById(customerId);
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
    private BillDetail[] billDetails(int billNum) {
        BillDetail[] listItem = new BillDetail[billNum];
        for (int j = 0; j < billNum; j++) {
            System.out.print("Nhập thông tin dịch vụ thứ " + (j + 1) + ", nhập ID dịch vụ: ");
            Service service = inputService();

            System.out.print("Khách hàng được sử dụng dịch vụ này: ");
            int itemNum;
            while (true) {
                try {
                    itemNum = new Scanner(System.in).nextInt();
                    if (itemNum > 0) {
                        break;
                    }
                    System.out.print("Khách hàng phải dùng dịch vụ: ");
                }catch (Exception e){
                    System.out.print("Nhập sai định dạng, mời nhập lại: ");

                }

            }
            BillDetail detail = new BillDetail(service, itemNum);
            saveBillDetail(detail, listItem);
        }
        return listItem;
    }

    private void saveBillDetail(BillDetail detail, BillDetail[] listItem) {
        for (int i = 0; i < listItem.length; i++) {
            if(listItem[i] == null){
                listItem[i] =detail;
                break;
            }
        }
    }

    private Service inputService() {
        int idService;
        Service service;
        do {
            try {
                idService = new Scanner(System.in).nextInt();

                service = serviceLogic.searchServiceById(idService);
                if (service != null) {
                    break;
                }
                System.out.print("Không tìm thấy dịch vụ nào có mã " + idService + ", vui lòng nhập lại: ");
            }catch (Exception e){
                System.out.print("Sai định dạng, mời nhập lại");
            }
           
        } while (true);
        return service;
    }
    private boolean checkData() {
        boolean checkService = false;
        for (int i = 0; i < serviceLogic.getServices().length; i++) {
            if (serviceLogic.getServices()[i] != null) {
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
        for (int i = 0; i < bills.length - 1; i++) {
            if (bills[i] == null) {
                continue;
            }
            for (int j = i + 1; j < bills.length; j++) {
                if (bills[j] == null) {
                    continue;
                }
                if (bills[i].getCustomer().getName().compareToIgnoreCase(bills[j].getCustomer().getName().trim()) > 0) {
                    Bill temp = bills[i];
                    bills[i] = bills[j];
                    bills[j] = temp;
                }
            }
        }
        showBill();
    }
    public void sortByBillQuantity() {
        if (!checkData()) {
            System.out.println("Chưa có dữ liêu của khách hàng hoặc dịch vụ");
            return;
        }
        for (int i = 0; i < bills.length - 1; i++) {
            if (bills[i] == null) {
                continue;
            }
            for (int j = i + 1; j < bills.length; j++) {
                if (bills[j] == null) {
                    continue;
                }
                if (bills[i].getTotalQuantity() < bills[j].getTotalQuantity()) {
                    Bill temp = bills[i];
                    bills[i] = bills[j];
                    bills[j] = temp;
                }
            }
        }
        showBill();
    }
    public void tinhThuNhap() {
        if (!checkData()) {
            System.out.println("Chưa có dữ liêu của khách hàng hoặc dịch vụ");
            return;
        }
        for (int i = 0; i < bills.length; i++) {
            double total = 0;
            Bill bill = bills[i];
            BillDetail[] billDetails = bill.getBillDetails();
            for (int j = 0; j < billDetails.length; j++) {
                total += billDetails[j].getService().getPrice() * billDetails[j].getQuantity();
            }
            System.out.println("Tổng thu nhập của nhân viên " + bills[i].getCustomer().getName() + " là: " + total);
        }
    }
}
