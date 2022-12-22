package Game.Board.Pieces;



public class Pawn extends  Piece {

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
            int currentHorizontal = Board.getHorizontal(this);

            if (isFirstMove) {
                if (vertical == currentVertical - 2 && currentHorizontal == horizontal || vertical == currentVertical - 1 && currentHorizontal == horizontal) {
                    this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                    Board.movePiece(this, horizontal, vertical);
                }
                if (vertical == currentVertical + 2 && currentHorizontal == horizontal || vertical == currentVertical + 1 && currentHorizontal == horizontal) {
                    this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                    Board.movePiece(this, horizontal, vertical);
                }
            } else {
                if (vertical == currentVertical - 1 && currentHorizontal == horizontal) {
                    this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                    Board.movePiece(this, horizontal, vertical);
                }
                if (vertical == currentVertical + 1 && currentHorizontal == horizontal) {
                    this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                    Board.movePiece(this, horizontal, vertical);
                }
            }
            System.out.println("Illegal move!");
    }
}
