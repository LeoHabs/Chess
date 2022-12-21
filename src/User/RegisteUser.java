package User;

import java.awt.*;
import java.util.Scanner;

public class RegisteUser {
    public static void createUser() {
        Scanner scanner = new Scanner(System.in);
        Users user = new Users();
        String password = "";
        String email = "";
        System.out.print("Name: ");
        user.setName(scanner.next());
        while (true) {
            System.out.print("User Name: ");
            user.setUserName(scanner.next());
            if (Checkers.checkUser(user)) {
                System.out.println("\033[0;31m" + "Username already exists" + "\033[39m" + "\033[49m");
                continue;
            }
            break;
        }
        try {
            while (true) {
                System.out.print("Age: ");
                user.setAge(scanner.nextInt());
                if (user.getAge() < 10) {
                    System.out.println("\033[0;31m" + "You need to be 10 years old to register." + "\033[39m" + "\033[49m");
                    continue;
                }
                break;
            }
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "Number not recognized." + "\033[39m" + "\033[49m");
        }


        while (!Checkers.emailValid(email)) {
            System.out.print("Email: ");
            email = scanner.next();
            if (Checkers.emailValid(email)) {
                user.setEmail(email);
                break;
            }
            System.out.println("\033[0;31m" + "Your email needs to have a \"@\" and a \".\"" + "\033[39m" + "\033[49m");

        }

        while (!Checkers.passValid(password)) {
            System.out.print("Password: ");
            password = scanner.next();

            if (Checkers.passValid(password)) {
                user.setPassword(password);
                break;
            }

            System.out.println("\033[0;31m" + "Your password needs:" +
                    "Letters Uppercase and Lowercase " +
                    "Special characters " +
                    "Numbers " + "\033[39m" + "\033[49m");
        }
        DataBase.users.add(user);
        System.out.println("Name: " + user.getName());
        System.out.println("User Name: " + user.getUserName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());

    }

}
