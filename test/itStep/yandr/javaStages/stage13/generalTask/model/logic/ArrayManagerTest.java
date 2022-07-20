package itStep.yandr.javaStages.stage13.generalTask.model.logic;

import itStep.yandr.javaStages.stage13.generalTask.exception.InvalidSizeOfArray;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.generalTask.model.logic.ArrayManager.findMaxValueIndex;
import static org.junit.Assert.fail;

public class ArrayManagerTest {
    private final int[][] INVALID_ARRAYS = {null, {}, {2}};

    @Test
    public void testFindMaxValueIndexWithPositiveMaxElement() throws InvalidSizeOfArray {
        int arrays[][] = {{6, 4, 0, 5, 8}, {5, -1, 2, 3}, {1, 5, 3, 7, -2, 6}, {0, 2}};
        int expected[] = {4, 0, 3, 1};
        int actual[] = new int[4];
        int index = 0;
        for (int[] array : arrays) {
            actual[index] = findMaxValueIndex(array);
            String error = String.format("Error with index:%d", index);
            Assert.assertEquals(error, actual[index], expected[index]);
            index++;
        }
    }

    @Test
    public void testFindMaxValueIndexWithNegativeMaxElement() throws InvalidSizeOfArray {
        int arrays[][] = {{-1, -6, -2, -5, -8}, {-5, -2, -3, 0}, {-5, -3, -1, -7, -2, -6}, {-4, -2}};
        int expected[] = {0, 3, 2, 1};
        int actual[] = new int[4];
        int index = 0;
        for (int[] array : arrays) {
            actual[index] = findMaxValueIndex(array);
            String error = String.format("Error with index:%d", index);
            Assert.assertEquals(error, actual[index], expected[index]);
            index++;
        }
    }

    @Test
    public void testFindMaxValueIndexWithInvalidSizeOfArray() {
        for (int[] array : INVALID_ARRAYS) {
            try {
                findMaxValueIndex(array);
                fail(String.format("The array with " + Arrays.toString(array) + " should have been thrown " +
                        "InvalidSizeOfArrayException "));
            } catch (InvalidSizeOfArray e) {
            }
        }
    }



}








