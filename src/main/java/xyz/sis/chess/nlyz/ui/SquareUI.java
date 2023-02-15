package xyz.sis.chess.nlyz.ui;

import xyz.sis.chess.nlyz.board.Square;
import xyz.sis.chess.nlyz.config.Configuration;
import xyz.sis.chess.nlyz.piece.Piece;
import xyz.sis.chess.nlyz.piece.XColor;

import javax.swing.JPanel;
import java.awt.*;
import java.io.IOException;

public class SquareUI extends JPanel {

    private static final double pieceScale = Configuration.getDouble("piece.image.scale");

    private Piece piece;
    private XColor color;
    private boolean highlighted;
    private Image image;

    private final Square square;

    public SquareUI(Square square) throws IOException {
        piece = square.getPiece();
        color = square.color;
        image = ImageCache.get(square.getPiece());
        this.square = square;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(color.color);
        g2.fillRect(0, 0, getWidth(), getHeight());

        if (highlighted) {
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(5));
            g2.drawRect(0, 0, getWidth(), getHeight());
        }

        if (image != null) {
            int h = (int) ((float) getHeight() * pieceScale);

            var image = ImageCache.getScaledKeepAspect(this.image, h);
            int x = (int) ((float) (getWidth() - image.getWidth(null))  / 2);
            int y = (int) ((float) getHeight() * (1 - pieceScale) / 2);
            g2.drawImage(image, x, y, null);
        }

//        g2.setColor(color == XColor.BLACK ? Color.WHITE : Color.BLACK);
//        g2.drawString(square.coordinate.toString(), 10, 15);
    }


}
