package User;


import java.io.*;
import java.util.Scanner;

public class LogIn {
    public static Users loginProcedure() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        Users user = null;
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
        System.out.print("Password: ");
            String password = scanner.next();
        System.out.println(arrOfStr[4]);
            if (password.equals(arrOfStr[4])) {
                return new Users(arrOfStr[0], arrOfStr[1], arrOfStr[2], arrOfStr[3], arrOfStr[4],"0");
            }
            System.out.println("Your username or password is wrong");
            br.close();
            return null;
    }
}
