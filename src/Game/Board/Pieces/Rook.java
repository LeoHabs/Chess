package Game.Board.Pieces;

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

    }
}
