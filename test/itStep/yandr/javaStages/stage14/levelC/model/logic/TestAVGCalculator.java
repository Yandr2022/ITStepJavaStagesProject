package itStep.yandr.javaStages.stage14.levelC.model.logic;

import org.junit.Assert;
import org.junit.Test;

public class TestAVGCalculator {


    @Test
    public void testCalculateGeometricAvgBasic() {
        int[][] array = {{85, 3, 90, 45, 67}, {100, 54, 82, 65, 267, 315, 95}, {1024, 350, 58, 986, 20356, 205, 23}};
        double[] exp = {36.98, 112.63, 410.59};
        for (int i = 0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], AVGCalculator.calculateGeometricAvg(array[i]), 0.01);
        }
    }

    @Test
    public void testCalculateGeometricAvgWithTwoElement() {
        int[][] array = {{85, 3}, {82, 65}, {1024, 20356}};
        double[] exp = {15.97, 73.01, 4565.58};
        for (int i = 0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], AVGCalculator.calculateGeometricAvg(array[i]), 0.01);
        }
    }

    @Test
    public void testCalculateGeometricAvgWithInvalidData() {
        int[][] array = {null, new int[0], {1}, {1, 2, 0}};
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(-1, AVGCalculator.calculateGeometricAvg(array[i]), 0.01);
        }
    }
    @Test
    public void testCalculateArithmeticAvgBasic() {
        int[][] array = {{832, 3, -90, 0, 67}, {100, 54, 82, 65, -7, 259, 95}, {1024, 350, 58, 986, 20356, 205, 23}};
        double[] exp = {162.4, 92.57, 3286};
        for (int i = 0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], AVGCalculator.calculateArithmeticAvg(array[i]), 0.01);
        }
    }

    @Test
    public void testCalculateArithmeticAvgWithTwoElements() {
        int[][] array = {{85, 3}, {82, 65}, {1024, 20356}};
        double[] exp = {44, 73.5, 10690};
        for (int i = 0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], AVGCalculator.calculateArithmeticAvg(array[i]), 0.01);
        }
    }

    @Test
    public void testCalculateArithmeticAvgWithInvalidData() {
        int[][] array = {null, new int[0], {1}};
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(-1, AVGCalculator.calculateArithmeticAvg(array[i]), 0.01);
        }
    }
}
