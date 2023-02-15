package xyz.sis.chess.nlyz.board;

import xyz.sis.chess.nlyz.piece.Piece;

import static xyz.sis.chess.nlyz.math.BasicMathHelper.*;


public class SquareMatrix {

    private Square[][] mx = new Square[8][8];

    SquareMatrix() {
        initialize();
    }

    void initialize() {
        for (int f : range8())
            for (int r : range8()) {
                mx[f][r] = new Square(new Coordinate(f, r));
            }
    }

    void set(int file, int rank, Piece p) {
        mx[file][rank].setPiece(p);
    }

    Square get(int f, int r) {
        return mx[f][r];
    }

}
