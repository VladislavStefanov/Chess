package chess.pieces;

public class Rook extends AbstractPiece {

    private static final int ROOK_VALUE = 5;
    private static final String BLACK_ROOK_SYMBOL = "\u265C";
    private static final String WHITE_ROOK_SYMBOL = "\u2656";

    public Rook(final boolean isWhite) {
        super(isWhite);
    }

    @Override
    public void draw() {
        if (isWhite) {
            System.out.print(WHITE_ROOK_SYMBOL);
        } else {
            System.out.print(BLACK_ROOK_SYMBOL);
        }
    }

    @Override
    public boolean isMoveValid(final int sourceRow, final int sourceColumn,
            final int destinationRow, final int destinationColumn) {
        return !((sourceRow != destinationRow)
                && (sourceColumn != destinationColumn));
    }

    @Override
    public int pieceValue() {
        return ROOK_VALUE;
    }

}
