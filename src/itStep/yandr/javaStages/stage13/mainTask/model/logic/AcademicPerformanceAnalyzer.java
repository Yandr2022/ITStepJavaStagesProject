package itStep.yandr.javaStages.stage13.mainTask.model.logic;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;

import static itStep.yandr.javaStages.stage13.util.DataValidator.validateArray;


public class AcademicPerformanceAnalyzer {
    public static final int[] MARKS = {5, 4, 3, 2, 1, 0};

    private static void validateMarksForComplianceWithTheScoringSystem(int[] marks)
            throws InvalidObjectException {
        for (int mark : marks) {
            if (mark > MARKS[0] || mark < MARKS[MARKS.length - 1]) {
                throw new InvalidObjectException();
            }
        }
    }

    private static int defineTheNumberOfSpecificElements(int[] array, int soughtForNumber) {
        int count = 0;
        for (int element : array) {
            if (element == soughtForNumber) {
                count++;
            }
        }
        return count;
    }

    private static double calculatePercentageOfTotalNumberOfElements(int number, int total) {
        return ((double) number / total) * 100;
    }


    /**
     * @return an array containing the percentage of grades in descending order from 5 to 0
     */
    public static double[] calculatePercentageOfMarks(int[] results) throws InvalidSizeOfArrayException
            , InvalidObjectException {
        validateArray(results);
        validateMarksForComplianceWithTheScoringSystem(results);
        double[] percentage = new double[MARKS.length];
        for (int i = 0; i < percentage.length; i++) {

            percentage[i] = calculatePercentageOfTotalNumberOfElements
                    (defineTheNumberOfSpecificElements(results, MARKS[i]), results.length);
        }
        return percentage;
    }
}
