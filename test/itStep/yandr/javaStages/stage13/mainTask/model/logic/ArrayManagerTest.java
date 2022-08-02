package itStep.yandr.javaStages.stage13.mainTask.model.logic;

import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArray;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayManagerTest {
    private final double[][] INVALID_ARRAYS = {null, new double[0], {6}};

    @Test
    public void testCheckOrderOfSequenceOfNumbersBasic() {
        double[][] arrays = {{-1, 3, 4, 7, 8, 12, 76.6}, {56, 8.2, 4, 1.6, 0, -2, -5.89}, {6, 2, 5, 9, 57, 4}};
        int[] expected = {2, 1, 0};
        for (int i = 0; i < expected.length; i++) {
            String error = "Error while checking an array %d" + Arrays.toString(arrays[i]);
            assertEquals(error, expected[i], ArrayManager.checkOrderOfSequenceOfNumbers(arrays[i]));
        }
    }

    @Test
    public void testCheckOrderOfSequenceOfNumbersWithTwoElements() {
        double[][] arrays = {{-1, 3}, {56, 8.2}, {6, 6}};
        int[] expected = {2, 1, 0};
        for (int i = 0; i < expected.length; i++) {
            String error = "Error while checking an array " + Arrays.toString(arrays[i]);
            assertEquals(error, expected[i], ArrayManager.checkOrderOfSequenceOfNumbers(arrays[i]));
        }
    }

    @Test
    public void testCheckOrderOfSequenceOfNumbersWithInvalidArray() {
        int expected = -1;
        for (int i = 0; i < INVALID_ARRAYS.length; i++) {
            String error = "Error while checking an array: " + Arrays.toString( INVALID_ARRAYS[i]);
           assertEquals(error, expected, ArrayManager.checkOrderOfSequenceOfNumbers( INVALID_ARRAYS[i]));
        }
    }

    @Test
    public void testCheckMirroredArrangementOfElementsReturnTrue() throws InvalidSizeOfArray {
        double[][] arrays ={ {2.5,7,0,9,9,0,7,2.5},{2.5,7,0,9,7,9,0,7,2.5}};
        for (double[]array:arrays) {
          assertTrue(ArrayManager.checkMirroredArrangementOfElements(array));
        }
    }

    @Test
    public void testCheckMirroredArrangementOfElementsReturnFalse() throws InvalidSizeOfArray {
        double[][] arrays ={ {2.5,7,1,0,9,9,0,7,2.5},{2.5,7,1,0,9,7,9,0,7,2.5}};
        for (double[]array:arrays) {
            assertFalse(ArrayManager.checkMirroredArrangementOfElements(array));
        }

    }
    @Test
    public void testCheckMirroredArrangementOfElementsWithTwoElements() throws InvalidSizeOfArray {
        double[][] arrays ={ {7,2.5},{2.5,2.5}};
        boolean [] expected = {false,true};
        for (int i = 0;i< expected.length;i++) {
            assertEquals(expected[i],ArrayManager.checkMirroredArrangementOfElements(arrays[i]));
        }
    }
    @Test
    public void testCheckMirroredArrangementOfElementsWithThreeElements() throws InvalidSizeOfArray {
        double[][] arrays ={ {7,2.5,7.6},{2.5,6,2.5}};
        boolean [] expected = {false,true};
        for (int i = 0;i< expected.length;i++) {
            assertEquals(expected[i],ArrayManager.checkMirroredArrangementOfElements(arrays[i]));
        }
    }

    @Test
    public void testCheckMirroredArrangementOfElementsWithInvalidArray() {
        for (double array[] : INVALID_ARRAYS) {
            try {
                ArrayManager.checkMirroredArrangementOfElements(array);
                fail("The array with " + Arrays.toString(array) + "should have been thrown " +
                        "OutOfRangeValueException \n");
            } catch (InvalidSizeOfArray e) {
            }
        }
    }

    @Test
    public void testCheckEqualityOrDifferenceNumbersOfSequenceBasic() {
        double[][] arrays = {{3, 3, 3, 3, 3, 3}, {56, 8.2, 4, 1.6, 0, -2, -5.89}, {6, 2, 5, 9, 6, 57, 4}};
        int[] expected = {1, 2, 0};
        for (int i = 0; i < expected.length; i++) {
            String error = "Error while checking an array %d" + Arrays.toString(arrays[i]);
            assertEquals(error, expected[i], ArrayManager.checkEqualityOrDifferenceNumbersOfSequence(arrays[i]));
        }
    }

    @Test
    public void testCheckEqualityOrDifferenceNumbersOfSequenceWithTwoElements() {
        double[][] arrays = {{-1, -1}, {56, 8.2}};
        int[] expected = {1, 2};
        for (int i = 0; i < expected.length; i++) {
            String error = "Error while checking an array " + Arrays.toString(arrays[i]);
            assertEquals(error, expected[i], ArrayManager.checkEqualityOrDifferenceNumbersOfSequence(arrays[i]));
        }
    }

    @Test
    public void testCheckEqualityOrDifferenceNumbersOfSequenceWithInvalidArray() {
        int expected = -1;
        for (int i = 0; i < INVALID_ARRAYS.length; i++) {
            String error = "Error while checking an array: " + Arrays.toString(INVALID_ARRAYS[i]);
            assertEquals(error, expected, ArrayManager.checkEqualityOrDifferenceNumbersOfSequence(INVALID_ARRAYS[i]));
        }
    }
}
