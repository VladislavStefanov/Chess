package chess.pieces;

import chess.pieces.AbstractPiece;

public class Queen extends AbstractPiece {

	public Queen(boolean isWhite) {
		super(isWhite);
		
		}

	@Override
	public void draw() {
		if (isWhite){
			System.out.print("\u2655");
		}
		else{
			System.out.print("\u265B");
		}
	}

	private static Boolean diagonalPath(int srcRow, int srcCol, int destRow,
			int destCol) {
		// returns true if the path is diagonal
		// arguments are initial and final coordinates of move in chessboard
		// array
		// good for checking if a move is valid
		return ((Math.abs(srcRow - destRow) == Math.abs(srcCol - destCol)));
	}

	private static Boolean straightPath(int srcRow, int srcCol, int destRow,
			int destCol) {
		// returns true if the path is straight
		// arguments are initial and final coordinates of move in chessboard
		// array
		// good for checking if a move is valid
		return !((srcRow != destRow) && (srcCol != destCol));
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		// TODO Auto-generated method stub
		return (diagonalPath(sourceRow, sourceColumn, destinationRow, destinationColumn))
				|| straightPath(sourceRow, sourceColumn, destinationRow, destinationColumn);
	}

	@Override
	public int pieceValue() {
		// TODO Auto-generated method stub
		return 9;
	}

}
