package chess.pieces;

public class King extends AbstractPiece {

    private static final String BLACK_KING_SYMBOL = "\u265A";
    private static final String WHITE_KING_SYMBOL = "\u2654";

    public King(final boolean isWhite) {
        super(isWhite);
    }

    @Override
    public void draw() {
        if (isWhite) {
            System.out.print(WHITE_KING_SYMBOL);
        } else {
            System.out.print(BLACK_KING_SYMBOL);
        }
    }

    @Override
    public boolean isMoveValid(final int sourceRow, final int sourceColumn,
            final int destinationRow, final int destinationColumn) {
        return Math.abs(destinationRow - sourceRow) <= 1
                || Math.abs(destinationColumn - sourceColumn) <= 1;
    }

    @Override
    public int pieceValue() {
        return 0;
    }

}
