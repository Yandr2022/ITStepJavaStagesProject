package itStep.yandr.javaStages.stage13.view;

import java.util.Scanner;

import static itStep.yandr.javaStages.stage13.view.Printer.printError;

public class InputManager {
    private static final Scanner SCAN = new Scanner(System.in);

    public static int getInt() {
        int num;
        if (SCAN.hasNextInt()) {
            num = SCAN.nextInt();
        } else {
            printError("Number not determined, try again");
            num = getInt();
        }
        return num;
    }

    public static String getStringWithLetter() {
        String name = SCAN.next();
        for (int i = 0; i < name.length(); i++) {
            char charValue = name.charAt(i);

            if (!Character.isLetter(charValue)) {
                printError("Letter not determined, try again");
                name = getStringWithLetter();
            }
        }
        return name;
    }

    public static double getDouble() {
        double num;
        if (SCAN.hasNextDouble()) {
            num = SCAN.nextDouble();
        } else {
            printError("Number not determined, try again");
            num = getDouble();
        }
        return num;
    }
}
