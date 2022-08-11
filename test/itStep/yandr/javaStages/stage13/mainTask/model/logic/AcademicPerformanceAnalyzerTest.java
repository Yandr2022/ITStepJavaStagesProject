package itStep.yandr.javaStages.stage13.mainTask.model.logic;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.fail;


public class AcademicPerformanceAnalyzerTest {

    @Test
    public void testCalculatePercentageOfMarksBasic() throws InvalidSizeOfArrayException
            , InvalidObjectException {
        int[][] results = {{5, 5, 1, 4, 3, 2, 1, 0, 3, 5, 3, 3}, {5, 5, 4, 3, 2, 1, 3, 5, 3, 3}};
        double[][] expected = {{25, 8.33, 33.33, 8.33, 16.66, 8.33}, {30, 10, 40, 10, 10, 0}};
        double[][] actual = {AcademicPerformanceAnalyzer.calculatePercentageOfMarks(results[0]), AcademicPerformanceAnalyzer.calculatePercentageOfMarks(results[1])};
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                Assert.assertEquals(expected[i][j], actual[i][j], 0.01);
            }
        }
    }

    @Test
    public void testCalculatePercentageOfMarksWithAllTheSameElements() throws InvalidSizeOfArrayException
            , InvalidObjectException {
        int[][] results = {{5, 5, 5, 5, 5}, {3, 3, 3, 3, 3}};
        double[][] expected = {{100, 0, 0, 0, 0, 0}, {0, 0, 100, 0, 0, 0}};
        double[][] actual = {AcademicPerformanceAnalyzer.calculatePercentageOfMarks(results[0])
                , AcademicPerformanceAnalyzer.calculatePercentageOfMarks(results[1])};
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                Assert.assertEquals(expected[i][j], actual[i][j], 0.01);
            }
        }
    }

    @Test
    public void testCalculatePercentageOfMarksWithOneElement() throws InvalidSizeOfArrayException
            , InvalidObjectException {
        int[][] results = {{5}, {3}};
        double[][] expected = {{100, 0, 0, 0, 0, 0}, {0, 0, 100, 0, 0, 0}};
        double[][] actual = {AcademicPerformanceAnalyzer.calculatePercentageOfMarks(results[0])
                , AcademicPerformanceAnalyzer.calculatePercentageOfMarks(results[1])};
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                Assert.assertEquals(expected[i][j], actual[i][j], 0.01);
            }
        }
    }

    @Test
    public void testCalculatePercentageOfMarksWithWrongArray() throws InvalidObjectException {
        int[][] results = {null, new int[0]};
        for (int result[] : results) {
            try {
                AcademicPerformanceAnalyzer.calculatePercentageOfMarks(result);
                fail("The array with " + Arrays.toString(result) + "should have been thrown " +
                        "InvalidSizeOfArrayException \n");
            } catch (InvalidSizeOfArrayException e) {
            }
        }

    }

    @Test
    public void testCalculatePercentageOfMarksWithWrongElementsOfArray() throws InvalidSizeOfArrayException {
        int[][] results = {{4, 5, 7, 3, 0}, {1, 2, -6, 4, 3}};
        for (int result[] : results) {
            try {
                AcademicPerformanceAnalyzer.calculatePercentageOfMarks(result);
                fail("The array with " + Arrays.toString(result) + "should have been thrown " +
                        "ArrayContainingIncorrectDataException \n");
            } catch (InvalidObjectException e) {
            }
        }

    }

}
