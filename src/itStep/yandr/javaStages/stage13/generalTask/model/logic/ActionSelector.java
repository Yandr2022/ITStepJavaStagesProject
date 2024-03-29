package itStep.yandr.javaStages.stage13.generalTask.model.logic;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;

import static itStep.yandr.javaStages.stage13.generalTask.model.logic.DescriptionsContainer.*;
import static itStep.yandr.javaStages.stage13.util.DataValidator.*;

import java.io.IOException;

import static itStep.yandr.javaStages.stage13.generalTask.model.logic.ArrayLogic.*;

public class ActionSelector {

    public static double[][] selectActions(double[] array, String... commands) throws InvalidSizeOfArrayException
            , IOException, InvalidObjectException {
        validateArray(array);
        validateArrayWithObjectTypeElements(commands);
        double[][] results = new double[commands.length][];
        for (int i = 0; i < commands.length; i++) {
            commands[i] = commands[i].toLowerCase();
            switch (commands[i]) {
                case (NAME_DEFINE_MIN_VALUE):
                    results[i] = new double[]{array[findMinValueIndex(array)]};
                    break;
                case (NAME_DEFINE_MAX_VALUE):
                    results[i] = new double[]{array[findMaxValueIndex(array)]};
                    break;
                case (NAME_CALCULATE_AVERAGE):
                    results[i] = new double[]{calculateArithmeticAverage(array)};
                    break;
                case (NAME_SWAP_EXTREME_VALUES):
                    swapMinMaxElements(array);
                    results[i] = array.clone();
                    break;
                case (NAME_SUM_MODULES_ARE_LESS_THAN_AVERAGE):
                    results[i] = new double[]{calculateSumOfAbsoluteValuesAreLessThanAverage(array)};
                    break;
                case (NAME_MULTIPLYING_POSITIVE_NUMBERS_TO_RIGHT_PLACES):
                    results[i] = new double[]{calculateResultMultiplyingPositiveElementsInTheRightPlaces(array)};
                    break;
                default:
                    throw new IOException();
            }
        }
        return results;
    }
}
