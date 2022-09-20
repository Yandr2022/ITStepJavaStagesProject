package itStep.yandr.javaStages.stage14.levelA.model.logic;

import itStep.yandr.javaStages.stage14.levelA.model.logic.strategy.*;
import itStep.yandr.javaStages.stage14.levelA.model.logic.decorator.Inverter;
import org.junit.Assert;
import org.junit.Test;

import static itStep.yandr.javaStages.stage14.levelA.model.logic.CounterElements.count;

public class CounterElementsTest {
    private final int[][] INVALID_ARRAYS = {null, new int[0]};
    private final int INVALID_RESULT = -1;
    private final int EMPTY_RESULT = 0;

    private final ElementCountable EQUALS_ZERO = new CountNumbersEqualsZero();
    private final ElementCountable NON_ZERO =new Inverter( new CountNumbersEqualsZero());
    private final ElementCountable EVEN_NUM = new CountEvenNumbers();
    private final ElementCountable ODD_NUM =new Inverter(new CountEvenNumbers()) ;
    private final ElementCountable POSITIVE_NUM = new CountPositiveNumbers();
    private final ElementCountable NEGATIVE_NUM = new CountNegativeNumbers();
    private final ElementCountable[] BEHAVIOR_OBJECTS = {EQUALS_ZERO,NON_ZERO,EVEN_NUM,ODD_NUM,POSITIVE_NUM,NEGATIVE_NUM};

    @Test
    public void testCountElementsBasic() {
        int[][] arrays = {{0, -1, 2, 3, 4}, {1, 2, -3, 0, 5, 0, -8, 1}, {0, 1, -5, -6, 0, -2, 12, 0}};
        int[][] expected = {{1, 2, 3}, {4, 6, 5}, {3, 4, 6}, {2, 4, 2}, {3, 4, 2}, {1, 2, 3}};
        for (int i = 0; i < BEHAVIOR_OBJECTS.length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                Assert.assertEquals(expected[i][j], count(BEHAVIOR_OBJECTS[i], arrays[j]));
            }

        }
    }

    @Test
    public void testCountElementsWithoutCorrespondingElements() {
        int[][][] arrays = {{{1, 2, 3, 4}, {1, 2, -3, 5, -8, 1}, {1, -5, 6, 2, 12}},{{0, 0, 0}, {0, 0}, {0, 0, 0, 0, 0}}
                ,{{23, -11, 67}, {-43, 21}, {89,-23, 105, -15, 47}},{{26, -14, 68}, {-42, 38}, {90,-22, 12, -18, 50}}
                ,{{-23, 0, -67}, {-43, -21}, {0,-23, -105, 0, -47}},{{23, 0, 67}, {43, 21}, {89,0, 105, 0, 47}}};
        for (int i = 0; i < BEHAVIOR_OBJECTS.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                Assert.assertEquals(EMPTY_RESULT, count(BEHAVIOR_OBJECTS[i], arrays[i][j]));
            }
        }
    }

    @Test
    public void testCountElementsWithAllCorrespondingElements() {
        int[][][] arrays = {{{0, 0, 0}, {0, 0}, {0, 0, 0, 0, 0}}, {{1, 2, 3, 4}, {1, 2, -3, 5, -8, 1}, {1, -5, 6, 2, 12}}
                , {{0, -14, 68}, {-42, 38}, {90, -22, 12, 0, 50}}, {{-23, 103, -67}, {43, 21}, {11, 23, 105, 17, -47}}
                , {{23, 10, 67}, {43, 28}, {89, 40, 105, 16, 47}},{{-23, -11, -67}, {-43, -21}, {-86, -23, -105, -15, -70}} };
        for (int i = 0; i < BEHAVIOR_OBJECTS.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                Assert.assertEquals(arrays[i][j].length, count(BEHAVIOR_OBJECTS[i], arrays[i][j]));
            }
        }
    }

    @Test
    public void testCountElementsWithOneElement() {
        int[] values = { 1, 0, -1};
        int[][]expected = {{0,1,0},{1,0,1},{0,1,0},{1,0,1},{1,0,0},{0,0,1}};
        for (int i = 0; i < BEHAVIOR_OBJECTS.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Assert.assertEquals(expected[i][j], count(BEHAVIOR_OBJECTS[i], values[j]));
            }
        }
    }

    @Test
    public void testCountNonZeroElementsWithInvalidArrays() {
        for (int i = 0; i < BEHAVIOR_OBJECTS.length; i++) {
            for (int j = 0; j < INVALID_ARRAYS.length; j++) {
                Assert.assertEquals(INVALID_RESULT, count(BEHAVIOR_OBJECTS[i], INVALID_ARRAYS[j]));
            }
        }
    }



}
