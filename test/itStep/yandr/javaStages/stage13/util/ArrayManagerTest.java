package itStep.yandr.javaStages.stage13.util;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.util.ArrayManager.*;
import static org.junit.Assert.*;


public class ArrayManagerTest {

    @Test
    public void testGetIndicesOfEqualsElementBasic() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[] array = {"abc", "cba", "bac", "bca"};
        int[][] expected = {{0}, {1}, {2}, {3}};
        for (int i = 0; i < expected.length; i++) {
            String error = String.format("Error with value [%s] to array %s\n", array[i], Arrays.toString(array));
            assertArrayEquals(error, expected[i], getIndicesOfEqualsElement(array[i], array));
        }
    }

    @Test
    public void testGetIndicesOfEqualsElementWithTheSameElements() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[] array = {"abc", "cba", "bac", "bac", "bca", "abc"};
        int[][] expected = {{0, 5}, {1}, {2, 3}, {2, 3}, {4}, {0, 5}};
        for (int i = 0; i < expected.length; i++) {
            String error = String.format("Error with value [%s] to array %s", array[i], Arrays.toString(array));
            assertArrayEquals(error, expected[i], getIndicesOfEqualsElement(array[i], array));
        }
    }

    @Test
    public void testGetIndicesOfEqualsElementWithoutSearchElements() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[] array = {"abc", "cba", "bac", "bac", "bca", "abc"};
        String[] searchElements = {"aaa", "bbb", "ccc"};
        int[][] expected = {{-1}, {-1}, {-1}};
        for (int i = 0; i < expected.length; i++) {
            String error = String.format("Error with value [%s] to array %s\n", searchElements[i], Arrays.toString(array));
            assertArrayEquals(error, expected[i], getIndicesOfEqualsElement(searchElements[i], array));
        }
    }

    @Test
    public void testGetIndicesOfEqualsElementWithOneElements() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[][] array = {{"cba"}, {"abc"}, {"bac"}};
        int[] expected = {0};
        for (String[] strings : array) {
            String error = String.format("Error with value %s to array %s", Arrays.toString(strings), Arrays.toString(array));
            assertArrayEquals(error, expected, getIndicesOfEqualsElement(strings[0], strings));
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
        for (String[] strings : array) {
            try {
                getIndicesOfEqualsElement("abc", strings);
                fail("The arrays with " + Arrays.toString(strings)
                        + " should have been thrown InvalidObjectException");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }

    @Test
    public void testGetIndexOfEqualsElementBasic() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[] array = {"abc", "cba", "bac", "bca"};
        int[] expected = {0, 1, 2, 3};
        for (int i = 0; i < expected.length; i++) {
            String error = String.format("Error with value [%s] to array %s\n", array[i], Arrays.toString(array));
            assertEquals(error, expected[i], getIndexOfEqualsElement(array[i], array));
        }
    }

    @Test
    public void testGetIndexOfEqualsElementWithTheSameElements() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[] array = {"abc", "cba", "bac", "bac", "bca", "abc"};
        int[] expected = {5, 1, 3, 3, 4, 5};
        for (int i = 0; i < expected.length; i++) {
            String error = String.format("Error with value [%s] to array %s", array[i], Arrays.toString(array));
            assertEquals(error, expected[i], getIndexOfEqualsElement(array[i], array));
        }
    }

    @Test
    public void testGetIndexOfEqualsElementWithoutSearchElements() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[] array = {"abc", "cba", "bac", "bac", "bca", "abc"};
        String[] searchElements = {"aaa", "bbb", "ccc"};
        int expected = -1;
        for (String searchElement : searchElements) {
            String error = String.format("Error with value [%s] to array %s\n", searchElement, Arrays.toString(array));
            assertEquals(error, expected, getIndexOfEqualsElement(searchElement, array));
        }
    }

    @Test
    public void testGetIndexOfEqualsElementWithOneElements() throws InvalidSizeOfArrayException, InvalidObjectException {
        String[][] array = {{"cba"}, {"abc"}, {"bac"}};
        int expected = 0;
        for (String[] strings : array) {
            String error = String.format("Error with value [%s] to array %s", Arrays.toString(strings), Arrays.toString(array));
            assertEquals(error, expected, getIndexOfEqualsElement(strings[0], strings));
        }
    }

    @Test
    public void testGetIndexOfEqualsElementWithNullObject() throws InvalidSizeOfArrayException {
        String[][] array = {{"abc", "bac"}, {"abc", null}};
        String[] searchElements = {null, "abc"};
        for (int i = 0; i < array.length; i++) {
            try {
                getIndexOfEqualsElement(searchElements[i], array[i]);
                fail("Search element " + searchElements[i] + " to array with " + Arrays.toString(array[i])
                        + " should have been thrown InvalidObjectException");
            } catch (InvalidObjectException e) {
            }
        }
    }

    @Test
    public void testGetIndexOfEqualsElementWithInvalidArray() throws InvalidObjectException {
        String[][] array = {new String[0], null};
        for (String[] strings : array) {
            try {
                getIndexOfEqualsElement("abc", strings);
                fail("The arrays with " + Arrays.toString(strings)
                        + " should have been thrown InvalidSizeOfArrayException");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }

    @Test
    public void testConcatenateArraysWithReplacementElementBasic()
            throws InvalidSizeOfArrayException, InvalidObjectException, IOException {
        String[] array1 = {"0", "1", "2", "3"};
        String[] array2 = {"aaa", "bbb", "ccc"};
        String[][] expected = {{"aaa", "bbb", "ccc", "1", "2", "3"}, {"0", "aaa", "bbb", "ccc", "2", "3"}
                , {"0", "1", "aaa", "bbb", "ccc", "3"}, {"0", "1", "2", "aaa", "bbb", "ccc"}};
        for (int i = 0; i < array1.length; i++) {
            assertArrayEquals(expected[i], concatenateArraysWithReplacementElement(array1, array2, i));
        }
    }

    @Test
    public void testConcatenateArraysWithReplacementElementWithOneElementsToArray()
            throws InvalidSizeOfArrayException, InvalidObjectException, IOException {
        String[] array1 = {"abc"};
        String[] array2 = {"aaa", "bbb", "ccc"};
        String[] actual = concatenateArraysWithReplacementElement(array1, array2, 0);
        assertArrayEquals(array2, actual);
    }

    @Test
    public void testConcatenateArraysWithReplacementElementWithInvalidIndex()
            throws InvalidSizeOfArrayException, InvalidObjectException {
        String[] array1 = {"abc"};
        String[] array2 = {"aaa", "bbb", "ccc"};
        int[] indices = {1, -2};
        for (int index : indices) {
            try {
                concatenateArraysWithReplacementElement(array1, array2, index);
                fail("The index " + index + " should have been thrown IOException");
            } catch (IOException e) {
            }
        }
    }

    @Test
    public void testConcatenateArraysWithReplacementElementWithNullObject()
            throws InvalidSizeOfArrayException, IOException {
        String[][] array1 = {{null}, {"abc"}};
        String[][] array2 = {{"aaa", "bbb", "ccc"}, {"aaa", null, "ccc"}};
        for (int i = 0; i < array1.length; i++) {
            try {
                concatenateArraysWithReplacementElement(array1[i], array2[i], 0);
                fail("when replacing the element at index zero in the array" + Arrays.toString(array1[i])
                        + " on the values " + Arrays.toString(array2[i]) + " should have been thrown InvalidObjectException");
            } catch (InvalidObjectException e) {
            }
        }
    }

    @Test
    public void testConcatenateArraysWithReplacementElementWithInvalidArray() throws InvalidObjectException
            , IOException {
        String[][] array1 = {new String[0], null, {"1"}, {"2"}};
        String[][] array2 = {{"1"}, {"2"}, new String[0], null};
        for (int i = 0; i < array1.length; i++) {
            try {
                concatenateArraysWithReplacementElement(array1[i], array2[i], 0);
                fail("when replacing the element at index zero in the array" + Arrays.toString(array1[i])
                        + " on the values " + Arrays.toString(array2[i]) + " should have been thrown InvalidSizeOfArrayException");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }


    @Test
    public void testExchangeAllEqualsBasic() throws InvalidSizeOfArrayException, InvalidObjectException, IOException {
        String[][] array = {{"min","all","avg"},{"min", "avg","all"},{"all", "min", "avg"}};
        String[][] exp ={{"min","min", "max","avg"},{"min", "avg","min", "max"}, {"min", "max","min", "avg" }};
        for (int i = 0; i < array.length; i++) {
            String error = String.format("Error with exchange value [%s] to array %s", array[0][1]
                    , Arrays.toString(array[i]));
            Assert.assertArrayEquals(error,exp[i], exchangeAllEquals(array[i], array[0][1],"min", "max"));
        }

    }

    @Test
    public void testExchangeAllEqualsWithMultipleEquivalents() throws InvalidSizeOfArrayException
            , InvalidObjectException, IOException {
        String[][] array = {{"0","0"},{"0", "1","2","0"},{"1","0","2","0","3","0","4"}};
        String[][] expected = {{"exc", "exc","exc", "exc"},{"exc", "exc", "1","2","exc", "exc"}
                ,{"1","exc", "exc","2","exc", "exc","3","exc", "exc","4"}};
        for (int i = 0; i < array.length ; i++) {
            String error = String.format("Error with exchange value [%s] to array %s","0"
                    , Arrays.toString(array[i]));
            Assert.assertArrayEquals(error,expected[i], exchangeAllEquals(array[i],"0","exc", "exc"));
        }

    }
    @Test
    public void testExchangeAllEqualsWithOneElement() throws InvalidSizeOfArrayException
            , InvalidObjectException, IOException {
        String[] array = {"0"};
        String[] replacement = {"exc", "exc"};
            Assert.assertArrayEquals(replacement, exchangeAllEquals(array,"0",replacement));
        }
    @Test
    public void testExchangeAllEqualsWithNullObject()
            throws InvalidSizeOfArrayException, IOException {
        String[][] replacement = {{null}, {"abc"}, {"abc"}};
        String[][] array = {{"0", "1", "2"}, {"0", null, "2"},{"0", "1", "2"}};
        String []equals = {"0","1",null};
        for (int i = 0; i < replacement.length; i++) {
            try {
                exchangeAllEquals(array[i],equals[i],replacement[i]);
                fail(String.format("exchange value [%s] on value %s to array %s should have been thrown InvalidObjectException"
                        ,equals[i], Arrays.toString(array[i]),Arrays.toString(replacement[i])));
            } catch (InvalidObjectException e) {
            }
        }
    }
    @Test
    public void testExchangeAllEqualsWithInvalidArray() throws InvalidObjectException
            , IOException {
        String[][] replacement = {null, {"abc"},new String[0], {"abc"}};
        String[][] array = {{"0", "1", "2"},  null, {"0", "1", "2"},new String[0],};
        for (int i = 0; i < array.length; i++) {
            try {
                exchangeAllEquals(array[i],"0",replacement[i]);
                fail(String.format("exchange value [0] on value %s to array %s should have been thrown " +
                        "InvalidSizeOfArrayException",Arrays.toString(replacement[i]), Arrays.toString(array[i])));
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }

    }

