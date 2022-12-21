package Board.Pieces;

import Board.Board;

import java.util.Objects;

public class Bishop extends Piece {
    public Bishop(String icon) {
        super("Bishop", icon, 3);
    }

    public static Bishop createWhiteBishop() {
        return new Bishop("♗");
    }

    public static Bishop createBlackBishop() {
        return new Bishop("♝");
    }

    @Override
    public void movePiece(int vertical, int horizontal) {

        int currentVertical = Board.getVertical(this);
        int currentHorizontal = Board.getHorizontal(this);

        if (horizontal == currentHorizontal && vertical != currentVertical) {
            System.out.println("Illegal movement");
            return;
        }
        if (horizontal != currentHorizontal && vertical == currentVertical) {
            System.out.println("Illegal movement");
            return;
        }

        int saverDiagRight = currentHorizontal +1 ;
        for (int i = currentVertical - 1; i >= vertical; i--) {
              if(Board.getBoard()[i][saverDiagRight].getPiece() != null){
                  System.out.println("There is something blocking the path!");
                  return;
              }
            saverDiagRight++;
        }

        Board.movePiece(this, horizontal, vertical);
    }
    
}
