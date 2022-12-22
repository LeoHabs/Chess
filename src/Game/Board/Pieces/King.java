package Game.Board.Pieces;

public class King extends Piece {
    public King(String icon) {
        super("King", icon, 0);
    }

    public static King createWhiteKing() {
        return new King("♔");
    }

    public static King createBlackKing() {
        return new King("♚");
    }

    @Override
    public void movePiece(int vertical, int horizontal) {
        if(checkCapturePiece(Board.getBoard()[vertical][horizontal].getPiece())) {
            int currentVertical = Board.getVertical(this);
            int currentHorizontal = Board.getHorizontal(this);

            if (horizontal == currentHorizontal - 1 && vertical == currentVertical) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return;
            }
            if (horizontal == currentHorizontal - 1 && vertical == currentVertical + 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return;
            }
            if (horizontal == currentHorizontal && vertical == currentVertical + 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return;
            }
            if (horizontal == currentHorizontal + 1 && vertical == currentVertical + 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return;
            }
            if (horizontal == currentHorizontal + 1 && vertical == currentVertical) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return;
            }
            if (horizontal == currentHorizontal + 1 && vertical == currentVertical - 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return;
            }
            if (horizontal == currentHorizontal - 1 && vertical == currentVertical - 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return;
            }
            System.out.println("Illegal move");
        }
    }
}
