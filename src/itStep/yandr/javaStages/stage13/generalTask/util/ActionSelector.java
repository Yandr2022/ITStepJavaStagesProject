package itStep.yandr.javaStages.stage13.generalTask.util;

import itStep.yandr.javaStages.stage13.generalTask.exception.InvalidSizeOfArray;

import java.io.IOException;
import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.generalTask.model.logic.ArrayManager.*;

public class ActionSelector {
    public static final String NAME_DEFINE_MIN_VALUE = "min";
    public static final String NAME_DEFINE_MAX_VALUE = "max";
    public static final String NAME_CALCULATE_AVERAGE = "avg";
    public static final String NAME_SWAP_EXTREME_VALUES = "swap";
    public static final String NAME_SUM_MODULES_ARE_LESS_THAN_AVERAGE = "sum";
    public static final String NAME_MULTIPLYING_POSITIVE_NUMBERS_TO_RIGHT_PLACES = "mpl";
    public static final String NAME_SELECT_ALL_ACTION = "all";
    public static final String DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE
            = "Minimum value in the entered sequence of numbers ";
    public static final String DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE
            = "Maximum value in the entered sequence of numbers ";
    public static final String DESCRIPTION_OF_METHOD_TO_CALCULATE_AVERAGE
            = "Arithmetic mean of the entered sequence of numbers ";
    public static final String DESCRIPTION_OF_METHOD_TO_SWAP_EXTREME_VALUES
            = "Result of exchanging extreme values of the entered sequence of numbers ";
    public static final String DESCRIPTION_OF_METHOD_TO_CALCULATE_SUM_OF_NUMBERS_MODULES_ARE_LESS_THAN_AVERAGE
            = "Sum of numbers whose absolute value is less than the arithmetic mean of the entered sequence of numbers ";
    public static final String DESCRIPTION_OF_METHOD_TO_CALCULATE_PRODUCT_OF_POSITIVE_NUMBERS_TO_EVEN_PLACES
            = "Product of positive numbers located at even places of the entered sequence of numbers ";

    public static String selectActions(double[] array, String... commands) throws InvalidSizeOfArray, IOException {
        if (array == null || array.length == 0) {
            throw new InvalidSizeOfArray();
        }
        if (commands == null || commands.length == 0) {
            throw new InvalidSizeOfArray();
        }
        double[] arrayCopy = array.clone();
        StringBuilder result = new StringBuilder();
        for (String command : commands) {
            if (command == null) {
                throw new IOException();
            }
            command = command.toLowerCase();
            switch (command) {
                case (NAME_DEFINE_MIN_VALUE):
                    result.append(DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE).append(array[findMinValueIndex(array)] + "\n");
                    break;
                case (NAME_DEFINE_MAX_VALUE):
                    result.append(DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE).append(array[findMaxValueIndex(array)] + "\n");
                    break;
                case (NAME_CALCULATE_AVERAGE):
                    result.append(DESCRIPTION_OF_METHOD_TO_CALCULATE_AVERAGE).append(calculateArithmeticAverage(array) + "\n");
                    break;
                case (NAME_SWAP_EXTREME_VALUES):
                    swapMinMaxElements(arrayCopy);
                    result.append(DESCRIPTION_OF_METHOD_TO_SWAP_EXTREME_VALUES).append(Arrays.toString(arrayCopy) + "\n");
                    break;
                case (NAME_SUM_MODULES_ARE_LESS_THAN_AVERAGE):
                    result.append(DESCRIPTION_OF_METHOD_TO_CALCULATE_SUM_OF_NUMBERS_MODULES_ARE_LESS_THAN_AVERAGE)
                            .append(calculateSumOfAbsoluteValuesAreLessThanAverage(array) + "\n");
                    break;
                case (NAME_MULTIPLYING_POSITIVE_NUMBERS_TO_RIGHT_PLACES):
                    result.append(DESCRIPTION_OF_METHOD_TO_CALCULATE_PRODUCT_OF_POSITIVE_NUMBERS_TO_EVEN_PLACES)
                            .append(calculateResultMultiplyingPositiveElementsInTheRightPlaces(array) + "\n");
                    break;
                case (NAME_SELECT_ALL_ACTION):
                    result.append(DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE).append(array[findMinValueIndex(array)] + "\n");
                    result.append(DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE).append(array[findMaxValueIndex(array)] + "\n");
                    result.append(DESCRIPTION_OF_METHOD_TO_CALCULATE_AVERAGE).append(calculateArithmeticAverage(array) + "\n");
                    swapMinMaxElements(arrayCopy);
                    result.append(DESCRIPTION_OF_METHOD_TO_SWAP_EXTREME_VALUES).append(Arrays.toString(arrayCopy) + "\n");
                    result.append(DESCRIPTION_OF_METHOD_TO_CALCULATE_SUM_OF_NUMBERS_MODULES_ARE_LESS_THAN_AVERAGE)
                            .append(calculateSumOfAbsoluteValuesAreLessThanAverage(array) + "\n");
                    result.append(DESCRIPTION_OF_METHOD_TO_CALCULATE_PRODUCT_OF_POSITIVE_NUMBERS_TO_EVEN_PLACES)
                            .append(calculateResultMultiplyingPositiveElementsInTheRightPlaces(array) + "\n");
                    break;
                default:
                    throw new IOException();
            }
        }
        return result + "";
    }
}
