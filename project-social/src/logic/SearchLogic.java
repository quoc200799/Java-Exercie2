package logic;

import entity.SearchUser;
import entity.User;
import util.MyFileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SearchLogic {
    private MyFileUtil<User> userMyFileUtil;
    private List<User> userList;
    private User user;
    private List<SearchUser> searchUsers;
    private int SIZE = 5;

    public SearchLogic() {
        List userFile = userMyFileUtil.readDataFromFile("user.dat");
        userList = userFile == null ? new ArrayList<>() : (List<User>) userFile;
    }

    public SearchLogic(User user) {
        this.user = user;
    }

    private void menuSearch() {
        System.out.println("Mời bạn chọn các chức năng.");
        System.out.println("1. Xem thêm.");
        System.out.println("2. Chọn bạn bè.");
        System.out.println("3. Quay lại");
        System.out.print("Chọn chức năng: ");
    }

    public void searchChoice() {
        menuSearch();
        searchForFavorite();
        int temp;
        while (true) {
            try {
                temp = new Scanner(System.in).nextInt();
                if (temp >= 1 && temp <= 4) {
                    break;
                }
                System.out.print("Chức năng từ [1, 3], mời nhập lại");
            } catch (Exception e) {
                System.out.print("Nhập sai định dạng, mời nhập lại: ");
            }
        }
        while (true) {
            switch (temp) {
                case 1:
                    SIZE += SIZE;
                    showUser();
                    break;
                case 2:
                    choiceFriend();
                    break;
                case 3:
                    Controller controller = new Controller(user);
                    controller.controllerChoice();
                    break;
                case 4:
//                loginLogic.loginChoice();
                    break;
            }
        }

    }

    private void searchForFavorite() {
        for (int i = 0; i < userList.size(); i++) {
            SearchUser searchUser = new SearchUser(userList.get(i), totalFavorite(userList.get(i)));
            searchUsers.add(searchUser);
        }
        sortFriendSearch();
    }

    private void sortFriendSearch() {
        for (int i = 0; i < searchUsers.size() - 1; i++) {
            for (int j = i + 1; j < searchUsers.size(); j++) {
                SearchUser temp = searchUsers.get(i);
                searchUsers.set(i, searchUsers.get(j));
                searchUsers.set(j, temp);
            }
        }
        showUser();
    }

    private void showUser() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println("+ ID= " + searchUsers.get(i).getUser().getId());
            System.out.println("+ Tên: " + searchUsers.get(i).getUser().getFullname());
        }
    }


    private int totalFavorite(User userx) {
        int total = 0;
        for (int i = 0; i < user.getFavoriteTypes().size(); i++) {
            if (userx.getFavoriteTypes().contains(user.getFavoriteTypes().get(i))) {
                total += total;
            }
        }
        return total;
    }

    private void choiceFriend() {
        List<User> userList1 = new ArrayList<>();
        String userId;
        User userAddFr;
        while (true) {
            userId = new Scanner(System.in).nextLine();
            userAddFr = findUserById(userId);
            if (userAddFr != null) {
                break;
            }
            System.out.print("không có mã " + userId + ", vui lòng nhập lại: ");
        }
        userList1.add(userAddFr);
        userMyFileUtil.writeDataFromFile(userList1, userId + "change.dat");
    }

    public User findUserById(String userId) {
        for (int i = 0; i < searchUsers.size(); i++) {
            if (Objects.equals(userId, searchUsers.get(i).getUser().getId())) {
                return userList.get(i);
            }
        }
        return null;
    }
}
