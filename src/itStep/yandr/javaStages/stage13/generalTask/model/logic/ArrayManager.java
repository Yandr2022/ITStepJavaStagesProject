package itStep.yandr.javaStages.stage13.generalTask.model.logic;

import itStep.yandr.javaStages.stage13.generalTask.exception.InvalidSizeOfArray;

public class ArrayManager {

    private static void ValidateArrayForFindAndSwapExtrems(double[] array) throws InvalidSizeOfArray {
        if (array == null || array.length < 2) {
            throw new InvalidSizeOfArray();
        }
    }

    private static void ValidateArrayForFindArithmeticAverage(double[] array) throws InvalidSizeOfArray {
        if (array == null || array.length == 0) {
            throw new InvalidSizeOfArray();
        }
    }

    public static int findMaxValueIndex(double[] array) throws InvalidSizeOfArray {
        ValidateArrayForFindAndSwapExtrems(array);
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }

    public static int findMinValueIndex(double[] array) throws InvalidSizeOfArray {
        ValidateArrayForFindAndSwapExtrems(array);
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return min;
    }

    public static double calculateArithmeticAverage(double[] array) throws InvalidSizeOfArray {
        ValidateArrayForFindArithmeticAverage(array);
        if (array.length == 1) {
            return array[0];
        }
        double sum = 0;
        for (double element : array) {
            sum += element;
        }
        return sum / array.length;
    }

    public static void swapMinMaxElements(double[] array) throws InvalidSizeOfArray {
        ValidateArrayForFindAndSwapExtrems(array);
        int minI = findMinValueIndex(array);
        int maxI = findMaxValueIndex(array);
        double temp = array[maxI];
        array[maxI] = array[minI];
        array[minI] = temp;
    }
}
