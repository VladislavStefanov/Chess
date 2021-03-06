package chess;

import java.util.Random;
import java.util.Scanner;

import chess.pieces.AbstractPiece;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

/**
 * An 8x8 Chessboard with a console display and string user input Has some basic
 * rules for checking if a move is valid or not Keeps track of the score of each
 * player by the value of pieces they take For best results construct a
 * Chessboard(), call move() and call printBoard().
 *
 * @author SamiStart
 *
 */

public class Chessboard {

    private static final String SEPARATING_LINE = "___________________________________________________\n";
    private Boolean gameRunning;
    private AbstractPiece[][] chessboard = new AbstractPiece[NUMBER_OF_ROWS_AND_COLUMNS][NUMBER_OF_ROWS_AND_COLUMNS];// [row][column]
    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static final int NUMBER_OF_ROWS_AND_COLUMNS = 8;
    private int sourceRow, sourceColumn, destinationRow, destinationColumn;
    private int whiteScore = 0, blackScore = 0;
    private Boolean isWhitesTurnToMove;
    private Boolean isMoveInvalid = false;
    // Holds string with the user input for move instructions
    private String move;

    /**
     * Constructs a Chessboard object and populates it with pieces Starts a
     * chess game running.
     */

    public Chessboard() {
        initialiseBoard(chessboard);
        gameRunning = true;
    }

    /**
     * This gets attribute Boolean gameRunning if this is false then you should
     * stop calling move() and printBoard() and close the Chessboard()
     *
     * @return a Boolean that is false if the user wants to exit called
     *         gameRunning
     */
    public Boolean isGameRunning() {
        return gameRunning;
    }

    /**
     * Populates the chessboard of AbstractPiece with the correct pieces and
     * randomly assigns whether white or black moves first
     *
     * @param chessboard
     */
    private void initialiseBoard(final AbstractPiece[][] chessboard) {
        // a chessboard with 8x8 matrix of pieces
        // rows [0] and [1] are black
        // rows [6] and [7] are white

        for (int row = 0; row < chessboard.length; row++) {
            for (int column = 0; column < chessboard[row].length; column++) {
                if (row == 0) {
                    switch (column) {
                    case 0:
                        chessboard[row][column] = new Rook(false);
                        break;
                    case 1:
                        chessboard[row][column] = new Knight(false);
                        break;
                    case 2:
                        chessboard[row][column] = new Bishop(false);
                        break;
                    case 3:
                        chessboard[row][column] = new Queen(false);
                        break;
                    case 4:
                        chessboard[row][column] = new King(false);
                        break;
                    case 5:
                        chessboard[row][column] = new Bishop(false);
                        break;
                    case 6:
                        chessboard[row][column] = new Knight(false);
                        break;
                    case 7:
                        chessboard[row][column] = new Rook(false);
                        break;
                    }
                } else if (row == 1) {
                    chessboard[row][column] = new Pawn(false);
                } else if (row == 6) {
                    chessboard[row][column] = new Pawn(true);
                } else if (row == 7) {
                    switch (column) {
                    case 0:
                        chessboard[row][column] = new Rook(true);
                        break;
                    case 1:
                        chessboard[row][column] = new Knight(true);
                        break;
                    case 2:
                        chessboard[row][column] = new Bishop(true);
                        break;
                    case 3:
                        chessboard[row][column] = new Queen(true);
                        break;
                    case 4:
                        chessboard[row][column] = new King(true);
                        break;
                    case 5:
                        chessboard[row][column] = new Bishop(true);
                        break;
                    case 6:
                        chessboard[row][column] = new Knight(true);
                        break;
                    case 7:
                        chessboard[row][column] = new Rook(true);
                        break;
                    }
                } else {
                    chessboard[row][column] = null;
                }
            }
        }

        generateFirstPlayerColor();
    }

    private void generateFirstPlayerColor() {
        Random random = new Random();
        isWhitesTurnToMove = random.nextBoolean();
    }

