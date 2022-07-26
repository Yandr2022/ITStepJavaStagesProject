package itStep.yandr.javaStages.stage13.view;

import java.util.Scanner;

import static itStep.yandr.javaStages.stage13.view.Printer.printError;

public class InputManager {

    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            printError("Number not determined, try again");
            num = getInt();
        }
        return num;
    }

    public static String getStringWithLetter() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

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
        Scanner scanner = new Scanner(System.in);
        double num;
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
        } else {
            printError("Number not determined, try again");
            num = getDouble();
        }
        return num;
    }
}
