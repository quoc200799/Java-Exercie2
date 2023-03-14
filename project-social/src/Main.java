import entity.User;
import logic.LoginLogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

//        System.out.println(user);
//        User user = new User();
//        user.inforInput();
//        System.out.println(user);
//        System.out.println(user.getFavoriteTypes());
//        String str = new Scanner(System.in).nextLine();
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        format.setLenient(false);
//        Date now = new Date();
//        System.out.println(format.parse(str).getTime()); //919357200000
//        System.out.println(now.getTime());               //1678556061664
//                                                          //- 8734
        LoginLogic loginLogic = new LoginLogic();
        loginLogic.loginChoice();
    }
}