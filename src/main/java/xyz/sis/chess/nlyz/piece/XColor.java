package xyz.sis.chess.nlyz.piece;

import java.awt.Color;

public enum XColor {

    WHITE(Color.WHITE), BLACK(Color.BLACK), EMPTY(Color.RED);

    public final Color color;

    XColor(Color color) {
        this.color = color;
    }

}
