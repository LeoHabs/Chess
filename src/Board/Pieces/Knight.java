package Board.Pieces;

public class Knight extends Piece{
    public Knight(String icon) {
        super("Knight", icon, 3);
    }

    public static  Knight createWhiteKnight(){
        return new Knight("♘");
    }

    public static Knight createBlackKnight(){
        return new Knight("♞");
    }

    public void movePiece(int vertical, int horizontal) {

    }
}
