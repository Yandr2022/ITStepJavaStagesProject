package itStep.yandr.javaStages.stage14.levelA.controller;



import static itStep.yandr.javaStages.stage14.levelA.model.logic.Constants.BEHAVIOR_OBJECTS;
import static itStep.yandr.javaStages.stage14.levelA.model.logic.Constants.DESCRIPTIONS;
import static itStep.yandr.javaStages.stage14.levelA.model.logic.CounterElements.count;


import itStep.yandr.javaStages.stage14.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage14.exception.InvalidSizeOfArrayException;

import itStep.yandr.javaStages.stage14.util.ArrayInitializer;
import itStep.yandr.javaStages.stage14.view.MsgBuilder;
import itStep.yandr.javaStages.stage14.view.Printer;

public class Main {

    public static void main(String[] args) {
        int array[] = new int[ArrayInitializer.getSizeOfArray("numbers")];
        try {
            ArrayInitializer.fillArrayWithSelectTypeInit(array);
            int[] result = new int[BEHAVIOR_OBJECTS.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = count(BEHAVIOR_OBJECTS[i],array);
            }
            Printer.print(MsgBuilder.buildMsg(result, DESCRIPTIONS));

        } catch (InvalidSizeOfArrayException | InvalidObjectException e) {
            e.printStackTrace();
        }


    }
}
