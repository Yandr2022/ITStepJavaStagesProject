package itStep.yandr.javaStages.stage13.mainTask.model.logic;

import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArray;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayManagerTest {

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
        double[][] arrays = {null, {}, {6}};
        int expected = -1;
        for (int i = 0; i < arrays.length; i++) {
            String error = "Error while checking an array: " + Arrays.toString(arrays[i]);
           assertEquals(error, expected, ArrayManager.checkOrderOfSequenceOfNumbers(arrays[i]));
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
        double[][] arrays = {null, {}, {6}};
        for (double array[] : arrays) {
            try {
                ArrayManager.checkMirroredArrangementOfElements(array);
                fail("The array with " + Arrays.toString(array) + "should have been thrown " +
                        "OutOfRangeValueException \n");
            } catch (InvalidSizeOfArray e) {
            }
        }
    }
}
