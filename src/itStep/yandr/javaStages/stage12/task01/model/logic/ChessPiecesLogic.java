package itStep.yandr.javaStages.stage12.task01.model.logic;

import itStep.yandr.javaStages.stage12.task01.exception.OutOfRangeValueException;
import itStep.yandr.javaStages.stage12.task01.exception.SameCoordinatesException;

import java.io.IOException;

public class ChessPiecesLogic {
    public static final int FIRST_CHESS_SQUARE = 1;
    public static final int LAST_CHESS_SQUARE = 8;

    private static boolean checkRankAndFileMove(int x1, int y1, int x2, int y2) {
        return (x1 == x2 && y1 != y2 || y1 == y2 && x1 != x2);
    }

    private static boolean checkOneMoveAround(int x1, int y1, int x2, int y2) {
        return (x2 == x1 - 1 || x2 == x1 || x2 == x1 + 1 ) && (y2 == y1 - 1 || y2 == y1 || y2 == y1 + 1);
    }

    private static boolean checkDiagonalMove(int x1, int y1, int x2, int y2) {
        return x1 + y1 == x2 + y2 || x1 - y1 == x2 - y2;
    }
    private static boolean checkLShapeMove(int x1, int y1, int x2, int y2) {
        return (Math.abs(x2 -x1 )== 2 && Math.abs( y2- y1)== 1)||(Math.abs(x2 -x1 )== 1 && Math.abs( y2- y1)== 2);
    }


    private static void validationCoordinates(int x1, int y1, int x2, int y2) throws SameCoordinatesException
            , OutOfRangeValueException {
        boolean chessboardBorder = x1 < FIRST_CHESS_SQUARE || x1 > LAST_CHESS_SQUARE
                || y1 < FIRST_CHESS_SQUARE || y1 > LAST_CHESS_SQUARE || x2 < FIRST_CHESS_SQUARE
                || x2 > LAST_CHESS_SQUARE || y2 < FIRST_CHESS_SQUARE || y2 > LAST_CHESS_SQUARE;
        if (x1 == x2 && y2 == y1) {
            throw new SameCoordinatesException();
        } else if (chessboardBorder) {
            throw new OutOfRangeValueException();
        }
    }


    public static boolean checkRookMove(int x1, int y1, int x2, int y2) throws SameCoordinatesException
            , OutOfRangeValueException {

        validationCoordinates(x1, y1, x2, y2);
        return checkRankAndFileMove(x1, y1, x2, y2);
    }

    public static boolean checkKingMove(int x1, int y1, int x2, int y2) throws SameCoordinatesException
            , OutOfRangeValueException {
        validationCoordinates(x1, y1, x2, y2);
        return checkOneMoveAround(x1, y1, x2, y2);
    }

    public static boolean checkBishopMove(int x1, int y1, int x2, int y2) throws SameCoordinatesException
            , OutOfRangeValueException {
        validationCoordinates(x1,y1,x2,y2);
        return checkDiagonalMove(x1, y1, x2, y2);
    }

    public static boolean checkQueenMove(int x1, int y1, int x2, int y2) throws SameCoordinatesException
            , OutOfRangeValueException {
        validationCoordinates(x1, y1, x2, y2);
        return checkRankAndFileMove(x1, y1, x2, y2)||checkDiagonalMove(x1,y1,x2,y2);
    }

    public static boolean checkKnightMove(int x1, int y1, int x2, int y2) throws SameCoordinatesException
            , OutOfRangeValueException {
        validationCoordinates(x1, y1, x2, y2);
        return checkLShapeMove(x1, y1, x2, y2);
    }

}

