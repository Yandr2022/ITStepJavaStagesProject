package itStep.yandr.javaStages.stage13.generalTask.model.logic;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.generalTask.model.logic.ActionSelector.selectActions;
import static org.junit.Assert.*;

public class ActionSelectorTest {


    @Test
    public void testSelectActionsBasic() throws IOException, InvalidSizeOfArrayException
            , InvalidObjectException {
        double[] array = {2.4, 5.3, -2.4, 0, 6.7, 8, 24};
        double [][] expected = {{5.299999999999999},
                {2.4, 5.3, 24.0, 0.0, 6.7, 8.0, -2.4},{-2.4},{6.285714285714286},{24.0},{ 42.4}};
        double[][] actual = selectActions(array, "sum", "swap", "min", "avg", "max", "mpl");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSelectActionsWithSameCommands() throws IOException, InvalidSizeOfArrayException
            , InvalidObjectException {
        double[] array = {2.4, 5.3, 0, 6.7, 8, 24};
        double [][][] expected = {{{14.399999999999999},{14.399999999999999}},{{ 852.24}
                , {2.4, 5.3, 24.0, 6.7, 8.0, 0.0},{35.51}}};
        String [][]commands ={{"sum","sum"},{"mpl","swap","mpl"}};
        for (int i = 0; i < commands.length; i++) {
            double [][]actual = selectActions(array, commands[i]);
            assertArrayEquals(expected[i], actual);
        }

    }

    @Test
    public void testSelectActionsWithNull() throws IOException, InvalidObjectException {
        double[][] arrays = {null , {1,2}};
        String[][] commands = {{"mpl"}, null};
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
    public void testSelectActionsWithNullWithinArray() throws IOException, InvalidSizeOfArrayException
            , InvalidObjectException {
        double[] arrays = {0, 1};
        String[] commands = {"swap", null};
        selectActions(arrays, commands);
    }

    @Test
    public void testSelectActionsWithWrongCommand() throws InvalidSizeOfArrayException
            , InvalidObjectException {
        double[] array = {1, 2};
        String[][] commands = {{"123"}, {""}, {"mpl","ghj"}};
        for (String[] command : commands) {
            try {
                selectActions(array, command);
                fail("The arrays with " + Arrays.toString(command) +
                        " should have been thrown IOException");
            } catch (IOException e) {
            }
        }
    }


}


