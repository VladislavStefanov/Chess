package chess.pieces;

public class Queen extends AbstractPiece {

    private static final int QUEEN_VALUE = 9;
    private static final String BLACK_ROOK_SYMBOL = "\u265B";
    private static final String WHITE_ROOK_SYMBOL = "\u2655";

    public Queen(final boolean isWhite) {
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

    private static Boolean diagonalPath(final int sourceRow, final int sourceColumn,
            final int destinationRow, final int destinationColumn) {
        // returns true if the path is diagonal
        // arguments are initial and final coordinates of move in chessboard
        // array
        // good for checking if a move is valid
        return ((Math.abs(sourceRow - destinationRow) == Math.abs(sourceColumn - destinationColumn)));
    }

    private static Boolean straightPath(final int sourceRow, final int sourceColumn,
            final int destinationRow, final int destinationColumn) {
        // returns true if the path is straight
        // arguments are initial and final coordinates of move in chessboard
        // array
        // good for checking if a move is valid
        return !((sourceRow != destinationRow) && (sourceColumn != destinationColumn));
    }

    @Override
    public boolean isMoveValid(final int sourceRow, final int sourceColumn,
            final int destinationRow, final int destinationColumn) {
        return (diagonalPath(sourceRow, sourceColumn, destinationRow,
                destinationColumn))
                || straightPath(sourceRow, sourceColumn, destinationRow,
                        destinationColumn);
    }

    @Override
    public int pieceValue() {
        return QUEEN_VALUE;
    }

}
