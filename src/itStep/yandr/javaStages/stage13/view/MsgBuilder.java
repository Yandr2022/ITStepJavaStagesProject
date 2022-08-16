package itStep.yandr.javaStages.stage13.view;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;


import java.io.IOException;
import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.util.ArrayManager.*;
import static itStep.yandr.javaStages.stage13.util.DataValidator.*;


public class MsgBuilder {

    public static String buildMsg(double[][] results, String... descriptions) throws InvalidSizeOfArrayException
            , InvalidObjectException {
        validateArray(results);
        validateArrayWithObjectTypeElements(descriptions,results);
        checkEquivalenceOfArraySizes(descriptions,results);
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            msg.append(descriptions[i]).append(" : ").append(Arrays.toString(results[i])).append("\n");
        }
        return msg + "";
    }


    public static String buildMsg(String complement, double[] results, String... descriptions)
            throws InvalidSizeOfArrayException, InvalidObjectException {
        validateObject(complement);
        validateArray(results);
        validateArrayWithObjectTypeElements(descriptions);
        checkEquivalenceOfArraySizes(descriptions,results);
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            msg.append(descriptions[i]).append(" : ").append(String.format("%.2f %s\n", results[i], complement));
        }
        return msg + "";
    }

    public static String buildMsg(String[] keyWords, String... descriptions)
            throws InvalidSizeOfArrayException, InvalidObjectException {
        validateArrayWithObjectTypeElements(keyWords,descriptions);
        checkEquivalenceOfArraySizes(descriptions,keyWords);
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < keyWords.length; i++) {
            msg.append(keyWords[i]).append(" : ").append(descriptions[i]).append("\n");
        }
        return msg + "";
    }

    public static String[] buildArrayOfDescriptionsByKeywords(String[] usedKeywords, String[] allKeywords
            , String[] descriptions) throws InvalidSizeOfArrayException, InvalidObjectException, IOException {
        validateArrayWithObjectTypeElements(usedKeywords, allKeywords, descriptions);
//        !!!replace with active foolproof
        if (allKeywords.length > descriptions.length) {
            throw new InvalidSizeOfArrayException();
        }
        String[] result = new String[usedKeywords.length];
        int  index ;
        for (int i = 0; i < result.length; i++) {
            index = getIndexOfEqualsElement(usedKeywords[i], allKeywords);
            result[i] = index != -1 ? descriptions[index] : String.format
                    ("%s: keyword used, not found in keyword list ", usedKeywords[i]);
        }
        return result;
    }
}
