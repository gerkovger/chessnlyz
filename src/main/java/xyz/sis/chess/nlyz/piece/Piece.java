package xyz.sis.chess.nlyz.piece;

public abstract class Piece {

    protected final PieceType type;
    protected final XColor color;
    public final String fullName;

    Piece(PieceType type, XColor color) {
        this.type = type;
        this.color = color;
        fullName = color.name().charAt(0) + type.name();
    }

    @Override
    public String toString() {
        return fullName;
    }
}
