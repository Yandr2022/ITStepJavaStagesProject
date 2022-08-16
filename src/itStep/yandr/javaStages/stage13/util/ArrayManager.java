package itStep.yandr.javaStages.stage13.util;

import static itStep.yandr.javaStages.stage13.util.DataValidator.*;
import static itStep.yandr.javaStages.stage13.util.InputManager.getInt;
import static itStep.yandr.javaStages.stage13.util.InputManager.getStringWithLetter;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import itStep.yandr.javaStages.stage13.view.Printer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class ArrayManager {
    private static final Random RND = new Random();
    private static final int ROUNDING = 100;
    private static final String DEFAULT_MSG = "Input elements:\n";
    private static final String KEYWORD_USER_INIT = "manually";
    private static final String KEYWORD_RANDOM_INIT = "automatic";
    private static final String INITIAL_MSG_FOR_FILL_WITH_SELECT
            = String.format("Would you like to enter a sequence of numbers manually or use automatic filling " +
            "with random values?\n(Entered keyword: %s or %s )\n",KEYWORD_USER_INIT,KEYWORD_RANDOM_INIT);
    private static final String INITIAL_MSG_FOR_USER_INIT ="Input numbers:\n" ;
    private static final String[] INITIAL_MSG_FOR_RANDOM_INIT = {"Input min value: \n","Input max value: \n"} ;
    private static final String MSG_INVALID_KEYWORD ="Key word not determined, try again \n" ;
    private static final String DEFAULT_ELEMENT_NAME = "elements";
    private static final String INITIAL_MSG_GET_SIZE ="Input the amount of " ;
    private static final String ERROR_MSG_GET_SIZE ="%d is not correct value, try again\n " ;

    public static void randomInit(int[] array, int min, int max) throws InvalidSizeOfArrayException {
        validateArray(array);
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        Random rnd = RND;
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(max - min + 1) + min;
        }
    }


    public static void randomInit(double[] array, double max) throws InvalidSizeOfArrayException {
        validateArray(array);
        Random rnd = RND;
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.ceil((rnd.nextDouble() * max) * ROUNDING) / ROUNDING;
        }
    }

    public static void userInit(int[] array, String msg) throws InvalidSizeOfArrayException {
        validateArray(array);
        msg = msg == null ? DEFAULT_MSG : msg;
        Printer.print(msg);
        for (int i = 0; i < array.length; i++) {
            array[i] = getInt();
        }
    }

    public static void userInit(double[] array, String msg) throws InvalidSizeOfArrayException {
        validateArray(array);
        msg = msg == null ? DEFAULT_MSG : msg;
        Printer.print(msg);
        for (int i = 0; i < array.length; i++) {
            array[i] = InputManager.getDouble();
        }
    }

    public static void userInit(String[] array, String msg) throws InvalidSizeOfArrayException {
        validateArray(array);
        msg = msg == null ? DEFAULT_MSG : msg;
        Printer.print(msg);
        for (int i = 0; i < array.length; i++) {
            array[i] = getStringWithLetter();
        }
    }
    public static void userInitWithControllingBounds(int[] array, String msg,int boundMin,int boundMax) throws InvalidSizeOfArrayException {
        validateArray(array);
        msg = msg == null ? DEFAULT_MSG : msg;
        String temp =msg;
        for (int i = 0; i < array.length; i++) {
          do {
              Printer.print(msg);
              array[i] = getInt();
              msg = array[i]<boundMin||array[i]>boundMax?String.format(ERROR_MSG_GET_SIZE,array[i]):temp;
          }while(array[i]<boundMin||array[i]>boundMax);
        }
    }

    public static void fillArrayWithSelectTypeInit(int[] array) throws InvalidSizeOfArrayException {
        validateArray(array);
        Printer.print(INITIAL_MSG_FOR_FILL_WITH_SELECT);
        String kw = getStringWithLetter();
        if (kw.equals(KEYWORD_USER_INIT)) {
            userInit(array, INITIAL_MSG_FOR_USER_INIT);

        } else if (kw.equals(KEYWORD_RANDOM_INIT)) {
            Printer.print(INITIAL_MSG_FOR_RANDOM_INIT[0]);
            int min = getInt();
            Printer.print(INITIAL_MSG_FOR_RANDOM_INIT[1]);
            int max = getInt();
            randomInit(array, min, max);
            Printer.print(Arrays.toString(array) + "\n");
        } else {
            Printer.printError(MSG_INVALID_KEYWORD);
            fillArrayWithSelectTypeInit(array);
        }
    }
    public static void fillArrayWithSelectTypeInitWithControllingBounds(int[] array, int boundMin, int boundMax)
            throws InvalidSizeOfArrayException {
        validateArray(array);
        Printer.print(INITIAL_MSG_FOR_FILL_WITH_SELECT);
        String kw = getStringWithLetter();
        if (kw.equals(KEYWORD_USER_INIT)) {
            userInitWithControllingBounds(array, INITIAL_MSG_FOR_USER_INIT,boundMin,boundMax);
            Printer.print(Arrays.toString(array) + "\n");
        } else if (kw.equals(KEYWORD_RANDOM_INIT)) {
            int min;
            do {
                Printer.print(INITIAL_MSG_FOR_RANDOM_INIT[0]);
                min =getInt();
            } while (min<boundMin||min>boundMax);
            int max;
            do {
                Printer.print(INITIAL_MSG_FOR_RANDOM_INIT[1]);
                max =getInt();
            } while (max>boundMax||max<boundMin);
            randomInit(array, min, max);
            Printer.print(Arrays.toString(array) + "\n");
        } else {
            Printer.printError(MSG_INVALID_KEYWORD);
            fillArrayWithSelectTypeInit(array);
        }
    }

    public static void fillArrayWithSelectTypeInit(double[] array) throws InvalidSizeOfArrayException, InvalidObjectException {
        validateArray(array);
        Printer.print(INITIAL_MSG_FOR_FILL_WITH_SELECT);
        String kw = getStringWithLetter();
        if (kw.equals(KEYWORD_USER_INIT)) {
            userInit(array, INITIAL_MSG_FOR_USER_INIT);

        } else if (kw.equals(KEYWORD_RANDOM_INIT)) {
            Printer.print(INITIAL_MSG_FOR_RANDOM_INIT[1]);
            double max = InputManager.getDouble();
            randomInit(array, max);
            Printer.print(Arrays.toString(array));
        } else {
            Printer.printError(MSG_INVALID_KEYWORD);
            fillArrayWithSelectTypeInit(array);
        }
    }

    public static int getSizeOfArray(String itemName) {
        itemName = itemName == null ? DEFAULT_ELEMENT_NAME : itemName;
        Printer.print(INITIAL_MSG_GET_SIZE + itemName);
        int num = getInt();
        if (num < 1) {
            num = getSizeOfArray(itemName);
        }
        return num;
    }

    public static int[] getIndicesOfEqualsElement(String searchElement, String[] elements) throws InvalidSizeOfArrayException
            , InvalidObjectException {
        validateObject(searchElement);
        validateArrayWithObjectTypeElements(elements);

//        if (searchElement == null) {
//            Printer.print("the search element is not defined, please re-enter");
//            searchElement = getStringWithLetter();
//            getIndicesOfEqualsElement(searchElement, elements);
//        }
        int[] index = {-1};
        for (int i = 0, j = 0; i < elements.length; i++) {
            elements[i] = elements[i].toLowerCase();
            if (elements[i].equals(searchElement.toLowerCase())) {
                if (j > 0) {
                    index = Arrays.copyOf(index, index.length + 1);
                    index[j] = i;
                }
                index[j] = i;
                j++;
            }
        }
        return index;
    }

    public static int getIndexOfEqualsElement(String searchElement, String[] elements) throws InvalidSizeOfArrayException
            , InvalidObjectException {
        validateObject(searchElement);
        validateArrayWithObjectTypeElements(elements);
        int index = -1;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = elements[i].toLowerCase();
            if (elements[i].equals(searchElement.toLowerCase())) {
                index = i;
            }
        }
        return index;
    }

    public static String[] concatenateArraysWithReplacementElement(String[] array1, String[] array2, int index)
            throws InvalidSizeOfArrayException, InvalidObjectException, IOException {
        validateArrayWithObjectTypeElements(array1, array2);
        if (index > array1.length-1||index<0) {
            throw new IOException();
        }
        String[] result = new String[(array1.length - 1) + array2.length];
        for (int i = 0; i < index; i++) {
            result[i] = array1[i];
        }
        for (int i = 0, j = index; i < array2.length; i++, j++) {
            result[j] = array2[i];
        }
        for (int i = index + array2.length, j = index + 1; i < result.length; i++, j++) {
            result[i] = array1[j];
        }
        return result;
    }

    public static String[] exchangeAllEquals(String[] array, String equals, String... replacement) throws InvalidSizeOfArrayException
            , InvalidObjectException, IOException {
        validateObject(equals);
        validateArrayWithObjectTypeElements(array, replacement);
        int index = getIndexOfEqualsElement(equals, array);
        if (index == -1) {
            return array;
        }
        return exchangeAllEquals(concatenateArraysWithReplacementElement(array, Arrays.copyOfRange
                (replacement, 0, replacement.length), index), equals, replacement);
    }
}
