package itStep.yandr.javaStages.stage12.task01.util;

import java.util.Scanner;

public class InputManager {

    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.err.println("Number not determined, try again");
            scanner.next();
            num = getInt();
        }
        return num;
    }

    //    name.matches("[A-Za-z]") почему-то не заработал((
    public static String getStringWithLetter() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        for (int i = 0; i < name.length(); i++) {
            char charValue = name.charAt(i);

            if (!Character.isLetter(charValue)) {
                System.err.println("Letter not determined, try again");
                scanner.next();
                name = getStringWithLetter();
            }
        }
        return name;


    }
}
