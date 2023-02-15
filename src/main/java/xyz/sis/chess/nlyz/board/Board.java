package xyz.sis.chess.nlyz.board;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static xyz.sis.chess.nlyz.math.BasicMathHelper.range8;
import static xyz.sis.chess.nlyz.piece.PieceType.*;
import static xyz.sis.chess.nlyz.piece.XColor.BLACK;
import static xyz.sis.chess.nlyz.piece.XColor.WHITE;

public class Board {

    private static final Logger log = LogManager.getLogger(Board.class);
    
    private SquareMatrix smx = new SquareMatrix();

    public Board() {
        init();
    }

    public Square get(int file, int rank) {
        return smx.get(file, rank);
    }

    private void init() {
        for (int f : range8()) smx.set(f, 1, P.create(WHITE));
        for (int f : range8()) smx.set(f, 6, P.create(BLACK));

        smx.set(0, 0, R.create(WHITE));
        smx.set(7, 0, R.create(WHITE));

        smx.set(0, 7, R.create(BLACK));
        smx.set(7, 7, R.create(BLACK));

        smx.set(1, 0, N.create(WHITE));
        smx.set(6, 0, N.create(WHITE));

        smx.set(1, 7, N.create(BLACK));
        smx.set(6, 7, N.create(BLACK));

        smx.set(2, 0, B.create(WHITE));
        smx.set(5, 0, B.create(WHITE));

        smx.set(2, 7, B.create(BLACK));
        smx.set(5, 7, B.create(BLACK));

        smx.set(3, 0, Q.create(WHITE));
        smx.set(4, 0, K.create(WHITE));

        smx.set(3, 7, Q.create(BLACK));
        smx.set(4, 7, K.create(BLACK));

        log.debug("Board initialized.");
    }
    
}
