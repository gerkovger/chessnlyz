package xyz.sis.chess.nlyz.ui;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import xyz.sis.chess.nlyz.board.Board;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

public class BoardUI extends JPanel {

    private static final Logger log = LogManager.getLogger(BoardUI.class);

    private final SquareUI[][] squares = new SquareUI[8][8];

    private Board board;

    public BoardUI() throws IOException {
        board = new Board();
        initBoardUI();
    }

    private void initBoardUI() throws IOException {
        var layout = new GridBagLayout();
        layout.columnWeights = new double[]{0, 1, 1, 1, 1, 1, 1, 1, 1};
        layout.rowWeights = new double[]{1, 1, 1, 1, 1, 1, 1, 1};
        setLayout(layout);
        var c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        for (int i = 0; i < 8; i++) {
            c.gridx = 0;
            c.gridy = i;

            JLabel l = new JLabel("" + (8 - i));
            l.setBorder(new EmptyBorder(0, 5, 0, 8));
            add(l, c);

            c.gridx = i + 1;
            c.gridy = 8;
            JLabel l2 = new JLabel("" + (char)(65 + i));
            l2.setHorizontalAlignment(SwingConstants.CENTER);
            l2.setBorder(new EmptyBorder(8, 0, 5, 0));
            add(l2, c);
        }

        for (int f = 0; f < 8; f++) {
            for (int r = 0; r < 8; r++) {
                c.gridx = f + 1;
                c.gridy = 7 - r;
                squares[f][r] = new SquareUI(board.get(f, r));
                add(squares[f][r], c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setContentPane(new BoardUI());

        frame.setBounds(1000, 400, 800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }


}
