package itStep.yandr.javaStages.stage14.levelB.model.logic;

import org.junit.Assert;
import org.junit.Test;

import static itStep.yandr.javaStages.stage14.levelB.model.logic.CounterElements.count;


public class CounterElementsTest implements Constants{
    @Test
    public void testCountElementsBasic() {
        int[][] arrays = {{0, -1, 2, 3, 4}, {1, 2, -3, 0, 5 , 3, 0, -8, 1}, {0, 1, 3, -5, 6, 0, -2, 12, 0, 3}};
        int [] numbers = {3 , 0, -3};
        int[][][] expected =
                {{{1, 1, 2}, {3, 7, 6}, {1, 1, 2}, {4, 8, 8}, {1, 2, 4}, {4, 7, 6},{1,2,3},{3,5,5},{}}};
        for (int i = 0; i < BEHAVIOR_OBJECTS.length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                for (int k = 0; k < arrays.length ; k++) {
                    Assert.assertEquals(expected[i][j][k], count(BEHAVIOR_OBJECTS[i], numbers[j], arrays[k]));
                }
            }
        }
    }

}
