package itStep.yandr.javaStages.stage13.view;

import itStep.yandr.javaStages.stage13.exception.ArrayContainingIncorrectDataException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;


import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.generalTask.model.logic.DescriptionsContainer.COMMAND_NAMES;
import static itStep.yandr.javaStages.stage13.generalTask.model.logic.DescriptionsContainer.NAME_SELECT_ALL_ACTION;
import static itStep.yandr.javaStages.stage13.util.ArrayInitializer.concatenateArraysWithReplacementElement;
import static itStep.yandr.javaStages.stage13.util.ArrayInitializer.getIndexOfEqualsElement;
import static itStep.yandr.javaStages.stage13.util.DataValidator.*;


public class MsgBuilder {




    public static String buildMsg(double[][] results, String... descriptions) throws InvalidSizeOfArrayException
            , ArrayContainingIncorrectDataException {
        validateArray(results);
        validateArray(descriptions);
        validateElementsOfArray(descriptions);
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            msg.append(descriptions[i]).append(" : ").append(Arrays.toString(results[i]) + "\n");
        }
        return msg + "";
    }


    public static String buildMsg(String complement, double[] results, String... descriptions)
            throws InvalidSizeOfArrayException, ArrayContainingIncorrectDataException {
        validateArray(results);
        validateArray(descriptions);
        validateElementsOfArray(descriptions);
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            msg.append(descriptions[i]).append(" : ").append(String.format("%.3f %s\n", results[i], complement));
        }
        return msg + "";
    }

    public static String buildMsg(String[] keyWords, String... descriptions)
            throws InvalidSizeOfArrayException, ArrayContainingIncorrectDataException {
        validateArray(keyWords);
        validateElementsOfArray(keyWords);
        validateArray(descriptions);
        validateElementsOfArray(descriptions);
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < keyWords.length; i++) {
            msg.append(keyWords[i]).append(" : ").append(descriptions[i] + "\n");
        }
        return msg + "";
    }

    public static String[] buildArrayOfDescriptionsByKeywords(String[] usedKeywords, String[] allKeywords
            , String[] descriptions) throws InvalidSizeOfArrayException, ArrayContainingIncorrectDataException {
        validateArrayWithObjectTypeElements(usedKeywords, allKeywords, descriptions);
        int ind = getIndexOfEqualsElement(NAME_SELECT_ALL_ACTION, usedKeywords);
        if (ind != -1) {
            usedKeywords = concatenateArraysWithReplacementElement(usedKeywords, Arrays.copyOfRange
                    (COMMAND_NAMES, 0, COMMAND_NAMES.length - 1), ind);
        }
        String[] result = new String[usedKeywords.length];
        int index;
        for (int i = 0; i < usedKeywords.length; i++) {
            index = getIndexOfEqualsElement(usedKeywords[i], allKeywords);
            result[i] = index != -1 ? descriptions[index] : String.format
                    ("%s: keyword used, not found in keyword list ", usedKeywords[i]);
        }
        return result;
    }
}
