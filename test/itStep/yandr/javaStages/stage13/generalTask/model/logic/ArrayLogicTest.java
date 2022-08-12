package itStep.yandr.javaStages.stage13.generalTask.model.logic;

import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.generalTask.model.logic.ArrayLogic.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ArrayLogicTest {
    private final double[][] INVALID_ARRAYS = {null, new double[0], {2.6}};

    @Test
    public void testFindMaxValueIndexWithAllDifferentElements() throws InvalidSizeOfArrayException {
        double arrays[][] = {{6.2, 4.0, 0, 5.5, 8.7}, {5.3, -1, 2, 5.29}, {1.8, 5.0, 3.2, 7, -2.7, 6.5}, {0.1, 2}
        ,{-1.9, -6, -2.7, -5.0, -8},{-5.7, -2.0, -3.2, 0.4}, {-5.5, -3.8, -1.2, -7, -2.6, -6.8}
                , {-4, -2.8}};
        int expected[] = {4, 0, 3, 1, 0, 3, 2, 1};
        int index = 0;
        for (double array[] : arrays) {
            String error = "Error with value" + Arrays.toString(array);
            Assert.assertEquals(error, expected[index], findMaxValueIndex(array));
            index++;
        }
    }

    @Test
    public void testFindMaxValueIndexWithTwoSameElements() throws InvalidSizeOfArrayException {
        double arrays[][] = {{6.2, 8.7, 4.0, 0, 5.5, 8.7}, {5.3, -1, 2, 5.29, 5.3}, {1.8, 5.0, 7, 3.2, 7, -2.7, 6.5}
                , {2, 0.1, 2},{ -6, -2.7, -1.9, -5.0, -8,-1.9},{-5.7, 0.4, -2.0, -3.2, 0.4}
                , {-5.5, -3.8, -8, -1.2,-1.2, -2.6, -6.8}, {-4, -2.8, -4}};
        int expected[] = {1, 0, 2, 0, 2, 1, 3, 1};
        int index = 0;
        for (double array[] : arrays) {
            String error = "Error with value" + Arrays.toString(array);
            Assert.assertEquals(error, expected[index], findMaxValueIndex(array));
            index++;
        }
    }
    @Test
    public void testFindMaxValueIndexWithAllTheSameElements() throws InvalidSizeOfArrayException {
        double[] array = {1, 1, 1, 1, 1,};
        double expected = 0;
        Assert.assertEquals( expected, findMaxValueIndex(array), 0.000001);
    }

    @Test
    public void testFindMaxValueIndexWithOneDifferentElements() throws InvalidSizeOfArrayException {
        double[] []arrays = {{0, -1.4, -1.4, -1.4, -1.4,},{1.4, 1.4, 0, 1.4, 1.4,}};
        double expected = 0;
        for (double array[] : arrays) {
            String error = "Error with values:\n" + Arrays.toString(array) ;
            Assert.assertEquals(error, expected, findMaxValueIndex(array), 0.000001);
        }
    }

    @Test
    public void testFindMaxValueIndexWithInvalidSizeOfArray() {
        for (double[] array : INVALID_ARRAYS) {
            try {
                findMaxValueIndex(array);
                fail("The array with " + Arrays.toString(array) + " should have been thrown " +
                        "InvalidSizeOfArrayException ");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }

    @Test
    public void testFindMinValueIndexWithAllDifferentElements() throws InvalidSizeOfArrayException {
        double arrays[][] = {{6.7, 4.3, 5, 6.6, 0}, {1.999, 5.0, 2, 3.6}, {8.33, 5.89, 3.5, 2, 28.1, 6}, {2.9, 1}
                ,{-7.999, -6.5, -2, -5.005, -8}, {-5.8, -2.9, -3.76, 0}, {-5.0, -3.76, -1.5, -7.54, -2.3, -6.0}
                , {-4.98, -2.75}};
        int expected[] = {4, 0, 3, 1, 4, 0, 3, 0};
        int index = 0;
        for (double array[] : arrays) {
            String error = "Error with value" + Arrays.toString(array);
            Assert.assertEquals(error, expected[index], findMinValueIndex(array));
            index++;
        }
    }

    @Test
    public void testFindMinValueIndexWithTwoSameElements() throws InvalidSizeOfArrayException {
        double arrays[][] = {{6.7, 0, 4.3, 5, 6.6, 0}, {1.999, 5.0, 1.999, 2, 3.6}, {8.33, 5.89, 8.33, 3.5, 2, 28.1, 6}
                , {2.9, 2.9},{-7.999, -6.5, -2, -5.005, -8, -5.005,}, {-5.8, -2.9, -5.8, -3.76, 0}
                , {-5.0,-1.5, -3.76, -1.5, -7.54, -2.3, -6.0}, { -2.75, -4.98, -2.75}};
        int expected[] = {1, 0, 4, 0, 4, 0, 4, 1};
        int index = 0;
        for (double array[] : arrays) {
            String error = "Error with value" + Arrays.toString(array);
            Assert.assertEquals(error, expected[index], findMinValueIndex(array));
            index++;
        }
    }

    @Test
    public void testFindMinValueIndexWithAllTheSameElements() throws InvalidSizeOfArrayException {
        double[] array = {1, 1, 1, 1, 1};
        double expected = 0;
        Assert.assertEquals( expected, findMinValueIndex(array), 0.000001);
    }

    @Test
    public void testFindMinValueIndexWithOneDifferentElements() throws InvalidSizeOfArrayException {
        double[] []arrays = {{0, -1.4, -1.4, -1.4, -1.4,},{1.4, 1.4, 0, 1.4, 1.4,}};
        double[] expected = {1,2};
        int index = 0;
        for (double array[] : arrays) {
            String error = "Error with values:\n" + Arrays.toString(array) ;
            Assert.assertEquals(error, expected[index], findMinValueIndex(array), 0.000001);
            index++;
        }
    }

    @Test
    public void testFindMinValueIndexWithInvalidSizeOfArray() {
        for (double[] array : INVALID_ARRAYS) {
            try {
                findMinValueIndex(array);
                fail("The array with " + Arrays.toString(array) + " should have been thrown " +
                        "InvalidSizeOfArrayException ");
            } catch (InvalidSizeOfArrayException e) {
            }
        }

    }

    @Test
    public void testFindArithmeticAverageWithPositiveElements() throws InvalidSizeOfArrayException {
        double arrays[][] = {{6.7, 4.3, 4.3, 5, 6.6, 0}, {1.999, 5.0, 2, 3.6}, {3.5, 8.33, 5.89, 3.5, 2, 28.1,3.5, 6}
                , {2.9, 1}};
        double expected[] = {4.483, 3.14975, 7.6025, 1.95};
        int index = 0;
        for (double array[] : arrays) {
            String error = "Error with value" + Arrays.toString(array);
            Assert.assertEquals(error, expected[index], calculateArithmeticAverage(array), 0.001);
            index++;
        }
    }

    @Test
    public void testFindArithmeticAverageWithNegativeElements() throws InvalidSizeOfArrayException {
        double arrays[][] = {{-6.78, -8.35, 0 , -5.678, -6.6999, 0}, {-1.999, -8.0, -2.75, -3.6}
                , {-3.5,-5.89, -3.5, -28.1, -3.234, -28.1}, {-4.2, -0.25}};
        double expected[] = {-4.585, -4.08725, -12.054, -2.225};
        int index = 0;
        for (double array[] : arrays) {
            String error = "Error with value" + Arrays.toString(array);
            Assert.assertEquals(error, expected[index], calculateArithmeticAverage(array), 0.001);
            index++;
        }
    }

    @Test
    public void testFindArithmeticAverageWithMixedElements() throws InvalidSizeOfArrayException {
        double arrays[][] = {{ 0, -6.78, 8.35, 5.678, -6.6999, 0}, {1.999, -8.0, -2.75, 3.6}
                , {-5.89, 3.5, -3.234}, {4.2, 4.2, -0.25, -0.25}};
        double expected[] = {0.09135, -1.28775, -1.87466666666, 1.975};
        int index = 0;
        for (double array[] : arrays) {
            String error = "Error with value" + Arrays.toString(array);
            Assert.assertEquals(error, expected[index], calculateArithmeticAverage(array), 0.001);
            index++;
        }
    }

    @Test
    public void testFindArithmeticAverageWithAllTheSameElements() throws InvalidSizeOfArrayException {
        double arrays[][] = {{ 0, 0,  0, 0, 0}, { 1.2, 1.2, 1.2, 1.2}
                , {-5.89, -5.89, -5.89}};
        double expected[] = { 0, 1.2, -5.89};
        int index = 0;
        for (double array[] : arrays) {
            String error = "Error with value" + Arrays.toString(array);
            Assert.assertEquals(error, expected[index], calculateArithmeticAverage(array), 0.001);
            index++;
        }
    }

    @Test
    public void testArithmeticAverageWithInvalidSizeOfArray() {
        for (int i = 0; i < INVALID_ARRAYS.length - 1; i++) {
            try {
                calculateArithmeticAverage(INVALID_ARRAYS[i]);
                fail("The array with " + Arrays.toString(INVALID_ARRAYS[i]) + " should have been thrown " +
                        "InvalidSizeOfArrayException ");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }

    @Test
    public void testArithmeticAverageWithOneElements() throws InvalidSizeOfArrayException {
                double expected = 1.666;
                assertEquals(expected, calculateArithmeticAverage(new double[]{expected}),0.0001);
        }

    @Test
    public void testSwapMinMaxWithAllDifferentElements() throws InvalidSizeOfArrayException {
        double[][] arrays = {{-1.4, -0.5, -5.0, -3.8, -2.76}, {-6.89, 5.788, 0, 3.12, -7.68}
                , {1.2, 4.6, 8.5, 3.0, 12.6, 6.6},{1, 2.5}};
        double[][] expected = {{-1.4, -5.0, -0.5, -3.8, -2.76}, {-6.89, -7.68, 0, 3.12, 5.788}
                , {12.6, 4.6, 8.5, 3.0, 1.2, 6.6},{2.5, 1}};
        int index = 0;
        for (double array[] : arrays) {
            swapMinMaxElements(array);
            String error = "Error with values:\n" + Arrays.toString(array) + "\n" + Arrays.toString(expected[index]);
            Assert.assertArrayEquals(error, expected[index], array, 0.000001);
            index++;
        }
    }

    @Test
    public void testSwapMinMaxWithTwoSameElements() throws InvalidSizeOfArrayException {
        double[][] arrays = {{-0.5, -1.4, -0.5, -5.0, -3.8, -2.76}, {-6.89, 5.788, 0, 5.788, 3.12, -7.68}
                , {1.2, 4.6, 8.5, 3.0, 12.6, 8.5, 6.6}};
        double[][] expected = {{-5.0, -1.4, -0.5, -0.5, -3.8, -2.76}, {-6.89, -7.68, 0, 5.788, 3.12, 5.788}
                , {12.6, 4.6, 8.5, 3.0, 1.2, 8.5, 6.6}};
        int index = 0;
        for (double array[] : arrays) {
            swapMinMaxElements(array);
            String error = "Error with values:\n" + Arrays.toString(array) + "\n" + Arrays.toString(expected[index]);
            Assert.assertArrayEquals(error, expected[index], array, 0.000001);
            index++;
        }
    }

    @Test
    public void testSwapMinMaxWithAllTheSameElements() throws InvalidSizeOfArrayException {
        double[] array = {-1.4, -1.4, -1.4, -1.4, -1.4,};
        double[] expected = {-1.4, -1.4, -1.4, -1.4, -1.4,};
        swapMinMaxElements(array);
        String error = "Error with values:\n" + Arrays.toString(array) + "\n" + Arrays.toString(expected);
        Assert.assertArrayEquals(error, expected, array, 0.000001);
    }

    @Test
    public void testSwapMinMaxWithOneDifferentElements() throws InvalidSizeOfArrayException {
        double[] array = {-1.4, -1.4, 0, -1.4, -1.4,};
        double[] expected = {0, -1.4, -1.4, -1.4, -1.4,};
        swapMinMaxElements(array);
        String error = "Error with values:\n" + Arrays.toString(array) + "\n" + Arrays.toString(expected);
        Assert.assertArrayEquals(error, expected, array, 0.000001);
    }

    @Test
    public void testSwapMinMaxWithInvalidSizeOfArray() {
        for (double[] array : INVALID_ARRAYS) {
            try {
                swapMinMaxElements(array);
                fail("The array with " + Arrays.toString(array) + " should have been thrown " +
                        "InvalidSizeOfArrayException ");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }

    @Test
    public void testCalculateSumOfAbsoluteValuesAreLessThanAverage() throws InvalidSizeOfArrayException {
        double[][] arrays = {{-0.5, -1.4, -0.5, -5.0, -3.8, -2.76}, {-6.89, 5.788, -0.005, 0.005, 5.788, 3.1, -7.68}
                , {1.2, 4.6, 8.5, 3.0, 12.6, 8.5, 6.6}};
        double[] expected = {-2.4, 0, 8.8};
        int i = 0;
        for (double[] array : arrays) {
            Assert.assertEquals(expected[i], calculateSumOfAbsoluteValuesAreLessThanAverage(array), 0.0001);
            i++;
        }
    }

    @Test
    public void testCalculateSumOfAbsoluteValuesAreLessThanAverageWithOneElements() throws InvalidSizeOfArrayException {
        double expected = 0;
        assertEquals(expected, calculateSumOfAbsoluteValuesAreLessThanAverage(new double[]{3}), 0.0001);
    }

    @Test
    public void testCalculateSumOfAbsoluteValuesAreLessThanAverageWithAllTheSameElements() throws InvalidSizeOfArrayException {
        double arrays[][] = {{ 0, 0,  0, 0, 0}, { 1.2, 1.2, 1.2, 1.2}
                , {-5.89, -5.89, -5.89}};
        double expected[] = { 0, 0, 0};
        int index = 0;
        for (double array[] : arrays) {
            String error = "Error with value" + Arrays.toString(array);
            Assert.assertEquals(error, expected[index], calculateSumOfAbsoluteValuesAreLessThanAverage(array), 0.001);
            index++;
        }
    }

    @Test
    public void testCalculateSumOfAbsoluteValuesAreLessThanAverageWithInvalidSizeOfArray() {
        for (int i = 0; i < INVALID_ARRAYS.length - 1; i++) {
            try {
                calculateSumOfAbsoluteValuesAreLessThanAverage(INVALID_ARRAYS[i]);
                fail("The array with " + Arrays.toString(INVALID_ARRAYS[i]) + " should have been thrown " +
                        "InvalidSizeOfArrayException ");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }

    @Test
    public void testCalculateResultMultiplyingPositiveElementsInTheRightPlacesWithCountEvenElements() throws InvalidSizeOfArrayException {
        double[][] arrays = {{-0.5, 2.3, 6.0, 5, -4.0, -2.76}, {7, 6.75, -5, -34, 5.7, 3.2, -7.68, 2}
                , {1.2, -4.6, 8.5, 20},{12.6, 8}, {3.0, 2.25, 6.0, -58, 47, 9, -2, -4, 12, 42}};
        double expected[] = {11.5, 43.2, 20, 8, 850.5};
        int index = 0;
        for (double array[] : arrays) {
            String error = "Error with value" + Arrays.toString(array);
            Assert.assertEquals(error, expected[index], calculateResultMultiplyingPositiveElementsInTheRightPlaces(array), 0.001);
            index++;
        }
    }
    @Test
    public void testCalculateResultMultiplyingPositiveElementsInTheRightPlacesWithCountOddElements() throws InvalidSizeOfArrayException {
        double[][] arrays = {{-0.5, 2.3, 6.0, 5, -4.0, -2.76, 4}, {7, 6.75, -5, -34, 5.7, 3.2, -7.68, 2, 6}
                , {1.2, -4.6, 8.5, 20, 3.5},{12.6, 8, 5.9}, {3.0, 2.25, 6.0, -58, 47, 9, -2, -4, 12, 42, 1.45}};
        double expected[] = {11.5, 43.2, 20, 8, 850.5};
        int index = 0;
        for (double array[] : arrays) {
            String error = "Error with value" + Arrays.toString(array);
            Assert.assertEquals(error, expected[index], calculateResultMultiplyingPositiveElementsInTheRightPlaces(array), 0.0001);
            index++;
        }
    }
    @Test
    public void testCalculateResultMultiplyingPositiveElementsInTheRightPlacesWithoutCorrespondingElements()
            throws InvalidSizeOfArrayException {
        double[][] arrays = {{-0.5, 0, 6.0, -5, 4.0, -2.76, 4}, { 6.75, -5, -34, -4.6, 3.2, -7.68, 2, 0}
                , {1.2, -4.6, 8.5, -2.0, 3.5},{12.6,0, 5.9}, {3.0, -2.25, 6.0, -58, 47, -9, -2, -4, 12, -42},{ 2, 0}};
        double expected = 0;
        for (double array[] : arrays) {
            String error = "Error with value" + Arrays.toString(array);
            Assert.assertEquals(error, expected, calculateResultMultiplyingPositiveElementsInTheRightPlaces(array), 0.0001);
        }
    }

    @Test
    public void testCalculateResultMultiplyingPositiveElementsInTheRightPlacesWithInvalidSizeOfArray() {
        for (double[] array : INVALID_ARRAYS) {
            try {
                calculateResultMultiplyingPositiveElementsInTheRightPlaces(array);
                fail("The array with " + Arrays.toString(array) + " should have been thrown " +
                        "InvalidSizeOfArrayException ");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }



}













