package itStep.yandr.javaStages.stage13.util;

import itStep.yandr.javaStages.stage13.view.InputManager;
import itStep.yandr.javaStages.stage13.view.Printer;

import java.util.Random;
import java.util.Scanner;

public class ArrayInitializer {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final Random RND = new Random();

    public static void randomInit(int[] array, int min, int max) {
        Random rnd = RND;
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(max - min) + min;
        }
    }

    public static void randomInit(double[] array, double max) {
        Random rnd = RND;
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextDouble() * max;
        }
    }

    public static void userInit(int[] array, String msg) {
        Printer.print(msg);
        for (int i = 0; i < array.length; i++) {
            array[i] = InputManager.getInt();
        }
    }
    public static void userInit(double[] array, String msg) {
        Printer.print(msg);
        for (int i = 0; i < array.length; i++) {
            array[i] = InputManager.getDouble();
        }
    }
    public static void userInit(String[] array, String msg) {
        Printer.print(msg);
        for (int i = 0; i < array.length; i++) {
            array[i] = InputManager.getStringWithLetter();
        }
    }
}
