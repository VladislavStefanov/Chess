package chess.pieces;

public class Knight extends chess.pieces.AbstractPiece {

    private static final String BLACK_KNIGHT_SYMBLOL = "\u265E";
    private static final String WHITE_KNIGHT_SYMBLOL = "\u2658";

    public Knight(final boolean isWhite) {
        super(isWhite);
    }

    @Override
    public void draw() {
        if (isWhite) {
            System.out.print(WHITE_KNIGHT_SYMBLOL);
        } else {
            System.out.print(BLACK_KNIGHT_SYMBLOL);
        }
    }

    @Override
    public boolean isMoveValid(final int sourceRow, final int sourceColumn,
            final int destinationRow, final int destinationColumn) {
        // returns true if the path is L-shaped
        // arguments are initial and final coordinates of move in chessboard
        // array
        // good for checking if a move is valid

        return ((Math.abs(sourceRow - destinationRow) == 2
                && Math.abs(sourceColumn - destinationColumn) == 1)
                || (Math.abs(sourceRow - destinationRow) == 1
                        && Math.abs(sourceColumn - destinationColumn) == 2));
    }

    @Override
    public int pieceValue() {
        // TODO Auto-generated method stub
        return 0;
    }

}
