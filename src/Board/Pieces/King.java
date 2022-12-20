package Board.Pieces;

public class King extends Piece{
    public King(String icon) {
        super("King", icon, 0);
    }

    public static King createWhiteKing(){
        return new King("♔");
    }

    public static King createBlackKing(){
        return new King("♚");
    }

    public void movePiece(int vertical, int horizontal) {

    }
}
