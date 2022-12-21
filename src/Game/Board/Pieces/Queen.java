package Game.Board.Pieces;

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


        //vertical
        for (int i = currentHorizontal - 1; i >= horizontal; i--) {
            if (Board.getBoard()[currentVertical][i].getPiece() != null) {
                System.out.println("There is something blocking the path!");
                return;
            }
            if (vertical == currentVertical && horizontal == currentHorizontal - i) {
                Board.movePiece(this, horizontal, vertical);
            }
        }

        for (int i = currentHorizontal - 1; i <= horizontal; i++) {
            if (Board.getBoard()[currentVertical][i].getPiece() != null) {
                System.out.println("There is something blocking the path!");
                return;
            }
            if (vertical == currentVertical && horizontal == currentHorizontal + i) {
                Board.movePiece(this, horizontal, vertical);
            }
        }

        //horizontal

        for (int i = currentVertical - 1; i >= vertical; i--) {
            if (Board.getBoard()[i][currentHorizontal].getPiece() != null) {
                System.out.println("There is something blocking the path!");
                return;
            }
            if (vertical == currentVertical - i && horizontal == currentHorizontal) {
                Board.movePiece(this, horizontal, vertical);
            }
        }

        for (int i = currentHorizontal - 1; i <= horizontal; i++) {
            if (Board.getBoard()[i][currentHorizontal].getPiece() != null) {
                System.out.println("There is something blocking the path!");
                return;
            }
            if (vertical == currentVertical + i && horizontal == currentHorizontal) {
                Board.movePiece(this, horizontal, vertical);
            }
        }

        //Diagonal para o lado superior direito
        if (currentVertical - vertical == -(currentHorizontal - horizontal)) {
            int saverDiagRight = currentHorizontal + 1;
            for (int i = currentVertical - 1; i >= vertical; i--) {
                if (Board.getBoard()[i][saverDiagRight].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return;
                }
                saverDiagRight++;
            }
            Board.movePiece(this, horizontal, vertical);
        }

        //Diagonal para o lado superior esquerdo
        if (currentVertical - vertical == currentHorizontal - horizontal) {
            int saverDiagLeft = currentHorizontal - 1;
            for (int i = currentVertical - 1; i >= vertical; i--) {
                if (Board.getBoard()[i][saverDiagLeft].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return;
                }
                saverDiagLeft--;
            }
            Board.movePiece(this, horizontal, vertical);
        }

        //Diagonal para o lado inferior direito
        if (-(currentVertical - vertical) == -(currentHorizontal - horizontal)) {
            int saverDiagRDwn = currentHorizontal + 1;
            for (int i = currentVertical + 1; i >= vertical; i++) {
                if (Board.getBoard()[i][saverDiagRDwn].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return;
                }
                saverDiagRDwn++;
            }
            Board.movePiece(this, horizontal, vertical);
        }

        //Diagonal para o lado superior esquerdo
        if (-(currentVertical - vertical) == currentHorizontal - horizontal) {
            int saverDiagLDwn = currentHorizontal - 1;
            for (int i = currentVertical + 1; i >= vertical; i++) {
                if (Board.getBoard()[i][saverDiagLDwn].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return;
                }
                saverDiagLDwn++;
            }
            Board.movePiece(this, horizontal, vertical);
        }
        System.out.println("Illegal move!");
    }

    @Override
    public void capturePiece() {

    }
}
