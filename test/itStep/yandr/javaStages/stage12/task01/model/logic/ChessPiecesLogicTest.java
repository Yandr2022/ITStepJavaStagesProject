package itStep.yandr.javaStages.stage12.task01.model.logic;


import itStep.yandr.javaStages.stage12.task01.exception.OutOfRangeValueException;
import itStep.yandr.javaStages.stage12.task01.exception.SameCoordinatesException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ChessPiecesLogicTest {

    private final int[][] POINTS_OUTSIDE_CHESSBOARD = {{0, 3, 4, 6}, {8, 0, 7, 2}, {6, 1, 0, 4},
            {1, 5, 7, 0}, {-6, 2, 8, 1}, {7, -2, 5, 3}, {1, 5, -2, 3}, {7, 1, 2, -4}, {10, 5, 2, 4},
            {2, 12, 3, 1}, {4, 5, 9, 1}, {8, 2, 7, 13}
    };

    @Test
    public void testCheckRockMoveReturnTrue() throws SameCoordinatesException, OutOfRangeValueException {
        int x1 = 4, y1 = 4;
        int[][] points = {{1, 4}, {2, 4}, {3, 4}, {5, 4}, {6, 4}, {7, 4}, {8, 4}, {4, 1}
                , {4, 2}, {4, 3}, {4, 5}, {4, 6}, {4, 7}, {4, 8}};
        for (int i = 0; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            boolean actual = ChessPiecesLogic.checkRookMove(x1, y1, x2, y2);
            String error = String.format("Error with chess cell;(%d,%d)", x2, y2);

            assertTrue(error, actual);
        }
    }

    @Test
    public void testCheckRookMoveReturnFalse() throws SameCoordinatesException, OutOfRangeValueException{
        int x1 = 4, y1 = 4;
        int[][] points = {{1, 1}, {1, 2}, {1, 3}, {1, 5}, {1, 6}, {1, 7}, {1, 8}, {2, 1}, {2, 2}, {2, 3}, {2, 5}, {2, 6}
                , {2, 7}, {2, 8}, {3, 1}, {3, 2}, {3, 3}, {3, 5}, {3, 6}, {3, 7}, {3, 8}, {5, 1}, {5, 2}, {5, 3},
                {5, 5}, {5, 6}, {5, 7}, {5, 8}, {6, 1}, {6, 2}, {6, 3}, {6, 5}, {6, 6}, {6, 7}, {6, 8}, {7, 1}, {7, 2},
                {7, 3}, {7, 5}, {7, 6}, {7, 7}, {7, 8}, {8, 1}, {8, 2}, {8, 3}, {8, 5}, {8, 6}, {8, 7}, {8, 8}};
        for (int i = 0; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            boolean actual = ChessPiecesLogic.checkRookMove(x1, y1, x2, y2);
            String error = String.format("Error with chess cell;(%d,%d)", x2, y2);
            assertFalse(error, actual);
        }
    }

    @Test(expected = SameCoordinatesException.class)
    public void testCheckSameCoordinatesForRook() throws SameCoordinatesException, OutOfRangeValueException {
        int x1 = 5, y1 = 4;
        ChessPiecesLogic.checkRookMove(x1, y1, x1, y1);

    }

    @Test
    public void testCheckCoordinatesOutOFChessboardForRook() throws SameCoordinatesException {
        for (int i = 0; i < POINTS_OUTSIDE_CHESSBOARD.length; i++) {
            int[] point = POINTS_OUTSIDE_CHESSBOARD[i];
            int x1 = point[0];
            int y1 = point[1];
            int x2 = point[2];
            int y2 = point[3];
            try {
                ChessPiecesLogic.checkRookMove(x1, y1, x2, y2);
                fail(String.format("The coordinates x1:%d, y1:%d, x2:%d, y2:%d - should have been thrown " +
                        "OutOfRangeValueException \n", x1, y1, x2, y2));
            } catch (OutOfRangeValueException e) {
            }
        }

    }

    @Test
    public void testCheckKingMoveReturnTrue() throws SameCoordinatesException, OutOfRangeValueException  {
        int x1 = 5, y1 = 3;
        int[][] points = {{4, 2}, {4, 3}, {4, 4}, {5, 2}, {5, 4}, {6, 2}, {6, 3}, {6, 4}};
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int x2 = point[0];
            int y2 = point[1];
            boolean actual = ChessPiecesLogic.checkKingMove(x1, y1, x2, y2);
            String error = String.format("Error with chess cell;(%d,%d)", x2, y2);
            assertTrue(error, actual);
        }
    }

    @Test
    public void testCheckKingMoveReturnFalse() throws SameCoordinatesException, OutOfRangeValueException  {
        int x1 = 5, y1 = 3;
        int[][] points = {{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}, {1, 8}
                , {2, 1}, {2, 2},{2, 3}, {2, 4}, {2, 5}, {2, 6}, {2, 7}, {2, 8}
                , {3, 1}, {3, 2}, {3, 3},{3, 4}, {3, 5}, {3, 6}, {3, 7}, {3, 8}
                , {4, 1}, {4, 5}, {4, 6}, {4, 7}, {4, 8}
                , {5, 1}, {5, 5}, {5, 6}, {5, 7}, {5, 8}
                , {6, 1}, {6, 5}, {6, 6}, {6, 7}, {6, 8}
                , {7, 1}, {7, 2}, {7, 3},{7, 4}, {7, 5}, {7, 6}, {7, 7}, {7, 8}
                , {8, 1}, {8, 2}, {8, 3}, {8,4}, {8, 5}, {8, 6}, {8, 7}, {8, 8}};
        for (int i = 0; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            boolean actual = ChessPiecesLogic.checkKingMove(x1, y1, x2, y2);
            String error = String.format("Error with chess square;(%d,%d)", x2, y2);

            assertFalse(error, actual);
        }
    }

    @Test(expected = SameCoordinatesException.class)
    public void testCheckSameCoordinatesForKing() throws SameCoordinatesException, OutOfRangeValueException  {
        int x1 = 5, y1 = 4;
        ChessPiecesLogic.checkKingMove(x1, y1, x1, y1);

    }

    @Test
    public void testCheckCoordinatesOutOFChessboardForKing() throws SameCoordinatesException{
        for (int i = 0; i < POINTS_OUTSIDE_CHESSBOARD.length; i++) {
            int[] point = POINTS_OUTSIDE_CHESSBOARD[i];
            int x1 = point[0];
            int y1 = point[1];
            int x2 = point[2];
            int y2 = point[3];
            try {
                ChessPiecesLogic.checkKingMove(x1, y1, x2, y2);
                fail(String.format("The coordinates x1:%d, y1:%d, x2:%d, y2:%d - should have been thrown " +
                        "OutOfRangeValueException \n", x1, y1, x2, y2));
            } catch (OutOfRangeValueException e) {
            }
        }
    }
    @Test
    public void testCheckBishopMoveReturnTrue() throws SameCoordinatesException, OutOfRangeValueException {
        int x1 = 6, y1 = 4;
        int[][] points = {{3, 1}, {4, 2}, {5, 3}, {7, 5}, {8, 6}, {8, 2}, {7, 3}
                , {5, 5}, {4, 6}, {3, 7}, {2, 8}};
        for (int i = 0; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            boolean actual = ChessPiecesLogic.checkBishopMove(x1, y1, x2, y2);
            String error = String.format("Error with chess cell;(%d,%d)", x2, y2);

            assertTrue(error, actual);
        }
    }

    @Test
    public void testCheckBishopMoveReturnFalse() throws SameCoordinatesException, OutOfRangeValueException {
        int x1 = 6, y1 = 4;
        int[][] points = {{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}, {1, 8}
                , {2, 1}, {2, 2}, {2, 3},{2, 4}, {2, 5}, {2, 6}, {2, 7}
                , {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 6}, {3, 8}
                , {4, 1}, {4, 3}, {4, 4}, {4, 5}, {4, 7}, {4, 8}
                , {5, 1}, {5, 2}, {5, 4}, {5, 6}, {5, 7}, {5, 8}
                , {6, 1}, {6, 2}, {6, 3}, {6, 5}, {6, 6}, {6, 7}, {6, 8}
                , {7, 1}, {7, 2}, {7, 4}, {7, 6}, {7, 7}, {7, 8}
                , {8, 1}, {8, 3}, {8, 4}, {8, 5}, {8, 7}, {8, 8}};
        for (int i = 0; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            boolean actual = ChessPiecesLogic.checkBishopMove(x1, y1, x2, y2);
            String error = String.format("Error with chess cell;(%d,%d)", x2, y2);
            assertFalse(error, actual);
        }
    }

    @Test(expected = SameCoordinatesException.class)
    public void testCheckSameCoordinatesForBishop() throws SameCoordinatesException, OutOfRangeValueException {
        int x1 = 6, y1 = 4;
        ChessPiecesLogic.checkBishopMove(x1, y1, x1, y1);

    }

    @Test
    public void testCheckCoordinatesOutOFChessboardForBishop() throws SameCoordinatesException {
        for (int i = 0; i < POINTS_OUTSIDE_CHESSBOARD.length; i++) {
            int[] point = POINTS_OUTSIDE_CHESSBOARD[i];
            int x1 = point[0];
            int y1 = point[1];
            int x2 = point[2];
            int y2 = point[3];
            try {
                ChessPiecesLogic.checkBishopMove(x1, y1, x2, y2);
                fail(String.format("The coordinates x1:%d, y1:%d, x2:%d, y2:%d - should have been thrown " +
                        "OutOfRangeValueException \n", x1, y1, x2, y2));
            } catch (OutOfRangeValueException e) {
            }
        }

    }
    @Test
    public void testCheckQueenMoveReturnTrue() throws SameCoordinatesException, OutOfRangeValueException {
        int x1 = 6, y1 = 4;
        int[][] points = {{1, 4}, {2, 4}, {2, 8}, {3, 1}, {3, 4}, {3, 7}
                , {4, 2}, {4, 4}, {4, 6}, {5, 3}, {5, 4}, {5, 5}
                , {6, 1}, {6, 2}, {6, 3}, {6, 5}, {6, 6}, {6, 7}, {6, 8}
                , {7, 3},{7, 4}, {7, 5}, {8, 2}, {8, 4},  {8, 6}};
        for (int i = 0; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            boolean actual = ChessPiecesLogic.checkQueenMove(x1, y1, x2, y2);
            String error = String.format("Error with chess cell;(%d,%d)", x2, y2);

            assertTrue(error, actual);
        }
    }

    @Test
    public void testCheckQueenMoveReturnFalse() throws SameCoordinatesException, OutOfRangeValueException{
        int x1 = 6, y1 = 4;
        int[][] points = {{1, 1}, {1, 2}, {1, 3}, {1, 5}, {1, 6}, {1, 7}, {1, 8}
                , {2, 1}, {2, 2}, {2, 3}, {2, 5}, {2, 6}, {2, 7}
                , {3, 2}, {3, 3}, {3, 5}, {3, 6}, {3, 8}
                , {4, 1}, {4, 3}, {4, 5}, {4, 7}, {4, 8}
                , {5, 1}, {5, 2}, {5, 6}, {5, 7}, {5, 8}
                , {7, 1}, {7, 2}, {7, 6}, {7, 7}, {7, 8}
                , {8, 1}, {8, 3}, {8, 5}, {8, 7}, {8, 8}};
        for (int i = 0; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            boolean actual = ChessPiecesLogic.checkQueenMove(x1, y1, x2, y2);
            String error = String.format("Error with chess cell;(%d,%d)", x2, y2);
            assertFalse(error, actual);
        }
    }

    @Test(expected = SameCoordinatesException.class)
    public void testCheckSameCoordinatesForQueen() throws SameCoordinatesException, OutOfRangeValueException {
        int x1 = 6, y1 = 4;
        ChessPiecesLogic.checkQueenMove(x1, y1, x1, y1);

    }

    @Test
    public void testCheckCoordinatesOutOFChessboardForQueen() throws SameCoordinatesException{
        for (int i = 0; i < POINTS_OUTSIDE_CHESSBOARD.length; i++) {
            int[] point = POINTS_OUTSIDE_CHESSBOARD[i];
            int x1 = point[0];
            int y1 = point[1];
            int x2 = point[2];
            int y2 = point[3];
            try {
                ChessPiecesLogic.checkQueenMove(x1, y1, x2, y2);
                fail(String.format("The coordinates x1:%d, y1:%d, x2:%d, y2:%d - should have been thrown " +
                        "OutOfRangeValueException \n", x1, y1, x2, y2));
            } catch (OutOfRangeValueException e) {
            }
        }

    }

    @Test
    public void testCheckKnightMoveReturnTrue() throws SameCoordinatesException, OutOfRangeValueException {
        int x1 = 3, y1 = 6;
        int[][] points = {{1, 5}, {1, 7}, {2, 4}, {2, 8}, {4, 4}, {4, 8}, {5, 5}, {5, 7}};
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int x2 = point[0];
            int y2 = point[1];
            boolean actual = ChessPiecesLogic.checkKnightMove(x1, y1, x2, y2);
            String error = String.format("Error with chess cell;(%d,%d)", x2, y2);
            assertTrue(error, actual);
        }
    }

    @Test
    public void testCheckKnightMoveReturnFalse() throws SameCoordinatesException, OutOfRangeValueException {
        int x1 = 3, y1 = 6;
        int[][] points = {{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 6}, {1, 8}
                , {2, 1}, {2, 2},{2, 3}, {2, 5}, {2, 6}, {2, 7}
                , {3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 7}, {3, 8}
                , {4, 1}, {4, 2}, {4, 3}, {4, 5}, {4, 6}, {4, 7}
                , {5, 1}, {5, 2}, {5, 3}, {5, 4}, {5, 6}, {5, 8}
                , {6, 1}, {6, 2}, {6, 3}, {6, 4}, {6, 5}, {6, 6}, {6, 7}, {6, 8}
                , {7, 1}, {7, 2}, {7, 3}, {7, 4}, {7, 5}, {7, 6}, {7, 7}, {7, 8}
                , {8, 1}, {8, 2}, {8, 3}, {8, 4}, {8, 5}, {8, 6}, {8, 7}, {8, 8}};
        for (int i = 0; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            boolean actual = ChessPiecesLogic.checkKnightMove(x1, y1, x2, y2);
            String error = String.format("Error with chess square;(%d,%d)", x2, y2);

            assertFalse(error, actual);
        }
    }

    @Test(expected = SameCoordinatesException.class)
    public void testCheckSameCoordinatesForKnight() throws SameCoordinatesException, OutOfRangeValueException {
        int x1 = 3, y1 = 6;
        ChessPiecesLogic.checkKnightMove(x1, y1, x1, y1);

    }

    @Test
    public void testCheckCoordinatesOutOFChessboardForKnight() throws SameCoordinatesException{
        for (int i = 0; i < POINTS_OUTSIDE_CHESSBOARD.length; i++) {
            int[] point = POINTS_OUTSIDE_CHESSBOARD[i];
            int x1 = point[0];
            int y1 = point[1];
            int x2 = point[2];
            int y2 = point[3];
            try {
                ChessPiecesLogic.checkKnightMove(x1, y1, x2, y2);
                fail(String.format("The coordinates x1:%d, y1:%d, x2:%d, y2:%d - should have been thrown " +
                        "OutOfRangeValueException  \n", x1, y1, x2, y2));
            } catch (OutOfRangeValueException  e) {
            }
        }
    }



}
