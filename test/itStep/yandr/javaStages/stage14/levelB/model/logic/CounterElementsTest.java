package itStep.yandr.javaStages.stage14.levelB.model.logic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static itStep.yandr.javaStages.stage14.levelB.model.logic.CounterElements.count;


public class CounterElementsTest implements Constants {
    @Test
    public void testCountElementsBasic() {
        int[][] arrays = {{0, -1, 2, 3, 4}, {1, 2, -3, 0, 5, 3, 0, -8, 1}, {0, 1, 3, -5, 6, 0, -2, 12, 0, 3}};
        int[] numbers = {3, 1, -3};
        int[][][] expected = {{{1, 1, 2}, {3, 3, 4}, {5, 7, 9}}, {{3, 7, 6}, {2, 4, 5}, {0, 1, 1}}
                , {{1, 1, 2}, {0, 2, 1}, {0, 1, 0}}, {{4, 8, 8}, {5, 7, 9}, {5, 8, 10}}, {{2, 4, 7}, {5, 9, 10}, {2, 4, 7}}
                , {{3, 5, 3}, {0, 0, 0}, {3, 5, 3}}, {{1, 2, 3}, {3, 5, 6}, {1, 2, 3}}, {{3, 5, 5}, {1, 2, 3}, {3, 5, 5}}
                , {{1, 2, 2}, {1, 2, 1}, {1, 2, 2}}, {{4, 7, 8}, {4, 7, 9}, {4, 7, 8}}};
        for (int k = 0; k < BEHAVIOR_OBJECTS.length; k++) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < arrays.length; j++) {
                    Assert.assertEquals(String.format("error when counting the number %s of %d, among numbers %s"
                                    , BEHAVIOR_OBJECTS[k], numbers[i], Arrays.toString(arrays[j]))
                            , expected[k][i][j], count(BEHAVIOR_OBJECTS[k], numbers[i], arrays[j]));

                }
            }
        }
    }

    @Test
    public void testCountElementsWithoutCorrespondingElementsExceptNotEquals() {
        int[][] arrays = {{-1, 2, 3, 4}, {1, 2, -3, 5, 3, -8, 1}, {1, 3, -5, 6, -2, 12, 3}};
        int[] numbers = {15, -10, 91, 000, 7, 1, 15, 0, 91};
        for (int i = 0, length = BEHAVIOR_OBJECTS.length - 1; i < length; i++) {
            if (i != 3) {
                for (int j = 0; j < arrays.length; j++) {
                    Assert.assertEquals(String.format("error when counting the number %s of %d, among numbers %s "
                                    , BEHAVIOR_OBJECTS[i], numbers[i], Arrays.toString(arrays[j])),
                            EMPTY_RESULT, count(BEHAVIOR_OBJECTS[i], numbers[i], arrays[j]));
                }
            }
        }
    }

    @Test
    public void testCountElementsWithoutCorrespondingElementsForNotEquals() {
        int[][] arrays = {{1, 1, 1}, {0, 0, 0}, {-5, -5, -5}};
        int[] numbers = {1, 0, -5};
        for (int i = 3; i < BEHAVIOR_OBJECTS.length; i += 6) {
            for (int j = 0; j < arrays.length; j++) {
                Assert.assertEquals(String.format("error when counting the number %s of %d, among numbers %s "
                                , BEHAVIOR_OBJECTS[i], numbers[j], Arrays.toString(arrays[j])),
                        EMPTY_RESULT, count(BEHAVIOR_OBJECTS[i], numbers[j], arrays[j]));
            }
        }
    }

    @Test
    public void testCountElementsWithAllCorrespondingElementsExceptEquals() {
        int[][] arrays = {{2, -3, 4}, {5, -7}, {8, 6, 5, -4, 8}};
        int[] numbers = {-12, 91, 000, 7, 1, 10, 1, -18, 000, -9};
        for (int i = 0; i < BEHAVIOR_OBJECTS.length; i++) {
            if (i != 2 && i != 8) {
                for (int j = 0; j < arrays.length; j++) {
                    Assert.assertEquals(String.format("error when counting the number %s of %d, among numbers %s "
                                    , BEHAVIOR_OBJECTS[i], numbers[i], Arrays.toString(arrays[j]))
                            , arrays[j].length, count(BEHAVIOR_OBJECTS[i], numbers[i], arrays[j]));
                }
            }
        }
    }

    @Test
    public void testCountElementsWithAllCorrespondingElementsForEquals() {
        int[][] arrays = {{1, 1, 1}, {0, 0, 0}, {-5, -5, -5}};
        int[] numbers = {1, 0, -5};
        for (int i = 2; i < 9; i += 6) {
            for (int j = 0; j < arrays.length; j++) {
                Assert.assertEquals(String.format("error when counting the number %s of %d, among numbers %s "
                                , BEHAVIOR_OBJECTS[i], numbers[j], Arrays.toString(arrays[j])),
                        arrays[j].length, count(BEHAVIOR_OBJECTS[i], numbers[j], arrays[j]));
            }
        }
    }

    @Test
    public void testCountElementsWithOneElement() {
        int[] values = {2, 0, -2, 1, -1};
        int[][] expected = {{1, 0, 0, 0, 0}, {0, 1, 1, 0, 1}, {0, 0, 0, 1, 0}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 1}
                , {0, 0, 0, 0, 0}, {1, 0, 1, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {1, 1, 1, 0, 0}};
        for (int i = 0; i < BEHAVIOR_OBJECTS.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Assert.assertEquals(String.format("error when counting the number %s of %d, among numbers %d "
                        , BEHAVIOR_OBJECTS[i], 1, values[j]), expected[i][j], count(BEHAVIOR_OBJECTS[i], 1, values[j]));
            }
        }
    }

    @Test
    public void testCountElementsWithInvalidArrays() {
        for (int i = 0; i < BEHAVIOR_OBJECTS.length; i++) {
            for (int j = 0; j < INVALID_ARRAYS.length; j++) {
                Assert.assertEquals(INVALID_RESULT, count(BEHAVIOR_OBJECTS[i], 1, INVALID_ARRAYS[j]));
            }
        }
    }

    @Test
    public void testCountMultipleElementsWithInvalidData() {
        for (int i = 4; i < 6; i++) {
            Assert.assertEquals(INVALID_RESULT, count(BEHAVIOR_OBJECTS[i], 0, 1, 2, 3));
        }
    }
}







