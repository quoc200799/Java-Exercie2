package logic;

import entity.Customer;
import entity.Service;

import java.util.Scanner;

public class ServiceLogic {
    private Service service;
    private Service[] services;

    public int getTotalServices() {
        return totalServices;
    }

    public void setTotalServices(int totalServices) {
        this.totalServices = totalServices;
    }

    private int totalServices;

    public ServiceLogic(Service[] services) {
        this.services = services;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }
    public void inputService(){
        System.out.print("Nhập số lượng dịch vụ: ");
        int numberService;
        while (true) {
            try {
                numberService = new Scanner(System.in).nextInt();
                if (numberService > 0) {
                    break;
                }
                System.out.print("Danh sách dịch vụ phải nhiều hơn 0, nhập lại: ");
            }catch (Exception e){
                System.out.print("Nhập sai định dạng, mời nhập laại: ");
            }

        }
        for (int i = 0; i < numberService; i++) {
            if (services[i] == null) {
                service = new Service();
                service.inforInput();
                saveService(service);
                System.out.println("----------------------");
            }
        }
        totalServices += numberService;
    }

    private void saveService(Service service) {
        for (int i = 0; i < services.length; i++) {
            if (services[i] == null) {
                services[i] = service;
                break;
            }
        }
    }
    public void showService() {
        for (int i = 0; i < services.length; i++) {
            if (services[i] != null) {
                System.out.println(services[i]);
            }
        }
    }
    public Service searchServiceById(int id){
        Service service = null;
        for (int k = 0; k < services.length; k++) {
            if (services[k] != null && services[k].getId() == id) {
                service = services[k];
                break;
            }
        }
        return service;
    }
}
