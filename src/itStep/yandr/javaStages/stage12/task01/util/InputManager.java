package itStep.yandr.javaStages.stage12.task01.util;


import java.util.Scanner;

public class InputManager {

    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();

        } else {
            System.out.println("Number not determined, try again");
            scanner.next();
            num = getInt();
        }
        return num;
    }

}
