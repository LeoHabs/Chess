package Game.Board.Pieces;

public class Knight extends Piece {
    public Knight(String icon) {
        super("Knight", icon, 3);
    }

    public static Knight createWhiteKnight() {
        return new Knight("♘");
    }

    public static Knight createBlackKnight() {
        return new Knight("♞");
    }

    public void movePiece(int vertical, int horizontal) {
        int currentVertical = Board.getVertical(this);
        int currentHorizontal = Board.getHorizontal(this);

        if (vertical == currentVertical - 2 && horizontal == currentHorizontal - 1) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (vertical == currentVertical - 1 && horizontal == currentHorizontal - 2) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (vertical == currentVertical + 1 && horizontal == currentHorizontal - 2) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (vertical == currentVertical + 2 && horizontal == currentHorizontal - 1) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (vertical == currentVertical + 2 && horizontal == currentHorizontal + 1) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (vertical == currentVertical + 1 && horizontal == currentHorizontal + 2) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (vertical == currentVertical - 1 && horizontal == currentHorizontal + 2) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        if (vertical == currentVertical - 2 && horizontal == currentHorizontal + 1) {
            Board.movePiece(this, horizontal, vertical);
            return;
        }
        System.out.println("Illegal move!");
    }
}
