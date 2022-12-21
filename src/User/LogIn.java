package User;

import Board.Board;


import java.util.Scanner;

public class LogIn {
    public static void loginProcedure() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        Users user = null;

        while (count < 3) {
            System.out.println("Username: ");
            user = checkLogin(scanner.next());
            if (user == null) {
                return;
            }

            if (user.login()) {
                DataBase.setCurrentUser(user);
                Board.createBoard();
                Board.printBoard();
                return;
            } else {
                System.out.println("\033[0;31m" + "Your username or password " + "\033[39m" + "\033[49m");
                count++;
            }
        }
    }

    public static Users checkLogin(String userName) {
        for (int i = 0; i < DataBase.users.size(); i++) {
            if (userName.equals(DataBase.users.get(i).getUserName())) {
                return DataBase.users.get(i);


            }
        }
        System.out.println("\033[0;31m" + "User not found" + "\033[39m" + "\033[49m");
        return null;
    }

}
