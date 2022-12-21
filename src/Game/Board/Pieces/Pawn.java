package Game.Board.Pieces;

public class Pawn extends  Piece{
    public Pawn(String icon) {
        super("Pawn", icon, 1);
    }

    public static Pawn  createWhitePawn(){
        return new Pawn("♙");
    }

    public static Pawn createBlackPawn(){
        return new Pawn("♟");
    }


    public void movePiece(int vertical, int horizontal) {

    }
}
