package itStep.yandr.javaStages.stage13.generalTask.controller;

import itStep.yandr.javaStages.stage13.generalTask.exception.InvalidSizeOfArray;
import itStep.yandr.javaStages.stage13.generalTask.util.ActionSelector;
import itStep.yandr.javaStages.stage13.view.InputManager;
import itStep.yandr.javaStages.stage13.view.Printer;

import java.io.IOException;

import static itStep.yandr.javaStages.stage13.generalTask.util.ActionSelector.*;


public class Main {
    public static final String MSG_WRONG_DATA = "Entered data is not valid\n";

    public static void main(String[] args)  {
        Printer.print("Input the amount of elements in the sequence:\n ");
        int size = InputManager.getInt();
        double[] array = new double[size];
        Printer.print("Input the number: \n");
        for (int i = 0; i < array.length; i++) {
            array[i] = InputManager.getDouble();
        }
        Printer.print(String.format(
                "Commands:        Actions available " +
                        "\n%s  : %s\n%s  : %s\n%s  : %s\n%s : %s\n%s  : %s\n%s  : %s\n%s  : %s\n"
                , NAME_DEFINE_MIN_VALUE, DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE
                , NAME_DEFINE_MAX_VALUE, DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE
                , NAME_CALCULATE_AVERAGE, DESCRIPTION_OF_METHOD_TO_CALCULATE_AVERAGE
                , NAME_SWAP_EXTREME_VALUES, DESCRIPTION_OF_METHOD_TO_SWAP_EXTREME_VALUES
                , NAME_SUM_MODULES_ARE_LESS_THAN_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_SUM_OF_NUMBERS_MODULES_ARE_LESS_THAN_AVERAGE
                , NAME_MULTIPLYING_POSITIVE_NUMBERS_TO_RIGHT_PLACES
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_PRODUCT_OF_POSITIVE_NUMBERS_TO_EVEN_PLACES
                , NAME_SELECT_ALL_ACTION, "Get the results of executing all available functionality"));

        Printer.print("Input the amount of commands to be executed: \n");
        size = InputManager.getInt();
        String[] commands = new String[size];
        Printer.print("Input the commands: \n");
        for (int i = 0; i < commands.length; i++) {
            commands[i] = InputManager.getStringWithLetter();
        }
        try {
            String result = ActionSelector.selectActions(array, commands);
            Printer.print(result);
          } catch (InvalidSizeOfArray e) {
        e.printStackTrace();
    } catch (IOException e) {
        Printer.printError(MSG_WRONG_DATA);
        e.printStackTrace();
    }

    }
}
