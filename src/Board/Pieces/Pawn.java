package Board.Pieces;

import Board.Board;

import java.util.Scanner;

public class Pawn extends  Piece{

    private boolean isFirstMove = true;

    public Pawn(String icon) {
        super("Pawn", icon, 1);
    }

    public static Pawn createWhitePawn() {
        return new Pawn("♙");
    }

    public static Pawn createBlackPawn() {
        return new Pawn("♟");
    }

    @Override
    public void movePiece(int vertical, int horizontal) {

        int currentVertical = Board.getVertical(this);

        if (isFirstMove) {
            if (vertical == currentVertical - 2 || vertical == currentVertical - 1) {
                Board.movePiece(this, horizontal, vertical);
            } else if (vertical == currentVertical + 2 || vertical == currentVertical + 1) {
                Board.movePiece(this, horizontal, vertical);
            }
        } else {
            if (vertical == currentVertical - 1) {
                Board.movePiece(this, horizontal, vertical);
            } else if (vertical == currentVertical + 1) {
                Board.movePiece(this, horizontal, vertical);
            }
        }
    }
}
