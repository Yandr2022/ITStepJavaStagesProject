package itStep.yandr.javaStages.stage13.generalTask.util;

import itStep.yandr.javaStages.stage13.generalTask.exception.InvalidSizeOfArray;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.generalTask.util.ActionSelector.selectActions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ActionSelectorTest {

    @Test
    public void testSelectActionsWithAllOptionsWithSingleCommand() throws IOException, InvalidSizeOfArray {
        double[] array = {2.4, 5.3, -2.4, 0, 6.7, 8, 24};
        String expected = "Minimum value in the entered sequence of numbers: -2.4\n" +
                "Maximum value in the entered sequence of numbers: 24.0\n" +
                "Arithmetic mean of the entered sequence of numbers: 6.285714285714286\n" +
                "Result of exchanging extreme values of the entered sequence of numbers: [2.4, 5.3, 24.0, 0.0, 6.7, 8.0, -2.4]\n" +
                "Sum of numbers whose absolute value is less than the arithmetic mean of the entered sequence of numbers" +
                ": 5.299999999999999\n" +
                "Product of positive numbers located at even places of the entered sequence of numbers: 42.4\n";
        String actual = selectActions(array, "all");
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectActionsUsingGroupOfCommands() throws IOException, InvalidSizeOfArray {
        double[] array = {2.4, 5.3, -2.4, 0, 6.7, 8, 24};
        String expected = "Sum of numbers whose absolute value is less than the arithmetic mean " +
                "of the entered sequence of numbers: 5.299999999999999\n" +
                "Result of exchanging extreme values of the entered sequence of numbers:" +
                " [2.4, 5.3, 24.0, 0.0, 6.7, 8.0, -2.4]\n" +
                "Minimum value in the entered sequence of numbers: -2.4\n" +
                "Arithmetic mean of the entered sequence of numbers: 6.285714285714286\n" +
                "Maximum value in the entered sequence of numbers: 24.0\n" +
                "Product of positive numbers located at even places of the entered sequence of numbers: 42.4\n";
        String actual = selectActions(array, "sum", "swap", "min", "avg", "max", "mpl");
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectActionsWithNull() throws IOException, InvalidSizeOfArray {
        double[][] arrays = {null, {0}, null};
        String[][] commands = {{"all"}, {"swap", null}, null};
        for (int i = 0; i < commands.length; i++) {
            try {
                selectActions(arrays[i], commands[i]);
                fail("The arrays with " + Arrays.toString(arrays[i]) + Arrays.toString(commands[i]) +
                        " should have been thrown InvalidSizeOfArrayException ");
            } catch (InvalidSizeOfArray e ) {
            }
        }
    }

    @Test
    public void testSelectActionsWithWrongCommand() throws InvalidSizeOfArray {
        double[] array = {1, 2};
        String[][] commands = {{"123"}, {""}, {"all","ghj"}};
        for (String command[]:commands) {
            try {
                selectActions(array, command);
                fail("The arrays with " + Arrays.toString(commands) +
                        " should have been thrown IOException");
            } catch ( IOException e) {
            }
        }

    }
}


