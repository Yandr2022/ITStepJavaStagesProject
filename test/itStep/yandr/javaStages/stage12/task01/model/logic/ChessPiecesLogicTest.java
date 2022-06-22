package itStep.yandr.javaStages.stage12.task01.model.logic;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChessPiecesLogicTest {
    @Test
    public void testCheckRockStepReturnTrue() {
        int x1 = 4, y1 = 4;
        int[][] points = {{1, 4}, {2, 4}, {3, 4}, {5, 4}, {6, 4}, {7, 4}, {8, 4}, {4, 1}, {4, 2}, {4, 3}, {4, 5}, {4, 6}, {4, 7}, {4, 8}};
        for (int i = 0; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            boolean actual = ChessPiecesLogic.chessRockStep(x1, y1, x2, y2);
            String error = String.format("Error with chess cell;(%d,%d)", x2, y2);

            assertTrue(actual);
        }
    }
}
