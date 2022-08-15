package itStep.yandr.javaStages.stage13.mainTask.controller;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import itStep.yandr.javaStages.stage13.mainTask.model.logic.ActionSelector;
import itStep.yandr.javaStages.stage13.util.ArrayManager;
import itStep.yandr.javaStages.stage13.view.MsgBuilder;
import itStep.yandr.javaStages.stage13.view.Printer;

import java.io.IOException;
import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.mainTask.model.logic.DescriptionsContainer.*;
import static itStep.yandr.javaStages.stage13.util.ArrayManager.exchangeAllEquals;
import static itStep.yandr.javaStages.stage13.util.ArrayManager.getSizeOfArray;

public class MainArray {
    public static final String MSG_WRONG_DATA = "Entered data is not valid\n";
    public static void main(String[] args) {
        int[] array = new int[ArrayManager.getSizeOfArray("numbers: ")];
        try {
            ArrayManager.fillArrayWithSelectTypeInit(array);
            Printer.print("\nCommands:              Actions available\n " + MsgBuilder.buildMsg(COMMAND_NAMES
                    , DESCRIPTION_OF_METHODS));
            String[] commands = new String[getSizeOfArray("commands to be executed: \n")];
            ArrayManager.userInit(commands, "Input the commands: \n");
            commands=exchangeAllEquals(commands,NAME_SELECT_ALL_ACTION
                ,Arrays.copyOfRange(COMMAND_NAMES,0,COMMAND_NAMES.length-1));
            String[] results = ActionSelector.selectActions(array, commands);
            String[]descriptions=MsgBuilder.buildArrayOfDescriptionsByKeywords(commands,COMMAND_NAMES,DESCRIPTION_OF_METHODS);
            String msg = MsgBuilder.buildMsg(descriptions,results);
            Printer.print(msg);
        } catch (InvalidSizeOfArrayException  |InvalidObjectException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Printer.printError(MSG_WRONG_DATA);
            e.printStackTrace();
        }

    }
}
