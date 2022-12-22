
import Game.Board.Pieces.Board;


import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Board.createBoard();
        Board.printBoard();
        Board.getBoard()[6][0].getPiece().movePiece(6,3);
        Board.printBoard();
    }

}