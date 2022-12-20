import Board.Board;
import Board.Pieces.Knight;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Board.createBoard();
        Board.printBoard();
        Board.getBoard()[0][1].getPiece().movePiece(2,1);
        Board.printBoard();
    }
}