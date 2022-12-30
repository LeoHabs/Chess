package Game;

import Game.Board.Pieces.Board;
import Game.Board.Pieces.Piece;
import Game.Player.Player;
import Menu.Menu;
import User.LogIn;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static Player whitePlayer;
    private static Player blackPlayer;

    public static Player gameScript() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("White Player: ");
        while (true) {
            try {
                Game.setWhitePlayer(new Player(LogIn.loginProcedure()));
                if (Game.getWhitePlayer().getUser() != null) {
                    break;
                }
                System.out.println("You need to create an account first if you haven't yet! Go back to menu?(Y/N)");
                if (scanner.next().equals("Y")) {
                    Menu.mainMenu();
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
                System.out.println("You need to create an account first if you haven't yet! Go back to menu?(Y/N)");
                if (scanner.next().equals("Y")) {
                    Menu.mainMenu();
                }
            } catch (java.io.IOException e) {
                System.out.println("Couldn't login :(");
            }
        }
        if (Game.getWhitePlayer().getUser().getUserName().equals(Game.getBlackPlayer().getUser().getUserName())) {
            System.out.println("You can't play against yourself!");
            gameScript();
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
            if (endGame() != null) {
                winner = endGame();
                break;
            }

            while (true) {
                if (play(blackPlayer)) {
                    break;
                }
            }
            Board.printBoard();
            if (endGame() != null) {
                winner = endGame();
                break;
            }
        }
        System.out.println(winner.getUser().getUserName() + "wins!");
        Player loser = null;
        if (winner.equals(Game.getWhitePlayer())) {
            loser = Game.getBlackPlayer();
        } else {
            loser = Game.getWhitePlayer();
        }
        try {
            updatePointsWinner(winner);
            updatePointsLoser(loser);
        } catch (Exception e) {
            System.out.println(" ");
        }
        return winner;
    }

    public static void updatePointsWinner(Player player) throws IOException {
        File file = new File("src/User/File/Names");
        String filename = "src/User/File/Names";
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuffer fw = new StringBuffer(filename);
        String line = br.readLine();
        while (br.readLine() != null) {
            line = br.readLine();
            if (line.contains(player.getUser().getUserName())) {
                String[] arrOfStr = line.split("\s");
                arrOfStr[5] = Integer.toString(player.getPoints() + counterPointsWinner(player));
                System.out.println(arrOfStr.length);
                //   fw.append(Arrays.toString(arrOfStr).substring(1, Arrays.toString(arrOfStr).length() - 1));
                break;
            }
        }
    }

    public static void updatePointsLoser(Player player) throws IOException {
        FileReader fileReader=new FileReader("/Users/pedrooliveira/Desktop/Chess/Chess/src/User/File/Names");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line=bufferedReader.readLine())!=null){
            if(line.contains(player.getUser().getUserName())){
                FileWriter fileWriter = new FileWriter("/Users/pedrooliveira/Desktop/Chess/Chess/src/User/File/Names");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                StringBuffer buffer = new StringBuffer("Page");

                buffer.append("...");
                buffer.append("Msg");

                bufferedWriter.write(buffer.toString());
            }
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
