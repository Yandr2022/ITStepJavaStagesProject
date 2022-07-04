package itStep.yandr.javaStages.stage12.task01.model.logic;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SelectedChessPieceTest {
    @Test
    public void testSelectedChessPieceWithCorrectNameInLowercase() throws IOException {
        String[]namePieces = {"rook","king","bishop","queen","knight"};
        boolean actual;
        boolean []expected = {false,true,true,true,false,};
        int x1 = 5,y1 = 4,x2  = 6, y2 =5;
        for (int i = 0; i <expected.length ; i++) {
            actual = SelectionChessPiecesLogic.checkMoveChessPieceWithSelected(namePieces[i],x1,y1,x2,y2);
            assertEquals(String.format("Error with name: %s",namePieces[i]),expected[i],actual);

        }
    }

    @Test
    public void testSelectedChessPieceWithCorrectNameInUppercase() throws IOException {
        String[]namePieces = {"rOok","King","biShop","qUEeN","KNIGHT"};
        boolean actual;
        boolean []expected = {true,false,false,true,false};
        int x1 = 5,y1 = 5,x2  = 7, y2 =5;
        for (int i = 0; i <expected.length ; i++) {
            actual = SelectionChessPiecesLogic.checkMoveChessPieceWithSelected(namePieces[i],x1,y1,x2,y2);
            assertEquals(String.format("Error with name: %s",namePieces[i]),expected[i],actual);
        }
    }

    @Test
    public void testSelectedChessPieceWithWrongNameInUppercase() throws IOException {
        String[]namePieces = {"123","RJHJ","король","qU_EeN","*"};
        int x1 = 5,y1 = 5,x2  = 7, y2 =5;
        for (int i = 0; i <namePieces.length ; i++) {
            try {
                SelectionChessPiecesLogic.checkMoveChessPieceWithSelected(namePieces[i],x1,y1,x2,y2);
                fail(String.format("The name: %s - should have been thrown " +
                        "IllegalArgumentException \n",namePieces[i]));
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
