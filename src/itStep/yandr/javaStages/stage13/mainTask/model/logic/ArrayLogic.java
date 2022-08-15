package itStep.yandr.javaStages.stage13.mainTask.model.logic;

import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import itStep.yandr.javaStages.stage13.util.DataValidator;

public class ArrayLogic {


    private static boolean checkSequenceOfNumbersForAscending(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    private static boolean checkSequenceOfNumbersForAscending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSequenceOfNumbersForDescending(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    private static boolean checkSequenceOfNumbersForDescending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    private static boolean checkEqualityOfTheArrayElements(double[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[0]!= array[i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean checkDifferenceOfTheArrayElements(double[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i]== array[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean checkEqualityOfTheArrayElements(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[0]!= array[i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean checkDifferenceOfTheArrayElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i]== array[j]) {
                    return false;
                }
            }
        }
        return true;
    }



    public static int checkOrderOfSequenceOfNumbers(double[] array) {
        if (array == null || array.length < 2) {
            return -1;
        }
        int i = 0;
        int result = 0;
        if (array[i] < array[i + 1]) {
            result = checkSequenceOfNumbersForAscending(array) ? 1 : 0;
        } else if (array[i] > array[i + 1]) {
            result = checkSequenceOfNumbersForDescending(array) ? 2 : 0;
        }
        return result;
    }

    public static int checkOrderOfSequenceOfNumbers(int[] array) {
        if (array == null || array.length < 2) {
            return -1;
        }
        int i = 0;
        int result = 0;
        if (array[i] < array[i + 1]) {
            result = checkSequenceOfNumbersForAscending(array) ? 1 : 0;
        } else if (array[i] > array[i + 1]) {
            result = checkSequenceOfNumbersForDescending(array) ? 2 : 0;
        }
        return result;
    }

    public static boolean checkMirroredDispositionOfElements(double[] array) throws InvalidSizeOfArrayException {
        DataValidator.validateArrayIncludingArrayWithOneElement(array);
        for (int i = 0, half = array.length / 2; i < half; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkMirroredDispositionOfElements(int[] array) throws InvalidSizeOfArrayException {
        DataValidator.validateArrayIncludingArrayWithOneElement(array);
        for (int i = 0, half = array.length / 2; i < half; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static int checkEqualityOrDifferenceNumbersOfSequence(double[] array) {
        if (array == null || array.length < 2) {
            return -1;
        }
        int i = 0;
        int result;
        if (array[i] == array[i + 1]) {
            result = checkEqualityOfTheArrayElements(array) ? 1 : 0;
        } else {
            result = checkDifferenceOfTheArrayElements(array) ? 2 : 0;
        }
        return result;
    }
    public static int checkEqualityOrDifferenceNumbersOfSequence(int[] array) {
        if (array == null || array.length < 2) {
            return -1;
        }
        int i = 0;
        int result;
        if (array[i] == array[i + 1]) {
            result = checkEqualityOfTheArrayElements(array) ? 1 : 0;
        } else {
            result = checkDifferenceOfTheArrayElements(array) ? 2 : 0;
        }
        return result;
    }

    public static int countTheNumberOfEvenElements(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int count = 0;
        for (int element : array) {
            if (element % 2 == 0) {
                count += 1;
            }
        }
        return count;
    }

    public static int countTheNumberOfOddElements(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int count = 0;
        for (int element : array) {
            if (element % 2 != 0) {
                count += 1;
            }
        }
        return count;
    }

}
