package Board.Pieces;

public class Bishop extends Piece{
    public Bishop(String icon) {
        super("Bishop", icon, 3);
    }

    public static Bishop createWhiteBishop(){
        return new Bishop("♗");
    }

    public static Bishop createBlackBishop(){
        return new Bishop("♝");
    }

    @Override
    public void movePiece(int vertical, int horizontal) {

    }
}
