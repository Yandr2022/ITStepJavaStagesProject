package itStep.yandr.javaStages.stage12.task01.model.logic;

import java.io.IOException;

public class ChessPiecesLogic {
    public static final int FIRST_CHESS_SQUARE = 1;
    public static final int LAST_CHESS_SQUARE = 8;

    private static boolean checkHorizontalAndVerticalMove(int x1, int y1, int x2, int y2) {
        return (x1 == x2 && y1 != y2 || y1 == y2 && x1 != x2);
    }

    private static boolean checkOneMoveAround(int x1, int y1, int x2, int y2) {
        return (x2 == x1 - 1 || x2 == x1 || x2 == x1 + 1 )&& (y2 == y1 - 1 || y2 == y1 || y2 == y1 + 1);
    }


    protected static void validationCoordinates(int x1, int y1, int x2, int y2) throws IOException
            , IndexOutOfBoundsException {
        boolean chessboardBorder = x1 < FIRST_CHESS_SQUARE || x1 > LAST_CHESS_SQUARE
                || y1 < FIRST_CHESS_SQUARE || y1 > LAST_CHESS_SQUARE || x2 < FIRST_CHESS_SQUARE
                || x2 > LAST_CHESS_SQUARE || y2 < FIRST_CHESS_SQUARE || y2 > LAST_CHESS_SQUARE;
        if (x1 == x2 && y2 == y1) {
            throw new IOException();
        } else if (chessboardBorder) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static boolean checkRookMove(int x1, int y1, int x2, int y2) throws IOException, IndexOutOfBoundsException {
        validationCoordinates(x1, y1, x2, y2);
        return checkHorizontalAndVerticalMove(x1, y1, x2, y2);
    }

    public static boolean checkKingMove(int x1, int y1, int x2, int y2) throws IOException
            , IndexOutOfBoundsException {
        validationCoordinates(x1, y1, x2, y2);
        return checkOneMoveAround(x1, y1, x2, y2);
    }
}

