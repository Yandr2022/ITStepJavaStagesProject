package itStep.yandr.javaStages.stage13.util;

import itStep.yandr.javaStages.stage13.exception.ArrayContainingIncorrectDataException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;


public class DataValidator {
    public static void validateArrayIncludingArrayWithOneElement(double[] array) throws InvalidSizeOfArrayException {
        if (array == null || array.length < 2) {
            throw new InvalidSizeOfArrayException();
        }
    }

    public static void validateArrayIncludingArrayWithOneElement(int[] array) throws InvalidSizeOfArrayException {
        if (array == null || array.length < 2) {
            throw new InvalidSizeOfArrayException();
        }
    }

    public static void validateArray(double[] array) throws InvalidSizeOfArrayException {
        if (array == null || array.length == 0) {
            throw new InvalidSizeOfArrayException();
        }
    }

    public static void validateArray(int[] array) throws InvalidSizeOfArrayException {
        if (array == null || array.length == 0) {
            throw new InvalidSizeOfArrayException();
        }
    }

    public static void validateArray(Object[] array) throws InvalidSizeOfArrayException {
        if (array == null || array.length == 0) {
            throw new InvalidSizeOfArrayException();
        }
    }
    public static void validateElementsOfArray(Object[] array) throws ArrayContainingIncorrectDataException {
            for (Object element : array) {
                if (element == null) {
                    throw new ArrayContainingIncorrectDataException();
                }
            }
        }
    public static void validateArrayWithObjectTypeElements(Object[]... arrays) throws InvalidSizeOfArrayException
            , ArrayContainingIncorrectDataException {
        for (Object[] array : arrays) {
            DataValidator.validateArray(array);
            DataValidator.validateElementsOfArray(array);
        }
    }
    }

