package Game.Board.Pieces;

public class Bishop extends Piece {
    public Bishop(String icon) {
        super("Bishop", icon, 3);
    }

    public static Bishop createWhiteBishop() {
        return new Bishop("♗");
    }

    public static Bishop createBlackBishop() {
        return new Bishop("♝");
    }

    public void movePiece(int vertical, int horizontal) {
        if(checkCapturePiece(Board.getBoard()[vertical][horizontal].getPiece())) {
            int currentVertical = Board.getVertical(this);
            int currentHorizontal = Board.getHorizontal(this);


            if (!(Math.abs(currentVertical - vertical) == Math.abs(currentHorizontal - horizontal))) {
                System.out.println("Illegal movement");
                return;
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
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
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
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
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
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
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
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
            }
        }
    }
    
}
