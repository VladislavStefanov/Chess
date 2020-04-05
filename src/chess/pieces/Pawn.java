package chess.pieces;

public class Pawn extends AbstractPiece {

    private static final int PAWN_VALUE = 1;
    private static final String BLACK_PAWN_SYMBOL = "\u265F";
    private static final String WHITE_PAWN_SYMBOL = "\u2659";

    public Pawn(final boolean isWhite) {
        super(isWhite);
    }

    @Override
    public void draw() {
        if (isWhite) {
            System.out.print(WHITE_PAWN_SYMBOL);
        }
        if (!(isWhite)) {
            System.out.print(BLACK_PAWN_SYMBOL);

        }

    }

    @Override
    public boolean isMoveValid(final int sourceRow, final int sourceColumn,
            final int destinationRow, final int destinationColumn) {

        // if pawn moves forward one
        // or moves forward two from starting position
        // or takes a piece of black colour
        // break, else return false (not valid move)
        if (isWhite) {
            return (((sourceColumn == destinationColumn)
                    && sourceRow == (destinationRow + 1))
                    || ((sourceRow == 6) && (sourceColumn == destinationColumn)
                            && (sourceRow == (destinationRow + 2)))
                    || ((sourceRow == (destinationRow + 1)) && (Math
                            .abs(sourceColumn - destinationColumn) == 1)));
        } else {
            return (((sourceColumn == destinationColumn)
                    && sourceRow == (destinationRow - 1))
                    || ((sourceRow == 1) && (sourceColumn == destinationColumn)
                            && (sourceRow == (destinationRow - 2)))
                    || ((sourceRow == (destinationRow - 1)) && (Math
                            .abs(sourceColumn - destinationColumn) == 1)));
        }

    }

    @Override
    public int pieceValue() {
        return PAWN_VALUE;
    }

}
