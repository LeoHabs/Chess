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
    public boolean movePiece(int vertical, int horizontal) {

            int currentVertical = Board.getVertical(this);
            int currentHorizontal = Board.getHorizontal(this);

            if (horizontal == currentHorizontal - 1 && vertical == currentVertical) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (horizontal == currentHorizontal - 1 && vertical == currentVertical + 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (horizontal == currentHorizontal && vertical == currentVertical + 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (horizontal == currentHorizontal + 1 && vertical == currentVertical + 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (horizontal == currentHorizontal + 1 && vertical == currentVertical) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (horizontal == currentHorizontal + 1 && vertical == currentVertical - 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (horizontal == currentHorizontal - 1 && vertical == currentVertical - 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            System.out.println("Illegal move");
            return false;
        }

}
