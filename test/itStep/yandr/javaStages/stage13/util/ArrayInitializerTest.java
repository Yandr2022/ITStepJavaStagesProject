package itStep.yandr.javaStages.stage13.util;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import org.junit.Test;

import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.util.ArrayInitializer.concatenateArraysWithReplacementElement;
import static itStep.yandr.javaStages.stage13.util.ArrayInitializer.getIndicesOfEqualsElement;
import static org.junit.Assert.assertArrayEquals;


public class ArrayInitializerTest {

    @Test
    public void testGetIndexOfEqualsElementBasic() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[]array = {"abc","cba","bac","bca"};
        int[][]expected = {{0}, {1}, {2}, {3}};
        for (int i = 0;i<expected.length;i++) {
            String error = String.format("Error with value [%s] to array %s", array[i], Arrays.toString(array));
            assertArrayEquals(error,expected[i], getIndicesOfEqualsElement(array[i], array));
        }
    }
    @Test
    public void testGetIndexOfEqualsElementWithTheSameElements() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[]array = {"abc","cba","bac","bac","bca","abc"};
        int[][]expected = {{0,5}, {1}, {2,3}, {2,3}, {4},{0,5}};
        for (int i = 0;i<expected.length;i++) {
            String error = String.format("Error with value [%s] to array %s", array[i], Arrays.toString(array));
            assertArrayEquals(error,expected[i], getIndicesOfEqualsElement(array[i], array));
        }
    }
    @Test
    public void testConcatenateArraysWithReplacementElementBasic()
            throws InvalidSizeOfArrayException, InvalidObjectException {
        String[]array1 = {"abc","cba","bac","bca"};
        String[]array2 = {"aaa","bbb","ccc"};
        String[]expected = {"abc","aaa","bbb","ccc","bac","bca"};
        String[]actual =concatenateArraysWithReplacementElement(array1,array2,1);
        assertArrayEquals(expected,actual);
    }
}
