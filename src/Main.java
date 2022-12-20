import Board.Board;
import User.RegisteUser;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Board.createBoard();
        Board.printBoard();
        RegisteUser.createUser();
    }
}