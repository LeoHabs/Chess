package Game;

import Game.Board.Pieces.Board;
import Game.Board.Pieces.Piece;
import Game.Player.Player;
import User.Users;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static Player whitePlayer;
    private static Player blackPlayer;


    //Falta escolher quem é quem
    public static Player gameScript() {
        Board.createBoard();
        Board.printBoard();
        Player winner = null;
        while (winner == null) {
            while (true){
                if(play(whitePlayer)){
                    break;
                }
            }
            Board.printBoard();
            while (true){
                if(play(blackPlayer)){
                    break;
                }
            }
            Board.printBoard();
            winner = endGame();
        }
        return winner;
    }


    public static boolean play(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("From: ");
        String choiceFrom = scanner.next();
        if (choiceFrom.length() != 2) {
            System.out.println("Not a valid coordinate");
            return false;
        }
        Piece pieceToMove = Board.getBoard()[Board.letterToInt(choiceFrom.substring(0, 1))][Integer.parseInt(choiceFrom.substring(1, 2))-1].getPiece();
        if (player.getPlayerPieces().contains(pieceToMove)) {
            System.out.print("To: ");
            String choiceTo = scanner.next();
            if(choiceTo.length()!=2){
                return false;
            }
            Piece pieceToCapture = Board.getBoard()[Board.letterToInt(choiceTo.substring(0, 1))][Integer.parseInt(choiceTo.substring(1, 2))-1].getPiece();
            if (pieceToMove.checkCapturePiece(pieceToCapture) || pieceToCapture == null) {
                if(pieceToMove.movePiece(Board.letterToInt(choiceTo.substring(0, 1)), Integer.parseInt(choiceTo.substring(1, 2)) - 1)){
                    return true;
                }else{
                    return false;
                }
            }
        } else {
            System.out.println("No piece of yours in that coordinate");
        }
        return false;
    }


    public static Player getWhitePlayer() {
        return whitePlayer;
    }

    public static Player getBlackPlayer() {
        return blackPlayer;
    }


    public static void setWhitePlayer(Player player) {
        whitePlayer = player;
    }

    public static void setBlackPlayer(Player player) {
        blackPlayer = player;
    }

    public static Player endGame() {
        for (int i = 0; i < getWhitePlayer().getCapturedPieces().size(); i++) {
            if (getWhitePlayer().getCapturedPieces().get(i).getName().equals("King")) {
                return whitePlayer;
            }
        }
        for (int i = 0; i < getBlackPlayer().getCapturedPieces().size(); i++) {
            if (getBlackPlayer().getCapturedPieces().get(i).getName().equals("King")) {
                return blackPlayer;
            }
        }
        return null;
    }
}
