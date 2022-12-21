package Board.Pieces;

import Board.Board;

public class Queen extends Piece {
    public Queen(String icon) {

        super("Queen", icon, 9);
    }

    public static Queen createWhiteQueen() {

        return new Queen("♕");
    }

    public static Queen createBlackQueen() {

        return new Queen("♛");
    }

    @Override
    public void movePiece(int vertical, int horizontal) {

        int currentVertical = Board.getVertical(this);
        int currentHorizontal = Board.getHorizontal(this);

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

        for (int i = currentVertical; i >= vertical; i--) {
            for (int j = currentHorizontal - 1; j >= horizontal; j--) {
                if (Board.getBoard()[i][currentHorizontal].getPiece() != null && Board.getBoard()[currentVertical][j].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return;
                }
                Board.movePiece(this, horizontal, vertical);
            }
        }

        for (int i = currentVertical; i <= vertical; i++) {
            for (int j = currentHorizontal - 1; j <= horizontal; j++) {
                if (Board.getBoard()[i][currentHorizontal].getPiece() != null && Board.getBoard()[currentVertical][j].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return;
                }
                Board.movePiece(this, horizontal, vertical);
            }
        }
    }
}
