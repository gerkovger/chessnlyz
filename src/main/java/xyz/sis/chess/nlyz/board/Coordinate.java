package xyz.sis.chess.nlyz.board;

import static xyz.sis.chess.nlyz.math.BasicMathHelper.*;

public class Coordinate {

    public final int f, r;

    Coordinate(int file, int rank) {
        if (!inRange8(file)) throw new IllegalArgumentException("Out of range :" + file);
        if (!inRange8(rank)) throw new IllegalArgumentException("Out of range :" + rank);
        f = file;
        r = rank;
    }

    @Override
    public String toString() {
        return f + " : " + r;
    }
}
