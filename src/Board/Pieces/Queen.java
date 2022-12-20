package Board.Pieces;

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

    public void movePiece(int vertical, int horizontal) {

    }
}
