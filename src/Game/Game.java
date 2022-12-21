package Game;

import Game.Player.Player;
import User.Users;

import java.util.ArrayList;

public class Game {
    private static Player whitePlayer = new Player(new Users());
    private static Player blackPlayer = new Player(new Users());

    public static Player getWhitePlayer() {
        return whitePlayer;
    }

    public static Player getBlackPlayer() {
        return blackPlayer;
    }

    public static void setWhitePlayer(Player whitePlayer) {
        whitePlayer = whitePlayer;
    }

    public static void setBlackPlayer(Player blackPlayer) {
        blackPlayer = blackPlayer;
    }
}
