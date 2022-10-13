package itStep.yandr.javaStages.stage14.util;

import itStep.yandr.javaStages.stage14.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage14.exception.InvalidSizeOfArrayException;


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
    public static void validateObject(Object... array) throws InvalidObjectException {
            for (Object element : array) {
                if (element == null) {
                    throw new InvalidObjectException();
                }
            }
        }
    public static void validateArrayWithObjectTypeElements(Object[]... arrays) throws InvalidSizeOfArrayException
            , InvalidObjectException {
        for (Object[] array : arrays) {
            DataValidator.validateArray(array);
            DataValidator.validateObject(array);
        }
    }
    public static void checkEquivalenceOfArraySizes(Object[] array,double[][]array2) throws InvalidSizeOfArrayException {
            if (array.length != array2.length) {
                throw new InvalidSizeOfArrayException();
            }
    }
    public static void checkEquivalenceOfArraySizes(Object[] array,double[]array2) throws InvalidSizeOfArrayException {
            if (array.length != array2.length) {
                throw new InvalidSizeOfArrayException();
            }
    }
    public static void checkEquivalenceOfArraySizes(String[] array,int []array2) throws InvalidSizeOfArrayException {
            if (array.length != array2.length) {
                throw new InvalidSizeOfArrayException();
            }
    }
    public static void checkEquivalenceOfArraySizes(Object[] array,Object[] array2) throws InvalidSizeOfArrayException {
            if (array.length != array2.length) {
                throw new InvalidSizeOfArrayException();
            }
    }

    }

