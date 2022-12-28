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
    public boolean movePiece(int vertical, int horizontal) {


            int currentVertical = Board.getVertical(this);
            int currentHorizontal = Board.getHorizontal(this);

            for (int i = currentHorizontal - 1; i > horizontal; i--) {
                if (Board.getBoard()[currentVertical][i].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return false;
                }
            }

            if (vertical == currentVertical && horizontal == currentHorizontal - horizontal) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
            }

            for (int i = currentHorizontal - 1; i < horizontal; i++) {
                if (Board.getBoard()[currentVertical][i].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return false;
                }
            }

            if (vertical == currentVertical && horizontal == currentHorizontal + horizontal) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }

            //check horizontal
            for (int i = currentVertical - 1; i > vertical; i--) {
                if (Board.getBoard()[i][currentHorizontal].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return false;
                }
            }

            if (horizontal == currentHorizontal && vertical == currentHorizontal - vertical) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }

            for (int i = currentVertical - 1; i < vertical; i++) {
                if (Board.getBoard()[i][currentHorizontal].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return false;
                }
            }

            if (horizontal == currentHorizontal && vertical == currentHorizontal + vertical) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }

            for (int i = currentVertical; i > vertical; i--) {
                for (int j = currentHorizontal - 1; j >= horizontal; j--) {
                    if (Board.getBoard()[i][j].getPiece() != null) {
                        System.out.println("There is something blocking the path!");
                        return false;
                    }
                    this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                    Board.movePiece(this, horizontal, vertical);
                    return true;
                }
            }

            for (int i = currentVertical; i < vertical; i++) {
                for (int j = currentHorizontal - 1; j <= horizontal; j++) {
                    if (Board.getBoard()[i][j].getPiece() != null) {
                        System.out.println("There is something blocking the path!");
                        return false;
                    }
                    this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                    Board.movePiece(this, horizontal, vertical);
                    return true;
                }
            }
            System.out.println("Illegal move!");
            return false;
    }
}