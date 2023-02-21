import entity.Assignment;
import entity.Buses;
import entity.Driver;
import entity.Tour;

import java.util.Scanner;

public class Main {
    private static Driver driver;
    private static Buses buses;

    private static int numberDrive;
    private static int numberBuses;


    private static Driver[] driverActives = new Driver[1000];
    private static Buses[] busesActives = new Buses[1000];
    private static Assignment[] assignments = new Assignment[1000];
    private static Assignment assignment;

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            contentMenu();
            listMenu(functionChoice());
        }
    }

    private static void contentMenu() {
        System.out.println("========= Bảng quản lý lái xe buýt =========");
        System.out.println("1. Nhập danh sách lái xe.");
        System.out.println("2. In danh sách lái xe");
        System.out.println("3. Nhập danh sách tuyến");
        System.out.println("4. In danh sách tuyến");
        System.out.println("5. Nhập Danh sách phân công");
        System.out.println("6. Sắp xếp danh sách phân công");
        System.out.println("7. Tổng kê khoảng cách chạy mỡi ngày");
        System.out.println("8. Kết thúc chương trình");
        System.out.print("Mới bạn chọn: ");
    }

    private static void listMenu(int temp) {
        switch (temp) {
            case 1:
                inputDriver();
                break;
            case 2:
                showDriver();
                break;
            case 3:
                inputBuses();
                break;
            case 4:
                showBuses();
                break;
            case 5:
                lapBangKeKhai();
                break;
            case 6:
                sortByDriver();
                sortByQuantityBook();
                break;
            case 7:
                totalDistance();
                break;
            case 8:
                System.exit(0);
                break;
        }
    }

    private static void showBuses() {
        System.out.println("In Danh sách tuyến mới: ");
        for (int i = 0; i < busesActives.length; i++) {
            if (busesActives[i] != null)
                System.out.println(busesActives[i]);
        }
    }

    private static void inputBuses() {
        System.out.print("Nhập danh sách tuyến: ");
        numberBuses = new Scanner(System.in).nextInt();
        for (int i = 0; i < busesActives.length; i++) {
            if (busesActives[i] == null) {
                buses = new Buses();
                buses.infor();
                saveBuses(buses);
            }
        }
    }

    private static void saveBuses(Buses buses) {
        for (int j = 0; j < busesActives.length; j++) {
            if (busesActives[j] == null) {
                busesActives[j] = buses;
                break;
            }
        }
    }

    private static void showDriver() {
        System.out.println("In danh sách lái xe mới: ");
        for (int i = 0; i < driverActives.length; i++) {
            if (driverActives[i] != null)
                System.out.println(driverActives[i]);
        }
    }

    private static void inputDriver() {
        System.out.print("Nhập danh sách lái xe: ");
        numberDrive = new Scanner(System.in).nextInt();
        for (int i = 0; i < driverActives.length; i++) {
            if (driverActives[i] == null) {
                driver = new Driver();
                driver.infor();
                saveDriver(driver);
            }
        }

    }

    public static void saveDriver(Driver driver) {
        for (int j = 0; j < driverActives.length; j++) {
            if (driverActives[j] == null) {
                driverActives[j] = driver;
                break;
            }
        }
    }

    private static int functionChoice() {
        return new Scanner(System.in).nextInt();
    }

    private static void lapBangKeKhai() {
        System.out.println("Nhập danh sách phân công cho mỗi lái xe: ");
        int teacherNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < teacherNumber; i++) {
            System.out.println("Mã lái xe của ông thứ " + (i + 1) + " muốn lập bảng kê khai là: ");
            Driver driver = null;
            do {
                int busesId = new Scanner(System.in).nextInt();
                for (int j = 0; j < driverActives.length; j++) {
                    if (driverActives[j] != null && driverActives[j].getId() == busesId) {
                        driver = driverActives[j];
                        break;
                    }
                }
                if (driver != null) {
                    break;
                }
                System.out.println("Mã tài xế không hợp lệ, vui lòng nhập lại: ");
            } while (true);
            // xác định số tuyến mà ông lái xe muốn đi
            System.out.println("Số tuyến muốn đi của ông thứ " + (i + 1) + "là: ");
            int tourNumber = new Scanner(System.in).nextInt();
            int count = 0;
            Tour[] tour = new Tour[tourNumber];
            for (int j = 0; j < tourNumber; j++) {
                System.out.println("Tài xế thứ  " + (i + 1) + " đi thuyế: ");
                Buses buses = null;
                do {
                    int busesId = new Scanner(System.in).nextInt();

                    for (int k = 0; k < busesActives.length; k++) {
                        if (busesActives[k] != null && busesActives[k].getId() == busesId) {
                            buses = busesActives[k];
                            break;
                        }
                    }
                    if (buses != null) {
                        break;
                    }
                    System.out.println("Mã tuyến không hợp lệ, vui lòng nhập lại: ");
                } while (true);

                System.out.println("Số tuyến tài xế đi: ");
                int soTuyen;
                do {
                    soTuyen = new Scanner(System.in).nextInt();
                    if (soTuyen > 0 && soTuyen <= 15) {
                        break;
                    }
                    System.out.print("Ông khỏe thế, đi ít thôi: ");
                } while (true);

                Tour detail = new Tour(buses, soTuyen);
                tour[count] = detail;
                count++;
            }

            Assignment assignment = new Assignment(driver, tour);
            saveDriverBuses(assignment);
            showDriverBuses();
        }

    }

    private static void showDriverBuses() {
        for (int i = 0; i < assignments.length; i++) {
            if (assignments[i] != null) {
                System.out.println(i);
            }
        }
    }

    private static void saveDriverBuses(Assignment assignment) {
        for (int j = 0; j < assignments.length; j++) {
            if (assignments[j] == null) {
                assignments[j] = assignment;
                break;
            }
        }
    }

    public static void sortByDriver() {
        String drive;
        for (int i = 0; i < assignments.length - 1; i++) {
            for (int j = i + 1; j < assignments.length; j++) {
                drive = assignments[j + 1].getDriver().getName();
                if (assignments[j].getDriver().getName().compareTo(drive) > 0) {
                    assignment = assignments[j];
                    assignments[j] = assignments[j + 1];
                    assignments[j + 1] = assignment;
                }
            }
        }
    }

    public static void sortByQuantityBook() {
        for (int i = 0; i < assignments.length - 1; i++) {
            for (int j = i + 1; j < assignments.length; j++) {
                if (assignments[j].totalPoint() < assignments[j + 1].totalPoint()) {
                    assignment = assignments[j];
                    assignments[j] = assignments[j + 1];
                    assignments[j + 1] = assignment;
                }
            }
        }
    }

    public static void totalDistance() {
        for (int i = 0; i < assignments.length; i++) {
            System.out.print("Tổng khoảng cách đi được của tài xế thứ "+(i+1)+" là: ");
            System.out.println(assignments[i].totalATour());
        }
    }

}