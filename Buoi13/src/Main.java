import logic.MenuManagement;

public class Main {
    private static MenuManagement menuManagement;
    public static void main(String[] args) {
        menuManagement = new MenuManagement();
        menuManagement.menu();
    }
}