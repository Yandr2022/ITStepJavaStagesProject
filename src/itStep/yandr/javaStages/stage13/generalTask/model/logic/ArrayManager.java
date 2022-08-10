package itStep.yandr.javaStages.stage13.generalTask.model.logic;
import static itStep.yandr.javaStages.stage13.util.DataValidator.*;

import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;

public class ArrayManager {



    public static int findMaxValueIndex(double[] array) throws InvalidSizeOfArrayException {
        validateArrayIncludingArrayWithOneElement(array);
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }

    public static int findMinValueIndex(double[] array) throws InvalidSizeOfArrayException {
        validateArrayIncludingArrayWithOneElement(array);
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return min;
    }

    public static double calculateArithmeticAverage(double[] array) throws InvalidSizeOfArrayException {
        validateArray(array);
        if (array.length == 1) {
            return array[0];
        }
        double sum = 0;
        for (double element : array) {
            sum += element;
        }
        return sum / array.length;
    }

    public static void swapMinMaxElements(double[] array) throws InvalidSizeOfArrayException {
        validateArrayIncludingArrayWithOneElement(array);
        int minI = findMinValueIndex(array);
        int maxI = findMaxValueIndex(array);
        double temp = array[maxI];
        array[maxI] = array[minI];
        array[minI] = temp;
    }

    public static double calculateSumOfAbsoluteValuesAreLessThanAverage(double[]array) throws InvalidSizeOfArrayException {
        validateArray(array);
        if (array.length == 1) {
            return 0;
        }
        double sum = 0;
        double avg = Math.abs(calculateArithmeticAverage(array));
        for (double element : array) {
            if (Math.abs(element) < avg) {
                sum += element;
            }
        }
        return sum;
    }

    public static double calculateResultMultiplyingPositiveElementsInTheRightPlaces(double[] array) throws InvalidSizeOfArrayException {
        validateArrayIncludingArrayWithOneElement(array);
        double result = 1;
        int count = 0;
        for (int i = 1; i < array.length; i += 2) {
            if (array[i] > 0) {
                result *= array[i];
                count++;
            }
        }
        return count != 0 ? result : result - 1;
    }
}
