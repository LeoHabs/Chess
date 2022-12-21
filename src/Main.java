import Board.Board;
import Board.Pieces.Knight;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Board.createBoard();
        Board.printBoard();
        Board.movePiece(Board.getBoard()[6][3].getPiece(),3,5);
        Board.getBoard()[7][2].getPiece().movePiece(3,6);
        Board.printBoard();

    }


}