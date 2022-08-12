package itStep.yandr.javaStages.stage13.util;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.generalTask.model.logic.ArrayLogic.calculateArithmeticAverage;
import static itStep.yandr.javaStages.stage13.util.ArrayManager.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;


public class ArrayManagerTest {

    @Test
    public void testGetIndicesOfEqualsElementBasic() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[]array = {"abc","cba","bac","bca"};
        int[][]expected = {{0}, {1}, {2}, {3}};
        for (int i = 0;i<expected.length;i++) {
            String error = String.format("Error with value [%s] to array %s\n", array[i], Arrays.toString(array));
            assertArrayEquals(error,expected[i], getIndicesOfEqualsElement(array[i], array));
        }
    }
    @Test
    public void testGetIndicesOfEqualsElementWithTheSameElements() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[]array = {"abc","cba","bac","bac","bca","abc"};
        int[][]expected = {{0,5}, {1}, {2,3}, {2,3}, {4},{0,5}};
        for (int i = 0;i<expected.length;i++) {
            String error = String.format("Error with value [%s] to array %s", array[i], Arrays.toString(array));
            assertArrayEquals(error,expected[i], getIndicesOfEqualsElement(array[i], array));
        }
    }
    @Test
    public void testGetIndicesOfEqualsElementWithoutSearchElements() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[]array = {"abc","cba","bac","bac","bca","abc"};
        String[]searchElements = {"aaa","bbb","ccc"};
        int[][]expected = {{-1}, {-1}, {-1}};
        for (int i = 0;i<expected.length;i++) {
            String error = String.format("Error with value [%s] to array %s\n", searchElements[i], Arrays.toString(array));
            assertArrayEquals(error,expected[i], getIndicesOfEqualsElement(searchElements[i], array));
        }
    }
    @Test
    public void testGetIndicesOfEqualsElementWithOneElements() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[][]array = {{"cba"},{"abc"},{"bac"}};
        int[]expected = {0};
        for (int i = 0;i<array.length;i++) {
            String error = String.format("Error with value [%s] to array %s", array[i], Arrays.toString(array));
            assertArrayEquals(error,expected, getIndicesOfEqualsElement(array[i][0], array[i]));
        }
    }

    @Test
    public void testGetIndicesOfEqualsElementWithNullObject() throws InvalidSizeOfArrayException {
        String[][] array = {{"abc", "bac"}, {"abc", null}};
        String[] searchElements = {null, "abc"};
        for (int i = 0; i < array.length; i++) {
            try {
                getIndicesOfEqualsElement(searchElements[i], array[i]);
                fail("Search element " + searchElements[i] + " to array with " + Arrays.toString(array[i])
                        + " should have been thrown InvalidObjectException");
            } catch (InvalidObjectException e) {
            }
        }
    }
    @Test
    public void testGetIndicesOfEqualsElementWithInvalidArray() throws InvalidObjectException {
        String[][] array = {new String[0], null};
        for (int i = 0; i < array.length; i++) {
            try {
                getIndicesOfEqualsElement("abc", array[i]);
                fail("The arrays with " + Arrays.toString(array[i])
                        + " should have been thrown InvalidObjectException");
            } catch (InvalidSizeOfArrayException e) {
            }
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
    @Test
    public void testExchangeAllEqualsBasic() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[] commands = {"all", "min"};
        String[] exp = {"min", "max", "avg", "sum", "mpl", "swap", "min"};
        String[] act = exchangeAllEquals(commands,commands[0],"min", "max", "avg", "sum", "mpl", "swap");
        Assert.assertArrayEquals(exp, act);
    }

    @Test
    public void testExchangeAllEqualsWithMultipleEquivalents() throws InvalidSizeOfArrayException
            , InvalidObjectException {
        String[] commands = {"all", "min","swap","all"};
        String[] exp = {"min", "max", "avg", "sum", "mpl", "swap", "min","swap","min", "max", "avg", "sum", "mpl", "swap"};
        String[] act = exchangeAllEquals(commands,commands[0],"min", "max", "avg", "sum", "mpl", "swap");
        Assert.assertArrayEquals(exp, act);
    }
}
