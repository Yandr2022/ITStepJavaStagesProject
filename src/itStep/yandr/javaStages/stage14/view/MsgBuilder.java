package itStep.yandr.javaStages.stage14.view;

import itStep.yandr.javaStages.stage14.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage14.exception.InvalidSizeOfArrayException;

import static itStep.yandr.javaStages.stage14.util.DataValidator.*;


public class MsgBuilder {

    public static String buildMsg(int[] results, String... descriptions) throws InvalidSizeOfArrayException
            , InvalidObjectException {
        validateArray(results);
        checkEquivalenceOfArraySizes(descriptions,results);
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            msg.append(descriptions[i]).append(" : ").append(results[i]).append("\n");
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

}
