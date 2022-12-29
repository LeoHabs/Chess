package Game;

import Game.Board.Pieces.Board;
import Game.Board.Pieces.Piece;
import Game.Player.Player;
import User.LogIn;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static Player whitePlayer;
    private static Player blackPlayer;

    public static Player gameScript() {
        System.out.println("White Player: ");
        while (true) {
            try {
                Game.setWhitePlayer(new Player(LogIn.loginProcedure()));
                if (Game.getWhitePlayer().getUser() != null) {
                    break;
                }
            } catch (java.io.IOException e) {
                System.out.println("Couldn't login :(");
            }
        }
        System.out.println("Black Player");
        while (true) {
            try {
                Game.setBlackPlayer(new Player(LogIn.loginProcedure()));
                if (Game.getBlackPlayer().getUser() != null) {
                    break;
                }
                break;
            } catch (java.io.IOException e) {
                System.out.println("Couldn't login :(");
            }
        }

        Board.createBoard();
        Board.printBoard();
        Player winner = null;
        while (true) {
            while (true) {
                if (play(whitePlayer)) {
                    break;
                }
            }
            Board.printBoard();
            if (endGame() != null){
                winner = endGame();
                break;
            }

            while (true) {
                if (play(blackPlayer)) {
                    break;
                }
            }
            Board.printBoard();
            if (endGame() != null){
                winner = endGame();
                break;
            }
        }
        System.out.println(winner.getUser().getUserName());
        Player loser = null;
        if (winner.equals(Game.getWhitePlayer())) {
            loser = Game.getBlackPlayer();
        } else {
            loser = Game.getWhitePlayer();
        }
        try{
            updatePointsWinner(winner);
            updatePointsLoser(loser);
        }catch (Exception e){
            System.out.println(" ");
        }
        return winner;
    }

    public static void updatePointsWinner(Player player) throws IOException {
        File file = new File("src/User/File/Names");
        String filename = "src/User/File/Names";
        BufferedReader br = new BufferedReader(new FileReader(file));
        FileWriter fw = new FileWriter(filename, true);
        String line = br.readLine();
        while (br.readLine() != null) {
            line = br.readLine();
            if (line.contains(player.getUser().getUserName())) {
                String[] arrOfStr = line.split("\s");
                arrOfStr[5] = Integer.toString(player.getPoints() + counterPointsWinner(player));
                fw.write(Arrays.toString(arrOfStr));
                break;
            }
        }
        fw.close();
    }

    public static void updatePointsLoser(Player player) throws IOException {
        File file = new File("src/User/File/Names");
        String filename = "src/User/File/Names";
        BufferedReader br = new BufferedReader(new FileReader(file));
        FileWriter fw = new FileWriter(filename, true);
        String line = br.readLine();
        while (br.readLine() != null) {
            line = br.readLine();
            if (line.contains(player.getUser().getUserName())) {
                String[] arrOfStr = line.split("\s");
                arrOfStr[5] = Integer.toString(player.getPoints() + counterPointsLoser(player));
                fw.write(Arrays.toString(arrOfStr));
                break;
            }
            fw.close();
        }


    }

    public static int counterPointsWinner(Player player) {

        return 500 + player.getPoints() * (-(player.getMoves() * 2));
    }

    public static int counterPointsLoser(Player player) {

        return 200 + player.getPoints() * (-(player.getMoves() * 2));
    }

    public static boolean play(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("From: ");
        String choiceFrom = scanner.next();
        if (choiceFrom.length() != 2) {
            System.out.println("Not a valid coordinate");
            return false;
        }
        Piece pieceToMove = Board.getBoard()[Board.letterToInt(choiceFrom.substring(0, 1))][Integer.parseInt(choiceFrom.substring(1, 2)) - 1].getPiece();
        if (player.getPlayerPieces().contains(pieceToMove)) {
            System.out.print("To: ");
            String choiceTo = scanner.next();
            if (choiceTo.length() != 2) {
                return false;
            }
            Piece pieceToCapture = Board.getBoard()[Board.letterToInt(choiceTo.substring(0, 1))][Integer.parseInt(choiceTo.substring(1, 2)) - 1].getPiece();
            if (pieceToMove.checkCapturePiece(pieceToCapture) || pieceToCapture == null) {
                if (pieceToMove.movePiece(Board.letterToInt(choiceTo.substring(0, 1)), Integer.parseInt(choiceTo.substring(1, 2)) - 1)) {
                    return true;
                } else {
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
