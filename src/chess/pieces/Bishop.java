package chess.pieces;

public class Bishop extends AbstractPiece {

    private static final int BISHOP_VALUE = 3;
    private static final String BLACK_BISHOP_SYMBOL = "\u265D";
    private static final String WHITE_BISHOP_SYMBOL = "\u2657";

    public Bishop(final boolean isWhite) {
        super(isWhite);
    }

    @Override
    public void draw() {
        if (isWhite) {
            System.out.print(WHITE_BISHOP_SYMBOL);
        } else {
            System.out.print(BLACK_BISHOP_SYMBOL);
        }
    }

    private static Boolean diagonalPath(final int sourceRow,
            final int sourceColumn, final int destinationRow,
            final int destinationColumn) {
        // returns true if the path is diagonal
        // arguments are initial and final coordinates of move in chessboard
        // array
        // good for checking if a move is valid
        return (Math.abs(sourceRow - destinationRow) == Math
                .abs(sourceColumn - destinationColumn));
    }

    @Override
    public boolean isMoveValid(final int sourceRow, final int sourceColumn,
            final int destinationRow, final int destinationColumn) {
        return diagonalPath(sourceRow, sourceColumn, destinationRow,
                destinationColumn);
    }

    @Override
    public int pieceValue() {
        return BISHOP_VALUE;
    }

}
