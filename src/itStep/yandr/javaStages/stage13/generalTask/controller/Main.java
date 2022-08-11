package itStep.yandr.javaStages.stage13.generalTask.controller;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import itStep.yandr.javaStages.stage13.generalTask.model.logic.ActionSelector;
import itStep.yandr.javaStages.stage13.util.ArrayInitializer;
import itStep.yandr.javaStages.stage13.view.MsgBuilder;
import itStep.yandr.javaStages.stage13.view.Printer;

import java.io.IOException;

import static itStep.yandr.javaStages.stage13.generalTask.model.logic.DescriptionsContainer.*;
import static itStep.yandr.javaStages.stage13.util.ArrayInitializer.getSizeOfArray;


public class Main {
    public static final String MSG_WRONG_DATA = "Entered data is not valid\n";

    public static void main(String[] args) {
        double[] array = new double[getSizeOfArray("elements in the sequence")];
        try {
            ArrayInitializer.fillArrayWithSelectTypeInit(array);
            Printer.print("\nCommands:              Actions available\n " + MsgBuilder.buildMsg(COMMAND_NAMES
                    , DESCRIPTION_OF_METHODS));
            String[] commands = new String[getSizeOfArray("commands to be executed")];
            ArrayInitializer.userInit(commands, "Input the commands: \n");
            double[][] results = ActionSelector.selectActions(array, commands);
            String[]descriptions=MsgBuilder.buildArrayOfDescriptionsByKeywords(commands,COMMAND_NAMES,DESCRIPTION_OF_METHODS);
            String msg = MsgBuilder.buildMsg(results,descriptions);
            Printer.print(msg);
        } catch (InvalidSizeOfArrayException | InvalidObjectException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Printer.printError(MSG_WRONG_DATA);
            e.printStackTrace();
        }

    }
}
