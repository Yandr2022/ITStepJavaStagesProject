package itStep.yandr.javaStages.stage13.mainTask.model.logic;

import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayLogicTest {
    private final double[][] INVALID_ARRAYS_DOUBLE = {null, new double[0], {6}};
    private final int[][] INVALID_ARRAYS_INT = {null, new int[0], {6}};

    @Test
    public void testCheckOrderOfSequenceOfNumbersBasic() {
        double[][] arrays = {{-1, 3, 4, 7, 8, 12, 76.6}, {56, 8.2, 4, 1.6, 0, -2, -5.89}, {6, 2, 5, 9, 57, 4}};
        int[] expected = {1, 2, 0};
        for (int i = 0; i < expected.length; i++) {
            String error = "Error while checking an array %d" + Arrays.toString(arrays[i]);
            assertEquals(error, expected[i], ArrayLogic.checkOrderOfSequenceOfNumbers(arrays[i]));
        }
    }

    @Test
    public void testCheckOrderOfSequenceOfNumbersWithTwoElements() {
        double[][] arrays = {{-1, 3}, {56, 8.2}, {6, 6}};
        int[] expected = {1, 2, 0};
        for (int i = 0; i < expected.length; i++) {
            String error = "Error while checking an array " + Arrays.toString(arrays[i]);
            assertEquals(error, expected[i], ArrayLogic.checkOrderOfSequenceOfNumbers(arrays[i]));
        }
    }

    @Test
    public void testCheckOrderOfSequenceOfNumbersWithInvalidArray() {
        int expected = -1;
        for (double[] doubles : INVALID_ARRAYS_DOUBLE) {
            String error = "Error while checking an array: " + Arrays.toString(doubles);
            assertEquals(error, expected, ArrayLogic.checkOrderOfSequenceOfNumbers(doubles));
        }
    }

    @Test
    public void testCheckMirroredArrangementOfElementsReturnTrue() throws InvalidSizeOfArrayException {
        double[][] arrays = {{2.5, 7, 0, 9, 9, 0, 7, 2.5}, {2.5, 7, 0, 9, 7, 9, 0, 7, 2.5}};
        for (double[] array : arrays) {
            assertTrue(ArrayLogic.checkMirroredDispositionOfElements(array));
        }
    }

    @Test
    public void testCheckMirroredArrangementOfElementsReturnFalse() throws InvalidSizeOfArrayException {
        double[][] arrays = {{2.5, 7, 1, 0, 9, 9, 0, 7, 2.5}, {2.5, 7, 1, 0, 9, 7, 9, 0, 7, 2.5}};
        for (double[] array : arrays) {
            assertFalse(ArrayLogic.checkMirroredDispositionOfElements(array));
        }

    }

    @Test
    public void testCheckMirroredArrangementOfElementsWithTwoElements() throws InvalidSizeOfArrayException {
        double[][] arrays = {{7, 2.5}, {2.5, 2.5}};
        boolean[] expected = {false, true};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], ArrayLogic.checkMirroredDispositionOfElements(arrays[i]));
        }
    }

    @Test
    public void testCheckMirroredArrangementOfElementsWithThreeElements() throws InvalidSizeOfArrayException {
        double[][] arrays = {{7, 2.5, 7.6}, {2.5, 6, 2.5}};
        boolean[] expected = {false, true};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], ArrayLogic.checkMirroredDispositionOfElements(arrays[i]));
        }
    }

    @Test
    public void testCheckMirroredArrangementOfElementsWithInvalidArray() {
        for (double array[] : INVALID_ARRAYS_DOUBLE) {
            try {
                ArrayLogic.checkMirroredDispositionOfElements(array);
                fail("The array with " + Arrays.toString(array) + "should have been thrown " +
                        "OutOfRangeValueException \n");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }

    @Test
    public void testCheckEqualityOrDifferenceNumbersOfSequenceBasic() {
        double[][] arrays = {{3, 3, 3, 3, 3, 3}, {56, 8.2, 4, 1.6, 0, -2, -5.89}, {6, 2, 5, 9, 6, 57, 4}};
        int[] expected = {1, 2, 0};
        for (int i = 0; i < expected.length; i++) {
            String error = "Error while checking an array %d" + Arrays.toString(arrays[i]);
            assertEquals(error, expected[i], ArrayLogic.checkEqualityOrDifferenceNumbersOfSequence(arrays[i]));
        }
    }

    @Test
    public void testCheckEqualityOrDifferenceNumbersOfSequenceWithTwoElements() {
        double[][] arrays = {{-1, -1}, {56, 8.2}};
        int[] expected = {1, 2};
        for (int i = 0; i < expected.length; i++) {
            String error = "Error while checking an array " + Arrays.toString(arrays[i]);
            assertEquals(error, expected[i], ArrayLogic.checkEqualityOrDifferenceNumbersOfSequence(arrays[i]));
        }
    }

    @Test
    public void testCheckEqualityOrDifferenceNumbersOfSequenceWithInvalidArray() {
        int expected = -1;
        for (double[] doubles : INVALID_ARRAYS_DOUBLE) {
            String error = "Error while checking an array: " + Arrays.toString(doubles);
            assertEquals(error, expected, ArrayLogic.checkEqualityOrDifferenceNumbersOfSequence(doubles));
        }
    }

    @Test
    public void testDefineTheNumberOfEvenElementsBasic() {
        int[][] arrays = {{3, 6, -8, 5, 7, 5, 0}, {1, 5, 78, 2, 89, 67, -1}, {4, 7, 1, 89, 75, 9}, {5, 7, 9, 13, 17, 35}};
        int[] expected = {3, 2, 1, 0};
        for (int i = 0; i < expected.length; i++) {
            String error = "Error while checking an array" + Arrays.toString(arrays[i]);
            assertEquals(error, expected[i], ArrayLogic.countTheNumberOfEvenElements(arrays[i]));
        }
    }

    @Test
    public void testDefineTheNumberOfEvenElementsWithOneElements() {
        int[][] arrays = {{-2}, {57}};
        int[] expected = {1, 0};
        for (int i = 0; i < expected.length; i++) {
            String error = "Error while checking an array " + Arrays.toString(arrays[i]);
            assertEquals(error, expected[i], ArrayLogic.countTheNumberOfEvenElements(arrays[i]));
        }
    }

    @Test
    public void testDefineTheNumberOfEvenElementsWithInvalidArray() {
        int expected = -1;
        for (int i = 0; i < INVALID_ARRAYS_INT.length - 1; i++) {
            String error = "Error while checking an array: " + Arrays.toString(INVALID_ARRAYS_INT[i]);
            assertEquals(error, expected, ArrayLogic.countTheNumberOfEvenElements(INVALID_ARRAYS_INT[i]));
        }
    }

    @Test
    public void testDefineTheNumberOfOddElementsBasic() {
        int[][] arrays = {{3, 6, -8, 5, 7, 52, 0}, {10, 5, 78, 2, 89, 70}, {8, 6, 10, 90, 72, 9}, {54, 0, 96, 18, 20, 34}};
        int[] expected = {3, 2, 1, 0};
        for (int i = 0; i < expected.length; i++) {
            String error = "Error while checking an array" + Arrays.toString(arrays[i]);
            assertEquals(error, expected[i], ArrayLogic.countTheNumberOfOddElements(arrays[i]));
        }
    }

    @Test
    public void testDefineTheNumberOfOddElementsWithOneElements() {
        int[][] arrays = {{-2}, {57}};
        int[] expected = {0, 1};
        for (int i = 0; i < expected.length; i++) {
            String error = "Error while checking an array " + Arrays.toString(arrays[i]);
            assertEquals(error, expected[i], ArrayLogic.countTheNumberOfOddElements(arrays[i]));
        }
    }

    @Test
    public void testDefineTheNumberOfOddElementsWithInvalidArray() {
        int expected = -1;
        for (int i = 0; i < INVALID_ARRAYS_INT.length - 1; i++) {
            String error = "Error while checking an array: " + Arrays.toString(INVALID_ARRAYS_INT[i]);
            assertEquals(error, expected, ArrayLogic.countTheNumberOfOddElements(INVALID_ARRAYS_INT[i]));
        }
    }
}