    /**
     * Prints out the unicode for each character to the console using the draw()
     * method from the relevant piece's class followed by tabs for tidiness.
     * Prints numbers 1-8 alongside rows and letters a-h alongside columns
     */
    public void printBoard() {

        // must take an 8x8 array of Chessmen (chess pieces),
        // i.e. a chessboard, as argument

        System.out.println("\ta\tb\tc\td\te\tf\tg\th");
        for (int row = 0; row < chessboard.length; row++) {
            System.out.print(8 - row + ".\t");
            for (int col = 0; col < chessboard[row].length; col++) {
                if (chessboard[row][col] != null) {
                    chessboard[row][col].draw();
                    System.out.print("\t");

                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    /**
     * Checks if a move is valid with 2 steps. Step 1: some general rule checks
     * that any piece should obey. Step 2: The specific isMoveValid() method
     * from a piece's class that checks rules specific for that piece, e.g that
     * a rook moves in straight lines.
     *
     * @return True if valid, false if invalid.
     */

    private boolean isMoveValid() {

        // invalid if the move origin or destination is outside the board

        if (sourceRow < 0 || sourceRow > 7 || sourceColumn < 0
                || sourceColumn > 7 || destinationRow < 0 || destinationRow > 7
                || destinationColumn < 0 || destinationColumn > 7) {
            System.out.println("Move is outside the board");
            return false;
        }

        // Invalid if origin is null
        if (chessboard[sourceRow][sourceColumn] == null) {
            System.err.println("Origin is empty");
            return false;
        }

        // Invalid if player moves when it's not their turn
        if ((chessboard[sourceRow][sourceColumn].isWhite()
                && !isWhitesTurnToMove)
                || (!chessboard[sourceRow][sourceColumn].isWhite()
                        && isWhitesTurnToMove)) {
            System.err.println("It's not your turn");
            return false;
        }

        // return false if specific piece rules are not obeyed
        if (!chessboard[sourceRow][sourceColumn].isMoveValid(sourceRow,
                sourceColumn, destinationRow, destinationColumn)) {
            System.err.println("This piece doesn't move like that");
            return false;
        }

        // this statement stops the statement for checking if white lands on
        // white from performing isWhite() on a null space
        if (chessboard[destinationRow][destinationColumn] == null) {
            return true;
        }

        // invalid if the white lands on white
        if (chessboard[sourceRow][sourceColumn].isWhite()
                && chessboard[destinationRow][destinationColumn].isWhite()) {
            System.err.println("White cannot land on white");
            return false;
        }

        // invalid if the black lands on black
        if (!chessboard[sourceRow][sourceColumn].isWhite()
                && !chessboard[destinationRow][destinationColumn].isWhite()) {
            System.err.println("Black cannot land on black");
            return false;
        }

        return true;

    }

    /**
     * A private method called to update the score of whoever's turn it is after
     * they take an opposing piece
     */
    private void updateScore() {
        if (chessboard[destinationRow][destinationColumn] == null) {
            return;
        }
        if (isWhitesTurnToMove) {
            whiteScore += chessboard[destinationRow][destinationColumn]
                    .pieceValue();
        } else {
            blackScore += chessboard[destinationRow][destinationColumn]
                    .pieceValue();

        }
    }

    /**
     * Take user input for the instructions for move in the form "start coords
     * to destination coords", e.g. "d2 to d3" and converts this string to array
     * coordinates for the Chessboard. Checks if the move is valid using
     * moveValid(). If valid moves piece to destination on Chessboard and
     * updates score with updateScore(). If invalid prints error message and
     * recursively calls itself.
     */
    public void move() {

        printScore();

        move = USER_INPUT.nextLine();

        if (move.equalsIgnoreCase("exit")) {
            gameRunning = false;
            System.out.println("Thanks for playing.");
            return;
        }

        String lowerCase = move.toLowerCase();
        // parse move string into components
        String[] components = lowerCase.split(" ");

        // if you assume that move is "e1 to e5" then
        // components[0].chartAt(0) = 'e'
        // components [0].charAt (1) = '1'

        // use chars in components to set the array coordinates of the
        // move origin and move destination

        sourceRow = 7 - (components[0].charAt(1) - '1');
        sourceColumn = components[0].charAt(0) - 'a';
        destinationRow = 7 - (components[2].charAt(1) - '1');
        destinationColumn = components[2].charAt(0) - 'a';

        if (isMoveValid()) {
            updateScore();
            // put piece in destination
            chessboard[destinationRow][destinationColumn] = chessboard[sourceRow][sourceColumn];
            // empty the origin of the move
            chessboard[sourceRow][sourceColumn] = null;
            isWhitesTurnToMove = !isWhitesTurnToMove;
        } else {
            isMoveInvalid = true;
            move();

        }

    }

    private void printScore() {
        System.out.println(SEPARATING_LINE + "Score: White " + whiteScore
                + " | " + blackScore + " Black");

        if (isMoveInvalid) {
            System.err.println("Move is invalid. Please try again:");
            isMoveInvalid = false;
        } else if (isWhitesTurnToMove) {
            System.out.println(SEPARATING_LINE + "White's turn to move\n"
                    + SEPARATING_LINE);
        } else {
            System.out.println(SEPARATING_LINE + "Black's turn to move\n"
                    + SEPARATING_LINE);
        }
    }

}
