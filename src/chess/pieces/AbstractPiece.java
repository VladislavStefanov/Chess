package chess.pieces;

public abstract class AbstractPiece {

    protected final boolean isWhite;

    /**
     * If piece is white set true, false otherwise
     */
    public AbstractPiece(final boolean isWhite) {
        this.isWhite = isWhite;
    }

    /**
     * Returns true if white, false otherwise
     */
    public boolean isWhite() {
        return isWhite;
    }

    /**
     * Draws given piece into the console
     */
    public abstract void draw();

    /**
     * Checks whether a given move is valid. Returns true if valid, false
     * otherwise
     */
    public abstract boolean isMoveValid(final int sourceRow,
            final int sourceColumn, final int destinationRow,
            final int destinationColumn);

    /**
     * Returns relative chess piece value of this chessman.
     *
     * @return
     */
    public abstract int relativeValue();

}
