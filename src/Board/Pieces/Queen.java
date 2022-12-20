package Board.Pieces;

import Board.Board;

public class Queen extends Piece{
    public Queen( String icon) {
        super("Queen", icon, 9);
    }

    public static Queen createWhiteQueen(){
        return new Queen("♕");
    }

    public static Queen createBlackQueen(){
        return new Queen("♛");
    }

    @Override
    public void movePiece(int vertical, int horizontal) {

        int currentVertical = Board.getVertical(this);
        int currentHorizontal = Board.getHorizontal(this);





    }
}
