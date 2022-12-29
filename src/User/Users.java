package User;

import Game.Player.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Users {

    private String name;
    private String userName;
    private String age;
    private String email;
    private String password;

    private String points;
    private boolean logIn;

    public Users(String userName, String name, String age, String email, String password, String points) {
        this.name = name;
        this.userName = userName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.points = points;
    }

    public Users() {

    }

    public boolean login() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Password: ");
        if (scanner.next().equals(getPassword())) {
            this.logIn = true;

            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public boolean isLogIn() {
        return logIn;
    }

    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }

    public String toString() {
        return getName() + getUserName() + getAge() + getEmail() + getPassword();
    }

    public static void printAccount() throws Exception {
        Scanner scanner = new Scanner(System.in);

        File file = new File("src/User/File/Names");
        String filename = "src/User/File/Names";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        System.out.print("Username: ");
        String userName = scanner.next();
        while (br.readLine() != null) {
            line = br.readLine();
            if (line.contains(userName)) {
                break;
            }
        }
        String[] arrOfStr = line.split("\s");

        System.out.println("👨‍🦲Name: " + arrOfStr[1]);
        System.out.println("🤓Username: " + arrOfStr[0]);
        System.out.println("👶Age: " + arrOfStr[2]);
        System.out.println("＠Email: " + arrOfStr[3]);
        System.out.println("💎Points: " + arrOfStr[5]);
        System.out.println("🤴Rank: " + printRank(Integer.parseInt(arrOfStr[5])));
    }

    public static String printRank(Player player) {
        try {
            File file = new File("src/User/File/Names");
            String filename = "src/User/File/Names";
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            System.out.print("Username: ");
            String userName = player.getUser().getUserName();
            while (br.readLine() != null) {
                line = br.readLine();
                if (line.contains(userName)) {
                    break;
                }

                String[] arrOfStr = line.split("\s");
                int points = Integer.parseInt(arrOfStr[5]);
                System.out.print(points);
                if (points > 13000) {
                    return "🗡";
                }
                if (points > 8500) {
                    return "🪓";
                }
                if (points > 4500) {
                    return "🔨";
                }
                if (points > 2500) {
                    return "🎣";
                }
                if (points > 1000) {
                    return "🧹";
                }
                return null;
            }
        } catch (Exception e) {
            return " ";
        }
        return " ";
    }

    public static String printRank(int points) {
        if (points > 13000) {
            return "🗡";
        }
        if (points > 8500) {
            return "🪓";
        }
        if (points > 4500) {
            return "🔨";
        }
        if (points > 2500) {
            return "🎣";
        }
        if (points > 1000) {
            return "🧹";
        }
        return null;
    }
}
