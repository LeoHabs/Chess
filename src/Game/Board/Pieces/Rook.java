package Game.Board.Pieces;

public class Rook extends Piece {

    public Rook(String icon) {
        super("Rook", icon, 5);
    }

    public static Rook createWhiteRook() {
        return new Rook("♖");
    }

    public static Rook createBlackRook() {
        return new Rook("♜");
    }

    @Override
    public void movePiece(int vertical, int horizontal) {
        int currentVertical = Board.getVertical(this);
        int currentHorizontal = Board.getHorizontal(this);

        //check vertical
        for (int i = currentHorizontal - 1; i >= horizontal; i--) {
            if (Board.getBoard()[currentVertical][i].getPiece() != null) {
                System.out.println("There is something blocking the path!");
                return;
            }
        }

        if (vertical == currentVertical && horizontal == currentHorizontal - horizontal) {
            Board.movePiece(this, horizontal, vertical);
        }


        for (int i = currentHorizontal - 1; i <= horizontal; i++) {
            if (Board.getBoard()[currentVertical][i].getPiece() != null) {
                System.out.println("There is something blocking the path!");
                return;
            }
        }

        if (vertical == currentVertical && horizontal == currentHorizontal + horizontal) {
            Board.movePiece(this, horizontal, vertical);
        }


        //check horizontal
        for (int i = currentVertical - 1; i >= vertical; i--) {
            if (Board.getBoard()[i][currentHorizontal].getPiece() != null) {
                System.out.println("There is something blocking the path!");
                return;
            }
        }

        if (horizontal == currentHorizontal && vertical == currentHorizontal - vertical) {
            Board.movePiece(this, horizontal, vertical);
        }


        for (int i = currentVertical - 1; i <= vertical; i++) {
            if (Board.getBoard()[i][currentHorizontal].getPiece() != null) {
                System.out.println("There is something blocking the path!");
                return;
            }
        }

        if (horizontal == currentHorizontal && vertical == currentHorizontal + vertical) {
            Board.movePiece(this, horizontal, vertical);
        }
        System.out.println("Illegal move!");
    }
}
