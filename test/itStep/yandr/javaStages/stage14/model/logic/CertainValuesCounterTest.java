package itStep.yandr.javaStages.stage14.model.logic;

import org.junit.Assert;
import org.junit.Test;

import static itStep.yandr.javaStages.stage14.levelA.CertainValuesCounter.countEvenNumbers;
import static itStep.yandr.javaStages.stage14.levelA.CertainValuesCounter.countNonZeroElements;

public class CertainValuesCounterTest {
    private final int[][] INVALID_ARRAYS = {null, new int[0]};

    @Test
    public void testCountNonZeroElementsBasic() {
        int[][] arrays = {{0, 1, 2, 3, 4}, {1, 2, 3, 0, 5, 0, -8, 1}, {0, 1, -5, 6, 0, 2, 12, 0}};
        int[] exp = {4, 6, 5};
        for (int i = 0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], countNonZeroElements(arrays[i]));
        }
    }

    @Test
    public void testCountNonZeroElementsWithoutZero() {
        int[][] arrays = {{1, 2, 3, 4}, {1, 2, 3, 5, -8, 1}, {1, -5, 6, 2, 12}};
        for (int i = 0; i < arrays.length; i++) {
            Assert.assertEquals(arrays[i].length, countNonZeroElements(arrays[i]));
        }
    }

    @Test
    public void testCountNonZeroElementsWithAllZero() {
        int[] array = {0, 0, 0, 0};
        Assert.assertEquals(0, countNonZeroElements(array));
    }

    @Test
    public void testCountNonZeroElementsWithOneElement() {
        int[] values = {1, 0};
        for (int i = 0, j = 1; i < values.length; i++, j--) {
            Assert.assertEquals(j, countNonZeroElements(values[i]));
        }
    }

    @Test
    public void testCountNonZeroElementsWithInvalidArrays() {
        for (int[] arr : INVALID_ARRAYS) {
            Assert.assertEquals(-1, countNonZeroElements(arr));
        }
    }

    @Test
    public void testCountEvenNumbersBasic() {
        int[][] arrays = {{0, 1, 2, 3, 4}, {1, 2, 3, 0, 5, 0, -8, 1}, {0, 28, -5, 6, 0, 2, 1, 0}};
        int[] exp = {3, 4, 6};
        for (int i = 0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], countEvenNumbers(arrays[i]));
        }
    }

    @Test
    public void testCountEvenNumbersWithoutEvenNumbers() {
        int[][] arrays = {{1, 7, 3, 9}, {1, 11, 3, 5, -83, 1}, {1, -5, 21, 127}};
        for (int i = 0; i < arrays.length; i++) {
            Assert.assertEquals(0, countEvenNumbers(arrays[i]));
        }
    }

    @Test
    public void testCountEvenNumbersWithAllEven() {
        int[][] arrays = {{6, 8, 56, 4, 14, 0, 6}, {12, 98, -54}, {0, 2, 12, 6}};
        for (int i = 0; i < arrays.length; i++) {
            Assert.assertEquals(arrays[i].length, countEvenNumbers(arrays[i]));
        }
    }

    @Test
    public void testCountEvenNumbersWithOneElement() {
        int[] values = {1, 0};
        for (int i = 0; i < values.length; i++) {
            Assert.assertEquals(i, countEvenNumbers(values[i]));
        }
    }

    @Test
    public void testCountEvenNumbersWithInvalidArrays() {
        for (int[] arr : INVALID_ARRAYS) {
            Assert.assertEquals(-1, countEvenNumbers(arr));
        }
    }

}
