package Board.Pieces;

import Board.Board;

public class Rook extends Piece{

    public Rook(String icon) {
        super("Rook", icon, 5);
    }

    public static Rook createWhiteRook(){
        return new Rook("♖");
    }

    public static Rook createBlackRook(){
        return new Rook("♜");
    }

    @Override
    public void movePiece(int vertical, int horizontal) {

        int currentVertical = Board.getVertical(this);
        int currentHorizontal = Board.getHorizontal(this);

        if (vertical == currentVertical + vertical || horizontal == currentHorizontal + horizontal) {
            Board.movePiece(this, horizontal, vertical);
        }
    }
}
