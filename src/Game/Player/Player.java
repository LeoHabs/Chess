package Game.Player;
import Game.Board.Pieces.Board.Pieces.Piece;
import User.Users;
import java.util.ArrayList;

public class Player {
    private Users user;
    private ArrayList<Piece> playerPieces = new ArrayList<>();
    private ArrayList<Piece> capturedPieces = new ArrayList<>();

    public Player(Users user) {
        this.user = user;
    }

    public ArrayList<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    public ArrayList<Piece> getPlayerPieces() {
        return playerPieces;
    }


}
