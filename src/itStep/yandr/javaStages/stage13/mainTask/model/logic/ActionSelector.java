package itStep.yandr.javaStages.stage13.mainTask.model.logic;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;

import java.io.IOException;

import static itStep.yandr.javaStages.stage13.mainTask.model.logic.ArrayLogic.*;
import static itStep.yandr.javaStages.stage13.mainTask.model.logic.DescriptionsContainer.*;
import static itStep.yandr.javaStages.stage13.util.DataValidator.validateArray;
import static itStep.yandr.javaStages.stage13.util.DataValidator.validateArrayWithObjectTypeElements;

public class ActionSelector {
    public static String[] selectActions(int[] array, String... commands) throws InvalidSizeOfArrayException
            , IOException, InvalidObjectException {
        validateArray(array);
        validateArrayWithObjectTypeElements(commands);
        String[] results = new String[commands.length];
        int res;
        for (int i = 0; i < commands.length; i++) {
            commands[i] = commands[i].toLowerCase();
            switch (commands[i]) {
                case (NAME_CHECK_ORDER_OF_SEQUENCE):
                     res = checkOrderOfSequenceOfNumbers(array);
                    results[i] = res == 0 ? ZERO_RESULT_CHECK_ORDER_OF_SEQUENCE : res == 1
                            ? RESULT_ONE_TO_CHECK_ORDER_OF_SEQUENCE : res == 2 ? RESULT_TWO_TO_CHECK_ORDER_OF_SEQUENCE
                            : NEGATIVE_RESULT;
                    break;
            case (NAME_CHECK_MIRRORED_DISPOSITION):
                try {
                    results[i] = checkMirroredDispositionOfElements(array)?RESULT_TRUE:RESULT_FALSE;
                } catch (InvalidSizeOfArrayException e ){
                    results[i] =  NEGATIVE_RESULT;
                }
                break;
            case (NAME_CHECK_EQUALITY_OR_DIFFER_NUMBERS):
                 res = checkEqualityOrDifferenceNumbersOfSequence(array);
                results[i] = res == 0 ? ZERO_RESULT_CHECK_EQUAL_OR_DIFF_NUMB : res == 1
                        ? RESULT_ONE_TO_CHECK_EQUAL_OR_DIFF_NUMB : res == 2 ? RESULT_TWO_TO_CHECK_EQUAL_OR_DIFF_NUMB
                        : NEGATIVE_RESULT;
                break;
            case (NAME_COUNT_ODD):
                results[i] = String.valueOf(countTheNumberOfOddElements(array));
                break;
            case (NAME_COUNT_EVEN):
                results[i] =String.valueOf(countTheNumberOfEvenElements(array));
                break;
            case (NAME_SELECT_ALL_ACTION):

                break;
            default:
                throw new IOException();
        }
    }
    return results;
}
}
