package Game.Board.Pieces;


import Game.Game;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Pawn extends Piece {

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
    public boolean movePiece(int vertical, int horizontal) {
        int currentVertical = Board.getVertical(this);
        int currentHorizontal = Board.getHorizontal(this);

        if (Board.getBoard()[vertical][horizontal].getPiece() == null) {
            if (isFirstMove) {
                if (Game.getWhitePlayer().getPlayerPieces().contains(this)) {
                    if (vertical == currentVertical - 2) {
                        Board.movePiece(this, horizontal, vertical);
                        isFirstMove = false;
                        return true;
                    }
                    if (vertical == currentVertical - 1) {
                        Board.movePiece(this, horizontal, vertical);
                        isFirstMove = false;
                        return true;
                    }
                } else {
                    if (vertical == currentVertical + 2 && currentHorizontal == horizontal) {
                        Board.movePiece(this, horizontal, vertical);
                        isFirstMove = false;
                        return true;
                    }
                    if (vertical == currentVertical + 1 && currentHorizontal == horizontal) {
                        Board.movePiece(this, horizontal, vertical);
                        isFirstMove = false;
                        return true;
                    }
                }
            } else {
                if (Game.getWhitePlayer().getPlayerPieces().contains(this)) {
                    if (vertical == currentVertical - 1 && currentHorizontal == horizontal) {
                        Board.movePiece(this, horizontal, vertical);
                        return true;
                    }
                    if (vertical == currentVertical + 1 && currentHorizontal == horizontal) {
                        Board.movePiece(this, horizontal, vertical);
                        return true;
                    }
                }
            }
        }
        if (Board.getBoard()[vertical][horizontal].getPiece() != null) {
            if (Math.abs(currentVertical - vertical) == 1 && Math.abs(currentHorizontal - horizontal) == 1 && Math.abs(currentVertical - vertical) == Math.abs(currentHorizontal - horizontal)) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
        }
        System.out.println("Illegal move!");
        return false;
    }

}
