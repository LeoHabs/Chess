package Board;


import java.awt.*;

import Board.Pieces.*;
import Board.Spot.*;

public class Board {
    private static Spot[][] board= new Spot[8][8];


    public static void createBoard(){
        buildBoardSpots();
        placeRooks();
        placePawns();
        placeKnights();
        placeBishops();
        placeKingQueen();
    }
    public static void printBoard(){
        System.out.print("\033[1;37m");
        System.out.println("   A  B  C  D  E  F  G  H");
        System.out.print("\033[0m");
        for (int i = 0; i < board.length; i++) {
            System.out.print("\033[1;37m");
            System.out.print(i+1+" ");
            System.out.print("\033[0m");
            for (int j = 0; j < board[i].length; j++) {
                board[i][j].printSpot();
                if(j==7){
                    System.out.println();
                }
            }
        }
    }
    public static void placePawns(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[i].length; j++) {
                if(i == 1){
                    board[i][j].setPiece(Pawn.createBlackPawn());
                }
                if (i == 6){
                    board[i][j].setPiece(Pawn.createWhitePawn());
                }
            }
        }
    }

    public static void placeRooks(){
        board[0][0].setPiece(Rook.createBlackRook());
        board[0][7].setPiece(Rook.createBlackRook());
        board[7][0].setPiece(Rook.createWhiteRook());
        board[7][7].setPiece(Rook.createWhiteRook());
    }

    public static void placeKnights(){
        board[0][1].setPiece(Knight.createBlackKnight());
        board[0][6].setPiece(Knight.createBlackKnight());
        board[7][6].setPiece(Knight.createWhiteKnight());
        board[7][1].setPiece(Knight.createWhiteKnight());
    }

    public static void placeBishops(){
        board[0][2].setPiece(Bishop.createBlackBishop());
        board[0][5].setPiece(Bishop.createBlackBishop());
        board[7][2].setPiece(Bishop.createWhiteBishop());
        board[7][5].setPiece(Bishop.createWhiteBishop());
    }

    public static void placeKingQueen(){
        board[0][3].setPiece(Queen.createBlackQueen());
        board[0][4].setPiece(King.createBlackKing());
        board[7][3].setPiece(Queen.createWhiteQueen());
        board[7][4].setPiece(King.createWhiteKing());


    }
    public static void buildBoardSpots(){
        for (int i = 0; i < board.length; i++) {
            if(i%2 != 0){
                for (int j = 0; j <board[i].length; j++) {
                    if(j%2 != 0){
                       board[i][j] = new Spot("\033[0;100m" ,null);
                    }else{
                        board[i][j] = new Spot("\u001B[47m", null);
                    }
                }
            }else{
                for (int j = 0; j < board[i].length; j++) {
                    if (j%2 != 0){
                        board[i][j] = new Spot("\u001B[47m",null);
                    }else{
                        board[i][j] = new Spot("\033[0;100m",null);
                    }
                }
            }

        }
    }

    public static Spot[][] getBoard() {
        return board;
    }

    public static int getVertical(Piece piece){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                    if(board[i][j].getPiece().equals(piece)){
                        return i;
                }
            }
        }
        System.out.println("Piece isn't on the board");
        return 0;
    }


    public static int getHorizontal(Piece piece){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].getPiece().equals(piece)){
                    return j;
                }
            }
        }
        System.out.println("Piece isn't on the board");
        return 0;
    }

    public static void movePiece(Piece piece,int horizontal,int vertical){
        board[getVertical(piece)][getHorizontal(piece)].setPiece(null);
        board[vertical][horizontal].setPiece(piece);
    }
}
