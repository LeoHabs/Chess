package Game.Board.Pieces;

public abstract class Piece{
    private String name;
    private String icon;
    private int points;

    public Piece(String name, String icon, int points) {
        this.name = name;
        this.icon = icon;
        this.points = points;
    }

    public abstract void movePiece(int vertical, int horizontal);

    public abstract void capturePiece();

    public String getIcon() {
        return icon;
    }

}
