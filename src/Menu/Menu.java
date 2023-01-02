package Menu;

import Game.Game;
import Game.Tutorial;
import User.LogIn;
import User.RegisteUser;
import User.Users;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Menu {

    public static void mainMenu(){

        Scanner sc = new Scanner(System.in);
        System.out.println("‧‧‧‧‧‧‧" + "\uD835\uDE3E\uD835\uDE5D\uD835\uDE5A\uD835\uDE68\uD835\uDE68 \uD835\uDE5C\uD835\uDE56\uD835\uDE62\uD835\uDE5A" + "‧‧‧‧‧‧‧");
        System.out.println(" ① \uD835\uDDE7\uD835\uDE02\uD835\uDE01\uD835\uDDFC\uD835\uDDFF\uD835\uDDF6\uD835\uDDEE\uD835\uDDF9");
        System.out.println(" ② \uD835\uDDD6\uD835\uDDFF\uD835\uDDF2\uD835\uDDEE\uD835\uDE01\uD835\uDDF2 \uD835\uDE02\uD835\uDE00\uD835\uDDF2\uD835\uDDFF");
        System.out.println(" ③ \uD835\uDDDA\uD835\uDDEE\uD835\uDDFA\uD835\uDDF2");
        System.out.println(" ④ \uD835\uDDE6\uD835\uDDF2\uD835\uDDF2 \uD835\uDDFD\uD835\uDDF9\uD835\uDDEE\uD835\uDE06\uD835\uDDF2\uD835\uDDFF \uD835\uDDFD\uD835\uDDFF\uD835\uDDFC\uD835\uDDF3\uD835\uDDF6\uD835\uDDF9\uD835\uDDF2");
        int option = sc.nextInt();
        switch (option){
            case 1:
                Tutorial.showTutorial();
                mainMenu();
            break;
            case 2 :
                try{
                    RegisteUser.createUser();
                }catch (Exception e){
                    System.out.println("Unable to register");
                }
                mainMenu();
            break;
            case 3 :
                Game.gameScript();
                mainMenu();
                break;
            case 4:
                try {
                    Users.printAccount();
                }catch (Exception e){
                    System.out.println("Account doesn't exist");
                }
            default:
                mainMenu();
        }
    }
}
