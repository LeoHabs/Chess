package Menu;

import User.LogIn;
import User.RegisteUser;

import java.util.Scanner;

public class Menu {
    public static void menuLoginRegister() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equals("3")) {

            System.out.println("1 -> Register:");
            System.out.println("2 -> Log In:");
            System.out.print("Choose option:");
            choice = scanner.next();

            switch (choice) {
                case "1" -> RegisteUser.createUser();
                case "2" -> LogIn.loginProcedure();
            }
        }
    }
}
