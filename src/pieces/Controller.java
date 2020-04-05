package pieces;

public class Controller {

    public static void main(final String[] args) {
        Chessboard chessboard = new Chessboard();

        while (chessboard.isGameRunning()) {
            chessboard.printBoard();
            chessboard.move();
        }
    }

}
