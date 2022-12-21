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
        int currentVertical = Board.getVertical(this);
        int currentHorizontal = Board.getHorizontal(this);

        if (horizontal == currentHorizontal - 1 && vertical == currentVertical) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (horizontal == currentHorizontal - 1 && vertical == currentVertical + 1) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (horizontal == currentHorizontal && vertical == currentVertical + 1) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (horizontal == currentHorizontal + 1 && vertical == currentVertical + 1) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (horizontal == currentHorizontal + 1 && vertical == currentVertical) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (horizontal == currentHorizontal + 1 && vertical == currentVertical - 1) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (horizontal == currentHorizontal - 1 && vertical == currentVertical - 1) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }

        System.out.println("Illegal move");
    }
}
