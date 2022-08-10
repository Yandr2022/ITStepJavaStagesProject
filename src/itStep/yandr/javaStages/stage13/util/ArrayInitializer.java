package itStep.yandr.javaStages.stage13.util;

import static itStep.yandr.javaStages.stage13.util.DataValidator.*;
import static itStep.yandr.javaStages.stage13.util.InputManager.getInt;

import itStep.yandr.javaStages.stage13.exception.ArrayContainingIncorrectDataException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import itStep.yandr.javaStages.stage13.view.Printer;

import java.util.Arrays;
import java.util.Random;


public class ArrayInitializer {
    private static final Random RND = new Random();
    private static final int ROUNDING = 100;


    public static void randomInit(int[] array, int min, int max) throws InvalidSizeOfArrayException {
        validateArray(array);
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
        Printer.print(msg);
        for (int i = 0; i < array.length; i++) {
            array[i] = getInt();
        }
    }

    public static void userInit(double[] array, String msg) throws InvalidSizeOfArrayException {
        validateArray(array);
        Printer.print(msg);
        for (int i = 0; i < array.length; i++) {
            array[i] = InputManager.getDouble();
        }
    }

    public static void userInit(String[] array, String msg) throws InvalidSizeOfArrayException
            , ArrayContainingIncorrectDataException {
        validateArray(array);
        Printer.print(msg);
        for (int i = 0; i < array.length; i++) {
            array[i] = InputManager.getStringWithLetter();
        }
    }

    public static void fillArrayWithSelectTypeInit(int[] array) throws InvalidSizeOfArrayException {
        Printer.print("Would you like to enter a sequence of numbers manually or use automatic filling with random values?\n" +
                "(Entered keyword: manually or automatic)\n");
        String kw = InputManager.getStringWithLetter();
        if (kw.equals("manually")) {
            userInit(array, "Input numbers\n");

        } else if (kw.equals("automatic")) {
            Printer.print("Input min value: \n");
            int min = getInt();
            Printer.print("Input max value: \n");
            int max = getInt();
            randomInit(array, min, max);
            Printer.print(Arrays.toString(array) + "\n");
        } else {
            Printer.printError("Key word not determined, try again \n");
            fillArrayWithSelectTypeInit(array);
        }
    }

    public static void fillArrayWithSelectTypeInit(double[] array) throws InvalidSizeOfArrayException {
        Printer.print("Would you like to enter a sequence of numbers manually or use automatic filling with random values?\n" +
                "(Entered keyword: manually or automatic)\n");
        String kw = InputManager.getStringWithLetter();
        if (kw.equals("manually")) {
            userInit(array, "Input numbers\n");

        } else if (kw.equals("automatic")) {
            Printer.print("Input max value: \n");
            double max = InputManager.getDouble();
            randomInit(array, max);
            Printer.print(Arrays.toString(array));
        } else {
            Printer.printError("Key word not determined, try again \n");
            fillArrayWithSelectTypeInit(array);
        }
    }

    public static int getSizeOfArray(String itemName) {
        itemName = itemName == null ? "elements" : itemName;
        Printer.print(String.format("Input the amount of %s: ", itemName));
        int num = getInt();
        if (num < 1) {
           num= getSizeOfArray(itemName);
        }
        return num;
    }

    public static int getIndexOfEqualsElement(String searchElement, String[] elements) {
        int index = -1;
        for (int i = 0; i < elements.length; i++) {
            elements[i]=elements[i].toLowerCase();
            if (elements[i].equals(searchElement.toLowerCase())) {
                index = i;
            }
        }
        return index;
    }

    public static String[] concatenateArraysWithReplacementElement(String[] array1, String[] array2, int index) {
        String[] result = new String[(array1.length-1) + array2.length];
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
}
