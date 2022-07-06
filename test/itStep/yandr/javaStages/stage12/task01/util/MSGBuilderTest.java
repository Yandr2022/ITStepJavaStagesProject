package itStep.yandr.javaStages.stage12.task01.util;

import itStep.yandr.javaStages.stage12.task01.exception.InvalidSizeOfArray;
import itStep.yandr.javaStages.stage12.task01.exception.OutOfRangeValueException;
import itStep.yandr.javaStages.stage12.task01.exception.SameCoordinatesException;
import itStep.yandr.javaStages.stage12.task01.model.logic.SelectionChessPiecesLogic;
import org.junit.Test;

import java.io.IOException;

import static itStep.yandr.javaStages.stage12.task01.model.logic.SelectionChessPiecesLogic.checkMoveChessPieceWithSelectedName;
import static org.junit.Assert.assertEquals;

public class MSGBuilderTest {

    @Test
    public void testBuildMSGtoResultForAllChessPiecesWithCorrectData() throws SameCoordinatesException
            , OutOfRangeValueException, InvalidSizeOfArray {
        String actual = MSGBuilder.buildMSGtoResultForAllChessPieces(SelectionChessPiecesLogic
                .checkMoveAllChessPiece(5, 6, 7, 8));
        String expected = "Rook : No\nKing : No\nBishop : Yes\nQueen : Yes\n";
        assertEquals(actual, expected);
    }

    @Test(expected = InvalidSizeOfArray.class)
    public void testBuildMSGtoResultForAllChessPiecesWithNull() throws InvalidSizeOfArray {
        MSGBuilder.buildMSGtoResultForAllChessPieces(null);
    }

    @Test(expected = InvalidSizeOfArray.class)
    public void testBuildMSGtoResultForAllChessPiecesWithArrayWithLackOfValues() throws InvalidSizeOfArray {
        boolean[] array = {true, false, true};
        MSGBuilder.buildMSGtoResultForAllChessPieces(array);
    }

    @Test(expected = InvalidSizeOfArray.class)
    public void testBuildMSGtoResultForAllChessPiecesWithOverflowingArray() throws InvalidSizeOfArray {
        boolean[] array = {true, false, true, true, false, true};
        MSGBuilder.buildMSGtoResultForAllChessPieces(array);
    }
    @Test
    public void testBuildMSGtoResultForOneFromChessPiecesWithCorrectData() throws SameCoordinatesException
            , OutOfRangeValueException, IOException {
       String actual = MSGBuilder.buildMSGtoResultForOneFromChessPieces("king"
               ,checkMoveChessPieceWithSelectedName("king",4,4,6,7));
       String expected ="King : No";
        assertEquals(actual, expected);
    }

    @Test(expected = IOException.class)
    public void testBuildMSGtoResultForOneFromChessPiecesWithNull() throws IOException
            , SameCoordinatesException, OutOfRangeValueException {
        MSGBuilder.buildMSGtoResultForOneFromChessPieces(null
                ,checkMoveChessPieceWithSelectedName("king",4,4,6,7));;
    }

}
