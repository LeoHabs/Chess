
import Game.Board.Pieces.Board;
import Game.Board.Pieces.Pawn;
import Game.Game;
import Game.Player.Player;
import User.Users;


import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Game.setWhitePlayer(new Player(new Users()));
        Game.setBlackPlayer(new Player(new Users()));
        Game.gameScript();

    }

}