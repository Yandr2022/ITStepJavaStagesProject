package itStep.yandr.javaStages.stage13.mainTask.model.logic;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.mainTask.model.logic.ActionSelector.selectActions;
import static itStep.yandr.javaStages.stage13.mainTask.model.logic.DescriptionsContainer.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class ActionSelectorTest {

    @Test
    public void testSelectActionsBasic() throws IOException, InvalidSizeOfArrayException
            , InvalidObjectException {
        int[] array = {2, 5, -2, 5, 2};
        String[] expected = {ZERO_RESULT_CHECK_ORDER_OF_SEQUENCE,RESULT_TRUE
                ,ZERO_RESULT_CHECK_EQUAL_OR_DIFF_NUMB ,"2","3"};
        String[] actual = selectActions(array, Arrays.copyOfRange(COMMAND_NAMES,0,COMMAND_NAMES.length-1));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSelectActionsWithSameCommands() throws IOException, InvalidSizeOfArrayException
            , InvalidObjectException {
        int[] array = {2, 5, 10, 16, 18, 24};
        String[][] expected = {{RESULT_ONE_TO_CHECK_ORDER_OF_SEQUENCE,RESULT_ONE_TO_CHECK_ORDER_OF_SEQUENCE}
                ,{"1",RESULT_TWO_TO_CHECK_EQUAL_OR_DIFF_NUMB,"1"}};
        String [][]commands ={{"ord","ord"},{"odd","dif","odd"}};
        for (int i = 0; i < commands.length; i++) {
            String[]actual = selectActions(array, commands[i]);
            assertArrayEquals(expected[i], actual);
        }

    }
    @Test
    public void testSelectActionsWithPartlyInvalidArraySize() throws IOException, InvalidSizeOfArrayException
            , InvalidObjectException {
        int[] array = {2};
        String[] expected = {NEGATIVE_RESULT,NEGATIVE_RESULT
                ,NEGATIVE_RESULT ,"0","1"};
        String[] actual = selectActions(array, Arrays.copyOfRange(COMMAND_NAMES,0,COMMAND_NAMES.length-1));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSelectActionsWithNull() throws IOException, InvalidObjectException {
        int [][] arrays = {null , {1,2}};
        String[][] commands = {{"seq"}, null};
        for (int i = 0; i < commands.length; i++) {
            try {
                selectActions(arrays[i], commands[i]);
                fail("The arrays with " + Arrays.toString(arrays[i]) + Arrays.toString(commands[i]) +
                        " should have been thrown InvalidSizeOfArrayException ");
            } catch (InvalidSizeOfArrayException  e ) {
            }
        }
    }

    @Test(expected = InvalidObjectException.class)
    public void testSelectActionsWithNullObject() throws IOException, InvalidSizeOfArrayException
            , InvalidObjectException {
        int[] array = {0, 1};
        String[] commands = {"even", null};
        selectActions(array, commands);
    }

    @Test
    public void testSelectActionsWithWrongCommand() throws InvalidSizeOfArrayException
            , InvalidObjectException {
        int[] array = {1, 2};
        String[][] commands = {{"123"}, {""}, {"dif","ghj"}};
        for (String[] command : commands) {
            try {
                selectActions(array, command);
                fail("The commands " + Arrays.toString(command) +
                        " should have been thrown IOException");
            } catch (IOException e) {
            }
        }
    }



}
