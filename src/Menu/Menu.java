package Menu;

import Game.Game;
import Game.Tutorial;
import User.LogIn;
import User.RegisteUser;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Menu {


    public static void mainMenu(){

        Scanner sc = new Scanner(System.in);
        System.out.println("‧‧‧‧‧‧‧" + "\uD835\uDE3E\uD835\uDE5D\uD835\uDE5A\uD835\uDE68\uD835\uDE68 \uD835\uDE5C\uD835\uDE56\uD835\uDE62\uD835\uDE5A" + "‧‧‧‧‧‧‧");
        System.out.println(" ① \uD835\uDDE7\uD835\uDE02\uD835\uDE01\uD835\uDDFC\uD835\uDDFF\uD835\uDDF6\uD835\uDDEE\uD835\uDDF9");
        System.out.println(" ② \uD835\uDDD6\uD835\uDDFF\uD835\uDDF2\uD835\uDDEE\uD835\uDE01\uD835\uDDF2 \uD835\uDE02\uD835\uDE00\uD835\uDDF2\uD835\uDDFF");
        System.out.println(" ③ \uD835\uDDDA\uD835\uDDEE\uD835\uDDFA\uD835\uDDF2");
        int option = sc.nextInt();
        switch (option){
            case 1 -> Tutorial.showTutorial();
            //case 2 ->
            case 3 -> Game.gameScript();
        }
    }



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
