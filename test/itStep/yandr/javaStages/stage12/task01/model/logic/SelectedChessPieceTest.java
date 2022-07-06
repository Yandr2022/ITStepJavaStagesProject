package itStep.yandr.javaStages.stage12.task01.model.logic;

import itStep.yandr.javaStages.stage12.task01.exception.OutOfRangeValueException;
import itStep.yandr.javaStages.stage12.task01.exception.SameCoordinatesException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SelectedChessPieceTest {
    private final int[][] POINTS_OUTSIDE_CHESSBOARD = {{0, 3, 4, 6}, {8, 0, 7, 2}, {6, 1, 0, 4},
            {1, 5, 7, 0}, {-6, 2, 8, 1}, {7, -2, 5, 3}, {1, 5, -2, 3}, {7, 1, 2, -4}, {10, 5, 2, 4},
            {2, 12, 3, 1}, {4, 5, 9, 1}, {8, 2, 7, 13}
    };

    @Test
    public void testCheckMoveChessPieceWithSelectedNameWithCorrectNameInLowercase() throws IOException
            , SameCoordinatesException, OutOfRangeValueException {
        String[]namePieces = {"rook","king","bishop","queen","knight"};
        boolean actual;
        boolean []expecteds = {false,true,true,true,false,};
        int x1 = 5,y1 = 4,x2  = 6, y2 =5;
        for (int i = 0; i <expecteds.length ; i++) {
            actual = SelectionChessPiecesLogic.checkMoveChessPieceWithSelectedName(namePieces[i],x1,y1,x2,y2);
            assertEquals(String.format("Error with name: %s",namePieces[i]),expecteds[i],actual);

        }
    }

    @Test
    public void testCheckMoveChessPieceWithSelectedNameWithCorrectNameInUppercase() throws IOException
            , SameCoordinatesException, OutOfRangeValueException {
        String[]namePieces = {"rOok","King","biShop","qUEeN","KNIGHT"};
        boolean actual;
        boolean []expected = {true,false,false,true,false};
        int x1 = 5,y1 = 5,x2  = 7, y2 =5;
        for (int i = 0; i <expected.length ; i++) {
            actual = SelectionChessPiecesLogic.checkMoveChessPieceWithSelectedName(namePieces[i],x1,y1,x2,y2);
            assertEquals(String.format("Error with name: %s",namePieces[i]),expected[i],actual);
        }
    }

    @Test
    public void testCheckMoveChessPieceWithSelectedNameWithWrongNameInUppercase() throws SameCoordinatesException
            , OutOfRangeValueException {
        String[] namePieces = {"123", "RJHJ", "король", "qU_EeN", "*"};
        int x1 = 5, y1 = 5, x2 = 7, y2 = 5;
        for (int i = 0; i < namePieces.length; i++) {
            try {
                SelectionChessPiecesLogic.checkMoveChessPieceWithSelectedName(namePieces[i], x1, y1, x2, y2);
                fail(String.format("The name: %s - should have been thrown " +
                        "IOException \n", namePieces[i]));
            } catch (IOException e) {
            }
        }

    }
    @Test (expected = SameCoordinatesException.class)
    public void testCheckMoveChessPieceWithSelectedNameWithSameCoordinates() throws SameCoordinatesException
            , OutOfRangeValueException, IOException {
        int x1 = 8,y1 = 7;
        SelectionChessPiecesLogic.checkMoveChessPieceWithSelectedName("king",x1, y1, x1, y1);
    }

    @Test
    public void testCheckMoveChessPieceWithSelectedNameWithCoordinatesOutOFChessboard() throws SameCoordinatesException
            , IOException {
        for (int i = 0; i < POINTS_OUTSIDE_CHESSBOARD.length; i++) {
            int[] point = POINTS_OUTSIDE_CHESSBOARD[i];
            int x1 = point[0];
            int y1 = point[1];
            int x2 = point[2];
            int y2 = point[3];
            try {
                SelectionChessPiecesLogic.checkMoveChessPieceWithSelectedName("king",x1, y1, x2, y2);
                fail(String.format("The coordinates x1:%d, y1:%d, x2:%d, y2:%d - should have been thrown " +
                        "OutOfRangeValueException  \n", x1, y1, x2, y2));
            } catch (OutOfRangeValueException e) {
            }

        }
    }

    @Test
    public void testCheckMoveAllChessPieceWithLegalArguments() throws SameCoordinatesException, OutOfRangeValueException {
        int x1 = 8,y1 = 7,x2  = 3, y2 =4;
        boolean[] expecteds = {ChessPiecesLogic.checkRookMove(x1, y1, x2, y2)
                ,ChessPiecesLogic.checkKingMove(x1, y1, x2, y2),ChessPiecesLogic.checkBishopMove(x1, y1, x2, y2)
                ,ChessPiecesLogic.checkQueenMove(x1, y1, x2, y2),ChessPiecesLogic.checkKnightMove(x1, y1, x2, y2)};
        boolean[]actuals = SelectionChessPiecesLogic.checkMoveAllChessPiece(x1, y1, x2, y2);
        assertArrayEquals(expecteds,actuals);
    }

    @Test (expected = SameCoordinatesException.class)
    public void testCheckMoveAllChessPieceWithSameCoordinates() throws SameCoordinatesException, OutOfRangeValueException {
        int x1 = 8,y1 = 7;
        SelectionChessPiecesLogic.checkMoveAllChessPiece(x1, y1, x1, y1);
    }
    @Test
    public void testCheckMoveAllChessPieceWithCoordinatesOutOFChessboard() throws SameCoordinatesException {
        for (int i = 0; i < POINTS_OUTSIDE_CHESSBOARD.length; i++) {
            int[] point = POINTS_OUTSIDE_CHESSBOARD[i];
            int x1 = point[0];
            int y1 = point[1];
            int x2 = point[2];
            int y2 = point[3];
            try {
                SelectionChessPiecesLogic.checkMoveAllChessPiece(x1, y1, x2, y2);
                fail(String.format("The coordinates x1:%d, y1:%d, x2:%d, y2:%d - should have been thrown " +
                        "OutOfRangeValueException  \n", x1, y1, x2, y2));
            } catch (OutOfRangeValueException e) {
            }

        }
    }
}






